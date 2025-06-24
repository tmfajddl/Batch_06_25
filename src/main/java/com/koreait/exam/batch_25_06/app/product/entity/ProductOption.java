package com.koreait.exam.batch_25_06.app.product.entity;

import com.koreait.exam.batch_25_06.app.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SecondaryTable;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class ProductOption extends BaseEntity {
    private String color;
    private String size;
    private Integer price;

    private boolean isSoldOut;
    private int stockQuantity; // 수량

    @ManyToOne(fetch = LAZY)
    private Product product;


    public ProductOption(String color, String size) {
        this.color = color;
        this.size = size;
    }

}
