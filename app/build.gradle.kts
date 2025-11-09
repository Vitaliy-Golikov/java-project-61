plugins {
    application
    id("org.sonarqube") version "4.4.1.3373"
    checkstyle
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("hexlet.code.App")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

sonar {
    properties {
        property("sonar.projectKey", "Vitaliy-Golikov_java-project-61")
        property("sonar.organization", "vitaliy-golikov")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.gradle.skipCompile", "true")
    }
}

tasks.register("run-dist") {
    dependsOn("installDist")
    doLast {
        println("Application installed to: build/install/app/")
        println("Run: .\\build\\install\\app\\bin\\app.bat")
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}