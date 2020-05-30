plugins {
    `maven-publish`
    kotlin("jvm") version Versions.kotlin
    kotlin("plugin.serialization") version Versions.kotlin
}

group = "ss.kutil"
version = "1.02"

repositories {
//    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    mavenLocal()
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk7"))
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.serialization}")

    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
}


