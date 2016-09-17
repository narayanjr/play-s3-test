# play-s3-test

## Setup
- Make sure all 3 values in `application.conf` are set. Either use env vars or hard code.

## Run (with Error)
- ./activator run
- load localhost:9000
- Check console.  This will so the mismatch.
- Kill the app.

## Run (without error)
- Update file "/project/plugins.sbt" to use play "2.4.2"
- ./activator run
- load localhost:9000
- Check console.  File uploaded successfully.
- Kill the app.