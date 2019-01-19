package ru.ajana.admin;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ajana.admin.config.JpaConfig;
import ru.ajana.admin.config.WebConfig;

/**
 * Абстрактный класс для интеграционных тестов.
 *
 * @author Andrey Kharintsev on 19.01.2019
 */


@RunWith(SpringRunner.class)
@SqlConfig(encoding = "UTF-8")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = {"classpath:application-test.properties"})
@ContextConfiguration(classes = {TestApplication.class, JpaConfig.class, WebConfig.class})
public abstract class AbstractAdminIntegrationTest {

}
