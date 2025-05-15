package com.example.testtops.model.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PlmNode {
    private Long objectId;
    private String name;
    private String oboznachenie;
    private String className;
    private List<PlmNode> children = new ArrayList<>();

    public PlmNode(Long objectId, String name, String oboznachenie, String className) {
        this.objectId = objectId;
        this.name = name;
        this.oboznachenie = oboznachenie;
        this.className = className;
    }

    public void addChild(PlmNode child) {
        children.add(child);
    }
}
