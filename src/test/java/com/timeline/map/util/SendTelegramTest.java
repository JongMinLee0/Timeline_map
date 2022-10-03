package com.timeline.map.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SendTelegramTest {

    @Autowired
    private SendTelegram sendTelegram;

    @Test
    @DisplayName("텔레그램 메시지 전송")
    public void sendMessageTest() {
        sendTelegram.sendMessage("한글도 가능하지 않나?");
    }

}
