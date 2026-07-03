package com.thymeleaf.boot7.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Data;

@Controller
@RequestMapping("/basic")
public class BasicController {

	@GetMapping("/text-basic")
	public String textBasic(Model model) {
		model.addAttribute("data", "<b>Hello Spring!</b>");
		return "basic/text-basic";
	}
	
	@GetMapping("/utext-basic")
	public String utextBasic(Model model) {
		model.addAttribute("data", "<b>Hello Spring!</b>");
		return "basic/utext-basic";
	}
	
	@GetMapping("/variable")
	public String variable(Model model) { 
		User userA = new User("userA", 10);
		User userB = new User("userA", 20);
		
		List<User> list = new ArrayList<>();
		list.add(userA);
		list.add(userB);
		
		Map<String, User> map = new HashMap<>();
		map.put("userA", userA);
		map.put("userB", userB);
		
		model.addAttribute("user", userA);
		model.addAttribute("list", list);
		model.addAttribute("map", map);
		
		return "basic/variable";
	}
	
	@Data
	public static class User {
		
		private String username;
		private int age;
		
		public User(String username, int age) { 
			this.username = username;
			this.age = age;
		}
		
	}
	
}
