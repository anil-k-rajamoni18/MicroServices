package com.reporthub.coreapis.service;

import com.reporthub.coreapis.dtos.digital.DsAcessToken;
import com.reporthub.coreapis.records.Todo;

import com.reporthub.coreapis.dtos.digital.DigitalOrgApiReq;
import com.reporthub.coreapis.dtos.digital.DigitalOrgApiResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface TodoApi {

    @GET("/todos")
    public Call<List<Todo>> fetchTodos();

    @POST("/auth/oauth2/token")
     Call<DsAcessToken> fetchOauthToken(@Query("grant_type")
                                                    String grantType,
                                              @Query("client_id")
                                                    String clientId,
                                              @Query("client_secret")
                                                    String clientSecret
                                                    );

    @Headers({ "Content-Type: application/json;charset=UTF-8","Accept:application/json","Accept-Encoding:gzip,deflate"})
    @POST("/api/pdr/ds/access/org/v1.0")
    Call<DigitalOrgApiResponse> getProviderOrgs(@Body DigitalOrgApiReq digitalOrgApiReq,
                                                @Header("Authorization") String auth);
}
