package com.Rahul;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class RequestDao {
	String url="jdbc:mysql://localhost:3306/crud";
	String username="root";
	String password="";
	
	String insert="INSERT INTO details (name,email,address) VALUES(?,?,?)";
	String update="UPDATE details SET name=?,email=?,addess=? WHERE id=?;";
	String display="SELECT * FROM details";
	String delete="DELETE FROM details WHERE id=?;";
	String search="SELECT id,name,email,address FROM details WHERE id=?";
	
	public void insertData(User user) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			java.sql.PreparedStatement st=con.prepareStatement(insert);
			st.setString(1, user.getName());
			st.setString(2,user.getEmail());
			st.setString(3, user.getAddress());
			int res=st.executeUpdate();
			if(res==1) {
				System.out.println("Data Added");
			}
			else {
				System.out.println("Data Not Added");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean updateData(User user) {
		boolean rowUpdated=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			java.sql.PreparedStatement st=con.prepareStatement(update);
			st.setString(1,user.getName());
			st.setString(2, user.getEmail());
			st.setString(3, user.getAddress());
			st.setInt(4, user.getId());
			rowUpdated=st.executeUpdate()>0;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}
	
	public User searchData(int id) {
		User user=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			java.sql.PreparedStatement st=con.prepareStatement(search);
			st.setInt(1, id);
			System.out.println(st);
			java.sql.ResultSet rs=st.executeQuery();
			while(rs.next()) {
				int i=user.getId();
				String name=user.getName();
				String email=user.getEmail();
				String address=user.getAddress();
				user=new User(i,name,email,address);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public void deleteData(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			java.sql.PreparedStatement st=con.prepareStatement(delete);
			st.setInt(1,id);
			st.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList displayAllUser() {
		ArrayList<User> list=new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			java.sql.PreparedStatement st=con.prepareStatement(display);
			java.sql.ResultSet rs=st.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
				list.add(user);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
