package com.example.springannotations.advice;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class LazyLoadingBean {
    public LazyLoadingBean(){
        System.out.println("===========> LazyLoadingBean created ============>");
    }

}
