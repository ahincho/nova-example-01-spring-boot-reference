package pe.edu.nova.java.examples.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.nova.java.examples.dto.ClienteDto;
import pe.edu.nova.java.libs.observability.annotation.Traced;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Map;

/**
 * Controlador de ejemplo que retorna un DTO con datos sensibles.
 * Los campos anotados con {@code @Masked} se enmascaran automáticamente
 * en la respuesta JSON gracias al meta-framework Nova Platform.
 */
@RestController
@RequestMapping("/api")
public class HelloController {

    /**
     * Retorna un cliente de ejemplo con datos sensibles enmascarados.
     *
     * @return DTO del cliente con campos sensibles enmascarados en el JSON
     */
    @GetMapping("/hello")
    public ClienteDto hello() {
        return new ClienteDto(
                "Juan Pérez",
                "juan.perez@gmail.com",
                "+51987654321",
                "12345678",
                "4111111111111111"
        );
    }

    /**
     * Endpoint lento para demostrar trazas con latencia configurable.
     *
     * @return Mapa con el tiempo de espera y estado
     */
    @GetMapping("/slow")
    @Traced("demo.slow-endpoint")
    public Map<String, Object> slow() throws InterruptedException {
        int ms = ThreadLocalRandom.current().nextInt(100, 2501);
        Thread.sleep(ms);
        return Map.of("delayed_ms", ms, "status", "ok");
    }

    /**
     * Endpoint que lanza un error simulado para demostrar observabilidad de errores.
     *
     * @return Nunca retorna, siempre lanza excepción
     */
    @GetMapping("/error")
    public Map<String, Object> error() {
        throw new RuntimeException("Error simulado para demo de observabilidad");
    }
}
