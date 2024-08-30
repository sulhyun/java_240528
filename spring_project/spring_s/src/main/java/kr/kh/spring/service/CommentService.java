package kr.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.CommentDAO;
import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.model.vo.MemberVO;

@Service
public class CommentService {

	@Autowired
	CommentDAO commentDao;

	public boolean insertComment(CommentVO comment, MemberVO user) {
		if(comment == null || user == null) {
			return false;
		}
		comment.setCm_me_id(user.getMe_id());
		return commentDao.insertComment(comment);
	}
}
