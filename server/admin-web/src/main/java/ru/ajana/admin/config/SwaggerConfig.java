package ru.ajana.admin.config;

import static springfox.documentation.builders.PathSelectors.regex;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Конфигурация Swagger2.
 *
 * @author Andrey Kharintsev on 12.01.2019
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Value("${spring.info.swagger2.title}")
  private String title;
  @Value("${spring.info.swagger2.description}")
  private String description;
  @Value("${spring.info.swagger2.version}")
  private String version;
  @Value("${spring.info.swagger2.termsOfServiceUrl}")
  private String termsOfServiceUrl;
  @Value("${spring.info.swagger2.license}")
  private String license;
  @Value("${spring.info.swagger2.licenseUrl}")
  private String licenseUrl;

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
        .paths(regex("/.*"))
        .build().apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    return new ApiInfo(title, description, version, termsOfServiceUrl, null, licenseUrl,
        null);
  }

}
