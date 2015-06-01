package com.codechallenge.test;

import com.codechallenge.model.MessageDTO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MessageDTOTest {

    @Test
    public void checkContentOfMessage() {
        MessageDTO msg = new MessageDTO("MessageDTOTest");
        assertEquals("MessageDTOTest", msg.getContent());
        assertEquals("MessageDTOTest", msg.toString());

    }

    @Test
    public void checkMessageEquals() {
        MessageDTO msg = new MessageDTO("MessageDTOTest");
        MessageDTO msg2 = new MessageDTO("MessageDTOTest");
        MessageDTO msg3 = new MessageDTO("123456");
        Object o = new Object();
        assertTrue(msg.equals(msg2));
        assertFalse(msg.equals(msg3));
        assertFalse(msg.equals(o));
    }
}
