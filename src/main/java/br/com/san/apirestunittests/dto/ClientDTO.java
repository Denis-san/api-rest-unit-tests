package br.com.san.apirestunittests.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import br.com.san.apirestunittests.domain.Client;
import br.com.san.apirestunittests.service.validation.ClientUpdate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@ClientUpdate
public class ClientDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty
	@Length(min = 5, max = 120)
	private String name;

	@NotEmpty
	@Email
	private String email;

	public ClientDTO() {

	}

	public ClientDTO(Client client) {
		id = client.getId();
		name = client.getName();
		email = client.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Client toClient() {
		return new Client(id, name, email, null, null);
	}

}
