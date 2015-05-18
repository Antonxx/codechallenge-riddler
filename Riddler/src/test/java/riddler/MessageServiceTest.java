package riddler;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author ori
 */
public class MessageServiceTest {

    @Test
    public void testGreet() {
        MessageDao dao = mock(MessageDao.class);
        
        MessageService svc = new MessageService(dao);
        Message msg = svc.greet("John");
        assertEquals("Hello John", msg.getContent());
    }
    
    @Test
    public void testGetRecentMessages() {
        MessageDao dao = mock(MessageDao.class);
        when(dao.getRecent(10)).thenReturn(new ArrayList<Message>());
        
        MessageService svc = new MessageService(dao);
        RecentMessagesResponse response = svc.getRecentMessages();
        assertEquals(0, response.getMessageCount());
    }
}
