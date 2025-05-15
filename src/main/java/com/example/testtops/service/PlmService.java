package com.example.testtops.service;

import com.example.testtops.model.Plm;
import com.example.testtops.model.PlmHierarchy;
import com.example.testtops.model.dto.PlmNode;
import com.example.testtops.repository.PlmHierarchyRepository;
import com.example.testtops.repository.PlmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlmService {
    @Autowired
    private PlmRepository plmRepository;

    @Autowired
    private PlmHierarchyRepository plmHierarchyRepository;

    public List<PlmNode> buildHierarchy() {
        List<Plm> allPlms = plmRepository.findAll();
        List<PlmHierarchy> hierarchies = plmHierarchyRepository.findAll();
        return buildTree(allPlms, hierarchies);
    }

    private List<PlmNode> buildTree(List<Plm> plmList, List<PlmHierarchy> hierarchies) {
        Map<Long, PlmNode> nodeMap = new HashMap<>();
        List<PlmNode> roots = new ArrayList<>();

        for (Plm plm : plmList) {
            PlmNode node = new PlmNode(plm.getObjectId(), plm.getName());
            nodeMap.put(plm.getObjectId(), node);
        }

        for (PlmHierarchy hierarchy : hierarchies) {
            PlmNode child = nodeMap.get(hierarchy.getObjectId());
            PlmNode parent = nodeMap.get(hierarchy.getParentId());

            if (parent != null) {
                parent.addChild(child);
            } else {
                roots.add(child);
            }
        }
        return roots;
    }
}
