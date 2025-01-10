# Les cas d'usages

| **Cas recommandé**         | **Description**                                    |
|----------------------------|----------------------------------------------------|
| Faible mémoire et CPU      | Applications légères nécessitant peu de ressources |
| Ligne de commande          | Applications rapides et efficaces                  |
| Serverless (ex: Cloud run) | Démarrage instantané pour serverless, scaling de 0 |

##==##
# Les cas d'usages

| **Cas à évaluer** | **Description**                                                       |
|-------------------|-----------------------------------------------------------------------|
| Microservices     | Compatible, mais dépend de la charge et des besoins                   |
| Back-offices      | Possible, mais vérifier les dépendances et performances attendues     |
| Observabilité     | Possible, mais vérifier si on ne perd pas en capacité d'observabilité |

##==##
# Les cas d'usages

| **Mieux avec la JVM**       | **Description**                                                       |
|-----------------------------|-----------------------------------------------------------------------|
| Forte mémoire et CPU        | Applications nécessitant beaucoup de ressources                       |
| Fort trafic                 | La JVM gère mieux les charges élevées grâce au JIT                    |
| Gros monolithes             | Meilleur support des applications complexes                           |
| Dépendances non supportées  | Certaines bibliothèques Java ne sont pas compatibles avec GraalVM     |
| Déploiements très fréquents | Les temps de compilation natifs longs ralentissent les cycles rapides |
