# http-status-codes

## Dependencies
Make sure you have installed on your operating system:<br/>
1. [JDK. Oracle](http://www.java.com/) OR [OpenJDK](https://openjdk.java.net/)
2. [Git](https://git-scm.com/)
3. [Maven](https://maven.apache.org/)


## Run Spring App.
`$> mvn clean spring-boot:run ` - command to start standalone application using Maven.

## Swagger UI
In your example the documentation will be available by next URL's:</br>
- http://localhost:7778/v2/api-docs - OpenAPI JSON. Information about the current project.</br></br>
- http://localhost:7778/swagger-ui/index.html - Swagger UI for different definitions (and external OpenAPI JSON (`src/main/resources/public/openapi.json`) too)

**Swagger:** http://server:port/context-path/swagger-ui.html</br>
**OpenAPI:** http://server:port/context-path/v3/api-docs

## TBD
Add online integration from running services.

___

## Intro



### 1 Documentation

####  1.1 SpringFox
Springfox is a framework that acts as the “glue” between Swagger and Spring. 
It generates the specification (contract) based on your code and also deploys 
the Swagger UI client with your application, allowing you to immediately test your REST API.

####  1.2 Open API

The ability of APIs to describe their own structure is the root of all
awesomeness in OpenAPI. Once written, an OpenAPI specification and
Swagger tools can drive your API development further in various ways.

![OpenAPI. Bean](./doc/MultiOpenApiDocumentationConfiguration.png)
**_Pic#1_**. Spring Boot configuration Bean for OpenAPI/Swagger documentation


We can simply access the Open API documentation at:

***URL (JSON):** http://localhost:7778/v2/api-docs*


**In out case we do not have any REST controllers, so It will be contact info only.**


![OpenAPI. JSON](./doc/open-api-firefox.png)
**_Pic#2_**. OpenAPI documentation JSON (it's how Mozilla parse JSON by
default)


###  1.3 Swagger UI

Swagger is a set of open-source tools built around the OpenAPI
Specification that can help you design, build, document and consume REST
APIs. Swagger UI - renders OpenAPI specs as interactive API
documentation. Use Swagger UI to generate interactive API documentation
that lets your users try out the API calls directly in the browser.

*URL: http://localhost:7778/swagger-ui/index.html*

![Swagger UI](./doc/swagger-default.png)
**_Pic#3_**. Swagger UI. Default project (contact information only)


![Swagger UI](./doc/swagger-uploaded.png)
**_Pic#4_**. Swagger UI. Uploaded project from `src/main/resources/public/openapi.json`


## References
* [SwaggerResourceConfig.kt](https://gist.github.com/brunapereira/52033b00a81ad885a60c2950eb371fb3#file-swaggerresourceconfig-kt)
* [Remove Basic Error Controller In SpringFox Swagger-UI](https://www.baeldung.com/spring-swagger-remove-error-controller)
* [Spring Doc](https://springdoc.org/#Introduction)
* [Swagger](https://swagger.io/docs/specification/about)
* [OpenAPI Specifications](https://medium.com/creditas-tech/open-api-specifications-with-your-api-rest-spring-boot-17951e9c22a0)
* [Spring Fox GitHub](https://github.com/springfox/springfox)
* [postman-to-openapi](https://joolfe.github.io/postman-to-openapi/)
* [Postman2OpenAPI](https://github.com/kevinswiber/postman2openapi)
* [SpringFox](https://dimitr.im/documenting-rest-api-swagger-springfox)




