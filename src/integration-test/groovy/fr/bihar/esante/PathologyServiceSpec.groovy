package fr.bihar.esante

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PathologyServiceSpec extends Specification {

    PathologyService pathologyService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Pathology(...).save(flush: true, failOnError: true)
        //new Pathology(...).save(flush: true, failOnError: true)
        //Pathology pathology = new Pathology(...).save(flush: true, failOnError: true)
        //new Pathology(...).save(flush: true, failOnError: true)
        //new Pathology(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //pathology.id
    }

    void "test get"() {
        setupData()

        expect:
        pathologyService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Pathology> pathologyList = pathologyService.list(max: 2, offset: 2)

        then:
        pathologyList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        pathologyService.count() == 5
    }

    void "test delete"() {
        Long pathologyId = setupData()

        expect:
        pathologyService.count() == 5

        when:
        pathologyService.delete(pathologyId)
        sessionFactory.currentSession.flush()

        then:
        pathologyService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Pathology pathology = new Pathology()
        pathologyService.save(pathology)

        then:
        pathology.id != null
    }
}
