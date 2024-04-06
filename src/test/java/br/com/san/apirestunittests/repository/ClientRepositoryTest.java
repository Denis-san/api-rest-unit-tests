package br.com.san.apirestunittests.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.san.apirestunittests.domain.Client;
import br.com.san.apirestunittests.domain.enums.ClientType;

@DataJpaTest
@TestInstance(Lifecycle.PER_CLASS)
class ClientRepositoryTest {
	
	Client cli1;
	
	@Autowired
	private ClientRepository repository;

	@BeforeAll
	public void setup() {
		cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.PHYSICAL_PERSON);
	}
	
	@Test
	void givenClientEmail_whenFindByEmail_thenReturnClientObject() {
		// Given / Arrange
		String email = "maria@gmail.com";
		
		// When / Act
		Client clientFromDb = repository.findByEmail(email); 

		// Then / Assert
		assertNotNull(clientFromDb);
		assertEquals(cli1.getCpfOrCnpj(), clientFromDb.getCpfOrCnpj());
	}

}
