package kr.kh.spring_react.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring_react.dao.PostDAO;
import kr.kh.spring_react.model.vo.CommunityVO;
import kr.kh.spring_react.model.vo.PostVO;
import kr.kh.spring_react.pagination.PageMaker;
import kr.kh.spring_react.pagination.PostCriteria;

@Service
public class PostServiceImp implements PostService {
	
	@Autowired
	private PostDAO postDao; 
	
	@Override
	public List<CommunityVO> getCommunityList() {
		return postDao.selectCommunityList();
	}

	@Override
	public List<PostVO> getPostList(PostCriteria cri) {
		if(cri == null) {
			return null;
		}
		return postDao.selectPostList(cri);
	}

	@Override
	public PageMaker getPageMaker(PostCriteria cri) {
		if(cri == null) {
			return null;
		}
		int totalCount =  postDao.selectPostTotalCount(cri);
		return new PageMaker(3, cri, totalCount);
	}
	
}
