import Dependencies._

lazy val actor = (project in file(".")).settings(
  inThisBuild(
    List(
      organization := "crossroad0201.akkastudy",
      scalaVersion := "2.12.6",
      version := "0.1.0-SNAPSHOT"
    )),
  name := "akka-actor",
  libraryDependencies ++= Seq(
    akkaActor,
    scalaTest % Test
  ),
  scalafmtOnCompile in ThisBuild := true,
  scalafmtTestOnCompile in ThisBuild := true,
  fork in Test := true,
  javaOptions in Test ++= Seq("-Duser.timezone=UTC")
)
