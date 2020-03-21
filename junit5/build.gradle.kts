dependencies {
    implementation("org.junit.jupiter:junit-jupiter:$JUNIT5")
}

tasks.test { useJUnitPlatform() }

configurePublishing(
    version = "2.0.0",
    artifactId = "mockk-junit5"
)
