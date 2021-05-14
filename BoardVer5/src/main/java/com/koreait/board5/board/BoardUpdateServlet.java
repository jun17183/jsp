package com.koreait.board5.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;

@WebServlet("/board/boardUpdate")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MyUtils.getLoginUser(request) == null) {
			response.sendRedirect("/user/userLogin");
			return;
		}
		
		int iboard = MyUtils.getParamInt("iboard", request);
		BoardVO param = new BoardVO();
		param.setIboard(iboard);
		
		BoardVO board = BoardDAO.selectBoard(param);
		
		if (MyUtils.getLoginUserPk(request) != board.getIuser()) {
			response.sendRedirect("boardDetail?iboard=" + iboard);
			return;
		}
		
		request.setAttribute("vo", board);
		
		MyUtils.openJSP("board/boardUpdate", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);		
		BoardVO param = new BoardVO();
		param.setTitle(request.getParameter("title"));
		param.setCtnt(request.getParameter("ctnt"));
		param.setIboard(iboard);
		
		BoardDAO.updateBoard(param);
		
		response.sendRedirect("boardDetail?iboard=" + iboard);
	}

}
