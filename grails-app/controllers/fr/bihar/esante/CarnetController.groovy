package fr.bihar.esante

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured('ROLE_ADMIN')
class CarnetController {

    CarnetService carnetService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond carnetService.list(params), model:[carnetCount: carnetService.count()]
    }

    def show(Long id) {
        respond carnetService.get(id)
    }

    def create() {
        respond new Carnet(params)
    }

    def save(Carnet carnet) {
        if (carnet == null) {
            notFound()
            return
        }

        try {
            carnetService.save(carnet)
        } catch (ValidationException e) {
            respond carnet.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'carnet.label', default: 'Carnet'), carnet.id])
                redirect carnet
            }
            '*' { respond carnet, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond carnetService.get(id)
    }

    def update(Carnet carnet) {
        if (carnet == null) {
            notFound()
            return
        }

        try {
            carnetService.save(carnet)
        } catch (ValidationException e) {
            respond carnet.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'carnet.label', default: 'Carnet'), carnet.id])
                redirect carnet
            }
            '*'{ respond carnet, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        carnetService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'carnet.label', default: 'Carnet'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'carnet.label', default: 'Carnet'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
