package fr.bihar.esante

import grails.gorm.services.Service

@Service(Carnet)
interface CarnetService {

    Carnet get(Serializable id)

    List<Carnet> list(Map args)

    Long count()

    void delete(Serializable id)

    Carnet save(Carnet carnet)

}