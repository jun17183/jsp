package com.koreait.board4.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.MyUtils;
import com.koreait.board4.UserDAO;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");
		
		if (loginUser != null) {
			response.sendRedirect("/board/list");
			return;
		}
		
		MyUtils.openJSP("user/login", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		UserVO vo = new UserVO();
		vo.setUid(uid);
		vo.setUpw(upw);
		
		int result = UserDAO.loginUser(vo);

		if (result == 1) {
			// 로그인 성공 시 계정의 iuser, uid, unm 값을 담아 list로 이동 
			HttpSession hs = request.getSession();	
			
			vo.setUpw(null);	// pw는 화면에 찍을 일이 없기 때문에 지워줌
			hs.setAttribute("loginUser", vo);
			
			response.sendRedirect("/board/list");
			return;
		}
		
		String errMsg = null;
		switch (result) {
		case 0:
			errMsg = "에러가 발생하였습니다.";
			break;
		case 2:
			errMsg = "아이디를 확인해주세요.";
			break;
		case 3:
			errMsg = "비밀번호를 확인해주세요.";
			break;
		}
		request.setAttribute("errMsg", errMsg);
		doGet(request, response);	
		
	}

}

// response.sendRedirect("login") 이렇게 해도 됨. 단 doGet은 request가 이어지지만 이 방법은 request가 끊김
// doGet이 더 좋아보이기도 하지만 취향임. response를 쓰면 ("login?err=" + result) 이런 식으로 에러를 직접 보내게 되는데,
// 취향따라 위 방법이 더욱 깔끔한 코드라고 볼 수도 있음
