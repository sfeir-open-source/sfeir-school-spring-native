## Prérequis
Créer une classe de configuration pour ajouter des hints que l'on va nommer 'CompilerHints' et qui va implémenter l'interface
'RuntimeHintsRegistrar'

--- 
A partir de maintenant, l'ordre d'exécution de cette exercice n'est pas important. 
Vous pouvez commencer par ce que vous voulez.


## Objectif : Gérer le cas d'un proxy (HTTP Exchange)

- Ajouter un proxy pour récupérer l'actuator de l'application (avec HTTP Exchange)
 
https://docs.spring.io/spring-framework/reference/integration/rest-clients.html#rest-http-interface

<details>
<summary>Voir comment faire</summary>

``` java
@HttpExchange
public interface HeatlhSpringResource {

	@GetExchange(url = "/actuator/health")
	ResponseEntity<String> health();
}
```

puis dans HelloController

``` java

private final HeatlhSpringResource heatlhSpringResource;

public HelloController() {
    RestClient restClient = RestClient.builder().baseUrl("http://localhost:8080").build();
    RestClientAdapter adapter = RestClientAdapter.create(restClient);
    HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
    heatlhSpringResource = factory.createClient(HeatlhSpringResource.class);
}
    
```

</details>


- Vous pouvez tester le bon fonctionnement en testant l'endpoint `/app/health` via une JVM
(possible de tester avec HTTP client d'Intellij -> resources/http-client/get-actuator.http)

- Essayer de compiler en native et constater l'erreur

- Ajouter le hint nécessaire pour que la compilation fonctionne


## Objectif : Gérer le cas de la réflexion

- Créer une classe MessageService qui aura une méthode privée `private String secretMessage()`

- Ajouter un endpoint /reflect qui utilise la réflexion pour appeler la méthode privée secretMessage() 

<details>
<summary>Voir comment faire</summary>

``` java

@GetMapping("/reflect")
public ResponseEntity<String> testReflection() {
    try {
        Class<?> messageServiceClass = ClassUtils.forName(MessageService.class.getName(),  getClass().getClassLoader());
        Object instance = messageServiceClass.getDeclaredConstructor().newInstance();
        Method secretMethod = messageServiceClass.getDeclaredMethod("secretMessage");
        secretMethod.setAccessible(true);
        String result = (String) secretMethod.invoke(instance);
        return ResponseEntity.ok("Message obtenu par réflexion: " + result);
    } catch (Exception e) {
        return ResponseEntity.status(500)
                .body(e.getMessage());
    }
}

```
</details>

- Vous pouvez tester le bon fonctionnement en testant l'endpoint `/reflect` via une JVM
  (possible de tester avec HTTP client d'Intellij -> resources/http-client/reflection.http)
- Essayer de compiler en native et retester l'endpoint
- Ajouter le hint nécessaire pour que l'endpoint fonctionne


## Objectif : Gérer le cas des ressources

- Ajouter un fichier `src/main/resources/test.txt` qui contient un message

- Ajouter un endpoint /resource qui lit le contenu du fichier secret.txt et l'affiche 

<details>
<summary>Voir comment faire</summary>

``` java
@GetMapping("/resource")
public ResponseEntity<String> testResource() {
    try {
        InputStream fileStream = getClass().getClassLoader().getResourceAsStream("test.txt");
        String content = new BufferedReader(
                new InputStreamReader(fileStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
        return ResponseEntity.ok(content);
    } catch (Exception e) {
        return ResponseEntity.status(500)
                .body(e.getMessage());
    }
}
```
</details>

- Vous pouvez tester le bon fonctionnement en testant l'endpoint `/resource` via une JVM
  (possible de tester avec HTTP client d'Intellij -> resources/http-client/reflection.http)
- Essayer de compiler en native et retester l'endpoint
- Ajouter le hint nécessaire pour que l'endpoint fonctionne

- Supprimer le hint et essayer d'ajouter le hint de façon statique (resource-config.json)
