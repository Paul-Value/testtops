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
    private List<PlmNode> children = new ArrayList<>();

    public PlmNode(Long objectId, String name) {
        this.objectId = objectId;
        this.name = name;
    }

    public void addChild(PlmNode child) {
        children.add(child);
    }
}
