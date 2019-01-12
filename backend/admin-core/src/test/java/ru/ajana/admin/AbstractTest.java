package ru.ajana.admin;

import com.namics.commons.random.RandomData;
import ru.ajana.admin.core.mapper.MapperFactory;

/**
 * Абстрактный тест.
 *
 * @author Andrey Kharintsev by 11.02.2018
 */
public abstract class AbstractTest {

  protected static final MapperFactory MAPPER_FACTORY = MapperFactory.getInstance();

  /**
   * Создаёт объект заданного типа.
   *
   * @param type тип объекта
   * @param info дополнительную дополнительную информацию для объекта, который должен быть создан,
   * например. имя поля
   */
  protected <T> T generateObject(Class<T> type, Object... info) {
    return RandomData.random(type, info);
  }
}
