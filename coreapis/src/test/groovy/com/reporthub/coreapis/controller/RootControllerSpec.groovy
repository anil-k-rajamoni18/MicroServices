package com.reporthub.coreapis.controller

import com.reporthub.coreapis.dtos.test.CityInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(RootController.class)
class RootControllerSpec extends Specification{

    @Autowired
    MockMvc mvc;

    def "Status Check"(){
        given:
        def apiResponse = "core api is UP and RUNNING ...."

        expect: "should display status message"
        mvc.perform(get("/api/status"))
        .andExpect(status().isOk())
        .andReturn()
        .response.contentAsString.equalsIgnoreCase(apiResponse)


    }

    def "test 1"(){

        given:
        def str1 = "Hey Groovy"
        def str2 = "Welcome, Learning you is bit interesting."
        when:
        def concatString = str1 +" "+ str2
        then:
        concatString == "Hey Groovy Welcome, Learning you is bit interesting."
    }

    def "test2 city info check"(){
        given:
        def cityList = new ArrayList< CityInfo>()
        when:
        cityList.add(new CityInfo("hyderbad",4))
        cityList.add(new CityInfo("mumbai",3))
        cityList.add(new CityInfo("chennai",2))
        cityList.add(new CityInfo("kolkata",1))

        then:
//        cityList.get(0).cityName() == "hyderbad"
//        cityList.get(1).cityName() == "mumbai"
//        cityList.get(2).cityName() == "chennai"
        cityList*.cityName == ["hyderbad","mumbai","chennai","kolkata"]

    }

    def "setup"(){
        println "in setup method"
    }


    def "cleanup"(){
        println "in cleanup method"
    }

    def "setupSpec"(){
        println("in setupSpec method")
    }

    def "cleanupSpec"(){
        println("in setupSpec method")
    }
}
