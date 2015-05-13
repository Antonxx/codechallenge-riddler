package riddler;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

/**
 *
 * @author ori
 */
public class MessageResourceTest {
    
    @Test
    public void testGreet() {
        IMessageService service = mock(IMessageService.class);
        when(service.greet("John")).thenReturn(new Message("Hello John"));
        
        MessageResource res = new MessageResource(service);
        Message msg = res.greet("John");
        assertEquals("Hello John", msg.getContent());
    }
    
    @Test
    public void testGetRecentMessages() {
        IMessageService service = mock(IMessageService.class);
        when(service.getRecentMessages()).thenReturn(new RecentMessagesResponse(null, 0, null));
        
        MessageResource resource = new MessageResource(service);
        RecentMessagesResponse response = resource.getRecentMessages();
        assertEquals(0, response.getMessageCount());
    } 
}
