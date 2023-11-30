package com.learn101;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
@Slf4j
public class HelloWorldController {

    @GetMapping("/hello")
    public String showHelloWorldString() {
        return "Hello World Spring.";
    }

    @GetMapping("/testHeaders")
    public ResponseEntity<String> greeting(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String acceptLanguage, @RequestHeader("client-code") String clientCode) {
        log.info("Accept-Language: " + acceptLanguage);
        log.info("Client-Code: " + clientCode);
        return ResponseEntity.ok().body("Hello World Spring.");
    }

    @GetMapping("/listHeaders")
    public ResponseEntity<String> listAllHeaders(@RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> {
            log.info(String.format("Header '%s' = %s", key, value));
        });

        return new ResponseEntity<>(String.format("Listed %d headers", headers.size()), HttpStatus.OK);
    }
}
