package org.example.services;

import org.example.dao.MessagesDao;
import org.example.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesService {
    @Autowired
    private MessagesDao messagesDao;

    @Cacheable(cacheNames = "messages")
    public List<Message> allMessages() {
        return messagesDao.findAll();
    }

    @Cacheable(cacheNames = "messagesByText")
    public List<Message> findMessageContains(String text) {
        ////
        return null;
    }

    @CacheEvict(cacheNames = {"messages", "messagesByText"}, allEntries = true)
    public long addMessage(Message message) {
        messagesDao.save(message);
        long count = messagesDao.count();
        return count;
    }
}