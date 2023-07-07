package ua.nprblm.springboottodoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.nprblm.springboottodoapp.service.TodoItemService;

@Controller
public class HomeController {

    private final TodoItemService todoItemService;

    @Autowired
    public HomeController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", todoItemService.getAllReversed());
        return modelAndView;
    }
}
