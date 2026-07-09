plugins {
    id("pe.edu.nova.java.spring-boot") version "1.0.0"
}

group = "pe.edu.nova.java.examples"
version = findProperty("version") as String

dependencies {
    implementation("pe.edu.nova.java.starters:nova-observability-starter:0.1.0-SNAPSHOT")
    implementation("org.springframework.boot:spring-boot-starter-restclient")
}
