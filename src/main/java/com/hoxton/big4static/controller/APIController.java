package com.hoxton.big4static.controller;

import com.hoxton.big4static.dao.OpenAPIDao;
import com.hoxton.big4static.response.FirmCompany;
import com.hoxton.big4static.service.APIService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class APIController {

    private final APIService apiService;
    private final OpenAPIDao openAPIDao;


    @GetMapping("/company")
    @CrossOrigin("http://localhost:3000")
    @Cacheable(value = "listCache")
    public ResponseEntity<?> test(){
        ArrayList<FirmCompany> firmVisaCompanyList = apiService.getFirmVisaCompanyList();
        return ResponseEntity.status(HttpStatus.OK).body(firmVisaCompanyList);
    }
}


