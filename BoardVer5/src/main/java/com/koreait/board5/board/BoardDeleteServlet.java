package com.koreait.board5.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;
import com.koreait.board5.user.UserVO;

@WebServlet("/board/boardDelete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MyUtils.getLoginUser(request) == null) {
			response.sendRedirect("/user/userLogin");
			return;
		}
		
		int iboard = MyUtils.getParamInt("iboard", request);
		BoardVO param = new BoardVO();
		param.setIboard(iboard);
		param.setIuser(MyUtils.getLoginUserPk(request));
		
		int result = BoardDAO.deleteBoard(param);
		
		if (result == 0) {
			response.sendRedirect("boardDetail?iboard=" + iboard);
			return;
		}
		
		response.sendRedirect("boardList");
	}

}
