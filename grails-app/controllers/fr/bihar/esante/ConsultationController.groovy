package fr.bihar.esante

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured('ROLE_ADMIN')
class ConsultationController {

    ConsultationService consultationService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN','ROLE_AUX'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond consultationService.list(params), model:[consultationCount: consultationService.count()]
    }

    @Secured(['ROLE_ADMIN','ROLE_AUX'])
    def show(Long id) {
        respond consultationService.get(id)
    }

    def create() {
        respond new Consultation(params)
    }

    def save(Consultation consultation) {
        if (consultation == null) {
            notFound()
            return
        }

        try {
            consultationService.save(consultation)
        } catch (ValidationException e) {
            respond consultation.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'consultation.label', default: 'Consultation'), consultation.id])
                redirect consultation
            }
            '*' { respond consultation, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN','ROLE_AUX'])
    def edit(Long id) {
        respond consultationService.get(id)
    }

    @Secured(['ROLE_ADMIN','ROLE_AUX'])
    def update(Consultation consultation) {
        if (consultation == null) {
            notFound()
            return
        }

        try {
            consultationService.save(consultation)
        } catch (ValidationException e) {
            respond consultation.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'consultation.label', default: 'Consultation'), consultation.id])
                redirect consultation
            }
            '*'{ respond consultation, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        consultationService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'consultation.label', default: 'Consultation'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'consultation.label', default: 'Consultation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
