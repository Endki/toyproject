package com.endki.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//새로운 게시글 정보를 입력받기 위해
//게시글 등록 페이지로 이동

public class BoardWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		String url="/board/boardWrite.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
}
