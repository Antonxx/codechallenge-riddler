package com.codechallenge.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.codechallenge.jdbc.dao.MessageDAO;
import com.codechallenge.model.LastMessages;
import com.codechallenge.rest.service.MessageService;


public class MessageServiceTest {

    @Test
    public void checkMessageCreation() {

        MessageDAO mockMessageDAO = mock(MessageDAO.class);
        LastMessages lstmsg = mock(LastMessages.class);

        when(mockMessageDAO.getLastMessages()).thenReturn(lstmsg);

        MessageService ms = new MessageService(mockMessageDAO);
        assertEquals("Hello Antonio", ms.createMessage("Antonio").getContent());
        assertTrue(ms.createLastMessages().equals(lstmsg));

        verify(mockMessageDAO).getLastMessages();

    }

}
