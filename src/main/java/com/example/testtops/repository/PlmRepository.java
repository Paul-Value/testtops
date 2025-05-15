package com.example.testtops.repository;

import com.example.testtops.model.Plm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlmRepository extends JpaRepository<Plm, Long> {
    List<Plm> findByClassId(Long classId);
}
