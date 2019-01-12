package ru.ajana.admin.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import ru.ajana.admin.core.util.PasswordUtils;

/**
 * Тест утилиты вспомогательных методов для работы с паролем.
 *
 * @author Andrey Kharintsev by 10.03.2018
 */
public class PasswordUtilsTest {

  @Test
  public void genSalt() throws Exception {
    String salt = PasswordUtils.genSalt();
    assertNotNull(salt);
  }

  @Test(expected = IllegalArgumentException.class)
  public void hashPasswordIsNull() throws Exception {
    String salt = PasswordUtils.genSalt();
    PasswordUtils.hashPassword(null, salt);
  }

  @Test(expected = IllegalArgumentException.class)
  public void hashPasswordSaltIsNull() throws Exception {
    PasswordUtils.hashPassword("test", null);
  }

  @Test
  public void hashPassword() throws Exception {
    String salt = PasswordUtils.genSalt();
    String password = "test";
    String hash = PasswordUtils.hashPassword(password, salt);
    assertNotNull(hash);
  }

  @Test
  public void checkPassword() throws Exception {
    String salt = PasswordUtils.genSalt();
    String password = PasswordUtils.hashPassword("test", salt);
    assertTrue(PasswordUtils.checkPassword(password, "test", salt));
    assertFalse(PasswordUtils.checkPassword(password, "test_1", salt));
  }
}