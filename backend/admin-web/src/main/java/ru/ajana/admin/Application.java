package ru.ajana.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Точка входа для запуска приложения.
 *
 * @author Andrey Kharintsev on 09.04.2018
 */
@SpringBootApplication(scanBasePackages = {"ru.ajana.admin"})
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }
}
