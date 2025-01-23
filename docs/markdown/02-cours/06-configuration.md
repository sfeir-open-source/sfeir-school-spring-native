# Prérequis avant de se lancer

<ul>
  <li>
    <strong>Support Java 17 minimal</strong> : utiliser Java 21 est encore mieux pour bénéficier des dernières fonctionnalités et optimisations
  </li>
  <li>
    <strong> Spring boot 3+ </strong>
  </li>
  <li>
    <strong> GraalVM Native Image </strong> : vérifier l'installation avec <code> native-image --version </code>
    <a href="https://www.graalvm.org/"> https://www.graalvm.org/ </a>
  </li>
</ul>

##==##

<!-- .slide: class="with-code" -->

# Ajout de la configuration GraalVM

```xml
<!-- Maven -->
<plugin>
  <groupId>org.graalvm.buildtools</groupId>
  <artifactId>native-maven-plugin</artifactId>
</plugin>
```

<br/>

```groovy
// Gradle Groovy
plugins {
  id 'org.graalvm.buildtools.native' version '0.10.4'
}
```

<br/>

```kotlin
// Gradle Kotlin
plugins {
  id("org.graalvm.buildtools.native") version "0.10.4"
}

```
##==##
<!-- .slide: class="with-code" -->

# Compiler

```shell
# Maven
./mvnw -Pnative native:compile 

# Gradle
./gradlew nativeCompile
```

```shell
cd target
./my-app
```


##==##

# Hints

Les hints sont des instructions spécifiques qui aident le compilateur native-image à comprendre ce dont une application a besoin
lors de la compilation.

<br/>
Certaines fonctionnalités dynamiques courantes en Java ne sont pas détectées lors de cette analyse, comme :

<br />
<br />

<ul>
  <li> <strong> Réflexion</strong> : utilisation des classes et méthodes via leur nom en runtime </li>
  <li> <strong> Ressources </strong> : chargement de fichiers ou propriétés du classpath </li>
  <li> <strong> Proxy </strong> : interfaces implémentées dynamiquement </li>
</ul>

##==##

<!-- .slide: class="with-code" -->

# Hints

## Approche programmatique
```java
public class MyRuntimeHints implements RuntimeHintsRegistrar {

  @Override
  public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
    // Register method for reflection
    try {
      Class<?> messageServiceClass = Class.forName(MessageService.class.getName());
      Method method = messageServiceClass.getDeclaredMethod("secretMessage");
      hints.reflection().registerMethod(method, ExecutableMode.INVOKE);
      hints.reflection().registerConstructor(messageServiceClass.getDeclaredConstructor(), ExecutableMode.INVOKE);
    } catch (ClassNotFoundException | NoSuchMethodException e) {
      System.err.println("Error while registering reflection hints: " + e.getMessage());
    }

    // Register resources
    hints.resources().registerPattern("my-resource.txt");

    // Register serialization
    hints.serialization().registerType(MySerializableClass.class);

    // Register proxy
    hints.proxies().registerJdkProxy(MyInterface.class);
  }

}
```


##==##

<!-- .slide: class="with-code" -->

# Hints
## Approche programmatique
```java

@SpringBootApplication
@ImportRuntimeHints(MyRuntimeHints.class)
public class TestNativeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestNativeApplication.class, args);
	}

}

```

##==##

# Hints
## Approche statique

Les hints générés pendant le traitement AOT sont écrits dans le répertoire :

<code> META-INF/native-image/{groupId}/{artifactId}/ </code>

<br /> 

Pour éviter les conflits, placez vos fichiers de hints statiques dans un répertoire distinct, par exemple :

<code> META-INF/native-image/{groupId}/{artifactId}-additional-hints/ </code>

💡 Cette séparation permet de distinguer clairement les hints générés automatiquement de vos configurations personnalisées

##==##

# Hints
## Approche statique

<ul>
  <li> <strong> Ressources hints </strong> : resource-config.json</li>
  <li> <strong> Reflection hints </strong> : reflect-config.json</li>
  <li> <strong> Serialization hints </strong> : serialization-config.json</li>
  <li> <strong> Proxy hints </strong> : proxy-config.json</li>
</ul>


##==##
<!-- .slide: class="with-code" -->
# Hints
## Exemple : resource-config.json

```json
{
  "resources": {
    "includes": [
      {"pattern": "my-resource.txt"}
    ]
  }
}
```
