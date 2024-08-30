package kr.kh.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.spring.service.CommentService;

@RestController // 컨트롤러 안에 있는 메소드에 @ResponseBody를 붙이지 않아도 ajax로 통신
public class CommentController{
	
	@Autowired
	CommentService commentService;

}
