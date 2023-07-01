package com.hoxton.big4static.pojo;

import lombok.Data;

@Data
public class Company {
    /**
     * 出表日期
     */
    private String reportDate;

    /**
     * 公司代號
     */
    private String companyCode;

    /**
     * 公司名稱
     */
    private String companyName;

    /**
     * 公司簡稱
     */
    private String companyAbbreviation;

    /**
     * 外國企業註冊地國
     */
    private String foreignCompanyRegistrationCountry;

    /**
     * 產業別
     */
    private String industry;

    /**
     * 住址
     */
    private String address;

    /**
     * 營利事業統一編號
     */
    private String unifiedBusinessNumber;

    /**
     * 董事長
     */
    private String chairman;

    /**
     * 總經理
     */
    private String generalManager;

    /**
     * 發言人
     */
    private String spokesperson;

    /**
     * 發言人職稱
     */
    private String spokespersonTitle;

    /**
     * 代理發言人
     */
    private String proxySpokesperson;

    /**
     * 總機電話
     */
    private String mainPhone;

    /**
     * 成立日期
     */
    private String establishmentDate;

    /**
     * 上市日期
     */
    private String listingDate;

    /**
     * 普通股每股面額
     */
    private String ordinarySharesParValue;

    /**
     * 實收資本額
     */
    private String paidInCapital;

    /**
     * 私募股數
     */
    private String privatePlacementShares;

    /**
     * 特別股
     */
    private String preferredShares;

    /**
     * 編制財務報表類型
     */
    private String financialStatementsType;

    /**
     * 股票過戶機構
     */
    private String stockTransferAgent;

    /**
     * 過戶電話
     */
    private String transferAgentPhone;

    /**
     * 過戶地址
     */
    private String transferAgentAddress;

    /**
     * 簽證會計師事務所
     */
    private String auditingAccountingFirm;

    /**
     * 簽證會計師1
     */
    private String signingAuditor1;

    /**
     * 簽證會計師2
     */
    private String signingAuditor2;

    /**
     * 英文簡稱
     */
    private String englishAbbreviation;

    /**
     * 英文通訊地址
     */
    private String englishMailingAddress;

    /**
     * 傳真機號碼
     */
    private String faxNumber;

    /**
     * 電子郵件信箱
     */
    private String email;

    /**
     * 網址
     */
    private String website;
}
