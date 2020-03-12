plugins {
    kotlin("jvm") version "1.3.70"
}

group = "com.github.erikhuizinga"
version = "1.0.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
    }
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}
