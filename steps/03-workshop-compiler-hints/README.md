## Prérequis
Créer une classe de configuration pour ajouter des hints que l'on va nommer 'CompilerHints' et qui va implémenter l'interface
'RuntimeHintsRegistrar'

--- 
A partir de maintenant, l'ordre d'exécution de cette exercice n'est pas important. 
Vous pouvez commencer par ce que vous voulez.


## Objectif : Gérer le cas d'un proxy (HTTP Exchange)

Ajouter ce proxy pour récupérer l'actuator de l'application

``` java
@HttpExchange
public interface HeatlhSpringResource {

	@GetExchange(url = "/actuator/health")
	ResponseEntity<String> health();
}
```

Vous pouvez tester le bon fonctionnement en testant l'endpoint `/actuator/health` via une JVM
(possible de tester avec HTTP client d'Intellij -> resources/http-client/get-actuator.http)

Essayer de compiler en native et constater l'erreur

Ajouter le hint nécessaire pour que la compilation fonctionne
