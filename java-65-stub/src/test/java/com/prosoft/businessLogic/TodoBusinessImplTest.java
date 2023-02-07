package com.prosoft.businessLogic;

import com.prosoft.data.TodoService;
import com.prosoft.data.TodoServiceStub;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoBusinessImplTest {
    @Test
    public void testWithStub() {
        // создание заглушки
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
        List filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        // проверка, что в отфильтрованном списке
        // два элемента
        assertEquals(2, filteredTodos.size());
    }
}
