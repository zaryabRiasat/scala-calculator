import sbt._

resolvers += Classpaths.typesafeReleases
addDependencyTreePlugin
ThisBuild / libraryDependencySchemes += "org.scala-lang.modules" %% "scala-xml" % VersionScheme.Always

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "1.0.0")
addSbtPlugin("com.sksamuel.scapegoat" %% "sbt-scapegoat" % "1.2.2")
addSbtPlugin("com.github.sbt" % "sbt-native-packager" % "1.9.16")
