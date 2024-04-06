package br.com.san.apirestunittests.service.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.san.apirestunittests.domain.enums.ClientType;
import br.com.san.apirestunittests.dto.NewClientDTO;
import br.com.san.apirestunittests.repository.ClientRepository;
import br.com.san.apirestunittests.resource.exceptions.FieldMessage;
import br.com.san.apirestunittests.service.validation.util.BR;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, NewClientDTO> {
	
	@Autowired
	private ClientRepository repository;

	@Override
	public void initialize(ClientInsert ann) {
	}

	@Override
	public boolean isValid(NewClientDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		if (objDto.getClientType().equals(ClientType.PHYSICAL_PERSON.getCode()) && !BR.isValidCPF(objDto.getCpfOrCnpj())) {
			list.add(new FieldMessage("cpfOrCnpj", "Invalid CPF"));
		}
		
		if (objDto.getClientType().equals(ClientType.LEGAL_PERSON.getCode()) && !BR.isValidCNPJ(objDto.getCpfOrCnpj())) {
			list.add(new FieldMessage("cpfOrCnpj", "Invalid CNPJ"));
		}
		
		
		if(repository.findByEmail(objDto.getEmail()) != null) {
			list.add(new FieldMessage("email", "Email already exists"));
		}
		

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getField())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}