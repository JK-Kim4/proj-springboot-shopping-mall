package com.springboot.shoppingMall.member;

import com.springboot.shoppingMall.domain.product.entity.Product;
import com.springboot.shoppingMall.domain.product.entity.ProductRepository;
import com.springboot.shoppingMall.dto.ProductSaveDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTest {

    @Autowired
    ProductRepository repository;

    @After
    public void clear(){
        repository.deleteAll();
    }

    @Test
    public void product_save_test(){

        //given

        //by client
        ProductSaveDto dto = ProductSaveDto.builder()
                .name("test product")
                .company("test company")
                .price(3000)
                .build();

        //convert
        Product request = new Product(dto);

        repository.save(request);

        //when
        List<Product> productList =  repository.findAll();
        Product insertP = productList.get(0);


        //then
        assertThat(insertP.getName()).isEqualTo(dto.getName());
        assertThat(insertP.getCompany()).isEqualTo(dto.getCompany());


    }

    @Test
    public void product_update_test(){
        //given
        ProductSaveDto dto = ProductSaveDto.builder()
                .name("test product")
                .company("test company")
                .price(3000)
                .build();

        //convert
        Product request = new Product(dto);
        repository.save(request);

        //when
        List<Product> productList =  repository.findAll();
        Product insertP = productList.get(0);

        ProductSaveDto udtDto = ProductSaveDto.builder()
                .name("update product")
                .company("update company")
                .price(8000)
                .content("update content")
                .build();

        Product updateP = new Product(udtDto);

        int result = repository.updateProduct(updateP, insertP.getSeq());
        System.out.println("result = " + result);

        List<Product> productList2 =  repository.findAll();
        Product resultP = productList2.get(0);

        //then
        assertThat(resultP.getCompany()).isEqualTo(udtDto.getCompany());
        assertThat(resultP.getPrice()).isEqualTo(udtDto.getPrice());
        assertThat(resultP.getName()).isEqualTo(udtDto.getName());

        assertThat(request.getSeq()).isEqualTo(resultP.getSeq());

    }


}
