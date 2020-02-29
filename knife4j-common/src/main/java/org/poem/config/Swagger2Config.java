package org.poem.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableSwagger2
public class Swagger2Config {

    public static final String AUTHORIZATION = "Authorization";

    @Bean
    public Docket createRestApi() {
        List<Parameter> paraList = new ArrayList<>();
        ParameterBuilder paraBuilder = new ParameterBuilder();
        Parameter param1 =
                paraBuilder.name(AUTHORIZATION)
                        .description(AUTHORIZATION)
                        .modelRef(new ModelRef("string"))
                        .parameterType("header")
                        .required(false)
                        .build();
        paraList.add(param1);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(paraList);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("knife4j")
                .description("spring cloud knife4j")
                .contact(new Contact("cloud", "127.0.0.1:8081", "xue_2013@sina.com"))
                .version("0.0.1")
                .build();
    }
}
