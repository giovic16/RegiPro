package com.regipro.backend.repository;

import com.regipro.backend.model.RegiProModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegiProRepository extends JpaRepository<RegiProModel, Long> {
    RegiProModel findByEmail(String email);
}
