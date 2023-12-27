package com.hcl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
	// Method to establish a database connection 
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","balaji");
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return connection;
	}
	
	// Method to save the employee record to the database
	public static int save(Emp e) {
		int status = 0;
		try {
			Connection connection = EmpDao.getConnection();
			PreparedStatement ps = connection.prepareStatement("insert into user907(name,password,email,country)values(?,?,?,?)");
			
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCountry());
			
			status = ps.executeUpdate();
			
			connection.close();
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		return status;
	}
	
	// Method to update employee record in the database
	public static int update(Emp e) {
		int status = 0;
		try {
			Connection connection = EmpDao.getConnection();
			PreparedStatement ps = connection.prepareStatement("Update user907 set name=?,password=?,email=?,country=? where id=?");
			
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCountry());
			ps.setInt(5, e.getId());
			
			status = ps.executeUpdate();
			
			connection.close();
		}
		catch(Exception e2) {
			e2.printStackTrace();
		}
		return status;
	}
	
	// Method to delete employee record from the database
	public static int delete(int id) {
		int status = 0;
		try {
			Connection connection = EmpDao.getConnection();
			PreparedStatement ps = connection.prepareStatement("delete from user907 where id=?");
			
			ps.setInt(1, id);
			
			status = ps.executeUpdate();
			
			connection.close();
		}
		catch(Exception e3) {
			e3.printStackTrace();
		}
		return status;
	}
	
	// Method to retrieve employee record by ID from the database
	public static Emp getEmployeeById(int id) {
		Emp e = new Emp();
		
		try {
			Connection connection = EmpDao.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from user907 where id=?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {	
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
			}
			connection.close();
		}
		catch(Exception e4) {
			e4.printStackTrace();
		}
		return e;
	}
	
	// Method to retrieve all employees records from the database 
	public static List<Emp> getAllEmployee(){
		List<Emp> list = new ArrayList<Emp>();
		
		try {
			Connection connection = EmpDao.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from user907");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Emp e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
				list.add(e);
			}
			connection.close();
		}
		catch(Exception e5) {
			e5.printStackTrace();
		}
		return list;
	}
	

}
