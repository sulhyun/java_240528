package kr.kh.spring_react.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring_react.model.vo.CommunityVO;
import kr.kh.spring_react.model.vo.PostVO;
import kr.kh.spring_react.pagination.PageMaker;
import kr.kh.spring_react.pagination.PostCriteria;
import kr.kh.spring_react.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	PostService postService;
	
	@GetMapping("/list/{co_num}")
	public String list(Model model, @PathVariable("co_num")int co_num, PostCriteria cri) {
		System.out.println("/post/list : GET");
		cri.setCo_num(co_num);
		cri.setPerPageNum(3);
		System.out.println(cri);
		List<CommunityVO> communities = postService.getCommunityList();
		List<PostVO> list = postService.getPostList(cri);
		PageMaker pm = postService.getPageMaker(cri);
		System.out.println(list);
		model.addAttribute("title", "커뮤니티");
		model.addAttribute("communities", communities);
		model.addAttribute("list", list);
		model.addAttribute("pm", pm);
		return "/post/list";
	}
}
