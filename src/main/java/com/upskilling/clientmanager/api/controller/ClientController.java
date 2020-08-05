package com.upskilling.clientmanager.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upskilling.clientmanager.api.bean.Client;
import com.upskilling.clientmanager.api.bean.ClientConfiguration;
import com.upskilling.clientmanager.api.bean.ClientConfigurationWrapper;
import com.upskilling.clientmanager.api.model.ClientModel;
import com.upskilling.clientmanager.api.repository.ClientRepository;

@RestController
@RequestMapping("/api")
public class ClientController {
	@Autowired
	private ClientRepository clientRepository;

	@PostMapping("/client")
	public ResponseEntity<HttpStatus> createClient(@RequestBody Client client) {
		System.out.println("client is .." + client);
		ClientModel clientModel = new ClientModel();
		BeanUtils.copyProperties(client, clientModel);
		clientModel.setStatus(true);
		clientRepository.save(clientModel);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/client")
	public ResponseEntity<HttpStatus> modifyClient(@RequestBody ClientConfigurationWrapper clientConfigurationWrapper) {

		for (ClientConfiguration clientConfiguration : clientConfigurationWrapper.getClientConfigurations()) {
			Optional<ClientModel> clientModelData = clientRepository.findById(clientConfiguration.getId());
			if (clientModelData.isPresent()) {
				ClientModel clientModel = clientModelData.get();
				clientModel.setStatus(clientConfiguration.getStatus());
				clientRepository.save(clientModel);
			} else {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<>(HttpStatus.OK);

	}

	@GetMapping("/client")
	public ResponseEntity<List<ClientModel>> getClient() {

		List<ClientModel> allClients = clientRepository.findAll();

		return new ResponseEntity<>(allClients, HttpStatus.OK);

	}

}