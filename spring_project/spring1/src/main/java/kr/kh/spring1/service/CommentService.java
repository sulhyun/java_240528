package kr.kh.spring1.service;

import java.util.List;

import kr.kh.spring1.model.vo.CommentVO;
import kr.kh.spring1.model.vo.MemberVO;
import kr.kh.spring1.pagination.Criteria;
import kr.kh.spring1.pagination.PageMaker;

public interface CommentService {

	List<CommentVO> getCommentList(Criteria cri);

	PageMaker getCommentPageMaker(Criteria cri);

	boolean insertComment(CommentVO comment, MemberVO user);

	boolean deleteComment(CommentVO comment, MemberVO user);

	boolean deleteComment(int cm_num, MemberVO user);

	boolean updateComment(CommentVO comment, MemberVO user);

}
