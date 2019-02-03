package ru.ajana.admin;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Абстрактный интеграционный тест.
 *
 * @author Andrey Kharintsev by 11.02.2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
@ContextConfiguration(classes = TestApplicationConfig.class)
@Sql({"/sql/schema-postgresql.sql", "/sql/test-data.sql"})
@Sql(value = "/sql/delete-all.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public abstract class AbstractIntegrationTest extends AbstractTest {

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }
}
