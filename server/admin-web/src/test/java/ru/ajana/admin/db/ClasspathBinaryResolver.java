package ru.ajana.admin.db;

import static java.lang.String.format;

import com.opentable.db.postgres.embedded.PgBinaryResolver;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Andrey Kharintsev on 20.01.2019
 */
public class ClasspathBinaryResolver implements PgBinaryResolver {

  public InputStream getPgBinary(String system, String machineHardware) throws IOException {
    ClassPathResource resource = new ClassPathResource(
        format("postgresql-%s-%s.txz", system, "x86_64"));
    return resource.getInputStream();
  }
}
