package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.UserDao;
import entity.UserEntity;
import entity.WatchListReturnEntity;
import listener.DataBase;

/**
 * Servlet implementation class UserDetails
 */
public class UserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
     	private Gson gson;
    	private UserDao dao;
	
	
    	public void init() {
    		gson = new Gson();
    		dao = new UserDao();
    	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		DataBase db = (DataBase) context.getAttribute("DataBase");
		Connection c = db.getConnection();
	
		UserEntity user = gson.fromJson(request.getReader(), UserEntity.class);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8") ;
		if(user.getWatchListName()==null) {
			List<WatchListReturnEntity> list = dao.getAllDetails(c, user);
			String s = gson.toJson(list);
			out.print(s);
			out.flush();
		}
		else {
			List<String> list = dao.getDetailsByWatchListName(c, user);
			String s=gson.toJson(list);
			out.print(s);
			out.flush();
		}
		try {
			c.close();
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context = getServletContext();
		DataBase db = (DataBase) context.getAttribute("DataBase");
		Connection c = db.getConnection();
		UserEntity user = gson.fromJson(request.getReader(), UserEntity.class);
		boolean b = dao.addUser(c, user);
		PrintWriter out = response.getWriter();
		if(b) {
			String s = gson.toJson(user);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8") ;
			out.print(s);
			out.flush();
		}
		else {
			out.println("Already Exsists");
			out.flush();
		}
		try {
			c.close();
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}


}
