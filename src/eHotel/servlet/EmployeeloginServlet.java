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

public class EmployeeloginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		//		employee account = new employee();

		String username = req.getParameter("eSSN");
		String pwd = req.getParameter("ePwd");

		PostgreSqlConn con = new PostgreSqlConn();
		String pwdfromdb = con.getpwdbyUname(Integer.parseInt(username));

		System.out.println(req.getAttribute("ePwd"));
		String pwdfromdbM=con.getpwdbyUnameMgr(Integer.parseInt(username));

		String eInfo=con.getEmpInfoBySSN(Integer.parseInt(username));
		
		ArrayList<Room> availableRooms=con.getAllAvailRoomsEmp(Integer.parseInt(username));
		

		boolean flag= con.isManager(Integer.parseInt(username));

		if(flag==true) {
			String eInfoMgr=con.getMgrInfoBySSN(Integer.parseInt(username));
			
			if(pwd.equals(pwdfromdbM)) {
				System.out.println("success");
				req.setAttribute("employee_id", username);
				req.setAttribute("employee_name", eInfoMgr);
				
				req.setAttribute("isManager", flag);
				req.setAttribute("allAvailRooms", availableRooms);

				
				req.getRequestDispatcher("login_success.jsp").forward(req,resp);

				return;			
				
			}
			
		}

		else if(flag==false) {

			if (pwd.equals(pwdfromdb)) {			
				System.out.println("success");
				req.setAttribute("employee_id", username);
				req.setAttribute("employee_name", eInfo);
				
				req.setAttribute("isManager", flag);
				req.setAttribute("allAvailRooms", availableRooms);

				

				req.getRequestDispatcher("login_success.jsp").forward(req,resp);

				return;			
			}
		}
		resp.sendRedirect("login_failure.jsp");
		return;
	}
}