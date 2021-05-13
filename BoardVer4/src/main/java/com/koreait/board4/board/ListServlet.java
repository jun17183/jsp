package com.koreait.board4.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;
import com.koreait.board4.user.UserVO;

@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// HttpSession hs = request.getSession();
		// UserVO loginUser = (UserVO) hs.getAttribute("loginUser");
		
		UserVO loginUser = MyUtils.getLoginUser(request);
		
		if (loginUser == null) {
			response.sendRedirect("/user/login");
			return;
		}
		
		request.setAttribute("list", BoardDAO.selectBoardList());
		
		MyUtils.openJSP("board/list", request, response);
	}
	
/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		
		Boolean loginSuccess = (Boolean)hs.getAttribute("loginSuccess");	// 그냥 boolean일 때, 만약 넘어온 값이 null이면 에러가 터짐
																			// 대문자로 된 Boolean같은 친구들을 래퍼클래스라고 하는데, 
																			// boolean이랑 똑같지만 그냥 위 현상을 방지하는 등의 다양한 기능 탑제 
		
		if (loginSuccess == null || loginSuccess == false) {
			response.sendRedirect("/user/login");
			return;
		}
		
		MyUtils.openJSP("board/list", request, response);
	}
*/

}
