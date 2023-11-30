package com.reporthub.coreapis.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reporthub.coreapis.dtos.*;
import com.reporthub.coreapis.dtos.digital.DsAcessToken;
import com.reporthub.coreapis.dtos.test.CityInfo;
import com.reporthub.coreapis.dtos.test.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

@Service
public class ExternalService {


    @Autowired
     private WebClient webClient;

    @Value("${client_secret}")
    private String clientSecret;

    @Value("${client_id}")
    private String clientId;

    @Value("${grant_type}")
    private String grantType;

    @Value("${dsAuthApiUrl}")
    private String dsAuthApiurl;


    public UserData getListOfUsers(){
        UserData userData = webClient
                .get()
                .uri("https://reqres.in/api/users?page=2")
                .retrieve()
                .bodyToMono(UserData.class)
                .block();
        System.out.println(userData.getData());
        return userData;
    }

    public DsAcessToken getAuthToken() {
        System.out.println(":::::::::::::::: DS AUTH TOKE API URL :::::::::::: "+dsAuthApiurl);
        return webClient.
                   post()
                   .uri(uriBuilder -> uriBuilder
                           .host(dsAuthApiurl)
                           .path("auth/oauth2/token/")
                           .queryParam("grant_type",grantType)
                           .queryParam("client_id",clientId)
                           .queryParam("client_secret",clientSecret)
                           .build())
                   .contentType(MediaType.APPLICATION_JSON)
                   .retrieve()
                   .bodyToMono(DsAcessToken.class)
                   .block();
    }

    public NbaDto getNBAPlayersList() {
        System.out.println("Inside get NBAPlayersLIst");
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/players")
                        .queryParam("page",0)
                        .queryParam("per_page",25)
                        .build())
                .header("X-RapidAPI-Key","e067b088b2msh4a769d2f8d934afp19fe9djsnea03e15e740a")
                .header("X-RapidAPI-Host","free-nba.p.rapidapi.com")
                .retrieve()
                .bodyToMono(NbaDto.class)
                .block();
    }


    public CityInfo getTestData(CityInfo cityInfo) {

        ObjectMapper mapper = new ObjectMapper();

        // try - @Builder & @Getter
   /*
        StudentDto studentDto = StudentDto.builder()
                .name("kumar")
                .college("UCEOU")
                .rank(18)
                .build();
    */

        // try-2 requires No-Argrs Default constructor. @Builder @Data

        StudentDto studentDto = null ;
        try {
            studentDto = mapper.readValue("{\"name\":\"akrajamoni\",\"college\":\"JNTUK\",\"rank\":1}",StudentDto.class);
        } catch (IOException exception) {
            System.out.println("exception occured : " + exception.getMessage());
        }
        System.out.println(studentDto);


        //try3
/*
        StudentDto studentDto = new StudentDto("ram","vasavi",17);

  */
        return cityInfo;
    }

}
