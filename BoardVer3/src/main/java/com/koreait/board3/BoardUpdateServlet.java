package com.koreait.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		int intIboard = Integer.parseInt(iboard);
		
		BoardVO vo = BoardDAO.selBoard(intIboard);
		request.setAttribute("vo", vo);
		
		String jsp = "/WEB-INF/view/update.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		String iboard = request.getParameter("iboard");
		int intIboard = Integer.parseInt(iboard);
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		vo.setIboard(intIboard);
		
		BoardDAO.updateBoard(vo);
		
		response.sendRedirect("/detail?iboard=" + iboard);
	}

}
