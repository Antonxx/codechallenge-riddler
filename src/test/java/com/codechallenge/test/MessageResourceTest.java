package com.codechallenge.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.codechallenge.model.LastMessages;
import com.codechallenge.model.MessageDTO;
import com.codechallenge.rest.resource.MessageResource;
import com.codechallenge.rest.service.MessageService;


public class MessageResourceTest {

    @Test
    public void checkRestAPI() {

        MessageService mockMessageService = mock(MessageService.class);
        MessageDTO mockDTO = mock(MessageDTO.class);
        when(mockMessageService.createMessage("Antonio")).thenReturn(mockDTO);

        MessageResource resource = new MessageResource(mockMessageService);
        LastMessages lstmsg = mock(LastMessages.class);
        when(mockMessageService.createLastMessages()).thenReturn(lstmsg);

        assertEquals(mockDTO, resource.postMessage("Antonio"));
        assertTrue(resource.getRecentMessages().equals(lstmsg));

        verify(mockMessageService).createMessage("Antonio");
        verify(mockMessageService).createLastMessages();


    }


}
