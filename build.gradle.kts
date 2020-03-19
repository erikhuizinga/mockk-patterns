import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins { kotlin("jvm") version KOTLIN }
allprojects { repositories { mavenCentral() } }

subprojects {
    buildscript {
        repositories {
            gradlePluginPortal()
        }
        dependencies {
            classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN")
        }
    }

    apply(plugin = "org.jetbrains.kotlin.jvm")

    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions.jvmTarget = "1.8"
    }

    dependencies {
        implementation(kotlin("stdlib-jdk8"))
        implementation("io.mockk:mockk:$MOCKK")
    }
}
