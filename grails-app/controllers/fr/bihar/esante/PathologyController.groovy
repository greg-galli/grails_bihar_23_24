package fr.bihar.esante

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured('ROLE_ADMIN')
class PathologyController {

    PathologyService pathologyService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN','ROLE_AUX'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond pathologyService.list(params), model:[pathologyCount: pathologyService.count()]
    }

    def show(Long id) {
        respond pathologyService.get(id)
    }

    def create() {
        respond new Pathology(params)
    }

    def save(Pathology pathology) {
        if (pathology == null) {
            notFound()
            return
        }

        try {
            pathologyService.save(pathology)
        } catch (ValidationException e) {
            respond pathology.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pathology.label', default: 'Pathology'), pathology.id])
                redirect pathology
            }
            '*' { respond pathology, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond pathologyService.get(id)
    }

    def update(Pathology pathology) {
        if (pathology == null) {
            notFound()
            return
        }

        try {
            pathologyService.save(pathology)
        } catch (ValidationException e) {
            respond pathology.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'pathology.label', default: 'Pathology'), pathology.id])
                redirect pathology
            }
            '*'{ respond pathology, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        pathologyService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'pathology.label', default: 'Pathology'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pathology.label', default: 'Pathology'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
