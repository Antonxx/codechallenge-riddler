package riddler;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author ori
 */
public class RecentMessagesResponse {
    
    private final int messageCount;
    private final Timestamp lastMessage;
    private final Collection<Message> messages;

    public RecentMessagesResponse(Collection<Message> messages, int messageCount, Timestamp lastMessage) {
        this.messageCount = messageCount;
        this.messages = messages;
        this.lastMessage = lastMessage;
    }

    public int getMessageCount() {
        return messageCount;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    public Timestamp getLastMessage() {
        return lastMessage == null ? null : (Timestamp) lastMessage.clone();
    }

    public Collection<Message> getMessages() {
        return Collections.unmodifiableCollection(messages);
    }
}
