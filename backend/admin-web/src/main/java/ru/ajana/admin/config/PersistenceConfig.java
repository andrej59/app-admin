package ru.ajana.admin.config;

import java.util.Collections;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;

/**
 * Конфигурация JPA.
 *
 * @author Andrey Kharintsev on 12.01.2019
 */
@Configuration
//@PropertySource(value = {"classpath:datasource.properties"}, name = "UTF-8")
public class PersistenceConfig extends JpaBaseConfiguration {

  private static final String[] ENTITYMANAGER_PACKAGES_TO_SCAN = {"ru.ajana.admin.jpa.entities"};

  protected PersistenceConfig(DataSource dataSource, JpaProperties properties,
      ObjectProvider<JtaTransactionManager> jtaTransactionManagerProvider,
      ObjectProvider<TransactionManagerCustomizers> transactionManagerCustomizers) {
    super(dataSource, properties, jtaTransactionManagerProvider, transactionManagerCustomizers);
  }

  @Override
  protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
    return new EclipseLinkJpaVendorAdapter();
  }

  @Override
  protected String[] getPackagesToScan() {
    return ENTITYMANAGER_PACKAGES_TO_SCAN;
  }

  @Override
  protected Map<String, Object> getVendorProperties() {
    return Collections.singletonMap("eclipselink.weaving", "false");
  }
}
