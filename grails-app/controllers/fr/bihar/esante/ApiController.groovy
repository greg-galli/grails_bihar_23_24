package fr.bihar.esante

import grails.converters.JSON
import grails.converters.XML
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class ApiController {

    /**
     * Répondra à l'appel sur /api/user/{id}
     * Devra gérer les requête de type GET, PUT, PATCH, DELETE
     */
    def user()
    {
        switch (request.getMethod())
        {
            case "GET":
                if (!params.id)
                    return response.status = 400
                User userInstance = User.get(params.id)
                if (!userInstance)
                    return response.status = 404
                renderThis(userInstance, request.getHeader("Accept"))
                break
            case "PUT":
                break
            case "PATCH":
                break
            case "DELETE":
                break
            default:
                return response.status = 405
                break
        }
    }

    /**
     * Répondra à l'appel sur /api/users
     * Devra gérer les requête de type GET, POST
     */
    def users()
    {

    }


    /**
     * Répondra à l'appel sur /api/consultation/{id}
     * Devra gérer les requête de type GET, PUT, PATCH, DELETE
     */
    def consultation()
    {

    }


    /**
     * Répondra à l'appel sur /api/consultations
     * Devra gérer les requête de type GET, POST
     */
    def consultations()
    {

    }

    def renderThis(Object instance, String accept)
    {
        switch (accept)
        {
            case "xml":
            case "application/xml":
            case "text/xml":
                render instance as XML
                break
            case "json":
            case "application/json":
            case "text/json":
                render instance as JSON
                break
            default:
                return response.status = 406
                break
        }
    }
}
