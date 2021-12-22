//package com.springboot.shoppingMall.web;
//
//import com.springboot.shoppingMall.domain.products.domain.ProductRepository;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.context.WebApplicationContext;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class ProductApiControllerTest {
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private ProductRepository productsRepository;
//
//    @Autowired
//    private WebApplicationContext context;
//
//    private MockMvc mvc;
//
////    @Before
////    public void setup(){
////        mvc = MockMvcBuilders
////                .webAppContextSetup(context)
////                .apply(springSecurity())
////                .build();
////    }
////
////    @After
////    public void tearDown() throws Exception{
////        productsRepository.deleteAll();
////    }
//
////    @Test
////    @WithMockUser(roles = "USER")
////    public void Products_save() throws Exception{
////        //given
////        String name = "test name";
////        String seller = "test seller";
////        String filePath = "";
////        String desc = "test desc";
////
////        ProductSaveReuestDto requestDto = ProductSaveReuestDto.builder()
////                .name(name)
////                .filePath(filePath)
////                .seller(seller)
////                .build();
////
////        String url = "http://localhost:" + port + "/api/product/insert";
////
////        //when
////        mvc.perform(
////                post(url)
////                .contentType(MediaType.APPLICATION_JSON_UTF8)
////                .content(new ObjectMapper().writeValueAsString(requestDto)))
////                .andExpect(status().isOk());
////
////        //then
////        List<Product> all = productsRepository.findAll();
////
////        assertThat(all.get(0).getName()).isEqualTo("test name");
////
////    }
////
////    @Test
////    @WithMockUser(roles = "USER")
////    public void Products_update() throws Exception{
////        //given
////        Product savedProd = productsRepository.save(
////                Product.builder()
////                        .name("test1")
////                        .filePath("")
////                        .build());
////
////        Long updateId = savedProd.getId();
////        String expectedName = "update name";
////
////        ProductUpdateRequestDto requestDto = ProductUpdateRequestDto.builder()
////                .name(expectedName)
////                .build();
////
////        String url = "http://localhost:" + port + "/api/product/update/" +updateId;
////
////        HttpEntity<ProductUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);
////
////        //when
////        mvc.perform(put(url)
////                .contentType(MediaType.APPLICATION_JSON_UTF8)
////                .content(new ObjectMapper().writeValueAsString(requestDto)))
////                .andExpect(status().isOk());
////
////        //then
////        List<Product> all = productsRepository.findAll();
////        assertThat(all.get(0).getName()).isEqualTo("update name");
////    }
//
//}
