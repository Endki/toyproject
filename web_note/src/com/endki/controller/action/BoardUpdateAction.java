package com.endki.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.endki.dao.BoardDAO;
import com.endki.dto.BoardVO;

//입력한 정보로 db에 있는 게시글 정보를 수정한다.

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		BoardVO bVo=new BoardVO();
		
		bVo.setNum(Integer.parseInt(request.getParameter("num")));
		bVo.setName(request.getParameter("name"));
		bVo.setPass(request.getParameter("pass"));
		bVo.setEmail(request.getParameter("email"));
		bVo.setTitle(request.getParameter("content"));
		bVo.setContent(request.getParameter("content"));
		
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.updateBoard(bVo);
		
		new BoardListAction().execute(request, response);
		
		
	}
}
