# REST_WEB_SERVICE_REPO

# REST - Representational State Transfer
# JSR - Java Specification Request
# JAXB - Java Architecture for XML Binding
# JAX-RS   Java API for RESTful Web Services - API Specification

# Topic list

JAX-RS is an specification (just a definition/API/ Java interface) and Jersey is a JAX-RS implementation.
Rest WebService by JAX-RS JSR-311
Rest , resource is acceseed by common interface based on http based method.in rest everything is resource.Resources are identified by URI.

Jersey - supports creation of xml/json via jaxb.

============================================================================================================
Create RestService Server: which will be deployed on Servlet Container.

@Path - done
@GET - done / @POST - done(tested by Advance RestClient plugin in chrome)
@PathParam - done
@Produces - done
@HeaderParam / @QueryParam - done
@Context - done
@FormParam - 
@Consumes - done / @FormDataParam @FormData


com.sun.jersey.api.container.servlet.ServletContainer
=====================================================================================================

Created RestWebServiceServerProject maven web project:

mvn archetype:generate -DarchetypeArtifactId=maven-archetype-webapp -DgroupId=com.chahar.webservice.rest.server -DartifactId=RestWebServiceServerProject -DinteractiveMode=false

==========================================================================================================================
Created RestWebServiceMAINClientProject maven project:

mvn archetype:generate -DarchetypeArtifactId=maven-archetype-quickstart -DgroupId=com.chahar.webservice.rest.client -DartifactId=RestWebServiceClientProject -DinteractiveMode=false

=======================================================================================================================

Created RestWebServiceJERSEYClientProject maven project:

mvn archetype:generate -DarchetypeArtifactId=maven-archetype-quickstart -DgroupId=com.chahar.webservice.rest.client -DartifactId=RestWebServiceJERSEYClientProject -DinteractiveMode=false
=======================================================================================================================

Reference:
	https://javapapers.com/java/restful-web-services-with-java-jax-rs-using-jersey/
	https://www.nabisoft.com/tutorials/java-ee/producing-and-consuming-json-or-xml-in-java-rest-services-with-jersey-and-jackson
	