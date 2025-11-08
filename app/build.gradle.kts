plugins {
    application
    jacoco
    id("com.github.ben-manes.versions") version "0.51.0"
    id("org.sonarqube") version "7.0.1.6134"
}

sonar {
    properties {
        property("sonar.projectKey", "Vitaliy-Golikov_java-project-61")
        property("sonar.organization", "vitaliy-golikov")
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

application {
    mainClass.set("hexlet.code.App")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

repositories {
    mavenCentral()
}