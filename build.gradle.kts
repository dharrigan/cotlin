import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel

plugins {
    val kotlinVersion = "1.5.31"
    val versionsVersion = "0.39.0"

    idea
    application
    kotlin("jvm") version kotlinVersion
    id("com.github.ben-manes.versions") version versionsVersion
}

group = "online.harrigan"
version = System.getenv("PROJECT_VERSION") ?: "0.0.0-SNAPSHOT"
description = "cotlin"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
}

repositories {
    mavenCentral()
}

configurations {
    all { resolutionStrategy.cacheChangingModulesFor(0, TimeUnit.SECONDS) }
    "testImplementation" { exclude(group = "junit", module = "junit") }
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
}

idea {
    module.isDownloadJavadoc = true
    project {
        vcs = "Git"
        languageLevel = IdeaLanguageLevel(java.sourceCompatibility)
    }
}

tasks {
    withType<JavaCompile>().configureEach {
        options.encoding = "UTF-8"
        options.compilerArgs.addAll(arrayOf("-Xlint:all", "-parameters"))
        options.isIncremental = true
    }
    compileKotlin {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            javaParameters = true
            jvmTarget = "11"
        }
    }
}

application {
    mainClass.set("online.harrigan.cotlin.ApplicationKt")
}
