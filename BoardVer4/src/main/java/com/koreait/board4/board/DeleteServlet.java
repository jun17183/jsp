package com.koreait.board4.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;
import com.koreait.board4.user.UserVO;

@WebServlet("/board/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVO loginUser = MyUtils.getLoginUser(request);
		
		int iboard = MyUtils.getParamInt("iboard", request);
		
		BoardVO vo = new BoardVO();
		vo.setIboard(iboard);
		vo.setIuser(loginUser.getIuser());
		
		int result = BoardDAO.deleteBoard(vo);
		
		if (result == 0) {
			response.sendRedirect("/board/detail?iboard=" + request.getParameter("iboard"));
			return;
		}
		response.sendRedirect("/board/list");
	}

}