package org.example.dao;

import org.example.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MessagesDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Message message) {
        entityManager.persist(message);
    }

    @Transactional(readOnly = true)
    public List<Message> findAll() {
        List<Message> list = entityManager
                .createQuery("select m from Message m", Message.class)
                .getResultList();
        return list;
    }

    @Transactional(readOnly = true)
    public long count() {
        Long count = entityManager
                .createQuery("select count(m) from Message m", Long.class)
                .getSingleResult();
        return count;
    }
}
