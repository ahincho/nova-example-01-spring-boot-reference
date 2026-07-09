plugins {
    id("pe.edu.nova.java.spring-boot") version "1.0.0"
    id("net.nemerosa.versioning") version "4.0.1"
}

versioning {
    releaseMode = "snapshot"
    displayMode = "snapshot"
    dirty = { it }
    releaseBuild = false
}

group = "pe.edu.nova.java.examples"
version = findProperty("version") as String

dependencies {
    implementation("pe.edu.nova.java.starters:nova-observability-starter:0.1.0-SNAPSHOT")
    implementation("org.springframework.boot:spring-boot-starter-restclient")
}
