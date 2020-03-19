import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun Project.kotlinJvmConfig() {
    apply<KotlinPlatformJvmPlugin>()
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions.jvmTarget = "1.8"
    }
}
