package com.prosoft.data;

import java.util.List;

public interface TodoService {

    /**
     * Метод retrieveTodos возвращает список задач пользователя
     *
     * @param user
     * @return
     */
    List<String> retrieveTodos(String user);
}
