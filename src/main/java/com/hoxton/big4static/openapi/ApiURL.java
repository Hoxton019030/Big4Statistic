package com.hoxton.big4static.openapi;

public enum ApiURL {
    /**
     * 上市公司基本資料
     */
    PUBLICLY_LISTED_COMPANY_BASIC_INFORMATION("/opendata/t187ap03_L"),
    /**
     * 公開發行公司基本資料
     */
    PUBLICLY_TRADED_COMPANY_BASIC_INFORMATION("/opendata/t187ap03_P");


    ApiURL(String value) {
        this.value = value;
    }

    private String value;
    private String OPENAPI= "https://openapi.twse.com.tw/v1";

    public String getURL() {
        return OPENAPI+value;
    }

}
