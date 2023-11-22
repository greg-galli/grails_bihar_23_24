package fr.bihar.esante

class Consultation {

    Note note
    Date dateCreated

    static hasMany = [pathologies: Pathology]

    static belongsTo = [carnet: Carnet]

    static constraints = {
        note nullable: true
        pathologies nullable: true
    }
}
