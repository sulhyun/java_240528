package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;


@WebServlet("/post/update")
public class PostUpdate extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private PostService postService = new PostServiceImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 번호를 받아옴
		String po_numStr = request.getParameter("po_num");
		try {
			int po_num = Integer.parseInt(po_numStr);
			// 회원 정보를 받아옴
			MemberVO user = (MemberVO)request.getSession().getAttribute("user");
			// 서비스에게 게시글 번호와 회원 정보를 주면서 게시글을 가져오라고 요청
			PostVO post = postService.getPost(po_num, user);
			// 게시글이 null 아니면 수정 페이지로 이동
			if(post != null) {
				request.setAttribute("post", post);
				request.getRequestDispatcher("/WEB-INF/views/post/update.jsp").forward(request, response);
			}
			// null 이면 작성자가 아니거나 게시글이 없습니다.라고 출력하도록 작성
			else {
				throw new RuntimeException();
			}
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "작성자가 아니거나 게시글이 없습니다.");
			request.setAttribute("url", "/post/detail?po_num=" + po_numStr);
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 번호를 받아옴
		String po_numStr = request.getParameter("po_num");
		try {
			int po_num = Integer.parseInt(po_numStr);
			// 회원 정보를 받아옴
			MemberVO user = (MemberVO)request.getSession().getAttribute("user");
			// 게시글 제목을 가져옴
			String title = request.getParameter("title");
			// 게시글 내용을 가져옴
			String content = request.getParameter("content");
			// 게시글 번호와 제목과 내용을 이용하여 객체를 생성
			PostVO post = new PostVO(po_num, title, content);
			// 서비스에게 게시글 정보와 회원 정보를 주면서 게시글을 가져오라고 요청하고 성공하면 성공 처리
			if(postService.updatePost(post, user)) {
				request.setAttribute("msg", "게시글 수정에 성공했습니다.");
			}
			//실패하면 실패 처리
			else {
				throw new RuntimeException();
			}
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "게시글 수정에 실패했습니다.");
		}
		request.setAttribute("url", "/post/detail?num=" + po_numStr);
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
