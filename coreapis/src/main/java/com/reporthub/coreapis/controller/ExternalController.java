package com.reporthub.coreapis.controller;

import com.reporthub.coreapis.dtos.digital.DsAcessToken;
import com.reporthub.coreapis.dtos.NbaDto;
import com.reporthub.coreapis.dtos.UserData;
import com.reporthub.coreapis.service.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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



    @GetMapping("/nba")
    public NbaDto getNbaPlayers(){
        return externalService.getNBAPlayersList();
    }


}
