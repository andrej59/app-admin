package ru.ajana.admin.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * Набор методов для работы с паролями.
 *
 * @author Andrey Kharintsev by 09.03.2018
 */
public final class PasswordUtils {

  private PasswordUtils() {
  }

  public static String genSalt() {
    return BCrypt.gensalt();
  }

  public static String hashPassword(String password, String salt) {
    if (password == null) {
      throw new IllegalArgumentException("The argument 'password' cannot be null");
    }
    if (salt == null) {
      throw new IllegalArgumentException("The argument 'salt' cannot be null");
    }
    return BCrypt.hashpw(password, salt);
  }

  /**
   * Определяет совпадение hash-значений паролей.
   *
   * @param hashPassword hash значение пароля, с которым выполняется сравление
   * @param password значение пароля для проверки
   * @param salt соль паролей
   * @return {@code true} - hash значения паролей совпадают, false - не совпадают
   */
  public static boolean checkPassword(String hashPassword, String password, String salt) {
    if (hashPassword == null || password == null || salt == null) {
      return false;
    }
    String hash = hashPassword(password, salt);
    return hashPassword.equals(hash);
  }
}
