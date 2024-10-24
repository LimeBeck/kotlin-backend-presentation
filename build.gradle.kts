val revealKtVersion = "0.3.1"

group = "dev.limebeck"
version = "1.0.0"

plugins {
    kotlin("jvm") version "2.0.0-RC2"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("dev.limebeck:revealkt-script-definition:$revealKtVersion")
}

//sourceSets {}
