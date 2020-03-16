import com.jfrog.bintray.gradle.BintrayExtension

plugins {
    kotlin("jvm")
    `maven-publish`
    id("com.jfrog.bintray") version BINTRAY
}

internal val theVersion = "1.0.0"
internal val theArtifactId = "mockk-junit5"
internal val thePublication = "${theArtifactId}Publication"
internal val theGroup = "com.github.erikhuizinga"

group = theGroup
version = theVersion

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.mockk:mockk:$MOCKK")
    implementation("org.junit.jupiter:junit-jupiter:$JUNIT5")
}

apply(from = "../kotlinJvmTarget.gradle")

tasks.test {
    useJUnitPlatform()
}

java.withSourcesJar()

publishing {
    publications {
        create<MavenPublication>(thePublication) {
            groupId = theGroup
            artifactId = theArtifactId
            version = theVersion
            from(components["java"])
        }
    }
}

configure<BintrayExtension> {
    dryRun = true
    user = properties["bintrayUser"] as? String
    key = properties["bintrayKey"] as? String
    pkg.apply {
        version.apply {
            name = theVersion
            vcsTag = theVersion
        }
        repo = "maven"
        name = theArtifactId
        userOrg = "erikhuizinga"
        setLicenses("Apache-2.0")
        vcsUrl = "https://github.com/erikhuizinga/mockk-patterns.git"
    }
    setPublications(thePublication)
}
