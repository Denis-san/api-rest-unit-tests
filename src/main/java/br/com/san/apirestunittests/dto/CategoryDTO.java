package br.com.san.apirestunittests.dto;


import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import br.com.san.apirestunittests.domain.Category;
import jakarta.validation.constraints.NotEmpty;

public class CategoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty
	@Length(min = 5, max = 80)
	private String name;

	public CategoryDTO() {

	}

	public CategoryDTO(Category category) {
		id = category.getId();
		name = category.getName();
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
	
	public Category toCategory() {
		return new Category(id, name);
	}

}
