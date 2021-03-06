package javastud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javastud.model.Student;

public class StudentDaoImpl extends DB implements StudentDao {

	// INSERT INTO `student` (`name`, `roll_no`, `phone_no`, `gender`, `email`,`address`, `college_name`) VALUES (?, ?, ?, ?,?,?, ?)

	@Override
	public void saveStudent(Student stud) throws Exception {

		Connection conn = getDBConnection();

		String sql = "INSERT INTO `student` (`name`, `family_name`, `roll_no`, `phone_no`, `gender`, `email`, `address`, `college_name`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, stud.getName());
		stat.setString(2, stud.getFamilyname());
		stat.setString(3, stud.getRollNo());
		stat.setString(4, stud.getPhoneNo());
		stat.setString(5, stud.getGender());
		stat.setString(6, stud.getEmail());
		stat.setString(7, stud.getAddress());
		stat.setString(8, stud.getCollegeName());
		             
		stat.executeUpdate();
		conn.close();

	}
	@Override
	public void resetStudent() throws Exception {

		Connection conn = getDBConnection();
		String sql = "DELETE FROM `studentdb`.`student`;  ";
		PreparedStatement stat = conn.prepareStatement(sql);	
		stat.executeUpdate();
		conn.close();

	}
	@Override
	public void deleteStudent(Student stud) throws Exception {

		Connection conn = getDBConnection();
//		System.out.println("reached StudentDaoImpl");
		String sql = "DELETE FROM `studentdb`.`student` WHERE `roll_no` =\'"+ stud.getRollNo() +"\';   ";
		PreparedStatement stat = conn.prepareStatement(sql);	
		stat.executeUpdate();
		conn.close();

	}

	@Override
	public List<Student> getAllStudents() throws Exception{

		Connection conn=getDBConnection();
		List<Student> studlist=new ArrayList<>();
		Statement stat =conn.createStatement();
		ResultSet rs = stat.executeQuery("select * from student");
		while (rs.next()){
			Student stud = new Student();
			stud.setId(rs.getLong("id"));
			stud.setName(rs.getString("name"));
			stud.setFamilyname(rs.getString("family_name"));
			stud.setRollNo(rs.getString("roll_no"));
			stud.setPhoneNo(rs.getString("phone_no"));
			stud.setGender(rs.getString("gender"));
			stud.setEmail(rs.getString("email"));
			stud.setAddress(rs.getString("address"));
			stud.setCollegeName(rs.getString("college_name"));
			studlist.add(stud);
			
		}
		conn.close();
		return studlist;
		
	}

}
