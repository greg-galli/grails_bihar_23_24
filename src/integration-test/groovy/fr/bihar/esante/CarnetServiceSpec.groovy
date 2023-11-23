package fr.bihar.esante

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CarnetServiceSpec extends Specification {

    CarnetService carnetService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Carnet(...).save(flush: true, failOnError: true)
        //new Carnet(...).save(flush: true, failOnError: true)
        //Carnet carnet = new Carnet(...).save(flush: true, failOnError: true)
        //new Carnet(...).save(flush: true, failOnError: true)
        //new Carnet(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //carnet.id
    }

    void "test get"() {
        setupData()

        expect:
        carnetService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Carnet> carnetList = carnetService.list(max: 2, offset: 2)

        then:
        carnetList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        carnetService.count() == 5
    }

    void "test delete"() {
        Long carnetId = setupData()

        expect:
        carnetService.count() == 5

        when:
        carnetService.delete(carnetId)
        sessionFactory.currentSession.flush()

        then:
        carnetService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Carnet carnet = new Carnet()
        carnetService.save(carnet)

        then:
        carnet.id != null
    }
}
