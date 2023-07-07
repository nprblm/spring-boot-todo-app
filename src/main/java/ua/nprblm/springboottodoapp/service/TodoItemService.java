package ua.nprblm.springboottodoapp.service;

import ua.nprblm.springboottodoapp.model.TodoItem;

import java.util.Optional;

public interface TodoItemService {
    Iterable<TodoItem> getAll();

    Optional<TodoItem> getById(Long id);

    TodoItem save(TodoItem todoItem);

    void delete(TodoItem todoItem);

    Iterable<TodoItem> getAllReversed();
}
