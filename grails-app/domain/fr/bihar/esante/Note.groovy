package fr.bihar.esante

class Note {

    String description

    static hasMany = [files: CustomFile]

    static belongsTo = Consultation

    static constraints = {
        description nullable: false, blank: false
        files nullable: true
    }

    static mapping = {
        description type: 'text'
    }
}
