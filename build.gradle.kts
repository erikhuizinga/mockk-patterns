plugins { kotlin("jvm") }
allprojects { repositories { mavenCentral() } }

subprojects {
    kotlinJvmConfig()

    dependencies {
        implementation(kotlin("stdlib-jdk8"))
        implementation("io.mockk:mockk:$MOCKK")
    }
}
