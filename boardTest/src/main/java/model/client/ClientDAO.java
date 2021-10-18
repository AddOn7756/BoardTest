package model.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JNDI;

public class ClientDAO {
	
	final static String sql_LOGIN="select * from client where userid=? and pw=?"; 
	final static String sql_INSERT="insert into client values (?,?,?)"; 
	final static String sql_DELETE="delete from client where userid=?"; 
	final static String sql_UPDATE="update client set userid=?, pw=?, name=? where userid=?"; 
	final static String sql_CHECK = "select * from client where userid = ?";
	

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ClientVO login(ClientVO vo) {
		conn=JNDI.connect();

		ClientVO outvo = null;

		try {
			pstmt=conn.prepareStatement(sql_LOGIN);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getPw());
			rs=pstmt.executeQuery();
			if (rs.next()) { 
				outvo = new ClientVO();
				outvo.setUserid(rs.getString("userid"));
				outvo.setPw(rs.getString("pw"));
				outvo.setName(rs.getString("name"));
			} 
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return outvo;

	}
	//====================================================
	public boolean insert(ClientVO vo) { 
		conn=JNDI.connect();
		boolean flag=false;
		
		try {
			pstmt =conn.prepareStatement(sql_INSERT);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
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
	public boolean delete(ClientVO vo) { 
		conn=JNDI.connect();
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(sql_DELETE);
			pstmt.setString(1, vo.getUserid());
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
	public boolean update(ClientVO vo) { 
		conn=JNDI.connect();
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(sql_UPDATE);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getUserid());
			pstmt.executeUpdate();

			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}

		return flag;

	}
	//====================================================
	public boolean checkID(ClientVO vo) {

		conn = JNDI.connect();
		boolean flag=false;
		try {
			pstmt = conn.prepareStatement(sql_CHECK);
			pstmt.setString(1, vo.getUserid());

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				flag = true;
			}
			
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return flag;
	}

}
