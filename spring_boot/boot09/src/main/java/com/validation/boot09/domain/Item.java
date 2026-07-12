package com.validation.boot09.domain;

import lombok.Data;

@Data
public class Item {
	// @NotNull(groups = UpdateCheck.class)
    private Long id;				// 상품 ID
    
    // @NotBlank(groups = {SaveCheck.class, UpdateCheck.class})
    private String itemName;		// 상품명
    
    // @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
    // @Range(min = 1000, max = 1000000, groups = {SaveCheck.class, UpdateCheck.class})
    private Integer price;			// 가격
    
    // @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
    // @Max(value = 9999, groups = SaveCheck.class)
    private Integer quantity;		// 수량

    public Item() {}

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    
}
