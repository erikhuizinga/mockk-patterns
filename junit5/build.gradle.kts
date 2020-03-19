dependencies {
    implementation("org.junit.jupiter:junit-jupiter:$JUNIT5")
}

tasks.test { useJUnitPlatform() }

configurePublishing(
    version = "2.0.0",
    groupId = "com.github.erikhuizinga",
    artifactId = "mockk-junit5"
)
