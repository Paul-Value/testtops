package com.example.testtops.repository;

import com.example.testtops.model.PlmHierarchy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlmHierarchyRepository extends JpaRepository<PlmHierarchy, Long> {
    List<PlmHierarchy> findByParentId(Long parentId);
}
