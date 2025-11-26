package com.board.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.board.dto.BoardDTO;
import com.board.dto.CommentDTO;
import com.board.util.DBUtil;

public class CommentDAO {
	
	public static void main(String[] args) {
		CommentDAO dao = new CommentDAO();
		BoardDTO b = new BoardDTO(2, null, null);
		dao.updateComment(b, 3, "ssssss");
	}

    public void addComment(BoardDTO board, String content) {
    	Connection conn = null;
    	PreparedStatement st = null;

    	String insertSql = "insert into comments (board_id, content) values(?, ?)";
    	
    	try {
    		conn = DBUtil.dbConnect();
			st = conn.prepareStatement(insertSql);
			st.setInt(1, board.getId());
			st.setString(2, content);
			int result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}
    	board.setComments(findByBoardId(board.getId()));
    }
    
    public List<CommentDTO> findByBoardId(int boardId) {
    	Connection conn = null;
    	Statement st = null;
    	ResultSet rs = null;

    	String sql = "select * from comments where board_id = " + boardId;
    	List<CommentDTO> list = new ArrayList<>();
    	try {
    		conn = DBUtil.dbConnect();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				CommentDTO dto = new CommentDTO(rs.getInt("ID"), rs.getInt("BOARD_ID"), rs.getString("CONTENT"));
				list.add(dto);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
    	return list;
    }

    public boolean deleteComment(BoardDTO board, int commentId) {
//    	boolean contains = false;
//    	List<CommentDTO> commList = board.getComments();
//    	int i;
//    	for (i = 0; i < commList.size(); i++) {
//    		if (commList.get(i).getId() == commentId) {
//    			contains = true;
//    			break;
//    		}
//    	}
//    	if (!contains) return false;
//    	commList.remove(i);
//    	
    	String sql = "delete from comments where id = " + commentId;
    	
    	Connection conn = null;
    	Statement st = null;
    	try {
    		conn = DBUtil.dbConnect();
			st = conn.createStatement();
			st.executeQuery(sql);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}
    	
        return true;
    }

    public boolean updateComment(BoardDTO board, int commentId, String newContent) {
    	String sql = "update comments set content = '" + newContent + "' where id = " + commentId;
    	
    	Connection conn = null;
    	Statement st = null;
    	try {
    		conn = DBUtil.dbConnect();
			st = conn.createStatement();
			st.executeQuery(sql);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}
    	
        return true;
        
    }
}