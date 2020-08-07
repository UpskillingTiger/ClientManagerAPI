package com.upskilling.clientmanager.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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
import com.upskilling.clientmanager.api.model.CaseModel;
import com.upskilling.clientmanager.api.repository.CaseRepository;

@RestController
@RequestMapping("/api")
public class CaseService {
	@Autowired
	private CaseRepository caseRepository;
	@Autowired
	private ClientService clientService;

	private String vendorData;

	@PostMapping("/case")
	public ResponseEntity<HttpStatus> receiveCase(@RequestBody CaseModel caseModel) {
		System.out.println("Incoming case payload is ... " + caseModel);

		List<CaseModel> foundCaseModel = caseRepository.findByCaseNumber(caseModel.getCaseNumber());

		if (!CollectionUtils.isEmpty(foundCaseModel)) {
			caseModel.setId(foundCaseModel.get(0).getId());
		}

		caseRepository.save(caseModel);
		send(caseModel);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/case")
	public ResponseEntity<ClientsWrapper> deleteClient() {

		caseRepository.deleteAll();

		return new ResponseEntity<>(HttpStatus.OK);

	}

	@GetMapping("/case")
	public ResponseEntity<List<CaseModel>> getClient() {

		List<CaseModel> allClientModels = caseRepository.findAll();
		return new ResponseEntity<>(allClientModels, HttpStatus.OK);

	}

	private void send(CaseModel caseModel) {
		List<Client> clients = clientService.getClient().getBody().getClients();
		if (!CollectionUtils.isEmpty(clients)) {
			for (Client client : clients) {
				if (client.getCaseSelection()) {
					List<String> products = client.getProducts();
					if (!CollectionUtils.isEmpty(products)) {
						if (products.contains(caseModel.getProduct())) {
							RestTemplate restTemplate = new RestTemplate();
							ResponseEntity<String> respEntity = restTemplate.postForEntity(client.getUrl(), caseModel,
									String.class);
							HttpStatus body = respEntity.getStatusCode();
							System.out.println(" Response after sent ..." + body);
						}

					}
				}
			}
		}
	}

	@PostMapping("/vendor1")
	public ResponseEntity<HttpStatus> postData(HttpEntity<String> httpEntity) {
		vendorData = httpEntity.getBody();
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/vendor1")
	public String getData() {
		return vendorData;
	}

}