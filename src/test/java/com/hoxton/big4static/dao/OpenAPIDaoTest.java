package com.hoxton.big4static.dao;

import com.hoxton.big4static.pojo.PunishEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OpenAPIDaoTest {
    @Autowired
    OpenAPIDao openAPIDao;

    @Test
    void get() {
    }

    @Test
    void getPubliclyListedCompanyList() {
    }

    @Test
    void getPubliclyTradeCompanyList() {
    }

    @Test
    void getAllPunishEvent() {
        List<PunishEvent> allPunishEvent = openAPIDao.getAllPunishEvent();
        for (PunishEvent punishEvent : allPunishEvent) {
            System.out.println("punishEvent.getCompanyName() = " + punishEvent.getCompanyName());
        }
    }
}