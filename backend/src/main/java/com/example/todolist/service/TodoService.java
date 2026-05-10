package com.example.todolist.service;

//import com.sun.org.apache.xalan.internal.xsltc.compiler.Sort;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.todolist.entity.Todo;
import com.example.todolist.repository.TodoRepository;

@Service
public class TodoService{
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo){
        todoRepository.save(todo);
        return this.list();
    }

    public List<Todo> update(Todo todo){
        todoRepository.save(todo);
        return this.list();
    }

    public List<Todo> remove(Long id){
        todoRepository.deleteById(id);
        return this.list();
    }

    public List<Todo> list(){
        Sort formato = Sort.sort(Todo.class).by(Todo::getPrioridade).descending();
        return todoRepository.findAll(formato);
    }

}
