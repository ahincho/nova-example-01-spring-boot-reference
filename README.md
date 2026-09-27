# Nova Java Example

A runnable Spring Boot service built on the Nova Platform. It exists to
be read: it is the smallest thing that shows what the meta-framework
does to an ordinary application.

## What it demonstrates

| Class | Shows |
|---|---|
| `NovaExampleApplication` | Bootstrapping through the Nova starter |
| `HelloController` | A controller returning a domain object, wrapped into `ApiResponse<T>` by the platform |
| `OrchestrationController` | Calling two downstream services and composing the result |
| `CourseClient`, `ForumClient` | Typed HTTP clients over `RestClient` |
| `HttpClientConfig` | Where the clients are configured |
| `ClienteDto` | A DTO carrying masked fields |

It depends on `nova-observability-starter`, so a run also emits the Four
Golden Signals and OTLP traces.

## Run

```bash
./gradlew bootRun
```

Then:

```bash
curl localhost:8080/hello
```

The response comes back in the platform envelope rather than as a bare
object — that wrapping is the point of the example.

Resolving the Nova dependencies needs a GitHub token with
`read:packages` in `gpr.user` / `gpr.key` or `GITHUB_ACTOR` /
`GITHUB_TOKEN`.

## Where to go next

| | |
|---|---|
| Generate your own service | [nova-java-spring-boot-archetype](https://github.com/ahincho/nova-java-17-spring-boot-archetype) |
| Add Nova to an existing one | [nova-java-spring-boot-starter](https://github.com/ahincho/nova-java-12-spring-boot-starter) |
| The Quarkus equivalent | [nova-java-quarkus-example](https://github.com/ahincho/nova-example-04-quarkus-reference) |

## Requirements

Java 25.

## License

Eclipse Public License 2.0 — see [LICENSE](LICENSE).

Copyright © 2026 Angel Hincho.
