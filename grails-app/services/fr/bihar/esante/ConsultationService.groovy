package fr.bihar.esante

import grails.gorm.services.Service

@Service(Consultation)
interface ConsultationService {

    Consultation get(Serializable id)

    List<Consultation> list(Map args)

    Long count()

    void delete(Serializable id)

    Consultation save(Consultation consultation)

}