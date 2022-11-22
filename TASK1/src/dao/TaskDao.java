package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Task;

public class TaskDao {

	private String jdbcURL = "jdbc:mysql://localhost:3306/myjavacode?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";
	
	private static final String INSERT_SQL = "insert into task (name,email,address,phone,city,country,education,photo) values (?,?,?,?,?,?,?,?);";
	private static final String SELECT_SQL = "select name,email,address,phone,city,country,education from task where id =?";
	private static final String SELECT_PEEK_SQL ="select id, name, date, city from task ";
	private static final String DELETE_SQL = "delete from task where id =?;";
	private static final String UPDATE_SQL = "update task set name=?, email=?, address=?, phone=?, city=?, country=?, education=?, photo=? where id=?;";
	private static final String VIEW_SQL = "select name, email, address, phone, city, country, education, photo from task where id=?;";
	
	public TaskDao() {
	}
	
	protected Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void insertTask(Task task) throws Exception {
		try(Connection con = getConnection();
				PreparedStatement pstm = con.prepareStatement(INSERT_SQL)){
			pstm.setString(1, task.getName());
			pstm.setString(2, task.getEmail());
			pstm.setString(3, task.getAddress());
			pstm.setString(4, task.getPhone());
			pstm.setString(5, task.getCity());
			pstm.setString(6, task.getCountry());
			pstm.setString(7, task.getEducation());
			String img = task.getPhoto();
			File file = new File(img);
			FileInputStream fis = new FileInputStream(file);
			int len = (int)file.length();
			pstm.setBinaryStream(8, (InputStream)fis,len);
			System.out.println(pstm);
			pstm.executeUpdate();			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public Task viewtask (int id) {
		Task task = null;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_SQL);) {
			statement.setInt(1, id);
			System.out.println(statement);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String city = rs.getString("city");
				String country = rs.getString("country");
				String education = rs.getString("education");
				task = new Task (id, name, email, address, phone, city, country, education);
			}
			}catch (SQLException e) {
				printSQLException(e);
			}
			return task;
	} 
	
	public List<Task> PeekTask() throws SQLException{
		List<Task> task = new ArrayList<>();
		try(Connection con = getConnection();
				PreparedStatement pstm = con.prepareStatement(SELECT_PEEK_SQL);){
			System.out.println(pstm);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String date = rs.getString("date");
				String city = rs.getString("city");
				task.add(new Task(id,name,date,city));
				}	
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return task;
		}
	
	public boolean deleteTask(int id) throws Exception{
		boolean rowDeleted;
		try (Connection con = getConnection();
			PreparedStatement pstm = con.prepareStatement(DELETE_SQL);){
			pstm.setInt(1, id);
			rowDeleted = pstm.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	public boolean updateTask(Task task) throws Exception{
		boolean rowUpdate;
		try(Connection con = getConnection();
				PreparedStatement pstm = con.prepareStatement(UPDATE_SQL);){
			System.out.println("update task" + pstm);
			pstm.setString(1, task.getName()); //name, email, address, phone, city, country, education, photo
			pstm.setString(2, task.getEmail());
			pstm.setString(3, task.getAddress());
			pstm.setString(4, task.getPhone());
			pstm.setString(5, task.getCity());
			pstm.setString(6, task.getCountry());
			pstm.setString(7, task.getEducation());
			String img = task.getPhoto();
			File file = new File (img);
			FileInputStream fis = new FileInputStream(file);
			int len = (int)file.length();
			pstm.setBinaryStream(8, (InputStream)fis, len);
			pstm.setInt(9, task.getId());
			rowUpdate = pstm.executeUpdate() > 0;
		}
		return rowUpdate;
	}
	
	public Task selectData(int id) throws SQLException {
		Task task = null;
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(VIEW_SQL);){
			ps.setInt(1, id);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String city = rs.getString("city");
				String country = rs.getString("country");
				String education = rs.getString("education");
				Blob img = rs.getBlob("photo");
				byte image [] = img.getBytes(1, (int)img.length());
				task = new Task (id, name, email, address, phone, city, country, education, image);
			}
			}catch (SQLException e) {
				printSQLException(e);
			}return task;
			}
		
	private void printSQLException(SQLException ex) {
	for (Throwable e : ex) {
		if (e instanceof SQLException) {
			e.printStackTrace(System.err);
			System.err.println("SQLState: " + ((SQLException) e).getSQLState());
			System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
			System.err.println("Message: " + e.getMessage());
			Throwable t = ex.getCause();
			while (t != null) {
				System.out.println("Cause: " + t);
				t = t.getCause();
			}
		}
	}
}

}
	

