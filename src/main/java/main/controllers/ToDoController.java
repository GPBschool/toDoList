package main.controllers;

import lombok.RequiredArgsConstructor;
import main.models.ToDoDto;
import main.service.ToDoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService toDoService;

    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("list", toDoService.findAll());
        return "index";
    }

    @GetMapping("{id}")
    public String findById(@PathVariable int id, Model model) {
        Optional<ToDoDto> toDoOptional = toDoService.findById(id);
        if (toDoOptional.isEmpty()) {
            return "redirect:/";
        }
        model.addAttribute("todo", toDoOptional);
        return "operations/edit";
    }

    @DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable int id) {
        toDoService.deleteById(id);
        return "redirect:/";
    }


    @GetMapping("new")
    public String newToDo(Model model) {
        model.addAttribute("todo", new ToDoDto());
        return "operations/new";
    }

    @PostMapping("add")
    public String add(@Valid @ModelAttribute("todo") ToDoDto toDoDto, BindingResult result) {
        if (result.hasErrors()) {
            return "operations/new";
        }
        toDoService.add(toDoDto);
        return "redirect:/";
    }


    @PostMapping("edit")
    public String put(@Valid @ModelAttribute("todo") ToDoDto toDoDto, BindingResult result) {
        if (result.hasErrors()) {
            return "operations/edit";
        }
        toDoService.update(toDoDto);
        return "redirect:/";
    }

}
