package com.hoxton.big4static.pojo;

import lombok.Data;

@Data
public class CompanyProfitInfo {
    private String reportDate;
    private String year;
    private String season;
    private String companyCode;
    private String companyName;
    private double operatingRevenue;
    private double grossProfitMargin;
    private double operatingProfitMargin;
    private double preTaxNetProfitMargin;
    private double afterTaxNetProfitMargin;
}
