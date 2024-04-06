package br.com.san.apirestunittests.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.san.apirestunittests.domain.Product;
import br.com.san.apirestunittests.dto.ProductDTO;
import br.com.san.apirestunittests.resource.util.URL;
import br.com.san.apirestunittests.service.ProductService;
import br.com.san.apirestunittests.service.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping("/products")
public class ProductResource {

	@Autowired
	private ProductService productService;

	@GetMapping("/{id}")
	public ResponseEntity<Product> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Product tempProduct = productService.findById(id);
		return ResponseEntity.ok().body(tempProduct);
	}

	@GetMapping("/")
	public ResponseEntity<Page<ProductDTO>> findPage(@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "categories", defaultValue = "") String categories,
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "linesPerPage", defaultValue = "24") Integer linesPerPages,
			@RequestParam(name = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(name = "direction", defaultValue = "ASC") String direction) {

		List<Integer> ids = URL.covertToList(categories);
		String nomeDecoded = URL.decodeParam(name);

		Page<Product> list = productService.search(nomeDecoded, ids, page, linesPerPages, orderBy, direction);

		Page<ProductDTO> listDto = list.map(e -> new ProductDTO(e));
		return ResponseEntity.ok().body(listDto);
	}

}
