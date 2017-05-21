name := "FP-In-Scala"

version := "1.0"

lazy val specs2Version               = "3.8.9"

libraryDependencies ++= Seq(
  "org.specs2"   %% "specs2-core"  % specs2Version % Test
)



parallelExecution in Test := false
