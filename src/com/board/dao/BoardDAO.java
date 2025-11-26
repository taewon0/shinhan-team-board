package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.board.dto.BoardDTO;
import com.board.util.DBUtil;


public class BoardDAO {
	
	
    private List<BoardDTO> boards = new ArrayList<>();

    

    
    
    public void addBoard(String title, String content) {
    	//id(seq), title, content
    	Connection conn = null;
    	PreparedStatement st = null;
    	String sql = "insert into board(title, content) values (?,?)";
    	
    	try {
    		conn = DBUtil.dbConnect();
			st = conn.prepareStatement(sql);
			
			st.setString(1, title);
			st.setString(2, content);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}
    }

    public boolean deleteBoard(int id) {
    	Connection conn = null;
    	PreparedStatement st = null;
    	String sql = "delete from board where id = ?";
		try {
			conn = DBUtil.dbConnect();
			st = conn.prepareStatement(sql);
			
			st.setInt(1, id);
			if(st.executeUpdate() != 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, st, null);
		}
        return false;
    }

    public BoardDTO getBoard(int id) {
    	
    	Connection conn = null;
    	PreparedStatement st = null;
    	ResultSet rs = null;
    	String sql = "select * from board where id = ?";
    	
    	BoardDTO dto = null;
    	
    	try {
			conn = DBUtil.dbConnect();
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			rs.next();
			dto = new BoardDTO(rs.getInt("id"), rs.getString("title"), rs.getString("content"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, st, null);
		}
    	
        return dto;
    }

    public List<BoardDTO> getAllBoards() {
    	Connection conn = null;
    	Statement st = null;
    	ResultSet rs = null;
    	String sql = "select * from board";
    	
    	try {
			conn = DBUtil.dbConnect();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO(rs.getInt("id"), rs.getString("title"), rs.getString("content"));
				boards.add(dto);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, st, null);
		}
    	
    	
        return boards;
    }
}