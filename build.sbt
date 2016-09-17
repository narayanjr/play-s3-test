name := """play-s3-test"""

version := "1"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
	ws,
	"net.kaliber" %% "play-s3" % "7.0.2"
)