package com.hoxton.big4static.response;

import com.hoxton.big4static.pojo.CompanyProfitInfo;
import lombok.Data;

import java.util.List;

@Data
public class FirmProfitResponse {
    String auditingAccountingFirm;
     List<CompanyProfitInfo> companyProfitList;
}
