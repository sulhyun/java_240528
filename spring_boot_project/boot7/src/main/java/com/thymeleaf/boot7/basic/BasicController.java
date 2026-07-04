package com.thymeleaf.boot7.basic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
	
	@GetMapping("/objects")
	public String objects(Model model, HttpSession session, 
			HttpServletRequest request, HttpServletResponse response) {
		session.setAttribute("sessionData", "Hello Session");
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		model.addAttribute("servletContext", request.getServletContext());
		return "basic/objects";
	}
	
	@GetMapping("/date")
	public String date(Model model) {
		model.addAttribute("localDateTime", LocalDateTime.now());
		return "basic/date";
	}
	
	@GetMapping("/link")
	public String link(Model model) { 
		model.addAttribute("param1", "data1");
		model.addAttribute("param2", "data2");
		return "basic/link";
	}
	
	@GetMapping("/literal")
	public String literal(Model model) {
		model.addAttribute("data", "spring!");
		return "basic/literal";
	}
	
	@Component("bean")
	static class Bean {
		
		public String beanData(String data) {
			return "Hello " + data;
		}
		
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
