package riddler;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.sql.Timestamp;

/**
 *
 * @author ori
 */
@JsonTypeInfo(use=Id.NAME, include=As.WRAPPER_OBJECT)
@JsonTypeName("message")
public class Message {
    private final String content;
    
    @JsonIgnore
    private final Timestamp timestamp;

    public Message(String content) {
        this(content, null);
    }
    
    public Message(String content, Timestamp timestamp) {
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getTimestamp() {
        return timestamp == null ? null : (Timestamp) timestamp.clone();
    }
}
