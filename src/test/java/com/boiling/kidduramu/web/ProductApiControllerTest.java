package com.boiling.kidduramu.web;

import com.boiling.kidduramu.domain.products.domain.Products;
import com.boiling.kidduramu.domain.products.domain.ProductsRepository;
import com.boiling.kidduramu.domain.products.domain.ProductSaveReuestDto;
import com.boiling.kidduramu.domain.products.domain.ProductUpdateRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup(){
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @After
    public void tearDown() throws Exception{
        productsRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles = "USER")
    public void Products_save() throws Exception{
        //given
        String name = "test name";
        String seller = "test seller";
        String fileUrl = "";
        String desc = "test desc";

        ProductSaveReuestDto requestDto = ProductSaveReuestDto.builder()
                .name(name)
                .desc(desc)
                .fileUrl(fileUrl)
                .seller(seller)
                .build();

        String url = "http://localhost:" + port + "/api/product/insert";

        //when
        mvc.perform(
                post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Products> all = productsRepository.findAll();

        assertThat(all.get(0).getName()).isEqualTo("test name");
        assertThat(all.get(0).getSeller()).isEqualTo("test seller");

    }

    @Test
    @WithMockUser(roles = "USER")
    public void Products_update() throws Exception{
        //given
        Products savedProd = productsRepository.save(
                Products.builder()
                        .name("test1")
                        .desc("test1")
                        .fileUrl("")
                        .seller("test1")
                        .build());

        Long updateId = savedProd.getId();
        String expectedName = "update name";
        String expectedDesc = "update desc";

        ProductUpdateRequestDto requestDto = ProductUpdateRequestDto.builder()
                .name(expectedName)
                .desc(expectedDesc)
                .build();

        String url = "http://localhost:" + port + "/api/product/update/" +updateId;

        HttpEntity<ProductUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        mvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Products> all = productsRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo("update name");
        assertThat(all.get(0).getDesc()).isEqualTo("update desc");
    }

}
