package com.reporthub.coreapis.controller;

import com.reporthub.coreapis.model.DSAcessToken;
import com.reporthub.coreapis.model.NbaDto;
import com.reporthub.coreapis.model.UserData;
import com.reporthub.coreapis.service.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/external")
public class ExternalController {

    @Autowired
    private ExternalService externalService;

    @GetMapping
    public UserData getUsers(){
        return  externalService.getListOfUsers();
    }

    @GetMapping("/auth")
    public DSAcessToken getDsAuthToken(){
       return externalService.getAuthToken();
    }

    @GetMapping("/nba")
    public NbaDto getNbaPlayers(){
        return externalService.getNBAPlayersList();
    }
}
