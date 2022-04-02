// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath (libs.gradle)
        classpath (libs.kotlin)
        classpath (libs.google.services)

        classpath (libs.navigation.safe.args)
    }
}
