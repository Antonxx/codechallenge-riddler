package com.codechallenge.test;

import com.codechallenge.model.MessageTimestamp;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;

public class MessageTimestampTest {

    @Test
    public void checkContent() {
        Timestamp time = new Timestamp(123);
        MessageTimestamp msg = new MessageTimestamp("MessageDTOTest", time);
        assertEquals("MessageDTOTest", msg.getContent());
        assertEquals("MessageDTOTest", msg.toString());

    }

    @Test
    public void checkGetTime() {
        Timestamp time = new Timestamp(123);
        MessageTimestamp msg = new MessageTimestamp("MessageDTOTest", time);
        assertTrue(time.equals(msg.getTime()));
    }
}