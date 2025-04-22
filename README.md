## Create and push Docker image

```sh
.\mvnw.cmd spring-boot:build-image -D"spring-boot.build-image.imageName=ghcr.io/trutzio/devops-tools"
echo $env:GH_PAT | docker login ghcr.io -u trutzio --password-stdin
docker push ghcr.io/trutzio/devops-tools:latest
```

## Instrumentation 

- `@WithSpan` on any desired method
- without `@WithSpan` `$env:OTEL_INSTRUMENTATION_METHODS_INCLUDE="my.package.ClassName[method];my.package.ClassName2[method2]"`

## Start penetration

```shell
docker run --rm ricoli/hey -n 1 -c 1 http://host.docker.internal:8080/dice
```