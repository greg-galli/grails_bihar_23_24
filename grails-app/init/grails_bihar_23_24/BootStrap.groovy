package grails_bihar_23_24

import fr.bihar.esante.*

class BootStrap {

    def init = { servletContext ->

        // On commence par créer les 4 rôles dont on va avoir besoin
        ["ROLE_ADMIN", "ROLE_DOC", "ROLE_PATIENT", "ROLE_AUX"].each {
            new Role(authority: it).save(flush: true)
        }

        ["Grippe", "Hypertension", "Diabete", "Cancer", "VIH", "Alergies", "Tuberculose"].each {
            String maladie ->
                new Pathology(name: maladie).save(flush: true)
        }

        def adminUser = new User(username: "admin", password: "admin").save()
        UserRole.create(adminUser, Role.findByAuthority('ROLE_ADMIN'), true)

        ["Geraud", "Ingrid", "Rana"].each {
            String name ->
                def userInstance = new User(username: name, password: "password", email: "$name@etu.estia.fr").save()
                UserRole.create(userInstance, Role.findByAuthority('ROLE_PATIENT'), true)

                // On crée le carnet pour chaque User
                def carnetInstance = new Carnet(fname: name, lname: "lname $name", dob: new Date(), weight: Math.random() * 100, height: Math.random() * 200, bloodType: "O")

                (1..5).each {
                    Integer consultIdx ->
                        def consultationInstance = new Consultation()
                        consultationInstance.addToPathologies(Pathology.get(consultIdx))
                        consultationInstance.addToPathologies(Pathology.get(consultIdx + 1))
                        consultationInstance.addToPathologies(Pathology.get(consultIdx + 2))
                        def noteInstance = new Note(description: "Ceci est une note très importante de la consultation")

                        (1..3).each {
                            Integer fileIdx ->
                                noteInstance.addToFiles(new CustomFile(name: "grails.svg"))
                        }

                        consultationInstance.note = noteInstance
                        carnetInstance.addToConsultations(consultationInstance)
                }
                userInstance.carnet = carnetInstance
                userInstance.save(flush: true)
        }

    }
    def destroy = {
    }
}
