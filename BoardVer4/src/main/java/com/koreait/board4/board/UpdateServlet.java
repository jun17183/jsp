package com.koreait.board4.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;
import com.koreait.board4.user.UserVO;

@WebServlet("/board/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVO loginUser = MyUtils.getLoginUser(request);
		
		int iboard = MyUtils.getParamInt("iboard", request);
		
		BoardVO vo = BoardDAO.selectBoard(iboard);
		if (loginUser.getIuser() != vo.getIuser()) {
			response.sendRedirect("detail?iboard=" + iboard);
			return;
		}
		
		request.setAttribute("vo", vo);
		
		MyUtils.openJSP("board/update", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		vo.setIboard(iboard);
		
		BoardDAO.updateBoard(vo);
		
		response.sendRedirect("detail?iboard=" + iboard);
	}

}
