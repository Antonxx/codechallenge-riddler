package com.codechallenge.test;

import static org.junit.Assert.assertEquals;

import com.codechallenge.model.MessageTimestamp;
import org.junit.Test;

import com.codechallenge.model.LastMessages;

import java.sql.Timestamp;
import java.util.Arrays;


public class LastMessagesTest {

    @Test
    public void checkLastMessageContent() {

        Timestamp time1 = new Timestamp(123);
        Timestamp time2 = new Timestamp(124);
        MessageTimestamp msg1 = new MessageTimestamp("MessageTest1", time1);
        MessageTimestamp msg2 = new MessageTimestamp("MessageTest2", time2);
        LastMessages lstMsg = new LastMessages(Arrays.asList(msg1, msg2));

        assertEquals(2, lstMsg.getMessageCount());
        assertEquals(time2.toString(), lstMsg.getLastMessage());
        assertEquals(msg1.getContent(), lstMsg.getMessages().get(0).getContent());
    }

}