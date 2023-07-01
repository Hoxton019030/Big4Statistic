package com.hoxton.big4static.pojo;

import lombok.Data;

@Data
public class PunishEvent {
    private String filingDate;
    private String letterDate;
    private String stockCode;
    private String companyName;
    private String violationReason;
    private String regulatoryViolations;
    private String penaltyDetails;
}
