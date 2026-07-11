package com.crud.boot06.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crud.boot06.domain.DeliveryCode;
import com.crud.boot06.domain.Item;
import com.crud.boot06.domain.ItemType;
import com.crud.boot06.repository.ItemRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/item/items")
@RequiredArgsConstructor
public class ItemController {

	private final ItemRepository itemRepository;
	
	@ModelAttribute("regions")
	public Map<String, String> regions() {
		Map<String, String> regions = new LinkedHashMap<>();
		regions.put("SEOUL", "서울");
		regions.put("BUSAN", "부산");
		regions.put("JEJU", "제주");
		return regions;
	}
	
	@ModelAttribute("itemTypes")
	public ItemType[] itemTypes() {
		return ItemType.values();
	}
	
	@ModelAttribute("deliveryCodes")
	public List<DeliveryCode> deliveryCodes() {
		List<DeliveryCode> deliveryCodes = new ArrayList<>();
		deliveryCodes.add(new DeliveryCode("FAST", "빠른 배송"));
		deliveryCodes.add(new DeliveryCode("NOMAL", "일반 배송"));
		deliveryCodes.add(new DeliveryCode("SLOW", "느린 배송"));
		return deliveryCodes;
	}
	
	@GetMapping
	public String items(Model model) {
		List<Item> items = itemRepository.findAll();
		model.addAttribute("items", items);
		return "item/items";
	}
	
	@GetMapping("/{itemId}")
	public String item(@PathVariable long itemId, Model model) {
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item", item);
		return "item/item";
	}
	
	@GetMapping("/add") 
	public String addForm(Model model) {
		model.addAttribute("item", new Item());
		return "item/addForm";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute Item item, RedirectAttributes redirectAttributes) {
		Item saveItem = itemRepository.save(item);
		redirectAttributes.addAttribute("itemId", saveItem.getId());
		redirectAttributes.addAttribute("status", true);
		// model.addAttribute("item", item); // 자동 추가 생략 가능
		return "redirect:/item/items/{itemId}";
	}
	
	@GetMapping("/{itemId}/edit")
	public String editForm(@PathVariable long itemId, Model model) {
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item", item);
		return "item/editForm"; 
	}
	
	@PostMapping("/{itemId}/edit")
	public String edit(@PathVariable long itemId, @ModelAttribute Item item) {
		itemRepository.update(itemId, item);
		return "redirect:/item/items/{itemId}";
	}
	
	@GetMapping("/{itemId}/delete")
	public String delete(@PathVariable long itemId, Model model) {
		itemRepository.delete(itemId);
		List<Item> items = itemRepository.findAll();
		model.addAttribute("items", items);
		return "redirect:/item/items";
	}
	
	/**
	 * 테스트용 데이터 추가
	 */
	@PostConstruct
	public void init() {
		itemRepository.save(new Item("itemA", 10000, 10));
		itemRepository.save(new Item("itemB", 20000, 20));
	}
	
}
