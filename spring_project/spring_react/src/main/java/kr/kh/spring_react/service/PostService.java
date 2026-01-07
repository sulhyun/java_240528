package kr.kh.spring_react.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring_react.model.vo.CommunityVO;
import kr.kh.spring_react.model.vo.FileVO;
import kr.kh.spring_react.model.vo.MemberVO;
import kr.kh.spring_react.model.vo.PostVO;
import kr.kh.spring_react.pagination.PageMaker;
import kr.kh.spring_react.pagination.PostCriteria;

public interface PostService {

	List<CommunityVO> getCommunityList();

	List<PostVO> getPostList(PostCriteria cri);

	PageMaker getPageMaker(PostCriteria cri);

	boolean addPost(PostVO post, MemberVO user, MultipartFile[] fileList);

	void updateView(int po_num);

	PostVO getPost(int po_num);

	List<FileVO> getFileList(int po_num);

	boolean updatePost(PostVO post, MemberVO user, MultipartFile[] fileList, int[] nums);

	boolean deletePost(int po_num, MemberVO user);

	List<PostVO> getPostListRN(int co_num);

}
