package com.koreait.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/del")
public class BoardDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		int intIboard = Integer.parseInt(iboard);
		
		// BoardDAO.deleteBoard(intIboard); int값을 전달인자로 받는 버전
		BoardVO param = new BoardVO();
		param.setIboard(intIboard);
		BoardDAO.deleteBoard(param);	// vo 객체를 전달인자로 받는 버전 (수정에 더욱 용이)
										// 나중에 해당 유저가 작성한 글인지 확인 후 삭제를 하려면 iboard값 뿐만 아니라 게시글 자체에 대한 정보를 담아줄 필요가 있음
		
		response.sendRedirect("/list");
	}

}
