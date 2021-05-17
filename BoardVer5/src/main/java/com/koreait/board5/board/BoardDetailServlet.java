package com.koreait.board5.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;
import com.koreait.board5.cmt.CmtDAO;
import com.koreait.board5.cmt.CmtVO;

@WebServlet("/board/boardDetail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MyUtils.getLoginUser(request) == null) {
			response.sendRedirect("/user/userLogin");
			return;
		}
		
		int iboard = MyUtils.getParamInt("iboard", request);
		
		BoardVO param = new BoardVO();
		param.setIboard(iboard);
		
		CmtVO cmtParam = new CmtVO();
		cmtParam.setIboard(iboard);
		
		request.setAttribute("vo", BoardDAO.selectBoard(param));
		request.setAttribute("cmtList", CmtDAO.selectCmtList(cmtParam));
		
		MyUtils.openJSP("board/boardDetail", request, response);
	}


}
