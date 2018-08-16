package com.endki.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//게시글을 수정 혹은 삭제할 수 있는 자격이 있는지 확인을 위해여 비밀번호 입력페이지로 이동하도록 한다.

public class BoardCheckPassFormAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		String url="/board/boardCheckPass.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	
	
}
