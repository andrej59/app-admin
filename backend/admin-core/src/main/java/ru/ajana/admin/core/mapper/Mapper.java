package ru.ajana.admin.core.mapper;

/**
 * Интерфейс мапперов сущностей.
 *
 * @author Andrey Kharintsev by 11.02.2018
 */
public interface Mapper<S, T> {

  /**
   * Выполняет маппинг сущности базы данных на объект модели приложения.
   *
   * @param entity сущность базы данных
   * @return объект модели
   */
  T mapTo(S entity);

  /**
   * Выполняет маппинг объекта модели на сущность базы данных.
   *
   * @param object объект модели приложения
   * @return сущность базы данных
   */
  S mapFrom(T object);
}
