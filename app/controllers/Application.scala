package controllers

import java.nio.file.{Files, Paths}
import java.util

import scala.concurrent.{Await, Future}

import fly.play.s3.{BucketFile, S3, S3Exception}
import play.api.mvc.{Action, Controller}
import play.api.Play.current
import play.api.Logger
import play.api.Play
import play.api.libs.concurrent.Execution.Implicits._
import scala.concurrent.duration._

class Application extends Controller
{
	def index() = Action
	{ implicit request =>

		val file_path = "avatar.jpeg"
		val bucket = S3(Play.configuration.getString("s3.bucket").get)
		val byte_array = Files.readAllBytes(Paths.get(file_path))

		val result:Future[Unit] = bucket + BucketFile("avatar.jpeg", "image/jpeg", byte_array)
		result.map { unit =>
			Logger.info("Saved the file")
		}
			.recover {
				case S3Exception(status, code, message, originalXml) =>
				{
					Logger.error("Error: " + message)
					Logger.info("originalXml: " + originalXml)
				}
			}

		Ok("Done")
	}
}