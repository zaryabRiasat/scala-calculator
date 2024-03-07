import com.typesafe.sbt.packager.docker._

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.4"

ThisBuild / scapegoatVersion := "1.4.8"

lazy val root = (project in file("."))
  .settings(
    name := "ScalaStyle"
  )

enablePlugins(JavaAppPackaging, DockerPlugin)

Docker / packageName := "scala-style-jenkins"

Docker / version := "0.0.1"

dockerChmodType := DockerChmodType.UserGroupWriteExecute
dockerPermissionStrategy := DockerPermissionStrategy.CopyChown
dockerAdditionalPermissions += (DockerChmodType.UserGroupPlusExecute, "/var/run/")

Docker / daemonUserUid := None
Docker / daemonUser := "root"

dockerBaseImage := "amazoncorretto:11-alpine3.18-jdk"

dockerCommands ++= Seq(
  Cmd("RUN", "apk", "add", "--no-cache", "bash")
)

val logbackVersion = "1.4.5"
val configVersion = "1.3.0"
val scalaTest = "3.2.17"

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % logbackVersion,
  "com.typesafe" % "config" % configVersion,
  "org.scalatest" %% "scalatest" % scalaTest
)

