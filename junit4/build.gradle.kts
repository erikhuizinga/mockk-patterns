dependencies {
    implementation("junit:junit:$JUNIT4")
}

tasks.test {
    exclude(
        "**/*ExampleMockkTest*", // Runs in ExampleTestSuite
        "**/*YourObjectIsNoLongerMockedTest*" // Runs in ExampleTestSuite
    )
}

configurePublishing(
    version = "1.0.0",
    artifactId = "mockk-junit4"
)
