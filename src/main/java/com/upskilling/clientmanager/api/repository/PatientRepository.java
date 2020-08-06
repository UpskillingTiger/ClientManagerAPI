package com.upskilling.clientmanager.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.upskilling.clientmanager.api.model.ClientModel;

@Component
public interface PatientRepository extends MongoRepository<ClientModel, String> {
}
