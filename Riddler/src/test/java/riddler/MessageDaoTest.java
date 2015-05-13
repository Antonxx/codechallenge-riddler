package riddler;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ori
 */
public class MessageDaoTest {
    
    @Test
    public void testCreateTable() {
        new MessageDao().createTable();
    }
    
    @Test
    public void testGetRecentMessages_empty() {
        MessageDao dao = new MessageDao();
        dao.createTable();
        List<Message> messages = dao.getRecent(10);
        assertTrue(messages.isEmpty());
    }
    
    @Test
    public void testGetRecentMessages() {
        MessageDao dao = new MessageDao();
        dao.createTable();
        dao.insert(new Message("test"));
        
        List<Message> messages = dao.getRecent(10);
        assertEquals(1, messages.size());
        assertEquals("test", messages.get(0).getContent());
    }
}
