package com.api.restapiexamples.controller;

import com.api.restapiexamples.model.RestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class StudentConroller {


    Map<String, RestUser> allUsers = new HashMap<String,RestUser>();

    @Autowired
    RestUser obj;

    @GetMapping("/test")
    public String hello(){
        return "greets from student controller.....";
    }

    @GetMapping("/get")
    public Map<String,RestUser> getMethod(){
        return allUsers;
    }

    @PostMapping("/post")
    public String postMethod(@RequestBody RestUser userDetails){
//        RestUser obj = new RestUser();
        obj.setUserID(userDetails.getUserID());
        obj.setName(userDetails.getName());
        obj.setEmail(userDetails.getEmail());
        allUsers.put(obj.getUserID(),obj);
        return "Data inserted ";
    }

    @DeleteMapping("/delete")
    public String deleteMethod(){
        return "delete method";
    }

    @PostMapping("/put")
    public String puttMethod(){
        return "put method";
    }



}
