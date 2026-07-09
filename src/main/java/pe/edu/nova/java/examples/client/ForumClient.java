package pe.edu.nova.java.examples.client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.Map;

/**
 * HTTP Client declarativo para el microservicio ms-forum.
 * Spring Boot 4 genera la implementación automáticamente.
 */
@HttpExchange
public interface ForumClient {

    @GetExchange("/api/forum/topics")
    Map<String, Object> listTopics();

    @GetExchange("/api/forum/topics/{id}")
    Map<String, Object> getTopic(@PathVariable int id);

    @GetExchange("/api/forum/stats")
    Map<String, Object> getStats();
}
