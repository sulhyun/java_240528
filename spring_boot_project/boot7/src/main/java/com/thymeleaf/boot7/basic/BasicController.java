package com.thymeleaf.boot7.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}
