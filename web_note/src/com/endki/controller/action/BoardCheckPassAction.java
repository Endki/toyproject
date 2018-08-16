package com.endki.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.endki.dao.BoardDAO;
import com.endki.dto.BoardVO;

//게시글 비밀번호가 일치하는지 비교한다.

public class BoardCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String url=null;
		
		String num=request.getParameter("num");
		String pass = request.getParameter("pass");
		
		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO bVo=bDao.selectOneBoardByNum(num);
		
		if(bVo.getPass().equals(pass)) { //성공하면
			url = "/board/checkSuccess.jsp";
		}else {  //실패
			url="/board/boardCheckPass.jsp";
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
	
	
	
}
