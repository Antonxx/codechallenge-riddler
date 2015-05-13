package riddler;

/**
 *
 * @author ori
 */
public interface IMessageService {

    Message greet(String name);
    
    RecentMessagesResponse getRecentMessages();
}
