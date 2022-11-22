package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskDao;
import model.Task;

@WebServlet("/")
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private TaskDao taskdao;
	
	public void init() {
		taskdao = new TaskDao();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String action = request.getServletPath();
		try {
			switch(action) {
			
			case "/new":
			viewTask(request,response);
			break;
			
			case "/insert":
				insertTask(request,response);
				break;
				
			case "/delete":
				deleteTask(request,response);
				break;
				
			case "/edit":
				editTask(request,response);
				break;
				
			case "/update":
				updateTask(request,response);
				break;
				
			case "/select":
				selectdata(request,response);
				break;

			case "/view":
				viewdata(request,response);
				break;

			case "/list":
				listTask(request,response);
				break;

			default:
				home(request,response);
				break;
			}
		}catch(SQLException e) {
			throw new ServletException(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void listTask(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<Task> listTask = taskdao.PeekTask();
		request.setAttribute("listTask", listTask);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void editTask(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		Task existingTask = taskdao.viewtask(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
		request.setAttribute("task", existingTask);
		dispatcher.forward(request, response);
	}
	
	private void viewTask(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertTask(HttpServletRequest request, HttpServletResponse response) throws Exception,SQLException,IOException, ServletException{
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String education = request.getParameter("education");
		String photo = request.getParameter("photo");
		Task newTask = new Task(name, email, address, phone, city, country, education, photo);
		taskdao.insertTask(newTask);
		response.sendRedirect("list");
	}
	
	private void updateTask (HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String education = request.getParameter("education");
		String photo = request.getParameter("photo");
		Task book = new Task(id, name, email, address, phone, city, country, education, photo);
		taskdao.updateTask(book);
		response.sendRedirect("list");
	}
	
	private void deleteTask (HttpServletRequest request, HttpServletResponse response)throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		taskdao.deleteTask(id);
		response.sendRedirect("list");

	}
	
	private void selectdata(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException, ServletException {
		response.setContentType("image/gif");
		RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
		dispatcher.forward(request, response);
	}
	
	private void viewdata(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		Task existingTask = taskdao.selectData(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
		request.setAttribute("task", existingTask);
		dispatcher.forward(request, response);
	}
	
	private void home(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,ServletException{
		response.sendRedirect("index.jsp");
	}
	
	

}
