package com.codechallenge.test;

import com.codechallenge.jdbc.dao.MessageDAO;
import com.codechallenge.model.MessageDTO;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;


public class MessageDAOTest {

    @Test
    public void checkSaveMessage() {
        DataSource mockDataSource = mock(DataSource.class);
        MessageDTO mockDTO = mock(MessageDTO.class);
        MessageDAO mDAO = new MessageDAO(mockDataSource);

        JdbcTemplate mockJdbc = mock(JdbcTemplate.class);
        mDAO.setTemplate(mockJdbc);

        assertEquals(0, mDAO.save(mockDTO));

    }
}
