package model.message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.client.ClientVO;
import model.common.JNDI;

public class MessageDAO {
	

	final static String sql_SELECT_ALL= "select * from message2 order by mnum desc"; 
	final static String sql_SELECT_ONE="select * from message2 where mnum=?";
	final static String sql_SELECT_USER="select * from message2 where userid=? order by mnum desc"; 
	final static String sql_INSERT="insert into message2(mnum,userid,title,content,wdate) values (nvl((select max(mnum) from message2),0)+1, ?, ?, ?, sysdate)";
	final static String sql_DELETE="delete from message2 where mnum=?"; 
	final static String sql_UPDATE="update message2 set title=?, content=?, wdate=sysdate where mnum=?";
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public MessageVO getDBData(MessageVO vo) {
		conn=JNDI.connect();
		System.out.println("selectone :"+vo.getMnum());
		try {
			pstmt=conn.prepareStatement(sql_SELECT_ONE);
			pstmt.setInt(1, vo.getMnum());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				vo.setMnum(rs.getInt("mnum"));
				vo.setUserid(rs.getString("userid"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWdate(rs.getDate("wdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return vo;
	}
	
	//====================================================
	public ArrayList<MessageVO> getDBList(ClientVO vo){
		ArrayList<MessageVO> datas = new ArrayList<MessageVO>();
		conn=JNDI.connect();
		System.out.println("getDBList :" +vo);
		try {
			if(vo == null ) {
				pstmt=conn.prepareStatement(sql_SELECT_ALL);
			}
			else{
				pstmt=conn.prepareStatement(sql_SELECT_USER);
				pstmt.setString(1, vo.getUserid());
			}
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {

				MessageVO data = new MessageVO();

				data.setMnum(rs.getInt("mnum"));
				data.setUserid(rs.getString("userid"));
				data.setTitle(rs.getString("title"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));

				datas.add(data);
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		System.out.println("mDAO selectAll : " + datas);
		return datas;

	}
	//====================================================

	public boolean m_insert(MessageVO vo) {
		conn=JNDI.connect();
		boolean flag=false;
		System.out.println("insert :" +vo);
		try {
			pstmt=conn.prepareStatement(sql_INSERT);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();

			flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return flag;
	}

	//====================================================
	public boolean m_delete(MessageVO vo) {
		conn=JNDI.connect();
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(sql_DELETE);
			pstmt.setInt(1, vo.getMnum());
			pstmt.executeUpdate();

			flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return flag;
	}

	//====================================================
	public boolean m_update(MessageVO vo) {
		conn=JNDI.connect();
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(sql_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getMnum());
			pstmt.executeUpdate();

			flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return flag;
	}
}
