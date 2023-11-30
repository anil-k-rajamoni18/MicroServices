package com.reporthub.coreapis.controller;

import com.reporthub.coreapis.dtos.shield.PcpCapReport;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@RestController
@RequestMapping("/api")
public class RootController {

    @GetMapping("/status")
    public String greet(){
        return "Core Api is UP and RUNNING ....";
    }

    @GetMapping(value = "/response-entity")
    public ResponseEntity<Resource> usingResponseEntityBuilderAndHttpHeaders() {

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("anil-Header", "hello-world");
        responseHeaders.set(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=sample.pdf");
        InputStreamResource inputStreamResource = new InputStreamResource(
                new ByteArrayInputStream("test message for ByteArrayInputStream".getBytes()));

        PcpCapReport.PcpData pcpData = new PcpCapReport.PcpData();
        pcpData.setId("000786240001");
        pcpData.setId("000786240002");
        System.out.println(pcpData);

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(inputStreamResource);
    }
}
