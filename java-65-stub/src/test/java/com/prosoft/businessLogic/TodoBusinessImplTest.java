package com.prosoft.businessLogic;

import com.prosoft.services.TodoService;
import com.prosoft.services.TodoServiceStub;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoBusinessImplTest {
    @Test
    public void testWithStub() {

        /**
         * Создание экземпляра стаба (заглушки)
         */
        TodoService todoServiceStub = new TodoServiceStub();

        /**
         * Создание экземпляра тестируемого класса и передача в конструктор экземпляра заглушки
         */
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
        List filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        /**
         * Проверка, элементов в отфильтрованном списке
         */
        assertEquals(2, filteredTodos.size());
    }
}
