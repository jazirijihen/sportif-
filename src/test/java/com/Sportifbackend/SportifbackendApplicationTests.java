package com.Sportifbackend;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.Sportifbackend.model.Product;
import com.Sportifbackend.repo.ProductRepository;
import com.Sportifbackend.repo.UserRepository;
import com.Sportifbackend.service.ProductService;
import com.Sportifbackend.service.UserService;

@SpringBootTest
class SportifbackendApplicationTests {
	@Autowired
	private UserService userservice;

	@Autowired
	private ProductService productservice;
	@MockBean
	private ProductRepository productrepo;
	@MockBean
	private UserRepository userrepo;

	@Test
	public void getProductsTest() {
		when(productrepo.findAll()).thenReturn(Stream
				.of(new Product("adidas", "blanc", 100),
						new Product("pull puma", "rouge", 200))
				.collect(Collectors.toList()));
		assertEquals(2, productservice.getProducts().size());
	}
	@Test
	public void addProduct() {
		Product product=new Product("adidas","rouge",100);
		productrepo.save(product);
	}
	@Test
	public void saveProductTest() {
		Product product = new Product ();
		product.setName("adidas");
		product.setDescription("rouge");
		product.setPrice(100);
		productrepo.save(product);
		//when(productrepo.save(product)).thenReturn(product);
	//	assertEquals(product, productservice.addProduct(product));
	}
}
