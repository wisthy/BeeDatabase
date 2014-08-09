name := """BeeDatabase"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  cache,
  javaWs,
  javaJdbc,
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "4.3.6.Final" // replace by your jpa implementation
)