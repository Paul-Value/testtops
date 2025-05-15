package com.example.testtops.service;

import com.example.testtops.model.Classes;
import com.example.testtops.model.Plm;
import com.example.testtops.model.PlmHierarchy;
import com.example.testtops.model.dto.PlmNode;
import com.example.testtops.repository.ClassesRepository;
import com.example.testtops.repository.PlmHierarchyRepository;
import com.example.testtops.repository.PlmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PlmService {
    @Autowired
    private PlmRepository plmRepository;

    @Autowired
    private PlmHierarchyRepository plmHierarchyRepository;

    @Autowired
    private ClassesRepository classesRepository;

    public List<PlmNode> buildHierarchy() {
        List<Plm> allPlms = plmRepository.findAll();
        List<PlmHierarchy> hierarchies = plmHierarchyRepository.findAll();
        Map<Long, Classes> classesMap = classesRepository.findAll().stream()
                .collect(Collectors.toMap(Classes::getPk, classes -> classes));
        return buildTree(allPlms, hierarchies, classesMap);
    }

    private List<PlmNode> buildTree(List<Plm> plmList, List<PlmHierarchy> hierarchies, Map<Long, Classes> classesMap) {
        Map<Long, PlmNode> nodeMap = new HashMap<>();
        List<PlmNode> roots = new ArrayList<>();

        for (Plm plm : plmList) {
            Classes cls = classesMap.get(plm.getClassId());
            String clsName = (cls != null) ? cls.getName() : "N/A";
            PlmNode node = new PlmNode(plm.getObjectId(), plm.getName(), plm.getOboznachenie(), clsName);
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
