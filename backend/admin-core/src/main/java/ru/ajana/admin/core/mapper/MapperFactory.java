package ru.ajana.admin.core.mapper;

/**
 * Фабрика мапперов сущностей.
 *
 * @author Andrey Kharintsev by 11.02.2018
 */
public class MapperFactory<T extends Mapper> {

  private static final MapperFactory instance = new MapperFactory();

  private MapperFactory() {
  }

  public static MapperFactory getInstance() {
    return instance;
  }

  /**
   * Создаёт маппер по заданному классу.
   *
   * @param clazz класс маппера сущности
   * @return маппер сущностей
   */
  public T createMapper(Class<T> clazz) {
    try {
      return clazz.newInstance();
    } catch (IllegalAccessException | InstantiationException e) {
      throw new RuntimeException(e);
    }
  }
}
