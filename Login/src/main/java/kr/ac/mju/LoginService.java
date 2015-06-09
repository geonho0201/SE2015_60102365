package kr.ac.mju;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
//	@Autowired
//	private LoginDAO loginDao;
//	private final static String URL= "jdbc:mysql://localhost:3306/lms";
//	private final static String ID= "sogong";
//	private final static String PASSWORD= "mju12345";
	private final static String URL= "jdbc:oracle:thin:@localhost:1521:xe";
	private final static String ID= "system";
	private final static String PASSWORD= "delab";
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, ID, PASSWORD);
	}
	
	private void closeConnection(Connection connection, Statement statement, ResultSet resultSet)throws SQLException{
		if(connection == null){
			return;
		}
		connection.close();
		statement.close();
		resultSet.close();
	}
	
	public void createAccount(String userDBID, String userDBPassword) throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = null;
		PreparedStatement statement = null;
		
		connection = DriverManager.getConnection(
//				"jdbc:mysql://localhost:3306",	
//				"root",
				"jdbc:oracle:thin:@localhost:1521:xe",
				"system",	
				"delab");
//		String accountSQL = "grant all privileges on *.* to sogong2@localhost"
//				+ "identified by 'mju12345' with grant option";
		String accountSQL = "grant connect,resource,unlimited tablespace to ? identified by ?";
		statement = connection.prepareStatement(accountSQL);
		statement.setString(1, userDBID);
		statement.setString(2, userDBPassword);
		statement.executeUpdate();
		statement.close();
		connection.close();
		System.out.println("계정 생성");
		System.out.println("id : "+ userDBID);
		System.out.println("password : "+userDBPassword);
	}
	
	public void createTable() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = null;
		PreparedStatement statement = null;
		
		connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe",
				"sogong2015",	
				"mju12345");
		String tableCreateSQL = "create table duser("
				+ "id varchar(12) not null, "
				+ "password varchar(12) not null, "
				+ "name varchar(12) not null, "
				+ "type varchar(12) not null)";
		statement = connection.prepareStatement(tableCreateSQL);
		statement.executeUpdate();
		statement.close();
		connection.close();
		System.out.println("테이블 생성");
	}
	
//	public void selectData(){
//		ArrayList<User> userList = (ArrayList<User>)userDao.selectUser();
//		
//		for(User user: userList){
//			System.out.println(user.getID() + 
//					". " + user.getPassword() + 
//					". " + user.getName());
//		}
//	}
	
	public void insertData() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = null;
		PreparedStatement statement = null;
		
		connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe",
				"sogong2015",	
				"mju12345");
		String sql0 = "INSERT INTO duser values('id0','pw0','name0','교수')";
		statement = connection.prepareStatement(sql0);
		statement.executeUpdate();
		String sql1 = "INSERT INTO duser values('id1','pw1','name1','교수')";
		statement = connection.prepareStatement(sql1);
		statement.executeUpdate();
		String sql2 = "INSERT INTO duser values('id2','pw2','name2','학생')";
		statement = connection.prepareStatement(sql2);
		statement.executeUpdate();
		String sql3 = "INSERT INTO duser values('id3','pw3','name3','학생')";
		statement = connection.prepareStatement(sql3);
		statement.executeUpdate();
		String sql4 = "INSERT INTO duser values('id4','pw4','name4','학생')";
		statement = connection.prepareStatement(sql4);
		statement.executeUpdate();
		statement.close();
		connection.close();
		System.out.println("데이터 입력 id0 ~ id4");
	}
	
	public void updateData() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = null;
		PreparedStatement statement = null;
		
		connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe",
				"sogong2015",	
				"mju12345");
		String tableCreateSQL = "update duser set id='id5',password='pw5',name='name5' where id='id0'";
		statement = connection.prepareStatement(tableCreateSQL);
		statement.executeUpdate();
		statement.close();
		connection.close();
		System.out.println("데이터 업데이트 id0 -> id5");
	}
	
	public void deleteId5() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = null;
		PreparedStatement statement = null;
		
		connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe",
				"sogong2015",	
				"mju12345");
		String tableCreateSQL = "delete from duser where id='id5'";
		statement = connection.prepareStatement(tableCreateSQL);
		statement.executeUpdate();
		statement.close();
		connection.close();
		System.out.println("데이터 삭제 id5");
	}
	
	public void dropTable() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = null;
		PreparedStatement statement = null;
		
		connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe",
				"sogong2015",	
				"mju12345");
		String tableCreateSQL = "drop table duser";
		statement = connection.prepareStatement(tableCreateSQL);
		statement.executeUpdate();
		statement.close();
		connection.close();
		System.out.println("테이블 삭제");
	}
	
	public void dropAccount() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = null;
		PreparedStatement statement = null;
		
		connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe",
				"system",	
				"delab");
		String dropSQL = "drop user sogong2015";
		statement = connection.prepareStatement(dropSQL);
		statement.executeUpdate();
		statement.close();
		connection.close();
		System.out.println("계정 삭제");
	}
	
	public void selectAll() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe",
				"sogong2015",	
				"mju12345");
		String dropSQL = "select * from duser";
		statement = connection.prepareStatement(dropSQL);
		resultSet = statement.executeQuery();
		System.out.println("select all from duser");
		while(resultSet.next()){
			System.out.println(resultSet.getString("id")+" "+resultSet.getString("password")+" "
					+resultSet.getString("name")+" "+resultSet.getString("type"));
		}
		
		statement.close();
		connection.close();
		resultSet.close();
		
	}
	
	public User login(String userID, String userPassword) throws FileNotFoundException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		// dao 호출
//		Class.forName("com.mysql.jdbc.Driver");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "select * from user";
		User user = null;
		
		connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe",
				"sogong2015",	
				"mju12345");
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				String id = resultSet.getString("id");
				String password = resultSet.getString("password");
				
				if(id.equals(userID) && password.equals(userPassword)){
					user = new User();
					user.setID(id);
					user.setName(resultSet.getString("name"));
					user.setPassword(password);
					closeConnection(connection, statement, resultSet);
					return user;
				}
			}
			
		closeConnection(connection, statement, resultSet);
		
		return null;
	}
}

