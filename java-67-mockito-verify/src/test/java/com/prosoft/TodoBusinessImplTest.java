package com.prosoft;

import com.prosoft.businessLogic.TodoBusinessImpl;
import com.prosoft.data.TodoService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

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

    /**
     * Метод testWithDeleteTodos() выполняет тестирование метода deleteTodosNotRelatedToSpring() в классе TodoBusinessImpl
     */
    @Test
    public void testWithDeleteTodos() {

        /**
         * Настройка условий для теста создание заглушки (Arrange)
         */
        TodoService todoServiceMock = mock(TodoService.class);

        /**
         * Настройка мока
         */
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        /**
         * Создание тестируемого объекта
         */
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        /**
         * Запуск метода (Act)
         */
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        /**
         * Проверка, что метод мока deleteTodo() вызывался с параметром "Learn to Dance" (Assert)
         */
        verify(todoServiceMock).deleteTodo("Learn to Dance");

        /**
         * Проверка, что метод не будет вызван с параметром 'Learn Spring'
         */
        verify(todoServiceMock, never()).deleteTodo("Learn Spring");

        /**
         * Проверка, что метод с данным параметром вызывается один раз с параметром times(N)
         */
        verify(todoServiceMock, times(1)).deleteTodo("Learn to Dance");

        /**
         * Проверка, что метод с данным параметром вызывается один раз с параметром atLeastOnce()
         */
        verify(todoServiceMock,atLeastOnce()).deleteTodo("Learn to Dance");

        /**
         * Проверка, что метод с данным параметром вызывается один раз с параметром atLeast(N)
         */
        verify(todoServiceMock,atLeast(1)).deleteTodo("Learn to Dance");
    }

}
