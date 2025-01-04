# Les avantages


<ul>
  <li class="fragment">Démarrage ultra-rapide 🚀
    <ul>
      <li>Les binaires natifs s'exécutent directement sans passer par une JVM</li>
      <li>Temps de démarrage réduit à quelques millisecondes</li>
    </ul>
  </li>

  <br />
  <li class="fragment">Pas de warmup ⚡️
    <ul>
      <li>Optimisations effectuées lors du build time grâce à la compilation AOT (Ahead Of Time)</li>
      <li>L'exécutable est directement prêt à tourner à pleine performance dès son démarrage</li>
    </ul>
  </li>

  <br />
  <li class="fragment">Faible utilisation des ressources 💾
    <ul>
      <li>Consommation mémoire réduite</li>
      <li>Pas de surcharge liée à la compilation dynamique</li>
    </ul>
  </li>
</ul>

##==##

# Les avantages

<ul>
  <li class="fragment">Packaging compact 📦
    <ul>
      <li>Binaires plus petits, adaptés aux containers légers</li>
      <li>Facilité de déploiement dans des environnements modernes</li>
    </ul>
  </li>

  <br />
  <li class="fragment">Réduction des coûts d'infrastructure 💰
    <ul>
      <li>Moins de ressources nécessaires pour exécuter l'application</li>
    </ul>
  </li>
</ul>


##==##

# Les contreparties

<ul>
  <li>Compilation très lente 🕒
    <ul>
      <li>Analyse approfondie de l'application pour identifier les chemins d'exécution</li>
      <li>Consommation élevée de mémoire et CPU pendant le processus de compilation</li>
      <li>Impact sur l’expérience développeur </li>
    </ul>
  </li>
</ul>

##==##

# Les contreparties

<ul>
  <li>Compatibilité limitée ⚠️
    <ul>
      <li>GraalVM ne prend pas en charge toutes les librairies Java</li>
      <li>Les bibliothèques qui utilisent des fonctionnalités dynamiques (réflexion, proxies) nécessitent des configurations manuelles</li>
      <li>Certaines dépendances populaires peuvent être partiellement ou totalement incompatibles </li>
    </ul>
  </li>
</ul>




