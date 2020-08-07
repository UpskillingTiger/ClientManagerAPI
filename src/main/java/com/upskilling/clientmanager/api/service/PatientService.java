package com.upskilling.clientmanager.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.upskilling.clientmanager.api.bean.Client;
import com.upskilling.clientmanager.api.bean.ClientsWrapper;
import com.upskilling.clientmanager.api.model.PatientModel;
import com.upskilling.clientmanager.api.repository.PatientRepository;

@RestController
@RequestMapping("/api")
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private ClientService clientService;

	@PostMapping("/patient")
	public ResponseEntity<HttpStatus> receivePatient(@RequestBody PatientModel patientModel) {
		System.out.println("patientInfo is .." + patientModel);

		List<PatientModel> foundPatientModel = patientRepository.findByContactId(patientModel.getContactId());

		if (!CollectionUtils.isEmpty(foundPatientModel)) {
			patientModel.setId(foundPatientModel.get(0).getId());
		}

		patientRepository.save(patientModel);
		send(patientModel);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/patient")
	public ResponseEntity<ClientsWrapper> deleteClient() {

		patientRepository.deleteAll();

		return new ResponseEntity<>(HttpStatus.OK);

	}

	@GetMapping("/patient")
	public ResponseEntity<List<PatientModel>> getClient() {

		List<PatientModel> allClientModels = patientRepository.findAll();
		return new ResponseEntity<>(allClientModels, HttpStatus.OK);

	}

	private void send(PatientModel patientModel) {
		List<Client> clients = clientService.getClient().getBody().getClients();
		if (!CollectionUtils.isEmpty(clients)) {
			for (Client client : clients) {
				if (client.getPatientSelection()) {
					RestTemplate restTemplate = new RestTemplate();
					ResponseEntity<String> respEntity = restTemplate.postForEntity(client.getUrl(), patientModel,
							String.class);
					HttpStatus body = respEntity.getStatusCode();
					System.out.println(" Response after patientModel sent ..." + body);
				}

			}
		}

	}

}