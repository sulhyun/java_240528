package kr.kh.spring1.dao;

import java.util.List;

import kr.kh.spring1.model.vo.CommunityVO;
import kr.kh.spring1.model.vo.PostVO;
import kr.kh.spring1.pagination.PostCriteria;

public interface PostDAO {

	List<CommunityVO> selectCommunityList();

	List<PostVO> selectPostList(PostCriteria cri);

	int selectPostTotalCount(PostCriteria cri);

	boolean insertPost(PostVO post);

	PostVO selectPost(int po_num);

	void updateView(int po_num);

	boolean deletePost(int po_num);

	boolean updatePost(PostVO post);

}
