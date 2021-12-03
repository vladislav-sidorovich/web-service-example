package org.example.services;

import org.example.dao.MessagesDao;
import org.example.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesService {
    @Autowired
    private MessagesDao messagesDao;

    public List<Message> allMessages() {
        return messagesDao.findAll();
    }

    public long addMessage(Message message) {
        messagesDao.save(message);
        long count = messagesDao.count();
        return count;
    }
}
