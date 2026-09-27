plugins {
    id("pe.edu.nova.java.spring-boot") version "1.0.3"
    id("net.nemerosa.versioning") version "4.0.1"
}

versioning {
    releaseMode = "snapshot"
    displayMode = "snapshot"
    releaseBuild = false
}

group = "pe.edu.nova.java.examples"
version = findProperty("version") as String

// El plugin agrega mavenLocal y mavenCentral; los starters de Nova están en GitHub Packages,
// con las mismas credenciales que el plugin en settings.gradle.kts.
repositories {
    val readToken = System.getenv("NOVA_PACKAGES_READ_TOKEN") ?: System.getenv("GITHUB_TOKEN")
    maven {
        name = "NovaCommonsSpringBootStarter"
        url = uri("https://maven.pkg.github.com/ahincho/nova-java-08-commons-spring-boot-starter")
        credentials {
            username = System.getenv("GITHUB_ACTOR")
            password = readToken
        }
    }
    maven {
        name = "NovaObservabilitySpringBootStarter"
        url = uri("https://maven.pkg.github.com/ahincho/nova-java-09-observability-spring-boot-starter")
        credentials {
            username = System.getenv("GITHUB_ACTOR")
            password = readToken
        }
    }
}

dependencies {
    implementation("pe.edu.nova.java.starters:nova-observability-spring-boot-starter:2.0.0")
    implementation("org.springframework.boot:spring-boot-starter-restclient")
}
