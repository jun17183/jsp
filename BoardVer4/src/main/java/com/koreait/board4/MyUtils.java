package com.koreait.board4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
}
