package com.upskilling.clientmanager.api.service;

import java.util.ArrayList;
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
import com.upskilling.clientmanager.api.bean.ClientsWrapper;
import com.upskilling.clientmanager.api.model.ClientModel;
import com.upskilling.clientmanager.api.repository.ClientRepository;

@RestController
@RequestMapping("/api")
public class CaseService {
	@Autowired
	private ClientRepository clientRepository;

	@PostMapping("/case")
	public ResponseEntity<HttpStatus> createClient(@RequestBody Client client) {
		System.out.println("client is .." + client);
		ClientModel clientModel = new ClientModel();
		BeanUtils.copyProperties(client, clientModel);
		clientModel.setStatus(true);
		clientRepository.save(clientModel);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/case")
	public ResponseEntity<HttpStatus> modifyClient(@RequestBody ClientsWrapper clientsWrapper) {

		for (Client client : clientsWrapper.getClients()) {
			Optional<ClientModel> clientModelData = clientRepository.findById(client.getId());
			if (clientModelData.isPresent()) {
				ClientModel clientModel = clientModelData.get();
				clientModel.setStatus(client.getStatus());
				clientRepository.save(clientModel);
			} else {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<>(HttpStatus.OK);

	}

	@GetMapping("/case")
	public ResponseEntity<ClientsWrapper> getClient() {

		ClientsWrapper clientsWrapper = new ClientsWrapper();
		List<Client> clients = new ArrayList<Client>();

		List<ClientModel> allClientModels = clientRepository.findAll();
		for (ClientModel clientModel : allClientModels) {
			Client client = new Client();
			BeanUtils.copyProperties(clientModel, client);
			clients.add(client);
		}

		clientsWrapper.setClients(clients);

		return new ResponseEntity<>(clientsWrapper, HttpStatus.OK);

	}

}