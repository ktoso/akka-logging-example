name := "logging"

organization := "logging"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.7"

val AkkaVersion = "2.5.4"

resolvers += Resolver.typesafeRepo("releases")

libraryDependencies += "com.typesafe.akka" %% "akka-actor"  % AkkaVersion
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % AkkaVersion
libraryDependencies += "com.typesafe.akka" %% "akka-slf4j"  % AkkaVersion
libraryDependencies += "org.slf4j" %% "slf4j-log4j12"  % "1.7.5"
