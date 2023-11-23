<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-user" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>

            <ol class="property-list user">

                <li class="fieldcontain">
                    <span id="username-label" class="property-label">Username</span>
                    <div class="property-value" aria-labelledby="username-label">${user.username}</div>
                </li>

                <li class="fieldcontain">
                    <span id="email-label" class="property-label">Email</span>
                    <div class="property-value" aria-labelledby="email-label">${user.email}</div>
                </li>

                <li class="fieldcontain">
                    <span id="role-label" class="property-label">Role</span>
                    <div class="property-value" aria-labelledby="email-label">${user.getAuthorities()*.authority.join(', ')}</div>
                </li>
                
                <g:if test="${user.getAuthorities()*.authority.contains('ROLE_PATIENT')}">

                    <h1>Carnet de santé</h1>

                    <li class="fieldcontain">
                        <span id="fname-label" class="property-label">First name</span>
                        <div class="property-value" aria-labelledby="fname-label">${user.carnet.fname}</div>
                    </li>

                    <li class="fieldcontain">
                        <span id="lname-label" class="property-label">Last name</span>
                        <div class="property-value" aria-labelledby="lname-label">${user.carnet.lname}</div>
                    </li>

                    <li class="fieldcontain">
                        <span id="dob-label" class="property-label">DOB</span>
                        <div class="property-value" aria-labelledby="dob-label"><g:formatDate date="${user.carnet.dob}" type="date" style="SHORT"/>
                        </div>
                    </li>

                    <li class="fieldcontain">
                        <span id="tel-label" class="property-label">Tel</span>
                        <div class="property-value" aria-labelledby="tel-label">${user.carnet.tel}</div>
                    </li>

                    <li class="fieldcontain">
                        <span id="weight-label" class="property-label">Weight</span>
                        <div class="property-value" aria-labelledby="weight-label">${user.carnet.weight}</div>
                    </li>

                    <li class="fieldcontain">
                        <span id="height-label" class="property-label">Height</span>
                        <div class="property-value" aria-labelledby="height-label">${user.carnet.height}</div>
                    </li>

                    <li class="fieldcontain">
                        <span id="bt-label" class="property-label">Blood Type</span>
                        <div class="property-value" aria-labelledby="bt-label">${user.carnet.bloodType}</div>
                    </li>
                </g:if>

            </ol>

            <g:form resource="${this.user}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.user}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
