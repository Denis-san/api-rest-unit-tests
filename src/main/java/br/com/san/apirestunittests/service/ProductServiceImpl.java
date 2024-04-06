package br.com.san.apirestunittests.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.san.apirestunittests.domain.Category;
import br.com.san.apirestunittests.domain.Product;
import br.com.san.apirestunittests.repository.CategoryRepository;
import br.com.san.apirestunittests.repository.ProductRepository;
import br.com.san.apirestunittests.service.exceptions.ObjectNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Product findById(Integer id) {
		Optional<Product> optProduct = repository.findById(id);
		return optProduct.orElseThrow(
				() -> new ObjectNotFoundException("Object not found! id: " + id + ", Type: " + Product.class.getName()));

	}

	@Override
	public Page<Product> search(String name, List<Integer> ids, Integer page, Integer linesPerPages, String orderBy,
			String direction) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPages, Direction.valueOf(direction), orderBy);
		
		List<Category> categories = categoryRepository.findAllById(ids);
		
		return repository.search(name, categories, pageRequest);
	}
	
	

}
