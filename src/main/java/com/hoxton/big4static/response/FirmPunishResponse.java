package com.hoxton.big4static.response;

import com.hoxton.big4static.pojo.PunishEvent;
import lombok.Data;

import java.util.List;

@Data
public class FirmPunishResponse {
    String auditingAccountingFirm;
    List<PunishEvent> punishEventList;
}
