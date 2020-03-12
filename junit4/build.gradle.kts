plugins {
    kotlin("jvm")
}

group = "com.github.erikhuizinga"
version = "1.0.0-SNAPSHOT"

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.mockk:mockk:1.9.3")
    implementation("junit:junit:4.13")
}
