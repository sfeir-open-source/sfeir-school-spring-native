# Tâche à réaliser 

 - Ajouter une classe de configuration activé par un profil (dev par exemple)
 - Ajouter un log dans le constructeur pour tracer l'activation de la config

Tester en normal/natif, que se passe-t-il ?

 - Ajouter le profile a la compilation, cela change-t-il quelque chose ?

# Tips
Lancer l'app avec un profile

    target/springnative-lab --spring.profiles.active=dev

Consulter la documentation spring sur les limitations des images graalvm : https://docs.spring.io/spring-boot/reference/packaging/native-image/introducing-graalvm-native-images.html
