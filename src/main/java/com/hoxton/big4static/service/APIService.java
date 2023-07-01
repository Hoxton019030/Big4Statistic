package com.hoxton.big4static.service;

import com.hoxton.big4static.dao.OpenAPIDao;
import com.hoxton.big4static.pojo.Company;
import com.hoxton.big4static.pojo.CompanyProfitInfo;
import com.hoxton.big4static.pojo.PunishEvent;
import com.hoxton.big4static.response.FirmCompany;
import com.hoxton.big4static.response.FirmProfitResponse;
import com.hoxton.big4static.response.FirmPunishResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class APIService {

    final OpenAPIDao openAPIDao;
    private HashMap<String, List<Company>> firmCompanyMap = new HashMap<>();
    private HashMap<String, List<PunishEvent>> punishMap = new HashMap<>();
    private HashMap<String, List<CompanyProfitInfo>> profitMap = new HashMap<>();


    public List<FirmCompany> getFirmVisaCompanyList() {
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
    public List<FirmPunishResponse> getComFirmPunishResponses() {
        punishMap = new HashMap<>();
        List<Company> allFirmCompany = openAPIDao.getAllFirmCompany();
        List<PunishEvent> allPunishEvent = openAPIDao.getAllPunishEvent();
        HashMap<String, List<PunishEvent>> classifyPunishEventsByCompany = classifyPunishEventsByCompany(allFirmCompany, allPunishEvent);
        List<FirmPunishResponse> firmPunishResponseList=new ArrayList<>();
        classifyPunishEventsByCompany.forEach((firmName, punishEventsList) -> {
            FirmPunishResponse firmPunishResponse = new FirmPunishResponse();
            firmPunishResponse.setAuditingAccountingFirm(firmName);
            firmPunishResponse.setPunishEventList(punishEventsList);
            firmPunishResponseList.add(firmPunishResponse);
        });
        return firmPunishResponseList;

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


    private void addCompanyToList(String firmName, Company company) {
        if (firmCompanyMap.containsKey(firmName)) {
            firmCompanyMap.get(firmName).add(company);
        } else {
            List<Company> companyList = new ArrayList<>();
            companyList.add(company);
            firmCompanyMap.put(firmName, companyList);
        }
    }





    private HashMap<String, List<PunishEvent>> classifyPunishEventsByCompany(List<Company> allFirmCompany, List<PunishEvent> allPunishEvent) {
        for (PunishEvent punishEvent : allPunishEvent) {
            assignPunishEventToCompany(allFirmCompany, punishEvent);
        }
        return punishMap;
    }

    private void assignPunishEventToCompany(List<Company> allFirmCompany, PunishEvent punishEvent) {
        String stockCode = punishEvent.getStockCode();
        for (Company company : allFirmCompany) {
            if (company.getCompanyCode().equals(stockCode)) {
                assignPunishEventToFirm(punishEvent, company.getAuditingAccountingFirm());
            }
        }
    }

    private void assignPunishEventToFirm(PunishEvent punishEvent, String auditingAccountingFirm) {
        if (auditingAccountingFirm.contains("勤業")) {
            addToPunishEventMap("勤業眾信聯合會計師事務所", punishEvent);
        } else if (auditingAccountingFirm.contains("資誠")) {
            addToPunishEventMap("資誠聯合會計師事務所", punishEvent);
        } else if (auditingAccountingFirm.contains("安侯")) {
            addToPunishEventMap("安侯聯合會計師事務所", punishEvent);
        } else if (auditingAccountingFirm.contains("安永")) {
            addToPunishEventMap("安永聯合會計師事務所", punishEvent);
        } else {
            addToPunishEventMap(auditingAccountingFirm, punishEvent);
        }

    }

    private void addToPunishEventMap(String firmName, PunishEvent punishEvent) {
        if (punishMap.containsKey(firmName)) {
            punishMap.get(firmName).add(punishEvent);
        } else {
            ArrayList<PunishEvent> punishEventsList = new ArrayList<>();
            punishEventsList.add(punishEvent);
            punishMap.put(firmName, punishEventsList);
        }
    }

    public List<FirmProfitResponse> getFirmProfitResponse(){
        List<CompanyProfitInfo> companyProfit = openAPIDao.getCompanyProfit();
        HashMap<String, List<CompanyProfitInfo>> stringListHashMap = classifyToFirm(companyProfit);
        List<FirmProfitResponse> firmProfitResponses = new ArrayList<>();
        stringListHashMap.forEach((s, companyProfitInfos) -> {
            FirmProfitResponse firmProfitResponse = new FirmProfitResponse();
            firmProfitResponse.setAuditingAccountingFirm(s);
            firmProfitResponse.setCompanyProfitList(companyProfitInfos);
            firmProfitResponses.add(firmProfitResponse);
        });
        return firmProfitResponses;

    }

    private HashMap<String, List<CompanyProfitInfo>> classifyToFirm(List<CompanyProfitInfo> companyProfit) {
        List<Company> allFirmCompany = openAPIDao.getAllFirmCompany();
        for (CompanyProfitInfo profitInfo : companyProfit) {
            String companyCode = profitInfo.getCompanyCode();
            for (Company company : allFirmCompany) {
                if (company.getCompanyCode().equals(companyCode)) {
                    classifyByFirmName(company.getAuditingAccountingFirm(),profitInfo);
                }
            }
        }
        return profitMap;
    }

    private void classifyByFirmName(String firmName, CompanyProfitInfo profitInfo) {
        if (firmName.contains("勤業")) {
            addToProfitMap("勤業眾信聯合會計師事務所", profitInfo);
        } else if (firmName.contains("資誠")) {
            addToProfitMap("資誠聯合會計師事務所", profitInfo);
        } else if (firmName.contains("安侯")) {
            addToProfitMap("安侯聯合會計師事務所", profitInfo);
        } else if (firmName.contains("安永")) {
            addToProfitMap("安永聯合會計師事務所", profitInfo);
        } else {
            addToProfitMap(firmName, profitInfo);
        }

    }

    private void addToProfitMap(String firmName, CompanyProfitInfo profitInfo) {
        if (profitMap.containsKey(firmName)) {
            profitMap.get(firmName).add(profitInfo);
        } else {
            ArrayList<CompanyProfitInfo> profitInfoArrayList = new ArrayList<>();
            profitInfoArrayList.add(profitInfo);
            profitMap.put(firmName, profitInfoArrayList);
        }
    }

}
