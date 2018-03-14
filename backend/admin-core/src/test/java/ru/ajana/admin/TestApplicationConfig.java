package ru.ajana.admin;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.eclipse.persistence.config.BatchWriting;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.logging.SessionLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Конфигурация приложения для тестирования.
 *
 * @author Andrey Kharintsev by 24.02.2018
 */

@SpringBootApplication(scanBasePackages = {"ru.ajana.admin"})
@PropertySource({"/application-test.properties", "/test-default.properties"})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"ru.ajana.admin.repository"})
public class TestApplicationConfig {

  private static final String JPA_PACKAGES_TO_SCAN = "ru.ajana.admin.jpa.entities";

  public static void main(String[] args) throws Exception {
    SpringApplication.run(TestApplicationConfig.class);
  }

  protected Map<String, Object> getVendorProperties() {
    final Map<String, Object> ret = new LinkedHashMap<>();
    ret.put(PersistenceUnitProperties.WEAVING, "static");
    ret.put(PersistenceUnitProperties.BATCH_WRITING, BatchWriting.JDBC);
    ret.put(PersistenceUnitProperties.LOGGING_LEVEL, SessionLog.FINE_LABEL);
    return ret;
  }

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
    final JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(emf);
    return transactionManager;
  }

  @Bean
  public JpaVendorAdapter jpaVendorAdapter() {
    return new EclipseLinkJpaVendorAdapter();
  }

  @Bean
  public EntityManagerFactory entityManagerFactory() {
    final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setPackagesToScan(JPA_PACKAGES_TO_SCAN);
    factory.setDataSource(dataSource());
    factory.setJpaVendorAdapter(jpaVendorAdapter());
    factory.setJpaPropertyMap(getVendorProperties());
    factory.afterPropertiesSet();
    return factory.getObject();
  }


  /**
   * Постпроцессор для обработки ошибок в стиле Spring Framework.
   */
  @Bean
  public PersistenceExceptionTranslationPostProcessor createPersistenceExceptionTranslationPostProcessor() {
    return new PersistenceExceptionTranslationPostProcessor();
  }
}
