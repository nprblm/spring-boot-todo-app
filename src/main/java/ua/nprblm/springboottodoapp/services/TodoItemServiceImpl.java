package ua.nprblm.springboottodoapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.nprblm.springboottodoapp.models.TodoItem;
import ua.nprblm.springboottodoapp.repositories.TodoItemRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    public Iterable<TodoItem> getAll() {
        return todoItemRepository.findAll();
    }

    public Optional<TodoItem> getById(Long id) {
        return todoItemRepository.findById(id);
    }

    public TodoItem save(TodoItem todoItem) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        if (todoItem.getId() == null) {
            todoItem.setCreatedAt(dtf.format(LocalDateTime.now()));
        }
        todoItem.setUpdatedAt(dtf.format(LocalDateTime.now()));
        return todoItemRepository.saveAndFlush(todoItem);
    }

    public void delete(TodoItem todoItem) {
        todoItemRepository.delete(todoItem);
    }

    @Override
    public Iterable<TodoItem> getAllReversed() {
        return todoItemRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

}
