package kr.kh.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.pagination.Criteria;

public interface CommentDAO {

	boolean insertComment(@Param("comment")CommentVO comment);

	List<CommentVO> selectCommentList(@Param("cri")Criteria cri);

	int selectCommentTotalCount(@Param("cri")Criteria cri);

}
