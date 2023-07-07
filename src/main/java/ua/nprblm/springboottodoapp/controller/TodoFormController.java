package ua.nprblm.springboottodoapp.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.nprblm.springboottodoapp.model.TodoItem;
import ua.nprblm.springboottodoapp.service.TodoItemService;

@Controller
public class TodoFormController {

    private final TodoItemService todoItemService;

    @Autowired
    public TodoFormController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @GetMapping("/create-todo")
    public String showCreateForm() {
        return "new-todo-item";
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid TodoItem todoItem) {
        todoItemService.save(todoItem);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id) {
        TodoItem item = validation(id);

        todoItemService.delete(item);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        TodoItem item = validation(id);

        model.addAttribute("todo", item);

        return "edit-todo-item";
    }

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") Long id, @Valid TodoItem todoItem) {
        TodoItem item = validation(id);

        item.setIsComplete(todoItem.getIsComplete());
        item.setDescription(todoItem.getDescription());

        todoItemService.save(item);

        return "redirect:/";
    }

    public TodoItem validation(Long id) {
        return todoItemService
                .getById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));
    }

}
