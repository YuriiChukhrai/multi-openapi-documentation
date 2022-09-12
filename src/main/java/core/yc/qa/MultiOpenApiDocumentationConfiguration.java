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

/**
 * @author limit (Yurii Chukhrai)
 */
@Configuration
public class MultiOpenApiDocumentationConfiguration {

    @Primary
    @Bean
    public SwaggerResourcesProvider swaggerResourcesProvider(final InMemorySwaggerResourcesProvider defaultResourcesProvider) {

        return () -> {
            final SwaggerResource demoResource = new SwaggerResource();
            demoResource.setName("Open API");
            demoResource.setSwaggerVersion("3.0.0");
            demoResource.setLocation("/openapi.json"); //src/main/resources/public/openapi.json

            final List<SwaggerResource> resources = new ArrayList<>(defaultResourcesProvider.get());
            resources.add(demoResource);
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

    /**
     * TBD - runtime fetching information from another microservices.
     * */
}
