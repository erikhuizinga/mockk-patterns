import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

fun Project.configurePublishing() {
    configureJavaPlugin()
}

private fun Project.configureJavaPlugin() {
    apply<JavaPlugin>()
    configure<JavaPluginExtension> { withSourcesJar() }
}
