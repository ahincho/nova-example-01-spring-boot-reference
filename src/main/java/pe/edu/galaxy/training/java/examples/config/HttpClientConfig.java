package pe.edu.nova.java.examples.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import pe.edu.nova.java.examples.client.CourseClient;
import pe.edu.nova.java.examples.client.ForumClient;

/**
 * Configuración de HTTP Clients declarativos.
 * Usa RestClient de Spring Boot 4 con propagación automática de contexto de traza.
 */
@Configuration
public class HttpClientConfig {

    @Bean
    public CourseClient courseClient(RestClient.Builder restClientBuilder) {
        RestClient restClient = restClientBuilder
                .baseUrl("http://localhost:8081")
                .build();
        return HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient))
                .build()
                .createClient(CourseClient.class);
    }

    @Bean
    public ForumClient forumClient(RestClient.Builder restClientBuilder) {
        RestClient restClient = restClientBuilder
                .baseUrl("http://localhost:8082")
                .build();
        return HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient))
                .build()
                .createClient(ForumClient.class);
    }
}
