package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class TodoController {
  @Autowired
  private TodoService service;

  @GetMapping(value = "Api/todos")
    public Iterable<Todo> List(){
        return service.List();

    }

    @PostMapping(value = "Api/todo")
    public Todo save(@RequestBody Todo todo){
        return  service.save(todo);
    }

    @PutMapping(value = "Api/todo")
    public Todo update(@RequestBody Todo todo){
      if (todo.getId() < 0){
          return  service.save(todo);
      }
      throw new RuntimeException("No existe el Id ");
    }


    @DeleteMapping(value = "Api/{id}/todo")
    public  void  delete(@PathVariable("id") long id){
        service.delete(id);
    }

    @GetMapping(value = "Api/{id}/Todo")
    public Todo get(@PathVariable("id") long id){
        return service.get(id);

    }

}
