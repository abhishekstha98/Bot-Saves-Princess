package javastud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDaoImpl extends DB implements UserDao{

	@Override
	public boolean validateUser(String username, String password) {
		try{
			Connection conn = getDBConnection();
			Statement stat = conn.createStatement();
			
			String sql="select * from `user1` where `username` = '"  + username +  " ' and `password`= '"  + password +  "';";
			
			ResultSet rs= stat.executeQuery(sql);
			
			return rs.next();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean validateUser1(String RollNo) {
		// TODO Auto-generated method stub
		try{
			Connection conn = getDBConnection();
			Statement stat = conn.createStatement();
			String sql="select * from `user1` where `roll_no` = '"  +RollNo+  "';";
			
			ResultSet rs= stat.executeQuery(sql);
			
			return rs.next();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public void ChangePassword(String Username,String Password) {
		// TODO Auto-generated method stub
		try{
			Connection conn = getDBConnection();
//			Statement stat = conn.createStatement();
			String sql="UPDATE `studentdb`.`user1` SET `password` = \'"+Password+"\' WHERE `username` = \'"+Username+"\';   ";
			PreparedStatement stat = conn.prepareStatement(sql);	
			stat.executeUpdate();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
