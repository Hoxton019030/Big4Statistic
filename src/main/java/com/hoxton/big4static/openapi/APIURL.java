package com.hoxton.big4static.openapi;

public enum APIURL {
    /**
     * 上市公司基本資料
     */
    PUBLICLY_LISTED_COMPANY_BASIC_INFORMATION("/opendata/t187ap03_L"),
    /**
     * 公開發行公司基本資料
     */
    PUBLICLY_TRADED_COMPANY_BASIC_INFORMATION("/opendata/t187ap03_P"),
    /**
     * "上市公司違反資訊申報、重大訊息及說明記者會規定專區"
     */
    VIOLATES_INFORMATION("/opendata/t187ap23_L"),
    /**
     * 上市公司金管會證券期貨局裁罰案件專區
     */
    PENALTY_CASES("/opendata/t187ap22_L"),


    /**
     * 上市公司營益分析查詢彙總表(全體公司彙總報表)
     */
    PROFIT_ANALYSIS("/opendata/t187ap17_L")
    ;



    APIURL(String value) {
        this.value = value;
    }

    private String value;
    private String OPENAPI= "https://openapi.twse.com.tw/v1";

    public String getURL() {
        return OPENAPI+value;
    }

}
