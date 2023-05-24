package com.reporthub.coreapis.service.todoimpl;

import com.reporthub.coreapis.model.Todo;
import com.reporthub.coreapis.service.TodoApi;
import com.reporthub.coreapis.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TodoImpl implements TodoService {

    @Autowired
    private final Retrofit retrofit;
    private TodoApi todoApi;

    public TodoImpl(Retrofit retrofit) {
        this.retrofit = retrofit;
        todoApi = this.retrofit.create(TodoApi.class);
    }

    @Override
    public List<Todo> fetchTodos()  {
        List<Todo> todoResponse = new ArrayList<>();
        Call<List<Todo>> fetchTodoCall = todoApi.fetchTodos();

        try{
        Response<List<Todo>> response = fetchTodoCall.execute();
        if(response.isSuccessful() && response.body() != null){
            todoResponse = response.body();
        }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return todoResponse;
    }
}
