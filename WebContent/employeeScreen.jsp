<%@page import="java.util.ArrayList"%>
<%@page import="eHotel.entities.Room"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMPLOYEE PAGE</title>
</head>
<body>


	<form method="post" action="roombook">
		<h4>
			Welcome, Employee
				<h4>Convert to room(s) to renting:</h4>
				
				<select name = "roomno">
					<%
						Object obj = request.getAttribute("allRooms");
						ArrayList<Room> roomList = null;
						if (obj instanceof ArrayList) {
							roomList = (ArrayList<Room>) obj;
						}
						if (roomList != null) {
							for (Room room : roomList) {
								/* String roominfo = room.getRoom_no() + "---" + room.getRoom_status(); */
					%>					
						<option><%=room.getRoom_no()%></option>

					<%
						}
						}
					%>
				</select>
				
				<button type="submit" onclick="return confirm('book?');">Convert to renting</button>
				
				<h4>Convert booking to renting:</h4>
				
				
				
				
	</form>


</body>
</html>