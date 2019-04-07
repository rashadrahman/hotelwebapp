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

public class CustomerloginServlet extends HttpServlet {

	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
//		employee account = new employee();
		String custSSN = req.getParameter("custSSNL");
		
		
		
		String custPwd = req.getParameter("custPwdL");
		
		
		PostgreSqlConn con = new PostgreSqlConn();
//		[0]:pwd,[1]:name
		
		
		
		String[] pwdfromdb = con.getuserinforbycustSSN(Integer.parseInt(custSSN));
		
		
		
		
		if (custPwd.equals(pwdfromdb[0])) {			
			
			ArrayList<Room> bookedRooms = con.getbookedRooms(custSSN);
			ArrayList<String> chains = con.chains();
			if (chains.isEmpty()) {
				System.out.print("chain list null");
			}
			System.out.print("chain list not null");
			
			ArrayList<Room> allRooms = con.getAllAvailRooms();
			
			req.setAttribute("chains", chains);
			req.setAttribute("CustName", pwdfromdb[1]);
			req.setAttribute("bookedRooms", bookedRooms);
			req.setAttribute("allRooms", allRooms);

			req.getRequestDispatcher("booking.jsp").forward(req, resp);
			return;	
		}
		resp.sendRedirect("login_failure.jsp");
		return;
	}
}