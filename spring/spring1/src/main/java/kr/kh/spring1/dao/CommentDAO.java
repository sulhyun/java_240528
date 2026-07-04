package kr.kh.spring1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring1.model.vo.CommentVO;
import kr.kh.spring1.pagination.Criteria;

public interface CommentDAO {

	List<CommentVO> selectCommentList(@Param("cri")Criteria cri);

	List<CommentVO> selectReplyList(@Param("cm_num")int cm_num);
	
	int selectCommentTotalCount(@Param("cri")Criteria cri);

	boolean insertComment(@Param("comment")CommentVO comment);

	boolean deleteComment(@Param("cm_num")int cm_num);

	CommentVO selectComment(@Param("cm_num")int cm_num);

	boolean updateComment(@Param("comment")CommentVO comment);

}
