import java.util.*
import java.io.File

// 配置local properties
val localProperties = Properties().apply {
    load(File(rootDir, "local.properties").inputStream())
}

// 先找gradle.properties再找local.properties
fun properties(key: String) = project.findProperty(key)?.toString() ?: localProperties.getProperty(key)


plugins {
    id("org.jetbrains.intellij") version "1.4.0"
    kotlin("jvm") version "1.5.10"
    java
}

group = properties("pluginGroup")
version = properties("pluginVersion")

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    pluginName.set(properties("pluginName"))
    version.set(properties("platformVersion"))
    type.set(properties("platformType"))

    // Plugin Dependencies. Uses `platformPlugins` property from the gradle.properties file.
    plugins.set(properties("platformPlugins").split(',').map(String::trim).filter(String::isNotEmpty))
}
tasks {
    patchPluginXml {
        version.set(properties("pluginVersion"))
        sinceBuild.set(properties("pluginSinceBuild"))
        untilBuild.set(properties("pluginUntilBuild"))
        pluginDescription.set("a website pocket")
        changeNotes.set("""
            Add change notes here.<br>
            <em>most HTML tags may be used</em>        """.trimIndent())
    }

    runIde {
        ideDir.set(File(properties("androidStudioPath")))
    }

}
tasks.getByName<Test>("test") {
    useJUnitPlatform()
}