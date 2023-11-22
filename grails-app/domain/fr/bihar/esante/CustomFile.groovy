package fr.bihar.esante

class CustomFile {

    /**
     * Besoin d'un path + url pour accéder au fichier
     * path + name = le moyen d'y accéder par le système de fichier
     * url + name = le moyen d'y accéder depuis l'extérieur
     */
    String name

    static belongsTo = Note

    static constraints = {
        name nullable: false, blank: false
    }
}
