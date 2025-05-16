package com.example.testtops.service;

import com.example.testtops.model.dto.PlmNode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlmService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<PlmNode> getHierarchy() {
        String sql = "SELECT get_plm_hierarchy() AS result";
        String jsonResult = jdbcTemplate.queryForObject(sql, String.class);
        return parceJsonToDto(jsonResult);
    }

    private List<PlmNode> parceJsonToDto(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, new TypeReference<List<PlmNode>>() {
            });
        } catch (Exception e) {
            throw new RuntimeException("Ошибка парсинга JSON", e);
        }
    }
}
