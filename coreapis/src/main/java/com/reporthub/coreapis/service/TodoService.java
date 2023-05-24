package com.reporthub.coreapis.service;

import com.reporthub.coreapis.model.Todo;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface TodoService {

    public List<Todo> fetchTodos();
}
