package com.brq.ms04.beans;

import com.brq.ms04.models.MessageInModel;
import com.brq.ms04.repositories.MessageInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageInBean {

    @Autowired
    private MessageInRepository repository;

    public MessageInModel save(String message){

        final var m = MessageInModel
                              .builder()
                              .message(message)
                              .build();

        return repository.save(m);
    }
}