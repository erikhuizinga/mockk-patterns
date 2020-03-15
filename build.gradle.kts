import Versions.KOTLIN

plugins {
    kotlin("jvm") version KOTLIN
}

allprojects {
    repositories {
        mavenCentral()
    }
}
