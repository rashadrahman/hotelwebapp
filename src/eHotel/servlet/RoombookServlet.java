package eHotel.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.PostgreSqlConn;
import eHotel.entities.Room;
import eHotel.entities.employee;

public class RoombookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
//		employee account = new employee();
		String city = req.getParameter("roomcity");
		int capacity = new Integer(req.getParameter("roomcap"));
		double price = new Double(req.getParameter("roomprice"));
		
		
		
		PostgreSqlConn con = new PostgreSqlConn();

		
		
		String userSSN = "abc";
		
		
//		[0]:name,[1]:pwd
//		String[] pwdfromdb = con.getuserinforbycustSSN(userSSN);
//		
//		
//		
		if (userSSN.length()!=0) {			
			
			//ArrayList<Room> bookedRooms = con.getbookedRooms(userSSN);
			ArrayList<Room> resultRooms = con.search(city,capacity,price);
			
			
			
			req.setAttribute("results", resultRooms);
			req.setAttribute("CustName", city);
			req.setAttribute("Ccapacity", capacity);
			req.setAttribute("Cprice", price);
			
			
			
			

			req.getRequestDispatcher("searchResults.jsp").forward(req, resp);
			return;	
		}
		
	
		return;

	}
}