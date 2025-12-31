package kr.kh.spring_react.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring_react.model.vo.CommunityVO;
import kr.kh.spring_react.model.vo.MemberVO;
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
		List<CommunityVO> communities = postService.getCommunityList();
		List<PostVO> list = postService.getPostList(cri);
		PageMaker pm = postService.getPageMaker(cri);
		model.addAttribute("title", "커뮤니티");
		model.addAttribute("communities", communities);
		model.addAttribute("list", list);
		model.addAttribute("pm", pm);
		return "/post/list";
	}
	
	@GetMapping("/insert/{co_num}")
	public String insert(Model model, @PathVariable("co_num")int co_num) {
		System.out.println("/post/insert : GET");
		model.addAttribute("title", "게시글 등록");
		model.addAttribute("co_num", co_num);
		return "/post/insert";
	}
	
	@PostMapping("/insert/{co_num}")
	public String insertPost(Model model, @PathVariable("co_num")int co_num, PostVO post, HttpSession session, MultipartFile[] fileList) {
		System.out.println("/post/insert : POST");
		post.setPo_co_num(co_num);
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = postService.addPost(post, user, fileList);
		if(res) {
			model.addAttribute("url", "/post/list/" + co_num);
			model.addAttribute("msg", "게시글 등록 성공");
		}else {
			model.addAttribute("url", "/post/insert/" + co_num);
			model.addAttribute("msg", "게시글 등록 실패");
		}
		return "/util/msg";
	}
	
}
