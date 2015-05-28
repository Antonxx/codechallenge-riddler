package com.codechallenge.rest.service;


import com.codechallenge.model.MessageDTO;

public class MessageService {

    public MessageDTO createMessage(String name) {
        MessageDTO message = new MessageDTO();
        name = "Hello " + name;
        message.setContent(name);
        return message;
    }


}
