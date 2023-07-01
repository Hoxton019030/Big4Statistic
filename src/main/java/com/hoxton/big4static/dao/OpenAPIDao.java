package com.hoxton.big4static.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.hoxton.big4static.openapi.ApiURL;
import com.hoxton.big4static.pojo.Company;
import com.hoxton.big4static.utils.CrawlUtil;
import com.hoxton.big4static.utils.JsonUtil;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OpenAPIDao {

    public JsonNode get(){
        String stream = CrawlUtil.stream(ApiURL.PUBLICLY_LISTED_COMPANY_BASIC_INFORMATION.getURL());
        return JsonUtil.getJsonNode(stream);
    }

//    @Cacheable(value = "publicListedCompanyList")
    public List<Company> getPubliclyListedCompanyList(){
        String stream = CrawlUtil.faster(ApiURL.PUBLICLY_LISTED_COMPANY_BASIC_INFORMATION.getURL());
        JsonNode jsonNode = JsonUtil.getJsonNode(stream);
        List<Company> companies = new ArrayList<>();
        for (JsonNode companyInfo : jsonNode) {

            boolean b = companies.stream().anyMatch(company -> company.getCompanyName().equals(companyInfo.get("公司名稱").asText()));
            if (b==true){
                String text = companyInfo.get("公司名稱").asText();
                System.out.println("text 沖服= " + text);
                break;
            }


            Company company = new Company();
//            company.setReportDate(companyInfo.get("出表日期").asText());
            company.setCompanyCode(companyInfo.get("公司代號").asText());
            company.setCompanyName(companyInfo.get("公司名稱").asText());
//            company.setCompanyAbbreviation(companyInfo.get("公司簡稱").asText());
//            company.setForeignCompanyRegistrationCountry(companyInfo.get("外國企業註冊地國").asText());
//            company.setIndustry(companyInfo.get("產業別").asText());
//            company.setAddress(companyInfo.get("住址").asText());
//            company.setUnifiedBusinessNumber(companyInfo.get("營利事業統一編號").asText());
//            company.setChairman(companyInfo.get("董事長").asText());
//            company.setGeneralManager(companyInfo.get("總經理").asText());
//            company.setSpokesperson(companyInfo.get("發言人").asText());
//            company.setSpokespersonTitle(companyInfo.get("發言人職稱").asText());
//            company.setProxySpokesperson(companyInfo.get("代理發言人").asText());
//            company.setMainPhone(companyInfo.get("總機電話").asText());
//            company.setEstablishmentDate(companyInfo.get("成立日期").asText());
//            company.setListingDate(companyInfo.get("上市日期").asText());
//            company.setOrdinarySharesParValue(companyInfo.get("普通股每股面額").asText());
//            company.setPaidInCapital(companyInfo.get("實收資本額").asText());
//            company.setPrivatePlacementShares(companyInfo.get("私募股數").asText());
//            company.setPreferredShares(companyInfo.get("特別股").asText());
//            company.setFinancialStatementsType(companyInfo.get("編制財務報表類型").asText());
//            company.setStockTransferAgent(companyInfo.get("股票過戶機構").asText());
//            company.setTransferAgentPhone(companyInfo.get("過戶電話").asText());
//            company.setTransferAgentAddress(companyInfo.get("過戶地址").asText());
            company.setAuditingAccountingFirm(companyInfo.get("簽證會計師事務所").asText());
            company.setSigningAuditor1(companyInfo.get("簽證會計師1").asText());
            company.setSigningAuditor2(companyInfo.get("簽證會計師2").asText());
//            company.setEnglishAbbreviation(companyInfo.get("英文簡稱").asText());
//            company.setEnglishMailingAddress(companyInfo.get("英文通訊地址").asText());
//            company.setFaxNumber(companyInfo.get("傳真機號碼").asText());
//            company.setEmail(companyInfo.get("電子郵件信箱").asText());
//            company.setWebsite(companyInfo.get("網址").asText());
            companies.add(company);
        }
        return companies;
    }

    @Cacheable(value = "publicTradedCompanyList")
    public List<Company> getPubliclyTradeCompanyList(){
        String stream = CrawlUtil.faster(ApiURL.PUBLICLY_TRADED_COMPANY_BASIC_INFORMATION.getURL());
        JsonNode jsonNode = JsonUtil.getJsonNode(stream);
        List<Company> companies = new ArrayList<>();
        for (JsonNode companyInfo : jsonNode) {
            Company company = new Company();
//            company.setReportDate(companyInfo.get("出表日期").asText());
            company.setCompanyCode(companyInfo.get("公司代號").asText());
            company.setCompanyName(companyInfo.get("公司名稱").asText());
//            company.setCompanyAbbreviation(companyInfo.get("公司簡稱").asText());
//            company.setForeignCompanyRegistrationCountry(companyInfo.get("外國企業註冊地國").asText());
//            company.setIndustry(companyInfo.get("產業別").asText());
//            company.setAddress(companyInfo.get("住址").asText());
//            company.setUnifiedBusinessNumber(companyInfo.get("營利事業統一編號").asText());
//            company.setChairman(companyInfo.get("董事長").asText());
//            company.setGeneralManager(companyInfo.get("總經理").asText());
//            company.setSpokesperson(companyInfo.get("發言人").asText());
//            company.setSpokespersonTitle(companyInfo.get("發言人職稱").asText());
//            company.setProxySpokesperson(companyInfo.get("代理發言人").asText());
//            company.setMainPhone(companyInfo.get("總機電話").asText());
//            company.setEstablishmentDate(companyInfo.get("成立日期").asText());
//            company.setListingDate(companyInfo.get("上市日期").asText());
//            company.setOrdinarySharesParValue(companyInfo.get("普通股每股面額").asText());
//            company.setPaidInCapital(companyInfo.get("實收資本額").asText());
//            company.setPrivatePlacementShares(companyInfo.get("私募股數").asText());
//            company.setPreferredShares(companyInfo.get("特別股").asText());
//            company.setFinancialStatementsType(companyInfo.get("編制財務報表類型").asText());
//            company.setStockTransferAgent(companyInfo.get("股票過戶機構").asText());
//            company.setTransferAgentPhone(companyInfo.get("過戶電話").asText());
//            company.setTransferAgentAddress(companyInfo.get("過戶地址").asText());
            company.setAuditingAccountingFirm(companyInfo.get("簽證會計師事務所").asText());
            company.setSigningAuditor1(companyInfo.get("簽證會計師1").asText());
            company.setSigningAuditor2(companyInfo.get("簽證會計師2").asText());
//            company.setEnglishAbbreviation(companyInfo.get("英文簡稱").asText());
//            company.setEnglishMailingAddress(companyInfo.get("英文通訊地址").asText());
//            company.setFaxNumber(companyInfo.get("傳真機號碼").asText());
//            company.setEmail(companyInfo.get("電子郵件信箱").asText());
//            company.setWebsite(companyInfo.get("網址").asText());
            companies.add(company);
        }
        return companies;
    }


}
