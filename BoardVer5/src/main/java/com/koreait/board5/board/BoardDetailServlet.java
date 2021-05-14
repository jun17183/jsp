package com.koreait.board5.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;

@WebServlet("/board/boardDetail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MyUtils.getLoginUser(request) == null) {
			response.sendRedirect("/user/userLogin");
			return;
		}
		
		BoardVO param = new BoardVO();
		param.setIboard(MyUtils.getParamInt("iboard", request));
		
		request.setAttribute("vo", BoardDAO.selectBoard(param));
		
		MyUtils.openJSP("board/boardDetail", request, response);
	}


}
