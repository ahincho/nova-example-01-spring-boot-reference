package pe.edu.nova.java.examples;

import pe.edu.nova.java.starters.boot.NovaPlatformApplication;
import pe.edu.nova.java.starters.boot.NovaPlatformSpringBootApplication;

/**
 * Aplicación de ejemplo que demuestra el uso del meta-framework Nova Platform.
 */
@NovaPlatformSpringBootApplication
public class NovaExampleApplication {
    public static void main(String[] args) {
        NovaPlatformApplication.run(NovaExampleApplication.class, args);
    }
}
