package com.codechallenge.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.sql.Timestamp;

public class LastMessages {

    private int messageCount;
    private String lastMessage;
    private List<MessageDTO> messages;

    public LastMessages(List<MessageTimestamp> msgs) {
        this.messages = new ArrayList<MessageDTO>();
        ArrayList<Timestamp> arraytime = new ArrayList<Timestamp>();
        for (MessageTimestamp m : msgs) {
            messages.add(new MessageDTO(m.getContent()));
            arraytime.add(m.getTime());
        }
        this.messageCount = messages.size();
        this.lastMessage = Collections.max(arraytime).toString();
    }

    public int getMessageCount() {
        return messageCount;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public List<MessageDTO> getMessages() {
        return messages;
    }


}
