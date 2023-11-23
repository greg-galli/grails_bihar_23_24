package fr.bihar.esante

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ConsultationServiceSpec extends Specification {

    ConsultationService consultationService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Consultation(...).save(flush: true, failOnError: true)
        //new Consultation(...).save(flush: true, failOnError: true)
        //Consultation consultation = new Consultation(...).save(flush: true, failOnError: true)
        //new Consultation(...).save(flush: true, failOnError: true)
        //new Consultation(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //consultation.id
    }

    void "test get"() {
        setupData()

        expect:
        consultationService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Consultation> consultationList = consultationService.list(max: 2, offset: 2)

        then:
        consultationList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        consultationService.count() == 5
    }

    void "test delete"() {
        Long consultationId = setupData()

        expect:
        consultationService.count() == 5

        when:
        consultationService.delete(consultationId)
        sessionFactory.currentSession.flush()

        then:
        consultationService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Consultation consultation = new Consultation()
        consultationService.save(consultation)

        then:
        consultation.id != null
    }
}
