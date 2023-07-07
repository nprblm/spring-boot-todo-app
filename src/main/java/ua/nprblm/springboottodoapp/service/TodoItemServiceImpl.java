package ua.nprblm.springboottodoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.nprblm.springboottodoapp.model.TodoItem;
import ua.nprblm.springboottodoapp.repository.TodoItemRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    private final TodoItemRepository todoItemRepository;

    @Autowired
    public TodoItemServiceImpl(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    public Optional<TodoItem> getById(Long id) {
        return todoItemRepository.findById(id);
    }

    public void save(TodoItem todoItem) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        if (todoItem.getId() == null) {
            todoItem.setCreatedAt(dtf.format(LocalDateTime.now()));
        }
        todoItem.setUpdatedAt(dtf.format(LocalDateTime.now()));
        todoItemRepository.saveAndFlush(todoItem);
    }

    public void delete(TodoItem todoItem) {
        todoItemRepository.delete(todoItem);
    }

    @Override
    public Iterable<TodoItem> getAllReversed() {
        return todoItemRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

}
