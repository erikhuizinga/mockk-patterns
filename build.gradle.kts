plugins {
    kotlin("jvm") version "1.3.70"
}

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
