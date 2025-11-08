import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    application
    id("org.sonarqube") version "7.0.1.6134"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("hexlet.code.App")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = setOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        showStandardStreams = true
    }
}

sonar {
    properties {
        property("sonar.projectKey", "Vitaliy-Golikov_java-project-61")
        property("sonar.organization", "vitaliy-golikov")
        property("sonar.projectName", "java-project-61")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.token", System.getenv("SONAR_TOKEN"))
        property("sonar.sources", "src/main/java")
        property("sonar.tests", "src/test/java")
        property("sonar.java.binaries", "build/classes")
        property("sonar.junit.reportPaths", "build/test-results/test")
        property("sonar.sourceEncoding", "UTF-8")
        property("sonar.java.source", "21")
    }
}