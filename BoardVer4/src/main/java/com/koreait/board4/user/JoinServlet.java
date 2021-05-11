package com.koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board4.MyUtils;
import com.koreait.board4.UserDAO;

@WebServlet("/user/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("user/join", request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		String unm = request.getParameter("unm");
		int gender = MyUtils.getParamInt("gender", request); 
		
		String hashedUpw = BCrypt.hashpw(upw, BCrypt.gensalt());	// 비밀번호 암호화
		System.out.println("hashedUpw : " + hashedUpw);
		
		UserVO vo = new UserVO();
		vo.setUid(uid);
		vo.setUpw(hashedUpw);
		vo.setUnm(unm);
		vo.setGender(gender);
		
		UserDAO.joinUser(vo);
		
		response.sendRedirect("/user/login");
	}

}

/*
	BCrypt : 암호화 기술 중 하나
	gensalt : salt란, 가령 우리가 입력한 암호가 123이고 암호화에 사용되는 특정 문자열 abc가 있다고 하면 이 둘을 버무려 암호화된 비밀번호를 만드는 것
*/