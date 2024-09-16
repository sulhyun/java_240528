package kr.kh.spring1.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring1.model.vo.CommunityVO;
import kr.kh.spring1.model.vo.MemberVO;
import kr.kh.spring1.model.vo.PostVO;
import kr.kh.spring1.pagination.PageMaker;
import kr.kh.spring1.pagination.PostCriteria;
import kr.kh.spring1.service.PostService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@GetMapping("/list/{co_num}")
	public String list(Model model, @PathVariable("co_num")int co_num, PostCriteria cri) {
		log.info("post/list:get");
		// 한페이지에 노출될 컨텐츠의 갯수를 정함
		cri.setPerPageNum(3);
		// 커뮤니티 리스트를 가져옴
		List<CommunityVO> communityList = postService.getCommunityList();
		// 커뮤니티 번호를 주고 게시글을 가져옴
		List<PostVO> postList = postService.getPostList(cri);
		// 페이지 메이커 객체 생성
		PageMaker pm = postService.getPageMaker(cri);
		model.addAttribute("communityList", communityList);
		model.addAttribute("postList", postList);
		model.addAttribute("pm", pm);
		return "/post/list";
	}
	
	@GetMapping("/detail/{po_num}")
	public String detail(Model model, @PathVariable("po_num")int po_num) {
		log.info("post/detail:get");
		// 조회수 증가 
		postService.updateView(po_num);
		// 서비스에게 게시글 번호를 주면서 게시글 정보를 가져옴
		PostVO post = postService.getPost(po_num);
		model.addAttribute("post", post);
		return "/post/detail";
	}
	
	@GetMapping("/insert/{co_num}")
	public String insert(Model model, @PathVariable("co_num")int co_num) {
		log.info("post/insert:get");
		return "/post/insert";
	}
	
	@PostMapping("/insert/{co_num}")
	public String insertPost(Model model,@PathVariable("co_num")int co_num, PostVO post, HttpSession session) {
		log.info("post/insert:post");
		// 게시글에게 현재 커뮤니티 번호를 저장
		post.setPo_co_num(co_num);
		// 세션에 있는 유저 정보를 가져옴
		MemberVO user = (MemberVO)session.getAttribute("user");
		// 서비스에게 게시글 정보를 주면서 저장하라고 함
		boolean res = postService.insertPost(post, user);
		log.info(res);
		if(res) {
			model.addAttribute("msg" , "게시글 등록 성공");
			model.addAttribute("url" , "/post/list/" + co_num);
		}else {
			model.addAttribute("msg" , "게시글 등록 실패");
			model.addAttribute("url" , "/post/insert/" + co_num);
		}
		return "/main/message";
	}
	
	@GetMapping("/delete/{co_num}/{po_num}")
	public String delete(Model model,@PathVariable("co_num")int co_num, @PathVariable("po_num")int po_num, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = postService.deletePost(po_num, user);
		if(res) {
			model.addAttribute("msg", "게시글 삭제 성공");
			model.addAttribute("url", "/post/list/" + co_num);
		}else {
			model.addAttribute("msg", "게시글 삭제 실패");
			model.addAttribute("url", "/post/detail/" + po_num);
		}
		return "/main/message";
	}
	
	@GetMapping("/update/{po_num}")
	public String update(Model model, @PathVariable("po_num")int po_num) {
		log.info("post/update:get");
		PostVO post = postService.getPost(po_num);
		model.addAttribute("post", post);
		return "/post/update";
	}
	
	@PostMapping("/update/{po_num}")
	public String updatePost(Model model, @PathVariable("po_num")int po_num, PostVO post, HttpSession session) {
		log.info("/post/update:post");
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = postService.updatePost(post, user);
		if(res) {
			model.addAttribute("msg", "게시글 수정 성공");
			model.addAttribute("url", "/post/detail/" + po_num);
		}else {
			model.addAttribute("msg", "게시글 수정 실패");
			model.addAttribute("url", "/post/detail/" + po_num);
		}
		return "/main/message";
	}
}
