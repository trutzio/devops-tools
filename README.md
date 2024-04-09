## Docker Image in GitHub Container Registry pushen

```sh
echo $env:GH_PAT | docker login ghcr.io -u trutzio --password-stdin
.\mvnw.cmd spring-boot:build-image -D"spring-boot.build-image.imageName=ghcr.io/trutzio/devops-tools"
docker push ghcr.io/trutzio/devops-tools:latest
```