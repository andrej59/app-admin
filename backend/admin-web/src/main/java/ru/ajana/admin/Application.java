package ru.ajana.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * Точка входа для запуска приложения.
 *
 * @author Andrey Kharintsev on 09.04.2018
 */
@SpringBootApplication(scanBasePackages = {"ru.ajana.admin"})
@PropertySources({
    @PropertySource(value = "classpath:application-default.properties", encoding = "UTF-8"),
    @PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true, encoding = "UTF-8"),
    @PropertySource(value = "classpath:datasource.properties", ignoreResourceNotFound = true, encoding = "UTF-8")
})
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }
}
