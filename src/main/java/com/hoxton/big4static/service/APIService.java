package com.hoxton.big4static.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.hoxton.big4static.openapi.ApiURL;
import com.hoxton.big4static.response.FirmResponse;
import com.hoxton.big4static.utils.CrawlUtil;
import com.hoxton.big4static.utils.JsonUtil;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class APIService {

    HashMap<String, Integer> accountingFirmMap = new HashMap<>();

    public List<FirmResponse> getAllCompanyStatistic() throws MalformedURLException, JsonProcessingException {
        accountingFirmMap=new HashMap<>();
        String stream = CrawlUtil.stream(ApiURL.COMPANY_STATISTIC.getURL());
        JsonNode jsonNode = JsonUtil.getJsonNode(stream);
        for (JsonNode node : jsonNode) {
            String firm = node.get("簽證會計師事務所").asText();
            if (firm.contains("勤業")) {
                // 将包含"勤業"的公司归类到名为"勤業"的键下
                String key = "勤業聯合會計師事務所";
                updateMapCount(key);
            } else if (firm.contains("資誠")) {
                // 将包含"資誠"的公司归类到名为"資誠"的键下
                String key = "資誠聯合會計師事務所";
                updateMapCount(key);
            } else if (firm.contains("安侯")) {
                // 将包含"安侯"的公司归类到名为"安侯"的键下
                String key = "安侯聯合會計師事務所";
                updateMapCount(key);
            } else if (firm.contains("安永")) {
                // 将包含"安永"的公司归类到名为"安永"的键下
                String key = "安永聯合會計師事務所";
                updateMapCount(key);
            } else {
                // 其他公司按照原逻辑归类
                if (!accountingFirmMap.containsKey(firm)) {
                    accountingFirmMap.put(firm, 1);
                } else {
                    Integer currentValue = accountingFirmMap.get(firm);
                    accountingFirmMap.put(firm, currentValue + 1);
                }
            }
        }

        List<FirmResponse> firmResponseArrayList = new ArrayList<>();


        List<FirmResponse> finalFirmResponseArrayList = firmResponseArrayList;
        accountingFirmMap.forEach((s, integer) -> {
            FirmResponse firmResponse = new FirmResponse();
            firmResponse.setFirmName(s);
            firmResponse.setCount(integer);
            finalFirmResponseArrayList.add(firmResponse);

        });

        firmResponseArrayList = firmResponseArrayList.stream().sorted((o1, o2) -> o2.getCount().compareTo(o1.getCount())).collect(Collectors.toList());


        return firmResponseArrayList;
    }

    private void updateMapCount(String key) {
        if(accountingFirmMap==null){return;}
        if (!accountingFirmMap.containsKey(key)) {
            accountingFirmMap.put(key, 1);
        } else {
            Integer currentValue = accountingFirmMap.get(key);
            accountingFirmMap.put(key, currentValue + 1);
        }
    }
}
