package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired  // inyectar nuestro repositorio

    private TodoRepository repository;

    public Iterable<Todo> List(){
        return repository.findAll(); // retornar del reposytorio todo los elementos

    }

    public Todo save(Todo todo){
        return  repository.save(todo);
    }

    public  void  delete(long id){
       repository.delete(get(id));
    }

    public Todo get(long id){
      return repository.findById(id).orElseThrow();

    }
}
