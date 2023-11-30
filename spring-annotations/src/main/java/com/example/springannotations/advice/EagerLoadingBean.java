package com.example.springannotations.advice;

import org.springframework.stereotype.Component;

@Component
public class EagerLoadingBean {

    public EagerLoadingBean(){
        System.out.println("====> EagerLoadingBean created ====>");
    }
}
