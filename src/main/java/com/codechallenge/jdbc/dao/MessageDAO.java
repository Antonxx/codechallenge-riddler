package com.codechallenge.jdbc.dao;

import javax.sql.DataSource;

import com.codechallenge.model.LastMessages;
import com.codechallenge.model.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.codechallenge.model.MessageTimestamp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class MessageDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MessageDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int save(MessageDTO message) {
        String query = "insert into messages (name) values(?)";
        Object[] args = new Object[]{message.getContent()};
        return jdbcTemplate.update(query, args);
    }

    public LastMessages getLastMessages() {
        String sqlSelect = "SELECT * FROM messages ORDER BY msg_timestamp DESC LIMIT 10";
        List<MessageTimestamp> listMessages = jdbcTemplate.query(sqlSelect, new RowMapper<MessageTimestamp>() {
            public MessageTimestamp mapRow(ResultSet resultSet, int i) throws SQLException {
                MessageTimestamp msg = new MessageTimestamp(resultSet.getString("name"), resultSet.getTimestamp("msg_timestamp"));
                return msg;
            }
        });
        return new LastMessages(listMessages);
    }

    public void setDataBaseSchema() {
        jdbcTemplate.execute("ALTER DATABASE docker SET datestyle TO \"ISO\";");
        jdbcTemplate.execute("CREATE TABLE messages (name VARCHAR(20) NOT NULL, msg_timestamp TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW());");
    }

    public void setTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
