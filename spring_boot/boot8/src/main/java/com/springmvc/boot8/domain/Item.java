package com.springmvc.boot8.domain;

import java.util.List;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Item {
	// @NotNull(groups = UpdateCheck.class)
    private Long id;				// 상품 ID
    
    // @NotBlank(groups = {SaveCheck.class, UpdateCheck.class})
    private String itemName;		// 상품명
    
    // @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
    // @Range(min = 1000, max = 10000, groups = {SaveCheck.class, UpdateCheck.class})
    private Integer price;			// 가격
    
    // @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
    // @Max(value = 9999, groups = SaveCheck.class)
    private Integer quantity;		// 수량
    
    private Boolean open;			// 판매 여부
    private List<String> regions;	// 등록 지역
    private ItemType itemType;		// 상품 종류
    private String deliveryCode;	// 배송 방식

    public Item() {}

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    
}
