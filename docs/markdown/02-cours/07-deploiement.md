<!-- .slide: class="with-code" -->
# Déployer l'application avec Docker

```Dockerfile
# Maven

# Build stage
FROM ghcr.io/graalvm/native-image-community:21 AS builder
WORKDIR /app
COPY . /app
RUN ./mvnw -Pnative native:compile

# Runtime stage
FROM ubuntu:22.04
WORKDIR /app
# Copie l'exécutable natif depuis l'étape de build
COPY --from=builder /app/target/my-app-name /app/application

# Expose le port
EXPOSE 8080

# Démarrage de l'application
ENTRYPOINT ["/app/application"]
```
##==##

<!-- .slide: class="with-code" -->
# Déployer l'application avec Docker

```Dockerfile
# Gradle

# Build stage
FROM ghcr.io/graalvm/native-image-community:21 AS builder
WORKDIR /app
COPY . /app
RUN ./gradlew nativeCompile

# Runtime stage
FROM ubuntu:22.04
WORKDIR /app
# Copie l'exécutable natif depuis l'étape de build
COPY --from=builder /app/build/native/nativeCompile/my-app-name /app/application

# Expose le port
EXPOSE 8080

# Démarrage de l'application
ENTRYPOINT ["/app/application"]
```
##==##

<!-- .slide: class="with-code" -->

# Déployer l'application avec Docker

```shell

# Build de l'image
docker build -t myapp-native .

# Exécution du conteneur
docker run -p 8080:8080 myapp-native
  
```

##==##

<!-- .slide: class="with-code" -->

# Déployer l'application avec Docker et Spring Boot

```xml
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <configuration>
        <excludes>
            <exclude>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
            </exclude>
        </excludes>
        <image>
            <!-- force caches names to prevent them from being cleared-->
            <name>${project.groupId}/library/${project.artifactId}</name>
            <buildCache>
                <volume>
                    <name>cache-${project.artifactId}.build</name>
                </volume>
            </buildCache>
            <launchCache>
                <volume>
                    <name>cache-${project.artifactId}.launch</name>
                </volume>
            </launchCache>
        </image>
    </configuration>
    <executions>
        <execution>
            <id>build-image</id>
            <goals>
                <goal>build-image-no-fork</goal>
            </goals>
        </execution>
        <execution>
            <goals>
                <goal>build-info</goal>
            </goals>
            <configuration>
                <additionalProperties>
                    <encoding.source>UTF-8</encoding.source>
                    <encoding.reporting>UTF-8</encoding.reporting>
                </additionalProperties>
            </configuration>
        </execution>
    </executions>
</plugin>
```

##==##

<!-- .slide: class="with-code" -->

# Déployer l'application avec Docker et Spring Boot

```xml
<plugin>
    <groupId>org.graalvm.buildtools</groupId>
    <artifactId>native-maven-plugin</artifactId>
    <executions>
        <execution>
            <id>build-native</id>
            <goals>
                <goal>compile-no-fork</goal>
            </goals>
            <phase>package</phase>
        </execution>
    </executions>
</plugin>
```

##==##

<!-- .slide: class="with-code" -->

# Déployer l'application avec Docker et Spring Boot

```yaml
version: '3.5'

services:
  springnative-lab :
    container_name: springnative-lab
    image: com.sfeir.codelabs/library/springnative-lab:latest
```