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

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

checkstyle {
    toolVersion = "10.12.1"
    config = resources.text.fromFile(File(projectDir, "app/config/checkstyle/checkstyle.xml"))
}
