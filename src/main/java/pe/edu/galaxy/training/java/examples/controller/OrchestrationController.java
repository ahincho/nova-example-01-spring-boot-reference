package pe.edu.nova.java.examples.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.nova.java.examples.client.CourseClient;
import pe.edu.nova.java.examples.client.ForumClient;
import pe.edu.nova.java.libs.observability.annotation.Traced;

import java.util.Map;

/**
 * Controlador de orquestación que llama a ms-course y ms-forum.
 * Demuestra trazas distribuidas: una petición aquí genera spans
 * en los 3 servicios (example → course, example → forum).
 */
@RestController
@RequestMapping("/api/orchestration")
public class OrchestrationController {

    private final CourseClient courseClient;
    private final ForumClient forumClient;

    public OrchestrationController(CourseClient courseClient, ForumClient forumClient) {
        this.courseClient = courseClient;
        this.forumClient = forumClient;
    }

    /**
     * Llama a ms-course y ms-forum y retorna un resumen.
     * En Grafana Tempo verás una traza con spans de los 3 servicios.
     */
    @GetMapping("/summary")
    @Traced("orchestration.summary")
    public Map<String, Object> summary() {
        Map<String, Object> courses = courseClient.listCourses();
        Map<String, Object> topics = forumClient.listTopics();
        Map<String, Object> forumStats = forumClient.getStats();

        return Map.of(
                "courses", courses,
                "topics", topics,
                "forumStats", forumStats
        );
    }

    /**
     * Obtiene un curso y sus estudiantes desde ms-course.
     * Genera una traza con 2 spans HTTP salientes.
     */
    @GetMapping("/courses/{id}/detail")
    @Traced("orchestration.course-detail")
    public Map<String, Object> courseDetail(@PathVariable int id) {
        Map<String, Object> course = courseClient.getCourse(id);
        Map<String, Object> students = courseClient.getStudents(id);

        return Map.of(
                "course", course,
                "students", students
        );
    }

    /**
     * Obtiene un tema del foro desde ms-forum.
     * Genera una traza distribuida entre example y forum.
     */
    @GetMapping("/forum/topics/{id}")
    @Traced("orchestration.forum-topic")
    public Map<String, Object> forumTopic(@PathVariable int id) {
        return forumClient.getTopic(id);
    }
}
