plugins {
    id("pe.edu.galaxy.training.spring-boot") version "1.0.0"
}

group = "pe.edu.galaxy.training.java.examples"
version = "1.0.0"

dependencies {
    implementation("pe.edu.galaxy.training.java.starters:observability-spring-boot-starter:1.0.0")
    implementation("org.springframework.boot:spring-boot-starter-restclient")
}
