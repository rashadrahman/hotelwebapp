<%@page import="java.util.ArrayList"%>
<%@page import="eHotel.entities.Room"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Loginsuccess</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Language" content="ch-cn">
</head>
<body>
<%
String employee_id = (String)request.getAttribute("employee_id");
%>

<%
String employee_name =(String)request.getAttribute("employee_name");
%>
<%
	boolean isManager=(Boolean) request.getAttribute("isManager");
	String extra="";
	if (isManager==true){
		extra="(Manager)";
	}
%>

	<h4>Welcome <%=employee_name %> <%=extra%><h4>
	</h4>Employee SSN: <%=employee_id%><h4>
	</h4>Convert Room to Renting<h4></h4>
	<select name = "roomno">
					<%
						Object obj = request.getAttribute("allAvailRooms");
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
	
	
</body>
</html>
