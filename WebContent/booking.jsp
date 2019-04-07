<%@page import="java.util.ArrayList"%>
<%@page import="eHotel.entities.Room"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Page</title>
</head>
<body>

	<%
		String CustName = (String) request.getAttribute("CustName");
	%>
	<form method="post" action="roombook">
		<h4>
			Welcome,
			<%=CustName%><h4>
				<h4>Here are the room(s) you booked</h4>
				<ul>
					<%
						Object obj1 = request.getAttribute("bookedRooms");
						
						ArrayList<Room> broomList = null;
						if (obj1 instanceof ArrayList) {
							broomList = (ArrayList<Room>) obj1;
						}
						if (broomList != null) {
							for (Room room : broomList) {
								String roominfo = room.getRoom_no() + "---" + room.getRoom_status();
					%>
					<li><%=roominfo%></li>
					<%
						}
						}
					%>
				</ul>
				<input type="hidden" name="custName" value="<%=CustName%>" />
				<h4>Here are avaiable rooms</h4>
				
				<%-- <%
					out.print("Available Rooms:");
				%> --%>
				<%-- <select name = "roomno">
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
				</select> --%>
				
				<br/>
				
				<%
					out.print("City:");
				%>
				
				<select name = "roomcity">
					<%
						Object obj2 = request.getAttribute("allRooms");
						ArrayList<Room> roomList1 = null;
						ArrayList<String> roomListB = null;
						roomListB = new ArrayList<String>();
						if (obj2 instanceof ArrayList) {
							roomList1 = (ArrayList<Room>) obj2;
						}
						if (roomList1 != null) {
							for (Room room : roomList1) {
								if (roomListB.contains(room.getRoom_city())){
									//nothing
								} else{
									roomListB.add(room.getRoom_city());
								}
							}
							
							for (String city : roomListB){
								
								/* String roominfo = room.getRoom_no() + "---" + room.getRoom_status(); */
					%>					
						<option><%=city%></option>

					<%
						}
						}
					%>
				</select>
				
				
				
				<br/>
				
				<%
					out.print("Price: ");
				%>
				<select name="roomprice">
					<%
						Object obj3 = request.getAttribute("allRooms");
						request.setAttribute("custName","hi");
						ArrayList<Room> roomList2 = null;
						ArrayList<Double> roomListA = null;
						roomListA = new ArrayList<Double>();
						if (obj3 instanceof ArrayList) {
							roomList2 = (ArrayList<Room>) obj3;
						}
						if (roomList2 != null) {
							for (Room room : roomList2) {
								Double check = new Double(room.getPrice());
								if (roomListA.contains(check)){
									//nothing
								} else{
									roomListA.add(check);
								}
							}
							
							for (Double price : roomListA){
								
								/* String roominfo = room.getRoom_no() + "---" + room.getRoom_status(); */
					%>
					<option><%=price%></option>

					<%
						}
									}
					%>
				</select> <br />
				<%
					out.print("Capacity: ");
				%>

				<select name="roomcap">
					<%
						Object obj4 = request.getAttribute("allRooms");
						ArrayList<Room> roomList3 = null;
						ArrayList<Integer> roomListC = null;
						roomListC = new ArrayList<Integer>();
						if (obj4 instanceof ArrayList) {
							roomList3 = (ArrayList<Room>) obj4;
						}
						if (roomList3 != null) {
							for (Room room : roomList3) {
								Integer check = new Integer(room.getCapacity());
								if (roomListC.contains(check)) {
									//nothing
								} else {
									roomListC.add(check);
								}
							}

							for (Integer price : roomListC) {

								/* String roominfo = room.getRoom_no() + "---" + room.getRoom_status(); */
					%>
					<option><%=price%></option>

					<%
						}
						}
					%>
				</select>
				<br>
				
				<%
					out.print("Hotel Chain: ");
				%>
				<select name="roomchain">
					<%
						Object obj5 = request.getAttribute("chains");
						//request.setAttribute("custName","hi");
						ArrayList<String> roomList5 = null;
						
						if (obj5 instanceof ArrayList) {
							roomList5 = (ArrayList<String>) obj5;
						}
						if (roomList5 != null) {
							
							for (String chainname : roomList5){
								
								/* String roominfo = room.getRoom_no() + "---" + room.getRoom_status(); */
					%>
					<option><%=chainname%></option>

					<%
						}
									}
					%>
				</select> <br />
				
				<br>
				
				<button type="submit" value="Submit">Search</button>
				</form>


</body>