package com.koreait.board5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board5.user.UserVO;

public class MyUtils {
	
	public static void openJSP(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/" + jsp + ".jsp").forward(request, response);
	}

	public static int parseStringToInt(String str) {
		try { return Integer.parseInt(str); } catch (Exception e) { return 0; }
	}
	
	public static String getParamStr(String key, HttpServletRequest request) {
		return request.getParameter(key);
	}
	
	public static int getParamInt(String key, HttpServletRequest request) {
		return parseStringToInt(request.getParameter(key));
	}
	
	public static UserVO getLoginUser(HttpServletRequest request) {
		if(request == null) { return null; }
		HttpSession hs = request.getSession();
		return (UserVO) hs.getAttribute("loginUser");
	}
	
	public static int getLoginUserPk(HttpServletRequest request) {
		if(request == null) { return 0; }
		return getLoginUser(request).getIuser();
	}
}
