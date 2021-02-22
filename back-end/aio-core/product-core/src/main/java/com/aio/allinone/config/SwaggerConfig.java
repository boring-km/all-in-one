package com.aio.allinone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    public Docket apiV1() {
        String version = "V1";
        String title = "product API " + version;

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName(version)
                .apiInfo(apiInfo(title, version))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.aio.allinone.product"))
                .paths(PathSelectors.ant("/product/**"))
                .build();

    }

    private ApiInfo apiInfo(String title, String version) {
        return new ApiInfo(
                title,
                "Swagger로 생성한 API Docs",
                version,
                "https://github.com/boring-km/all-in-one",
                new Contact("Contact Me", "https://github.com/boring-km/all-in-one", "ts4840644804@gmail.com"),
                "Licenses",
                "https://github.com/boring-km/all-in-one",
                new ArrayList<>());
    }
}