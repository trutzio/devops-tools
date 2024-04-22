## Create and push Docker image

```sh
.\mvnw.cmd spring-boot:build-image -D"spring-boot.build-image.imageName=ghcr.io/trutzio/devops-tools"
echo $env:GH_PAT | docker login ghcr.io -u trutzio --password-stdin
docker push ghcr.io/trutzio/devops-tools:latest
```

## Necessary environment variables
- `$env:OTEL_LOGS_EXPORTER="logging"`
- `$env:OTEL_METRICS_EXPORTER="logging"`

## Start application
```sh
java -javaagent:"opentelemetry-javaagent.jar" -jar .\target\devops-tools-0.0.1-SNAPSHOT.jar
```

## Instrumentation without `@WithSpan`
`$env:OTEL_INSTRUMENTATION_METHODS_INCLUDE="my.package.ClassName[method];my.package.ClassName2[method2]"`