plugins {
    kotlin("jvm")
    `maven-publish`
}

group = "com.github.erikhuizinga"
version = "1.0.0-SNAPSHOT"

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.mockk:mockk:1.9.3")
    implementation("junit:junit:4.13")
}

internal val name = "mockk-junit4"

publishing {
    publications {
        create<MavenPublication>(name) {
            groupId = project.group as String
            artifactId = name
            version = project.version as String

            from(components["java"])
        }
    }
}
