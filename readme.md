
# Objectifs du projet

Vous devez réaliser un projet qui consiste à créer une plateforme qui permettra aux utilisateurs d'enregistrer et suivre leur parcours de santé.

# Les entités

Pour gérer ce projet vous aurez besoin de quelques entités ...

## Utilisateur

Un utilisateur identifié sera capable de s'identifier sur la plateforme et pourra créer renseigner les informations contenues dans son carnet de santé

## Consultation

Les consultations effectuées par le patient pourront être sauvegardées dans le carnet de santé, ces consultations auront un rapport sous forme d'une note et ces notes pourront contenir des illustrations, sous forme de fichiers

## Pathology

Il s'agit d'une simple entité permettant de lister les pathologies qui seront diagnostiquées lors des consultations

## CustomFile

Il s'agit simplement d'une illustration, une image, identifiée par un simple nom de fichier, ce nom de fichier sera utilisé en conjonction avec des chemins stockés dans les fichiers de configuration pour composer le chemin interne (path) et le chemin externe (url)


# Ce qui est attendu

## Backend

Vous devez produire une plateforme permettant de ...
- Créer
- Voir de manière unitaire ou en liste
- Modifier
- Supprimer


... des **Users**, **Consultations** ainsi que des **Pathologies**

Ces pages devront être ergonomiquement respectables, présenter toutes les informations utiles et donner la possibilité de modifier les **Notes** et les **Illustrations** des **Consultations** dans le formulaire de ce dernier

Pour les illustrations, un upload de fichier est attendu

## Api

Vous devrez produire une API REST répondant aux requêtes suivantes :
- GET, PUT, PATCH et DELETE sur /api/user/{id}
- GET, POST sur /api/users
- GET, PUT, PATCH et DELETE sur /api/consultation/{id}
- GET, POST sur /api/consultations

Les requêtes seront faites avec un corps en JSON et la réponse pourra être alternativement du JSON ou du XML selon l'encodage demandé lors de l'appel

Les réponses devront retourner les codes d'erreur appropriés accompagnés de messages lorsque le problème n'est pas trivial

### Tests
Vous devrez implémenter une série de tests pour l'API que vous aurez produit, au minimum un test valide et invalide pour chaque point d'entrée

Le format des tests est à votre discrétion (curl, Postman, ...) mais vous devrez les jouer pendant la démonstration

### Documentation

Votre API devra être documentée sur le modèle suivant

#### Get un user

```http
  GET /api/user/{id}
```

| Parameter | Type     | Description                         |
| :-------- | :------- |:------------------------------------|
|   `id`    | `string` | **Required**. L'identifiant du user |

# Livraison

La livraison se fera **impérativement** sur un Github Classroom qui vous sera communiqué, la date de rendu sera précisée dans l'assignment que vous rejoindrez, aucune livraison ne sera acceptée par mail ou autre

La livraison contiendra :
- Le code de votre projet
- Un readme clair qui expliquera ce que vous avez fait, ce que vous n'avez pas pu faire et qui donnera des précisions sur le projet (versions utilisées) ainsi que les manipulations à effectuer afin que je puisse faire tourner votre projet sans problème
- La restitution se fera soit sous la forme d'une soutenance soit via une vidéo de démonstration qui respectera un scénario pré-établi qui vous sera transmis.


# Notation

Vous partez d'un capital de 20 points et vous pourrez en perdre pour plusieurs raison :
- Le code est de mauvaise qualité (jusqu'à -5 points)
- L'ergonomie est franchement mauvaise (jusqu'à -3 points)
- Le rendu est franchement mauvais (jusqu'à -3 points)
- Vous n'avez pas fourni de readme avec votre projet (-5 points)
- Vous n'avez pas fourni un des éléments demandés dans la section du dessus (-1 à -5 points par élément)
- Plagiat (-10 à -25 points), vous avez le droit de prendre du code en ligne tant que vous le comprenez mais ne prenez pas le code d'un camarade, la sentence vaut pour les deux groupes

Si vous réalisez des fonctionnalités non demandées, je rajoute des bonus, par exemple :
- Une carte qui présente les points d'intérêt
- Un formulaire d'upload drag & drop en ajax avec preview
- ...
