package kr.kh.spring1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring1.dao.CommentDAO;
import kr.kh.spring1.model.vo.CommentVO;
import kr.kh.spring1.model.vo.MemberVO;
import kr.kh.spring1.pagination.Criteria;
import kr.kh.spring1.pagination.PageMaker;

@Service
public class CommentServiceImp implements CommentService{
	
	@Autowired
	CommentDAO commentDao;

	@Override
	public List<CommentVO> getCommentList(Criteria cri) {
		if(cri == null) {
			return null;
		}
		return commentDao.selectCommentList(cri);		
	} // 댓글 목록을 가져오는 메소드

	@Override
	public PageMaker getCommentPageMaker(Criteria cri) {
		if(cri == null) {
			return null;
		}
		int totalCount = commentDao.selectCommentTotalCount(cri);
		return new PageMaker(2, cri, totalCount);
	} // 페이지 메이커 객체 생성하는 메소드

	@Override
	public boolean insertComment(CommentVO comment, MemberVO user) {
		if(comment == null || user == null) {
			return false;
		}
		comment.setCm_me_id(user.getMe_id());
		return commentDao.insertComment(comment);
	} // 댓글을 등록하는 메소드

	@Override
	public boolean deleteComment(CommentVO comment, MemberVO user) {
		if(comment == null || user == null) {
			return false;
		}
		return commentDao.deleteComment(comment.getCm_num());
	}

	@Override
	public boolean deleteComment(int cm_num, MemberVO user) {
		if(user == null) {
			return false;
		}
		if(!isWriter(cm_num, user.getMe_id())) {
			return false;
		}
		return commentDao.deleteComment(cm_num);
	}

	private boolean isWriter(int cm_num, String me_id) {
		CommentVO comment = commentDao.selectComment(cm_num);
		if(comment == null) {
			return false;
		}
		return comment.getCm_me_id().equals(me_id);
	}
	
	@Override
	public boolean updateComment(CommentVO comment, MemberVO user) {
		if(user == null || comment == null) {
			return false;
		}
		if(!isWriter(comment.getCm_num(), user.getMe_id())) {
			return false;
		}
		return commentDao.updateComment(comment);
	}
	
}
