package fr.bihar.esante

class Carnet {
// TODO : Facteurs aggravants pour aller plus loin

    String fname
    String lname
    Date dob
    String tel
    Integer weight
    Integer height
    String bloodType

    static belongsTo = User

    static hasMany = [consultations: Consultation]

    static constraints = {
        fname nullable: false, blank: false
        lname nullable: false, blank: false
        dob nullable: false
        tel nullable: true
        weight nullable: false
        height nullable: false
        bloodType nullable: false
    }
}
