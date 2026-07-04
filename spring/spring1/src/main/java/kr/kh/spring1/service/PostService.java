package kr.kh.spring1.service;

import java.util.List;

import kr.kh.spring1.model.vo.CommunityVO;
import kr.kh.spring1.model.vo.MemberVO;
import kr.kh.spring1.model.vo.PostVO;
import kr.kh.spring1.pagination.PageMaker;
import kr.kh.spring1.pagination.PostCriteria;

public interface PostService {

	List<CommunityVO> getCommunityList();

	List<PostVO> getPostList(PostCriteria cri);

	PageMaker getPageMaker(PostCriteria cri);

	boolean insertPost(PostVO post, MemberVO user);

	PostVO getPost(int po_num);

	void updateView(int po_num);

	boolean deletePost(int po_num, MemberVO user);

	boolean updatePost(PostVO post, MemberVO user);


}
