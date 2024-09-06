package kr.kh.spring3.dao;

import java.util.List;

import kr.kh.spring3.model.vo.CommunityVO;
import kr.kh.spring3.model.vo.FileVO;
import kr.kh.spring3.model.vo.PostVO;
import kr.kh.spring3.pagination.Criteria;
import kr.kh.spring3.pagination.PageMaker;
import kr.kh.spring3.pagination.PostCriteria;

public interface PostDAO {

	List<CommunityVO> selectCommunityList();

	List<PostVO> selectPostList(Criteria cri);

	int selectPostTotalCount(PostCriteria cri);

	PostVO selectPost(int po_num);

	void updateView(int po_num);

	List<FileVO> selectFileList(int po_num);

}
