package riddler;

import javax.inject.Singleton;
import org.springframework.stereotype.Service;

/**
 *
 * @author ori
 */
@Service
@Singleton
public class MessageService implements IMessageService {
    
    @Override
    public MessageResponse getGreeting(String name) {
        return new MessageResponse(new Message("Hello " + name));
    }
}
