package kr.kh.spring_react.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring_react.dao.PostDAO;
import kr.kh.spring_react.model.vo.CommunityVO;
import kr.kh.spring_react.model.vo.FileVO;
import kr.kh.spring_react.model.vo.MemberVO;
import kr.kh.spring_react.model.vo.PostVO;
import kr.kh.spring_react.pagination.PageMaker;
import kr.kh.spring_react.pagination.PostCriteria;
import kr.kh.spring_react.utils.UploadFileUtils;

@Service
public class PostServiceImp implements PostService {
	
	@Autowired
	private PostDAO postDao; 
	
	@Resource
	String uploadPath;
	
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

	@Override
	public boolean addPost(PostVO post, MemberVO user, MultipartFile[] fileList) {
		if(post == null || user == null) {
			return false;
		}
		if(post.getPo_title().length() == 0) {
			return false;
		}
		post.setPo_me_id(user.getMe_id());
		boolean res = postDao.insertPost(post);
		if(!res) {
			return false;
		}
		uploadFileList(fileList, post.getPo_num());
		return true;
	}

	private void uploadFileList(MultipartFile[] fileList, int po_num) {
		if(fileList == null || fileList.length == 0) {
			return;
		}
		for(MultipartFile file : fileList) {
			uploadFile(file, po_num);
		}

	}

	private void uploadFile(MultipartFile file, int po_num) {
		if(file == null || file.getOriginalFilename().length() == 0) {
			return;
		}
		// 첨부 파일을 서버에 업로드
		String fi_ori_name = file.getOriginalFilename();
		try {
			String fi_name = UploadFileUtils.uploadFile(uploadPath, fi_ori_name, file.getBytes());			
			// 업로드한 정보를 DB에 추가
			FileVO fileVo = new FileVO(fi_name, fi_ori_name, po_num);
			postDao.insertFile(fileVo);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
