package com.reporthub.coreapis.controller.digital;

import com.reporthub.coreapis.dtos.digital.DsAcessToken;
import com.reporthub.coreapis.dtos.digital.DigitalOrgApiReq;
import com.reporthub.coreapis.dtos.digital.DigitalOrgApiResponse;
import com.reporthub.coreapis.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/core/digital")
public class DigitalSecurityClientController {

    @Autowired
    private TodoService todoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/oauth")
    public DsAcessToken fetchOauthToken(){
        return todoService.fetchOauthToken();
    }

    @PostMapping("/org")
    public DigitalOrgApiResponse getProviderOrgs(@RequestBody DigitalOrgApiReq digitalOrgApiReq){
        return todoService.getProviderOrgs(digitalOrgApiReq);
    }
}
