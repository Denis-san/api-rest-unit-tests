package br.com.san.apirestunittests.service;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.san.apirestunittests.domain.Category;

public interface CategoryService {

	public Category findById(Integer id);

	public Category insert(Category category);

	public Category update(Category category);

	public void delete(Integer id);

	public List<Category> findAll();

	public Page<Category> findPage(Integer page, Integer linesPerPages, String orderBy, String direction);
	
}
