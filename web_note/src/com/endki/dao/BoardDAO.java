package com.endki.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.endki.dto.BoardVO;

import util.DBManager;
//데이터베이스 명령어를 함수화 처리
public class BoardDAO {
	private BoardDAO() {
	}	
	
	private static BoardDAO instance=new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	public List<BoardVO> selectAllBoards(){ // 순서대로 게시글을 출력하는 함수
		String sql="select * from board order by num desc";
		List<BoardVO> list=new ArrayList<BoardVO>();
		
		Connection conn=null;
		Statement stmt =null;
		ResultSet rs=null;
		
		try {
			conn = DBManager.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			//핵심 실행
			while(rs.next()) {
				BoardVO bVo=new BoardVO();
				
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setEmail(rs.getString("email"));
				bVo.setPass(rs.getString("pass"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
	
				list.add(bVo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}
	
	public void insertBoard(BoardVO bVo) { //데이터를 넣는 함수
		String sql="insert into board("+"num, name, email, pass, title, content) " + "values(board_seq.nextval, ?, ?, ?, ?, ?)";
		
		Connection conn =null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bVo.getName());
			pstmt.setString(2, bVo.getEmail());
			pstmt.setString(3, bVo.getPass());
			pstmt.setString(4, bVo.getTitle());
			pstmt.setString(5, bVo.getContent());
			
			//데이터를 넣는 부분
			
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void updateReadCount(String num) { // 조회수를  1올리도록 하는 명령
		String sql="update board set readcount=readcount+1 where num=?";
		
		Connection conn=null;
		PreparedStatement pstmt =null;
		
		try {
			conn=DBManager.getConnection();
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public BoardVO selectOneBoardByNum(String num) { // 게시글이 몇개인지 출력하는 함수
		String sql="select * from board where num = ?";
		
		BoardVO bVo=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		
		try {
			conn = DBManager.getConnection();
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				bVo=new BoardVO();
				
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setPass(rs.getString("pass"));
				bVo.setEmail(rs.getString("email"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
				bVo.setReadcount(rs.getInt("readcount"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return bVo;
	}
	
	public void updateBoard(BoardVO bVo) { //게시글 수정을 위한 함수
		String sql="update board set name=?, email=?, pass=?, "+"title=?, content=? where num=?";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBManager.getConnection();
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bVo.getName());
			pstmt.setString(2, bVo.getEmail());
			pstmt.setString(3, bVo.getPass());
			pstmt.setString(4, bVo.getTitle());
			pstmt.setString(5, bVo.getContent());
			pstmt.setInt(6, bVo.getNum());
			
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	public BoardVO checkPassWord(String pass,String num) { // 패스워드랑 넘버가 같은 문서를 찾는 함수
		String sql="select * from board where pass=? and num=?";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		BoardVO bVo=null;
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, pass);
			pstmt.setString(2, num);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				bVo=new BoardVO();
				
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setPass(rs.getString("pass"));
				bVo.setEmail(rs.getString("email"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
				bVo.setReadcount(rs.getInt("readcount"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return bVo;
	}
	
	
	public void deleteBoard(String num) { // 넘버의 게시글을 삭제한다.
		String sql="delete board where num=?";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
