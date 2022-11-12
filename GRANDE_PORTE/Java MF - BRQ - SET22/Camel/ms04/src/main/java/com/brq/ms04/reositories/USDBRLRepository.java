package com.brq.ms04.reositories;

import com.brq.ms04.models.USDBRLModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface USDBRLRepository extends JpaRepository<USDBRLModel, Integer> {
}
