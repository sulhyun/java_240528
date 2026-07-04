package kr.kh.spring1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring1.dao.PostDAO;
import kr.kh.spring1.model.vo.CommunityVO;
import kr.kh.spring1.model.vo.MemberVO;
import kr.kh.spring1.model.vo.PostVO;
import kr.kh.spring1.pagination.PageMaker;
import kr.kh.spring1.pagination.PostCriteria;

@Service
public class PostServiceImp implements PostService{
	
	@Autowired
	PostDAO postDao;

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
		int totalCount = postDao.selectPostTotalCount(cri);
		return new PageMaker(2, cri, totalCount);
	}

	@Override
	public boolean insertPost(PostVO post, MemberVO user) {
		if(post == null || user == null) {
			return false;
		}
		if(post.getPo_title().trim().length() == 0) {
			return false;
		}
		if(post.getPo_content().trim().length() == 0) {
			return false;
		}
		post.setPo_me_id(user.getMe_id());
		return postDao.insertPost(post);
	}

	@Override
	public PostVO getPost(int po_num) {
		return postDao.selectPost(po_num);
	}

	@Override
	public void updateView(int po_num) {
		postDao.updateView(po_num);
	}

	@Override
	public boolean deletePost(int po_num, MemberVO user) {
		if(user == null) {
			return false;
		}
		PostVO post = getPost(po_num);
		if(!post.getPo_me_id().equals(user.getMe_id())) {
			return false;
		}
		return postDao.deletePost(po_num);
	}

	@Override
	public boolean updatePost(PostVO post, MemberVO user) {
		if(post == null || user == null) {
			return false;
		}
		if(post.getPo_title().trim().length() == 0) {
			return false;
		}
		if(post.getPo_content().trim().length() == 0) {
			return false;
		}
		PostVO tmp = getPost(post.getPo_num());
		if(!tmp.getPo_me_id().equals(user.getMe_id())) {
			return false;
		}
		return postDao.updatePost(post);
	}

}
