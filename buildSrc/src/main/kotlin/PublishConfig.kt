import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.extra

fun Project.configurePublishing(
    name: String,
    version: String,
    artifactId: String
) {
    extra["NAME"] = name
    extra["VERSION"] = version
    extra["ARTIFACT_ID"] = artifactId
    apply(from = "${rootProject.rootDir}/ossrh-publishing.gradle")
}
