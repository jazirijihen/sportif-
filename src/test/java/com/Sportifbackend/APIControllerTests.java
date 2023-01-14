package com.Sportifbackend;

import static org.junit.jupiter.api.Assertions.*;



import com.Sportifbackend.repo.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;
import com.Sportifbackend.model.Product;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import com.Sportifbackend.repo.ProductRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

class APIControllerTests {

    @Autowired
    private MockMvc mockMvc; 
    
    @Autowired
    private ProductRepository repo;
    
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup(){
        repo.deleteAll();
    }
    
  /*  @Test
    public void givenListOfProducts_whenGetAllProducts_thenReturnProductsList() throws Exception{
        List<Product> listOfProducts = new ArrayList<>();
        listOfProducts.add(Product.builder().name("bag").description("good").price(52).build());
        listOfProducts.add(Product.builder().name("dress").description("red").price(58).build());
        System.out.print(listOfProducts);
        repo.saveAll(listOfProducts);
        ResultActions response = mockMvc.perform(get("/api/products"));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(listOfProducts.size())));

    }*/

    @Test
    public void givenProductId_whenDeleteProduct_thenReturn200() throws Exception{
        Product product= new Product();
        product.setName("table");
        product.setDescription("test");
        product.setPrice(200);
        repo.save(product);

        ResultActions response = mockMvc.perform(delete("/api/products/{id}", product.getId()));

        response.andExpect(status().isOk())
                .andDo(print());
    }

    
}