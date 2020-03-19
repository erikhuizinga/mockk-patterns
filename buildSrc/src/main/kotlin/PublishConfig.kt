import com.jfrog.bintray.gradle.BintrayExtension
import com.jfrog.bintray.gradle.BintrayPlugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.get

fun Project.configurePublishing(
    version: String,
    groupId: String,
    artifactId: String
) {
    configureJavaPlugin()
    val publication = "${artifactId}Publication"
    configureMavenPublishing(
        version = version,
        groupId = groupId,
        artifactId = artifactId,
        publication = publication
    )
    configureBintrayPlugin(
        version = version,
        artifactId = artifactId,
        publication = publication
    )
}

private fun Project.configureJavaPlugin() {
    apply<JavaPlugin>()
    configure<JavaPluginExtension> { withSourcesJar() }
}

private fun Project.configureMavenPublishing(
    version: String,
    groupId: String,
    artifactId: String,
    publication: String
) {
    apply<MavenPublishPlugin>()
    configure<PublishingExtension> {
        publications {
            create<MavenPublication>(publication) {
                this.groupId = groupId
                this.artifactId = artifactId
                this.version = version
                from(components["java"])
            }
        }
    }
}

private fun Project.configureBintrayPlugin(
    version: String,
    artifactId: String,
    publication: String
) {
    apply<BintrayPlugin>()
    configure<BintrayExtension> {
        configure<BintrayExtension> {
            dryRun = true
            publish = true
            user = properties["bintrayUser"] as? String
            key = properties["bintrayKey"] as? String
            pkg.apply {
                this.version.apply {
                    name = version
                    vcsTag = "${artifactId}v$version"
                }
                repo = "maven"
                name = artifactId
                userOrg = "erikhuizinga"
                setLicenses("Apache-2.0")
                vcsUrl = "https://github.com/erikhuizinga/mockk-patterns.git"
            }
            setPublications(publication)
        }
    }
}
