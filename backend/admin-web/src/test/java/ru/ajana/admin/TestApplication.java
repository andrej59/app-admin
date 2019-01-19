package ru.ajana.admin;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import java.io.IOException;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.ajana.admin.db.ClasspathBinaryResolver;

/**
 * @author Andrey Kharintsev on 19.01.2019
 */
@EnableWebMvc
@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class},
    scanBasePackages = {"ru.ajana.admin"})
public class TestApplication {
  @Bean
  public DataSource dataSource() throws IOException {
    EmbeddedPostgres.Builder builder = EmbeddedPostgres.builder();

    builder.setPgBinaryResolver(new ClasspathBinaryResolver());
    return builder.start().getPostgresDatabase();
  }

}
