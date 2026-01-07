package kr.kh.spring_react.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.spring_react.model.vo.CommunityVO;
import kr.kh.spring_react.model.vo.PostVO;
import kr.kh.spring_react.service.PostService;

@RestController
@RequestMapping("/spring/rn")
public class RnController {

	@Autowired
	PostService postService;
	
	@GetMapping("/community/list")
	public List<CommunityVO> communityList() {
		System.out.println(111);
		return postService.getCommunityList();
	}
	
	@GetMapping("/post/list/{co_num}")
	public Map<String, Object> list(@PathVariable("co_num")int co_num) {
		System.out.println(222);
		List<PostVO> list = postService.getPostListRN(co_num);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		return map;
	}
	
	@GetMapping("/post/detail/{po_num}")
	public PostVO postDetail(@PathVariable("po_num")int po_num) {
		System.out.println(333);
		postService.updateView(po_num);
		return postService.getPost(po_num);
	}
}
