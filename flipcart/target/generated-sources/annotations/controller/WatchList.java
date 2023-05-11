package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.WatchListDao;
import entity.WatchListEntity;
import listener.DataBase;

/**
 * Servlet implementation class WatchList
 */
public class WatchList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private Gson gson;
	private WatchListDao dao;
	
   	public void init() {
    		gson = new Gson();
    		dao = new WatchListDao();
    
    	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		DataBase db = (DataBase) context.getAttribute("DataBase");
		Connection c = db.getConnection();
		try {
			WatchListEntity watchList = gson.fromJson(request.getReader(), WatchListEntity.class);
			String s = dao.addProducts(c, watchList);
			PrintWriter out = response.getWriter();
			if(s.equalsIgnoreCase("Done")){
				String json = gson.toJson(watchList);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8") ;
				out.print(json);
				out.flush();
			}
			else {
				out.print(s);
				out.flush();
			}
			out.close();
		}
		finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
