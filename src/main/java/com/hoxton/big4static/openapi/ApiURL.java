package com.hoxton.big4static.openapi;

public enum ApiURL {
    COMPANY_STATISTIC("https://openapi.twse.com.tw/v1/opendata/t187ap03_L");

    ApiURL(String value) {
        this.value = value;
    }

    private String value;

    public String getURL() {
        return value;
    }

}
