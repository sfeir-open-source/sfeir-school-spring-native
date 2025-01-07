# Comment la compilation native fonctionne-t-elle ?

<ul>
  <li>La compilation native se base sur le principe de l'Ahead Of Time (AOT) où le code est compilé avant son exécution </li>
  <li>Elle suppose que toutes les classes nécessaires à l'exécution (runtime) peuvent être identifiées au moment de la compilation (build time) </li>
  <li>Le compilateur AOT analyse le code et élimine les portions inutilisées ainsi que les dépendances superflues </li>
  <li>Le fichier généré est une image native exécutable directement par le système d'exploitation, sans nécessiter de JVM. </li>
</ul>

##==##

# Comment la compilation native fonctionne-t-elle ?

<img class="full-width" src="./assets/images/native.jpg">

##==##

# Comparaison avec la compilation JIT

| Aspect                        | AOT (Ahead Of Time)                                      | JIT (Just-In-Time)                                      |
|-------------------------------|---------------------------------------------------------|--------------------------------------------------------|
| Moment de la compilation       | Avant l'exécution, lors du build time                   | Pendant l'exécution, à la volée                        |
| Performance au démarrage       | Démarrage rapide grâce à l'image native optimisée       | Démarrage plus lent à cause de la compilation à l'exécution |
| Optimisation dynamique         | Pas d'optimisation après la compilation                 | Optimisation continue basée sur les statistiques d'exécution |
| Taille de l'exécutable         | Plus grande, car toutes les dépendances nécessaires sont incluses | Plus légère, mais nécessite une JVM séparée             |
| Dépendance à la JVM            | Aucune : l'exécutable fonctionne directement sur le système d'exploitation | Requiert une JVM pour exécuter et compiler le code       |




