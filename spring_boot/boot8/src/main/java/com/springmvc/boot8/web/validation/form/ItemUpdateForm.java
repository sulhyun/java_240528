package com.springmvc.boot8.web.validation.form;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ItemUpdateForm {
	
	@NotNull
    private Long id;
	
	@NotBlank
	private String itemName;
	
    @NotNull
    @Range(min = 1000, max = 10000)
	private Integer price;
	
	@NotNull
	private Integer quantity;
	
}
