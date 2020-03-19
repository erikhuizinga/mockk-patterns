import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins { kotlin("jvm") version KOTLIN }
allprojects { repositories { mavenCentral() } }

subprojects {
    buildscript {
        repositories {
            gradlePluginPortal()
        }
        dependencies {
            classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.70")
        }
    }

    apply(plugin = "org.jetbrains.kotlin.jvm")

    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions.jvmTarget = "1.8"
    }

    configure<JavaPluginExtension>() { withSourcesJar() }

    dependencies {
        implementation(kotlin("stdlib-jdk8"))
        implementation("io.mockk:mockk:$MOCKK")
    }
}
