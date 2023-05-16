package ua.nprblm.springboottodoapp.services;

import ua.nprblm.springboottodoapp.models.TodoItem;

import java.util.Optional;

public interface TodoItemService {
    Iterable<TodoItem> getAll();

    Optional<TodoItem> getById(Long id);

    TodoItem save(TodoItem todoItem);

    void delete(TodoItem todoItem);

    Object getAllReversed();
}
