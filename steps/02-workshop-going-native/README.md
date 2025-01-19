# Tâche à réaliser

Ajouter les dépendances graalvm (native-maven-plugin)

https://graalvm.github.io/native-build-tools/latest/maven-plugin.html

Faire un test de perf normal/native

# Tips

Pour compiler nativement :

    ./mvnw native:compile -Pnative

Pour executer nativement :

- target/springnative-lab  (l'executable prend le nom de l'artifactId par défaut)