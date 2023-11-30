package com.ecommerce.investoryservice.controller;

import com.ecommerce.investoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String greet(){
        return "greetings from inventory service......";
    }

    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("sku-code")  String skuCode){
            return inventoryService.isInStock(skuCode);
    }

}
