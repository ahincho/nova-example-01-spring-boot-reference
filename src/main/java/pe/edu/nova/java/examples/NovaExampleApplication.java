package pe.edu.nova.java.examples;

import pe.edu.nova.java.starters.boot.NovaApplication;
import pe.edu.nova.java.starters.boot.NovaSpringBootApplication;

/**
 * Aplicación de ejemplo que demuestra el uso del meta-framework Nova Platform.
 */
@NovaSpringBootApplication
public class NovaExampleApplication {
    public static void main(String[] args) {
        NovaApplication.run(NovaExampleApplication.class, args);
    }
}
