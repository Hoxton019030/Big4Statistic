package com.hoxton.big4static.response;

import com.hoxton.big4static.pojo.Company;
import lombok.Data;

import java.util.List;

@Data
public class FirmCompany {
    String auditingAccountingFirm;
    List<Company> companyList;
}
