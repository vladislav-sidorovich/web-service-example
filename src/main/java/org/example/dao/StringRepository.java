package org.example.dao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StringRepository {
    private final List<String> db = new ArrayList<>();

    public void save(String str) {
        db.add(str);
    }

    public List<String> findAll() {
        return List.copyOf(db);
    }
}
