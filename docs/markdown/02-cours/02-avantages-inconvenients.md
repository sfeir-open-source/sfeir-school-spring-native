# Les avantages


<ul>
  <li class="fragment"><strong>Démarrage ultra-rapide 🚀 </strong>
    <ul>
      <li>Les binaires natifs s'exécutent directement sans passer par une JVM</li>
      <li>Temps de démarrage réduit à quelques millisecondes</li>
    </ul>
  </li>

  <br />
  <li class="fragment"> <strong> Pas de warmup ⚡️</strong>
    <ul>
      <li>Optimisations effectuées lors du build time grâce à la compilation AOT (Ahead Of Time)</li>
      <li>L'exécutable est directement prêt à tourner à pleine performance dès son démarrage</li>
    </ul>
  </li>

  <br />
  <li class="fragment"> <strong>Faible utilisation des ressources 💾 </strong>
    <ul>
      <li>Consommation mémoire réduite</li>
      <li>Pas de surcharge liée à la compilation dynamique</li>
    </ul>
  </li>
</ul>

##==##

# Les avantages

<ul>
  <li class="fragment"> <strong> Packaging compact 📦 </strong>
    <ul>
      <li>Binaires plus petits, adaptés aux containers légers</li>
      <li>Facilité de déploiement dans des environnements modernes</li>
    </ul>
  </li>

  <br />
  <li class="fragment"> <strong> Réduction des coûts d'infrastructure 💰  </strong>
    <ul>
      <li>Moins de ressources nécessaires pour exécuter l'application</li>
    </ul>
  </li>
</ul>


##==##

# Les contreparties

<ul>
  <li> <strong> Compilation très lente 🕒</strong>
    <ul>
      <li>Analyse approfondie de l'application pour identifier les chemins d'exécution</li>
      <li>Consommation élevée de mémoire et CPU pendant le processus de compilation</li>
      <li>Impact sur l’expérience développeur </li>
    </ul>
  </li>
  <br />
  <li> <strong> Compilation gourmande en ressource 🕒 </strong>
    <ul>
      <li>Consommation élevée de mémoire et CPU pendant le processus de compilation</li>
      <li>Nécessite des poste de dév puissant ( min 16go RAM )</li>
    </ul>
  </li>
</ul>

##==##

# Les contreparties

<ul>
  <li> <strong> Compatibilité limitée ⚠️ </strong>
    <ul>
      <li>Toutes les librairies Java ne prennent pas en charge GraalVM</li>
      <li>Les bibliothèques qui utilisent des fonctionnalités dynamiques (réflexion, proxies) nécessitent des configurations manuelles</li>
      <li>Certaines dépendances populaires peuvent être partiellement ou totalement incompatibles </li>
    </ul>
  </li>
  <br />
  <li> <strong> Perte de portabilité ⚠️ </strong>
    <ul>
      <li>L'executable natif est spécifique au hardware sur lequel il a été compilé</li>
      <li>Perte de la possibilité d'éxecuter sur n'importe quel machine/JVM</li>
      <li>La conteneurisation rend cette problèmatique transparente</li>
    </ul>
  </li>  
</ul>




