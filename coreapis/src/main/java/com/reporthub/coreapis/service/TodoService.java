package com.reporthub.coreapis.service;

import com.reporthub.coreapis.dtos.digital.DsAcessToken;
import com.reporthub.coreapis.records.Todo;
import com.reporthub.coreapis.dtos.digital.DigitalOrgApiReq;
import com.reporthub.coreapis.dtos.digital.DigitalOrgApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoService {

     List<Todo> fetchTodos();

     DsAcessToken fetchOauthToken();

    DigitalOrgApiResponse getProviderOrgs(DigitalOrgApiReq digitalOrgApiReq);
}
