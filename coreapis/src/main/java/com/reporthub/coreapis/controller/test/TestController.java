package com.reporthub.coreapis.controller.test;

import com.reporthub.coreapis.configuration.APIRegistryProps;
import com.reporthub.coreapis.dtos.test.CityInfo;
import com.reporthub.coreapis.service.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/json")
public class TestController {

    @Autowired
    APIRegistryProps props;

    @Autowired
    private ExternalService externalService;

    @GetMapping("/testSerialise")
    public CityInfo getTestData(final @RequestBody CityInfo cityInfo) {
        System.out.println(cityInfo);
        System.out.println(props);
        return externalService.getTestData(cityInfo);
    }
}
