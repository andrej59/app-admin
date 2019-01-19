package ru.ajana.admin.migration;

import org.flywaydb.core.Flyway;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ajana.admin.AbstractAdminIntegrationTest;

/**
 * Интеграционный тест миграций.
 *
 * @author Andrey Kharintsev on 19.01.2019
 */
public class MigrationIT extends AbstractAdminIntegrationTest {

  @Autowired
  private Flyway flyway;

  @Test
  public void testMigration() {
    flyway.migrate();
  }
}
