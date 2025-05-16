package com.example.testtops.controller;

import com.example.testtops.model.dto.PlmNode;
import com.example.testtops.service.PlmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plmData")
public class PlmController {
    @Autowired
    private PlmService plmService;

    @GetMapping
    public ResponseEntity<List<PlmNode>> getPlmData() {
        List<PlmNode> result = plmService.getHierarchy();
        return ResponseEntity.ok(result);
    }
}
