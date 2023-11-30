package com.reporthub.coreapis.service.todoimpl;

import com.reporthub.coreapis.constants.ClientConstants;
import com.reporthub.coreapis.dtos.digital.DsAcessToken;
import com.reporthub.coreapis.records.Todo;
import com.reporthub.coreapis.dtos.digital.DigitalOrgApiReq;
import com.reporthub.coreapis.dtos.digital.DigitalOrgApiResponse;
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

    @Override
    public DsAcessToken fetchOauthToken() {

        DsAcessToken dsAcessToken = null;

        Call<DsAcessToken> call = todoApi.fetchOauthToken(ClientConstants.GRANT_TYPE,
                                               ClientConstants.CLIENT_ID,
                                               ClientConstants.CLIENT_SECRET);
        try{
            Response<DsAcessToken> response = call.execute();
            if(response.isSuccessful() && response != null){
                dsAcessToken = response.body();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        return dsAcessToken;
    }

    @Override
    public DigitalOrgApiResponse getProviderOrgs(DigitalOrgApiReq digitalOrgApiReq) {



        DigitalOrgApiResponse digitalOrgApiResponse = null;

        String token = fetchOauthToken().access_token();

        Call<DigitalOrgApiResponse> call = todoApi.getProviderOrgs(digitalOrgApiReq,"Bearer "+token);
        try{
            Response<DigitalOrgApiResponse> response = call.execute();

            if(response.isSuccessful() && response != null){
                digitalOrgApiResponse = response.body();
            }
        }catch (IOException e){System.out.println(e.getMessage());}

        return digitalOrgApiResponse;
    }


}
