plugins {
//    `maven-publish`
    id("maven-publish")
    kotlin("jvm") version Versions.kotlin
    kotlin("plugin.serialization") version Versions.kotlin
}

group = "ss.kutil"
version = "1.03"

repositories {
    jcenter()
    mavenCentral()
//    mavenLocal()
}

val sourcesJar by tasks.creating(Jar::class) {
    dependsOn(JavaPlugin.CLASSES_TASK_NAME)
    @Suppress("DEPRECATION")
    classifier = "sources"
    from(sourceSets["main"].allSource)
}

publishing {
    publications {
        create<MavenPublication>("default") {
            from(components["java"])
            artifact(sourcesJar)
        }
    }
    repositories {
        mavenLocal()
    }
}


dependencies {
    implementation(kotlin("stdlib-jdk7"))
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.serialization}")

    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
}


