package com.reporthub.coreapis.service;

import com.reporthub.coreapis.model.Todo;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface TodoApi {

    @GET("/todos")
    public Call<List<Todo>> fetchTodos();
}
