package com.prosoft;

import com.prosoft.businessLogic.TodoBusinessImpl;
import com.prosoft.data.TodoService;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Класс TodoBusinessImplTest содержит методы тестирования класса TodoBusinessImpl
 */
public class TodoBusinessImplTest {

    /**
     * тест с захватом аргумента для метода deleteTodosNotRelatedToSpring()
     */
    @Test
    public void testWithDeleteTodos2() {

        /**
         * Объявить "захватчика" аргумента
         */
        ArgumentCaptor<String> stringArgCaptor = ArgumentCaptor.forClass(String.class);

        /**
         * Создание и настройка мока
         */
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        /**
         * Запуск тестируемого метода
         */
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        /**
         * Захват аргумента в вызываемом методе мока
         */
        verify(todoServiceMock).deleteTodo(stringArgCaptor.capture());

        /**
         * Проверка, что захваченный аргумент - это строка "Learn to Dance"
         */
        assertThat(stringArgCaptor.getValue(), is("Learn to Dance"));
    }

    /**
     * В методе testWithDeleteTodos3() проверяется, что метод deleteTodo() вызывается два раза
     * Тест с захватом нескольких аргументов для метода deleteTodosNotRelatedToSpring()
     */
    @Test
    public void testWithDeleteTodos3() {

        /**
         * Объявить "захватчика" аргумента
         */
        ArgumentCaptor<String> stringArgCaptor = ArgumentCaptor.forClass(String.class);

        /**
         * Создание и настройка мока
         */
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn to Rock and Roll", "Learn Spring", "Learn to Dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        /**
         * Запуск тестируемого метода
         */
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        /**
         * Множественный захват аргумента в вызываемом методе мока
         */
        verify(todoServiceMock, times(2)).deleteTodo(stringArgCaptor.capture());

        /**
         * Проверка количества захваченных аргументов
         */
        assertThat(stringArgCaptor.getAllValues().size(), is(2));
    }

}
