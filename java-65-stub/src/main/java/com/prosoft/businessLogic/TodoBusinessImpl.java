package com.prosoft.businessLogic;

import com.prosoft.data.TodoService;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализует какую-то бизнес-логику на основе задач пользователя
 */
public class TodoBusinessImpl {

    /**
     * Поле — список задач
     */
    private TodoService todoService;

    /**
     * Конструктор
     * @param todoService
     */
    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    /**
     * Метод, который будем тестировать: отбирает среди задач пользователя те, которые относятся к Spring
     * @param user
     * @return
     */
    public List<String> retrieveTodosRelatedToSpring(String user) {
        List<String> filteredTodos = new ArrayList<String>();
        List<String> todos = todoService.retrieveTodos(user); // вызов метода, реализации которого еще нет
        for (String todo : todos) {
            if (todo.contains("Spring")) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
}
