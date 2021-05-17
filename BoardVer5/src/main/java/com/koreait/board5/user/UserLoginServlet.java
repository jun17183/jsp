package com.koreait.board5.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board5.MyUtils;

@WebServlet("/user/userLogin")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MyUtils.getLoginUser(request) != null) {
			response.sendRedirect("/board/boardList");
			return;
		}
		
		MyUtils.openJSP("user/userLogin", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVO param = new UserVO();
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		param.setUid(uid);
		param.setUpw(upw);
		
		UserVO result = UserDAO.loginUser(param);
		
		String errMsg = "";
		
		if (result == null) {
			errMsg = "아이디를 확인해주세요.";
		} else if (BCrypt.checkpw(upw, result.getUpw())) {
			result.setUpw(null);
			
			HttpSession hs = request.getSession();
			hs.setAttribute("loginUser", result);
			
			response.sendRedirect("/board/boardList");
			System.out.println("list로 이동");
			return;
		} else {
			errMsg = "비밀번호를 확인해주세요.";
		}
		System.out.println(errMsg);
		request.setAttribute("errMsg", errMsg);
		doGet(request, response);
	}
}
