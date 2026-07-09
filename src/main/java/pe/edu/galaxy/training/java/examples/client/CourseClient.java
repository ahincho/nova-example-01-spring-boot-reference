package pe.edu.nova.java.examples.client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.Map;

/**
 * HTTP Client declarativo para el microservicio ms-course.
 * Spring Boot 4 genera la implementación automáticamente.
 */
@HttpExchange
public interface CourseClient {

    @GetExchange("/api/courses")
    Map<String, Object> listCourses();

    @GetExchange("/api/courses/{id}")
    Map<String, Object> getCourse(@PathVariable int id);

    @GetExchange("/api/courses/{id}/students")
    Map<String, Object> getStudents(@PathVariable int id);
}
