package com.hoxton.big4static.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hoxton.big4static.response.FirmResponse;
import com.hoxton.big4static.service.APIService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class APIController {

    private final APIService apiService;

    @GetMapping("/company")
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<List<FirmResponse>> getAllCompanyStatistic() throws MalformedURLException, JsonProcessingException {
        List<FirmResponse> allCompanyStatistic = apiService.getAllCompanyStatistic();
        return  ResponseEntity.ok().body(allCompanyStatistic);
    }
}

@NoArgsConstructor
@AllArgsConstructor
@Data
class People{
    String name;
    int age;
}
