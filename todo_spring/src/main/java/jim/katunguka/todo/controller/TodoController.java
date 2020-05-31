package jim.katunguka.todo.controller;

import jim.katunguka.todo.model.Todo;
import jim.katunguka.todo.repo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoRepo todoRepo;

    @GetMapping
    private List<Todo> getAllTodos(){
        return todoRepo.findAll();
    }

    @PostMapping
    private Todo addTodo(@RequestBody Todo todo){
        return todoRepo.save(todo);
    }

    @DeleteMapping("/{id}")
    private Todo deleteTodo(@PathVariable int id){
        todoRepo.deleteById(id);
        return null;
    }
}
