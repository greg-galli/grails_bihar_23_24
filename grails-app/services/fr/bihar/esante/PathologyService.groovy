package fr.bihar.esante

import grails.gorm.services.Service

@Service(Pathology)
interface PathologyService {

    Pathology get(Serializable id)

    List<Pathology> list(Map args)

    Long count()

    void delete(Serializable id)

    Pathology save(Pathology pathology)

}