package com.koreait.exam.batch_25_06.app.base;


import com.koreait.exam.batch_25_06.app.cart.Cartservice.CartService;
import com.koreait.exam.batch_25_06.app.member.entity.Member;
import com.koreait.exam.batch_25_06.app.member.service.MemberService;
import com.koreait.exam.batch_25_06.app.product.entity.Product;
import com.koreait.exam.batch_25_06.app.product.entity.ProductOption;
import com.koreait.exam.batch_25_06.app.product.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("dev")
public class DevInitData {


    @Bean
    public CommandLineRunner initData(MemberService memberService, ProductService productService, CartService cartService) {
        return args -> {
            String password = "{noop}1234";
            Member member2 = memberService.join("user2",password,"user2@test.com");
            Member member3 = memberService.join("user3",password,"user3@test.com");
            Member member4 = memberService.join("user4",password,"user4@test.com");

            Product product1 = productService.create("반팔1", 55000, "DDL-1",
                    Arrays.asList(
                            new ProductOption("RED","95"),
                            new ProductOption("RED","100"),
                            new ProductOption("BLLUE","95"),
                            new ProductOption("BLLUE","100")
                            )
                    );
            Product product2 = productService.create("셔츠1", 35000, "DDL-2",
                    Arrays.asList(
                            new ProductOption("WHITE","95"),
                            new ProductOption("WHITE","100"),
                            new ProductOption("BLACK","95"),
                            new ProductOption("BLACK","100")
                            )

                    );

            ProductOption productOption__RED_95 = product1.getProductOptions().get(0);
            ProductOption productOption__BLUE_95 = product1.getProductOptions().get(2);

            cartService.addItem(member2, productOption__RED_95,1);
            cartService.addItem(member2, productOption__RED_95,2);
            cartService.addItem(member2, productOption__BLUE_95,1);

        };
    }

}