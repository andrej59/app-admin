package ru.ajana.admin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Конфишурация веб-приложения.
 *
 * @author Andrey Kharintsev on 12.01.2019
 */
@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Autowired
  private ApplicationContext context;
  /**
   * Файл с настройкаси подключения к базе данных.
   */
  private static final String DATASOURCE_PROPERTIES = "datasource.properties";
  private static PropertySourcesPlaceholderConfigurer configurer;

  @Override
  public void addViewControllers(final ViewControllerRegistry registry) {
    registry.addRedirectViewController("/", "/rest/swagger-ui.html");
  }

  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    // Make Swagger meta-data available via <baseURL>/v2/api-docs/
    registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
    // Make Swagger UI available via <baseURL>/swagger-ui.html
    registry.addResourceHandler("/**")
        .addResourceLocations("classpath:/META-INF/resources/");
  }


  /**
   * Необходим для доступа к контексту из статических методов.
   */
  /*
  @Bean
  public AppContextProvider provider() {
    return new AppContextProvider(context);
  }
  */
  @Bean
  public static PropertySourcesPlaceholderConfigurer propertyConfigurer()
      throws IOException {

    configurer = new PropertySourcesPlaceholderConfigurer();
    configurer.setFileEncoding("UTF-8");
    configurer.setLocalOverride(true);
    configurer.setIgnoreResourceNotFound(true);
    // application.properties включается по умолчанию
    Resource datasourceConfig = new ClassPathResource(DATASOURCE_PROPERTIES);
    configurer.setLocations(datasourceConfig);
    return configurer;
  }


  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    ObjectMapper objectMapper = new ObjectMapper();
    StringHttpMessageConverter stringConverter = new StringHttpMessageConverter(
        Charset.forName("UTF-8"));
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(
        objectMapper);
    converters.add(stringConverter);
    converters.add(converter);
  }

  /*
  @Bean
  public RequestMappingHandlerMapping requestMappingHandlerMapping() {
    final ApiVersionRequestMappingHandlerMapping handlerMapping = new ApiVersionRequestMappingHandlerMapping(
        "v");
    handlerMapping.setOrder(0);
    handlerMapping.setUseTrailingSlashMatch(true);
    return handlerMapping;
  }

  @Bean
  public MessageSource messageSource() {
    CustomReloadableResourceBundleMessageSource messageSource = new CustomReloadableResourceBundleMessageSource();
    messageSource.setBasenames("classpath*:META-INF/messages");
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }
  */
}
