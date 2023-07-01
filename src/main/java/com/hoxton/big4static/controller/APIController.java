package com.hoxton.big4static.controller;

import com.hoxton.big4static.response.FirmCompany;
import com.hoxton.big4static.response.FirmProfitResponse;
import com.hoxton.big4static.response.FirmPunishResponse;
import com.hoxton.big4static.service.APIService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
@CrossOrigin(value = {"http://localhost:3000", "http://128.199.207.152:9000"})
public class APIController {

    private final APIService apiService;

    @GetMapping("/company")
    @Cacheable(value = "listCache")
    public ResponseEntity<?> getAllCompany() {
        List<FirmCompany> firmVisaCompanyList = apiService.getFirmVisaCompanyList();
        return ResponseEntity.status(HttpStatus.OK).body(firmVisaCompanyList);
    }

    @GetMapping("/punish")
    @Cacheable(value = "listPunish")
    public ResponseEntity<?> getAllPunish() {
        List<FirmPunishResponse> comFirmPunishResponses = apiService.getComFirmPunishResponses();
        return ResponseEntity.status(HttpStatus.OK).body(comFirmPunishResponses);
    }

    @GetMapping("/profit")
    @Cacheable(value = "listProfit")
    public ResponseEntity<?> getAllProfit() {
        List<FirmProfitResponse> firmProfitResponse = apiService.getFirmProfitResponse();
        return ResponseEntity.status(HttpStatus.OK).body(firmProfitResponse);
    }

}


