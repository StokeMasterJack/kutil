plugins {
    `maven-publish`
    kotlin("multiplatform") version Versions.kotlin
    kotlin("plugin.serialization") version Versions.kotlin
}

group = "ss.kutil"
version = "1.02"

repositories {
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    mavenLocal()
    jcenter()
    mavenCentral()
}

kotlin {

    jvm()
    //  js("nodeJs")
    //  linuxX64("linux") {/* Specify additional settings for the 'linux' target here */ }
    //  https://kotlinlang.org/docs/reference/building-mpp-with-gradle.html#setting-up-targets

    sourceSets {

        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:${Versions.serialization}")

            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        jvm().compilations["main"].defaultSourceSet {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.serialization}")
            }
        }
        jvm().compilations["test"].defaultSourceSet {
            dependencies {
                implementation(kotlin("test-junit"))


            }
        }
    }
}