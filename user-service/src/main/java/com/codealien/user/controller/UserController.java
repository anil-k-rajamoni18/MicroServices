package com.codealien.user.controller;

import com.codealien.user.VO.ResponseTemplateVO;
import com.codealien.user.entity.Person;
import com.codealien.user.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/")
    public Person saveUser(@RequestBody Person user) {
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    int count = 0;
    @GetMapping("/{id}")
//    @CircuitBreaker(name = "userService",fallbackMethod = "fallback")
//    @Retry(name="userService",fallbackMethod = "fallback")
    @RateLimiter(name="userService",fallbackMethod = "fallback")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Retry method called "+count++ + " times at "+new Date());
        return userService.getUserWithDepartment(userId);
    }

    public ResponseTemplateVO fallback(Exception e){
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        responseTemplateVO.setErrorDes("Department service  is down ");
        return  responseTemplateVO;
    }

}
