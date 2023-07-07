package ua.nprblm.springboottodoapp.service;

import ua.nprblm.springboottodoapp.model.TodoItem;

import java.util.Optional;

public interface TodoItemService {

    Optional<TodoItem> getById(Long id);

    void save(TodoItem todoItem);

    void delete(TodoItem todoItem);

    Iterable<TodoItem> getAllReversed();
}
