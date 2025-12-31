package kr.kh.spring_react.service;

import java.util.List;

import kr.kh.spring_react.model.vo.CommunityVO;
import kr.kh.spring_react.model.vo.PostVO;
import kr.kh.spring_react.pagination.PageMaker;
import kr.kh.spring_react.pagination.PostCriteria;

public interface PostService {

	List<CommunityVO> getCommunityList();

	List<PostVO> getPostList(PostCriteria cri);

	PageMaker getPageMaker(PostCriteria cri);

}
