package com.prosoft.businessLogic;

import com.prosoft.services.TodoService;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализует какую-то бизнес-логику на основе задач пользователя
 */
public class TodoBusinessImpl {

    /**
     * Поле — сервиса списка задач. Внедрение зависимости через конструктор класса
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
     * Метод retrieveTodosRelatedToSpring отбирает среди задач пользователя те, которые относятся к Spring
     * Данный метод планируется к тестам
     * @param user
     * @return
     */
    public List<String> retrieveTodosRelatedToSpring(String user) {
        List<String> filteredTodos = new ArrayList<String>();
        /**
         * Вызов метода, реализации которого еще нет
         */
        List<String> todos = todoService.retrieveTodos(user);
        for (String todo : todos) {
            if (todo.contains("Spring")) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
}
