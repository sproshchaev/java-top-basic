package com.prosoft.businessLogic;

import com.prosoft.data.TodoService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Класс TodoBusinessImplTest содержит методы тестирования класса TodoBusinessImpl
 */
public class TodoBusinessImplTest {
    @Test
    public void testWithMock() {

        /**
         * Создание мока и описание его поведения через
         */
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        /**
         * Создание тестируемого объекта и передача мока через конструктор (внедрение зависимости)
         */
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        List filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        /**
         * Проверка, что в отфильтрованном списке два элемента
         */
        assertEquals(2, filteredTodos.size());
    }

}
