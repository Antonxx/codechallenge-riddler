package riddler;

import java.sql.Timestamp;
import java.util.List;
import javax.inject.Singleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ori
 */
@Service
@Singleton
public class MessageService implements IMessageService {
    
    private MessageDao messageDao;

    @Autowired
    public MessageService(MessageDao messageDao) {
        this.messageDao = messageDao;
    }
    
    @Override
    public Message greet(String name) {
        Message msg = new Message("Hello " + name);
        messageDao.insert(msg);
        return msg;
    }

    @Override
    public RecentMessagesResponse getRecentMessages() {
        List<Message> messages = messageDao.getRecent(10);
        Timestamp lastMessage = messages.isEmpty() ? null : messages.get(0).getTimestamp();
        
        return new RecentMessagesResponse(messages, messages.size(), lastMessage);
    }
}
