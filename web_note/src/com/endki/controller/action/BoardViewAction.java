package com.endki.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.endki.dao.BoardDAO;
import com.endki.dto.BoardVO;

//게시글 번호에 해당되는 게시글을 db에서 찾아 상세정보를 보여준다.

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		String url ="/board/boardView.jsp";
		
		String num=request.getParameter("num");
		
		BoardDAO bDao = BoardDAO.getInstance();
		
		bDao.updateReadCount(num);
		
		BoardVO bVo=bDao.selectOneBoardByNum(num);
		
		request.setAttribute("board", bVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
}
