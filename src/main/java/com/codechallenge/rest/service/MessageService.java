package com.codechallenge.rest.service;


import com.codechallenge.jdbc.dao.MessageDAO;
import com.codechallenge.model.LastMessages;
import com.codechallenge.model.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageService {

    private MessageDAO messageDAO;

    @Autowired
    public MessageService(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
        this.messageDAO.setDataBaseSchema();
    }

    public MessageDTO createMessage(String name) {
        MessageDTO message = new MessageDTO("Hello " + name);
        messageDAO.save(message);
        return message;
    }

    public LastMessages createLastMessages() {
        return messageDAO.getLastMessages();
    }
}
