package com.endki.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.endki.dao.BoardDAO;

//db에 게시글 정보를 삭제한다.

public class BoardDeleteAction implements Action{
	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String num=request.getParameter("num");
		
		BoardDAO bDao=BoardDAO.getInstance();
		bDao.deleteBoard(num);
		
		new BoardListAction().execute(request, response);
	}
}
