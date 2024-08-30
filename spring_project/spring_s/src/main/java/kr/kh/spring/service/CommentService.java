package kr.kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.CommentDAO;
import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.pagination.Criteria;

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

	public List<CommentVO> getCommentList(Criteria cri) {
		if(cri == null) {
			return null;
		}
		return commentDao.selectCommentList(cri);
	}
}
