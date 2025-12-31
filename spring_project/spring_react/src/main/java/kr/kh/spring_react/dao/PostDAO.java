package kr.kh.spring_react.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring_react.model.vo.CommunityVO;
import kr.kh.spring_react.model.vo.FileVO;
import kr.kh.spring_react.model.vo.PostVO;
import kr.kh.spring_react.pagination.PostCriteria;

public interface PostDAO {

	List<CommunityVO> selectCommunityList();

	List<PostVO> selectPostList(@Param("cri")PostCriteria cri);

	int selectPostTotalCount(@Param("cri")PostCriteria cri);

	void insertFile(@Param("file")FileVO fileVo);

	boolean insertPost(@Param("post")PostVO post);

	void updateView(@Param("po_num")int po_num);

	PostVO selectPost(@Param("po_num")int po_num);

	List<FileVO> selectFileList(@Param("po_num")int po_num);

}
