package com.brq.ms04.repositories;

import com.brq.ms04.models.MessageInModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageInRepository
        extends JpaRepository<MessageInModel, Integer> {
}