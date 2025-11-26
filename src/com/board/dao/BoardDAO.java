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
    private int boardSeq = 1;

    
    public static void main(String[] args) {
    	BoardDAO dao = new BoardDAO();
		dao.addBoard("제목", "텍스트");
	}
    
    
    public BoardDTO addBoard(String title, String content) {
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
    	BoardDTO board = new BoardDTO(boardSeq, title, content);
        boards.add(board);
        return board;
    }

    public boolean deleteBoard(int id) {
    	Connection conn = null;
    	PreparedStatement st = null;
    	String sql = "delete from board where id = ?";
		try {
			conn = DBUtil.dbConnect();
			st = conn.prepareStatement(sql);
			
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, st, null);
		}
        return boards.removeIf(b -> b.getId() == id);
    }

    public BoardDTO getBoard(int id) {
    	
    	Connection conn = null;
    	PreparedStatement st = null;
    	ResultSet rs = null;
    	String sql = "select * from board where id = ?";
    	
    	try {
			conn = DBUtil.dbConnect();
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			rs.next();
			BoardDTO dto = new BoardDTO(rs.getInt("id"), rs.getString("title"), rs.getString("content"));
			boards.add(dto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, st, null);
		}
    	
        return boards.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
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