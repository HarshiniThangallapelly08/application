package com.vm.HGenAI.repository;

import com.vm.HGenAI.model.FNOL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FNOLRepository extends JpaRepository<FNOL, Long> {
}