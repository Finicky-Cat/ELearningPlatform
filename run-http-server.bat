REM Set the classpath
REM Assumes the build was executed with Maven copy-dependencies

SET ECOURSE_CP=ecourse.app.sharedboard.http.server/target/http.server-1.0.0.jar;ecourse.app.sharedboard.http.server/target/dependency/*;

REM Call the Java VM, e.g.,
java -cp "%ECOURSE_CP%" eapli.ecourse.app.sharedBoard.HttpSharedBoardServerApp %1
