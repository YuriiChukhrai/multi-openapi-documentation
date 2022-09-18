package core.yc.qa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.service.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author limit (Yurii Chukhrai)
 */
@Configuration
public class MultiOpenApiDocumentationConfiguration {

    @Primary
    @Bean
    public SwaggerResourcesProvider swaggerResourcesProvider(final InMemorySwaggerResourcesProvider defaultResourcesProvider) {

        return () -> {
//            final SwaggerResource demoResource = new SwaggerResource();
//            demoResource.setName("Open API");
//            demoResource.setSwaggerVersion("3.0.0");
//            demoResource.setLocation("/openapi.json"); //src/main/resources/public/openapi.json

            final List<SwaggerResource> resources = new ArrayList<>(defaultResourcesProvider.get());
            resources.add(getSwaggerResource("Open API",  "2.0", "/openapi.json", null));//demoResource
            resources.add(getSwaggerResource("External API", "3.0", "/v3/api-docs", "http://localhost:7777"));

            return resources;
        };
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Multiple OpenAPI Documentation", "Demo project for portfolio. Multiple OpenAPI documentation from [openapi.json] files", "API TOS", null,
                new Contact("Yurii Chukhrai", "https://github.com/YuriiChukhrai", "yurii.chukhrai@outlook.com"),
                null, null, Collections.emptyList());
    }

    //resources.add(swaggerResource("account-service", "/api/account/v2/api-docs", "2.0"));

    private SwaggerResource getSwaggerResource(final String name, final String version, final String location, final String uri) {
        final SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);

        /**
         * BUG: swagger-ui should respect absolute paths provided by swagger-resources
         *
         * https://github.com/springfox/springfox/issues/3413
         * https://github.com/springfox/springfox/pull/3596/files
         * https://github.com/ballcat-projects/ballcat-samples/blob/master/ballcat-sample-admin-application/src/main/resources/META-INF/resources/webjars/springfox-swagger-ui/springfox.js
         * */
        if(Objects.nonNull(uri)){
            swaggerResource.setUrl(uri);
        }

        return swaggerResource;
    }
}
