package com.springmvc.boot05.basic;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
@RequiredArgsConstructor
public class Data {

	private String username;
	private int age;
	
}
