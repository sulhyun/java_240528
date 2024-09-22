package kr.kh.spring1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.spring1.model.vo.CommentVO;
import kr.kh.spring1.model.vo.MemberVO;
import kr.kh.spring1.pagination.Criteria;
import kr.kh.spring1.pagination.PageMaker;
import kr.kh.spring1.service.CommentService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@ResponseBody
	@PostMapping("/list")
	public Map<String, Object> list(@RequestBody Criteria cri){
		log.info("comment/list:post");
		cri.setPerPageNum(2);
		Map<String, Object> map = new HashMap<String, Object>();
		// commentService에게 댓글 리스트 요청
		List<CommentVO> list = commentService.getCommentList(cri);
		// commentService에게 pageMaker 객체 생성 요청
		PageMaker pm = commentService.getCommentPageMaker(cri);
		map.put("list", list);
		map.put("pm", pm);
		return map;
	}
	
	@ResponseBody
	@PostMapping("/insert")
	public boolean insert(@RequestBody CommentVO comment, HttpSession session) {
		log.info("comment/insert:post");
		log.info(comment);
		MemberVO user = (MemberVO)session.getAttribute("user");		
		return commentService.insertComment(comment, user);
	}
	
	@ResponseBody
	@PostMapping("/delete1")
	public Map<String, Object> delete1(@RequestBody CommentVO comment, HttpSession session) {
		log.info("comment/delete1:post");
		log.info(comment);
		MemberVO user = (MemberVO)session.getAttribute("user");
		Map<String, Object> map = new HashMap<String, Object>();
		boolean res = commentService.deleteComment(comment, user);
		map.put("res", res);
		return map;
	}
	
	@ResponseBody
	@PostMapping("/delete2")
	public Map<String, Object> delete2(@RequestParam int cm_num, HttpSession session) {
		log.info("comment/delete2:post");
		log.info(cm_num);
		MemberVO user = (MemberVO)session.getAttribute("user");
		Map<String, Object> map = new HashMap<String, Object>();
		boolean res = commentService.deleteComment(cm_num, user);
		map.put("res", res);
		return map;
	}
	
	@ResponseBody
	@PostMapping("/delete3")
	public boolean delete3(@RequestParam int cm_num, HttpSession session) {
		log.info("comment/delete3:post");
		log.info(cm_num);
		MemberVO user = (MemberVO)session.getAttribute("user");
		return commentService.deleteComment(cm_num, user);
	}
	
	@ResponseBody
	@PostMapping("/update")
	public boolean update(@RequestBody CommentVO comment, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean result = commentService.updateComment(comment, user);
		return result;
	}
}
