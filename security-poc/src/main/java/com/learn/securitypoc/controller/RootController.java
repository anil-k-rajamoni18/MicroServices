package com.learn.securitypoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @Autowired
    private BuildProperties buildProperties;
    private static final String APP_VERSION_DEFAULT = "0.0.0";

    @GetMapping("/")
    public String status() {
        final String appVersion = StringUtils.hasText(buildProperties.getVersion()) ? buildProperties.getVersion() : APP_VERSION_DEFAULT;
        return String.format("Product service is UP & Running: v:%s", appVersion);
    }
}
