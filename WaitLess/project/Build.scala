import sbt._
import Keys._
import play.Project._
import com.github.play2war.plugin._

object ApplicationBuild extends Build {

  val appName         = "WaitLess"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean,
    "org.avaje" % "ebean" % "2.7.1"
  )

  val main = play.Project(appName, appVersion, appDependencies)
  	.settings(Play2WarPlugin.play2WarSettings: _*)
    .settings(
      // Add your own project settings here      
        Play2WarKeys.servletVersion := "3.0"
    )

}
