package riddler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.postgresql.Driver;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;

/**
 *
 * @author ori
 */
@Service
public class MessageDao {
        
    private final JdbcTemplate template;
    
    public MessageDao() {
        DataSource ds = new SimpleDriverDataSource(
                new Driver(), "jdbc:postgresql://localhost:5432/riddler", "riddleguy", "riddle");
        template = new JdbcTemplate(ds);
    }
    
    public void createTable() {
        template.execute("DROP TABLE IF EXISTS messages;"
                       + "CREATE TABLE messages ("
                         + "id SERIAL,"
                         + "content VARCHAR,"
                         + "timestamp TIMESTAMP DEFAULT now());");
    }
    
    public void insert(Message message) {
        template.update("INSERT INTO Messages (Content) VALUES (?)",
                new Object[] { message.getContent() });
    }
    
    public List<Message> getRecent(int maxAmount) {
        return template.query("SELECT content, timestamp FROM messages"
                    + " ORDER BY timestamp DESC"
                    + " LIMIT ?", new Object[]{ maxAmount },
                new MessageRowMapper());
    }

    private class MessageRowMapper implements RowMapper<Message> {

        @Override
        public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Message(rs.getString("content"), rs.getTimestamp("timestamp"));
        }
    }
}
