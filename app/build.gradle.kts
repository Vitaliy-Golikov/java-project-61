plugins {
    application
    jacoco
    id("org.sonarqube") version "7.0.1.6134"
}

repositories {
    mavenCentral()
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

// УДАЛИТЕ блок jacoco {} - он не нужен

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
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
        // property("sonar.coverage.jacoco.xmlReportPaths", "build/reports/jacoco/test/jacocoTestReport.xml") // ЗАКОММЕНТИРУЙТЕ пока
        property("sonar.sourceEncoding", "UTF-8")
        property("sonar.java.source", "21")
    }
}