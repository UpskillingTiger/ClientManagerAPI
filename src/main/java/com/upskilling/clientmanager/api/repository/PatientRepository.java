package com.upskilling.clientmanager.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.upskilling.clientmanager.api.model.PatientModel;

@Component
public interface PatientRepository extends MongoRepository<PatientModel, String> {

	List<PatientModel> findByContactId(String contactId);
}
