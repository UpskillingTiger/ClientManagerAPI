package com.upskilling.clientmanager.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.upskilling.clientmanager.api.model.CaseModel;

@Component
public interface CaseRepository extends MongoRepository<CaseModel, String> {
	List<CaseModel> findByCaseNumber(String CaseNumber);
}
