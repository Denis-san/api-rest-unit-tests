package br.com.san.apirestunittests.service;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.san.apirestunittests.domain.Client;

public interface ClientService {

	public Client findById(Integer id);

	public Client update(Client client);

	public void delete(Integer id);

	public List<Client> findAll();

	public Page<Client> findPage(Integer page, Integer linesPerPages, String orderBy, String direction);

	public Client insert(Client client);
	
}
