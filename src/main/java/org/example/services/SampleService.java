package org.example.services;

import org.example.dao.StringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SampleService {
    @Autowired
    private StringRepository stringRepository;

    public Map<String, Object> randomMap(String varName) {
        stringRepository.save(varName);
        List<String> all = stringRepository.findAll();

        return Map.of(
                "newString", varName,
                "allKnown", all
        );
    }
}
