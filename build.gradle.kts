plugins {
    kotlin("jvm") version "2.0.20"
}

group = "dev.artisra"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-params
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.2") // Needed
    // https://mvnrepository.com/artifact/io.kotest/kotest-assertions-core-jvm
    testImplementation("io.kotest:kotest-assertions-core:5.8.1") // Cool assertions

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}