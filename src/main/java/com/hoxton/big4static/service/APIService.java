package com.hoxton.big4static.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.hoxton.big4static.dao.OpenAPIDao;
import com.hoxton.big4static.pojo.Company;
import com.hoxton.big4static.response.FirmCompany;
import com.hoxton.big4static.response.FirmResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class APIService {

    final OpenAPIDao openAPIDao;
    private HashMap<String, List<Company>> firmCompanyMap = new HashMap<>();


    public ArrayList<FirmCompany> getFirmVisaCompanyList() {
        firmCompanyMap = new HashMap<>();
        List<Company> companyList = openAPIDao.getPubliclyListedCompanyList();
        List<Company> publiclyTradeCompanyList = openAPIDao.getPubliclyTradeCompanyList();
        companyList.addAll(publiclyTradeCompanyList);
        HashMap<String, List<Company>> stringListHashMap = companyClassify(companyList);
        ArrayList<FirmCompany> firmCompanies = new ArrayList<>();
        stringListHashMap.forEach((s, companyList1) -> {
            FirmCompany firmCompany = new FirmCompany();
            firmCompany.setAuditingAccountingFirm(s);
            firmCompany.setCompanyList(companyList1);
            firmCompanies.add(firmCompany);
        });
        return firmCompanies;

    }
    private HashMap<String, List<Company>> companyClassify(List<Company> companyList) {
        for (Company company : companyList) {
            String auditingAccountingFirm = company.getAuditingAccountingFirm();
            if (auditingAccountingFirm.contains("勤業")) {
                addCompanyToList("勤業眾信聯合會計師事務所", company);
            } else if (auditingAccountingFirm.contains("資誠")) {
                addCompanyToList("資誠聯合會計師事務所", company);
            } else if (auditingAccountingFirm.contains("安侯")) {
                addCompanyToList("安侯聯合會計師事務所", company);
            } else if (auditingAccountingFirm.contains("安永")) {
                addCompanyToList("安永聯合會計師事務所", company);
            } else {
                addCompanyToList(auditingAccountingFirm, company);
            }
        }
        return firmCompanyMap;
    }
    private void addCompanyToList(String key, Company company) {
        if (firmCompanyMap.containsKey(key)) {
            firmCompanyMap.get(key).add(company);
        } else {
            List<Company> companyList = new ArrayList<>();
            companyList.add(company);
            firmCompanyMap.put(key, companyList);
        }
    }


}
