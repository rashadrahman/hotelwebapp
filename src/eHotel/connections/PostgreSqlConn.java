
package eHotel.connections;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import eHotel.entities.Room; 


public class  PostgreSqlConn{

	Connection db =  null; 
	PreparedStatement ps = null;
	ResultSet rs = null;
	Statement st = null;
	String sql;


	public void getConn(){

		try {

			Class.forName("org.postgresql.Driver"); 

			db = DriverManager.getConnection("jdbc:postgresql://web0.site.uottawa.ca:15432/anguy116",
					"anguy116", "Anuget3174");
			if(db!=null) {
				System.out.println("DATABASE CONNECTED");
			}

		}catch(Exception e) {
			System.out.print("error catched");
		}

	}

	public void closeDB() {
		try {
			if(rs != null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(st!=null){
				st.close();
			}
			if(db!=null){
				db.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public String getpwdbyUname(int param){
		getConn();

		String pwd = "";

		try{
			ps = db.prepareStatement("select password from hotelappdb.employee where SSN='"+param+"'");

			rs = ps.executeQuery();


			while(rs.next()) {
				pwd = rs.getString("password");
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return pwd;       
	}
	
	public String getpwdbyUnameMgr(int param){
		getConn();

		String pwd = "";

		try{
			ps = db.prepareStatement("select password from hotelappdb.manager where mgrSSN='"+param+"'");

			rs = ps.executeQuery();


			while(rs.next()) {
				pwd = rs.getString("password");
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return pwd;       
	}


	public boolean isManager(int param) {
		getConn();
		boolean flag=false;

		try {
			ps=db.prepareStatement("select * from hotelappdb.manager where mgrssn='"+param+"' ");
			
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				flag=true;
			}
			
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}finally {
			closeDB();
		}



		return flag;


		}


public String[] getuserinforbycustSSN(int param){
	getConn();

	String[] pwd = new String[2];



	try{
		ps = db.prepareStatement("select * from hotelappdb.customer where SSN='"+param+"'");
		rs = ps.executeQuery();
		while(rs.next()) {
			pwd[0] = rs.getString("password");
			pwd[1] = rs.getString("name");
		}

	}catch(SQLException e){
		e.printStackTrace();
	}finally {
		closeDB();
	}
	return pwd;       
}

public String getEmpInfoBySSN(int param){
	getConn();

	String pwd="";


	try{
		ps = db.prepareStatement("select * from hotelappdb.employee where SSN='"+param+"'");
		rs = ps.executeQuery();
		while(rs.next()) {
			
			pwd = rs.getString("name");
		}

	}catch(SQLException e){
		e.printStackTrace();
	}finally {
		closeDB();
	}
	return pwd;       
}
public String getMgrInfoBySSN(int param){
	getConn();

	String pwd="";


	try{
		ps = db.prepareStatement("select * from hotelappdb.manager where mgrSSN='"+param+"'");
		rs = ps.executeQuery();
		while(rs.next()) {
			
			pwd = rs.getString("name");
		}

	}catch(SQLException e){
		e.printStackTrace();
	}finally {
		closeDB();
	}
	return pwd;       
}


public boolean insertNewCustomer(String[] param){
	getConn();


	try{
		st = db.createStatement();
		sql = "insert into HOTELAPPDB.customer values('"+param[0]+"','"+param[1]+"','"+param[2]+"','"+param[3]+"','"+param[4]+"','"+param[5]+"','"+param[6]+"')";

		System.out.print(sql);

		st.executeUpdate(sql);

		return true;

	}catch(SQLException e){
		e.printStackTrace();
		return false;
	}finally {
		closeDB();
	}	       
}

public  ArrayList<Room> getAllAvailRooms(){

	getConn();

	ArrayList<Room> Rooms = new ArrayList<Room>();

	try {
		ps = db.prepareStatement("SELECT * FROM hotelappdb.room NATURAL JOIN hotelappdb.hotel WHERE room.hotel_id=hotel.hotel_id AND room.available=true" );
		rs = ps.executeQuery();
		while(rs.next()){
			Integer room_no = rs.getInt("room_num");
			boolean room_status = rs.getBoolean("available");
			String room_city = rs.getString("city");
			String view=rs.getString("rview");
			int price=rs.getInt("price");
			boolean extend=rs.getBoolean("isextendable");
			int capacity=rs.getInt("capacity");
			String damages=rs.getString("damages");
			String amenities=rs.getString("amenities");
			int hotel_id=rs.getInt("hotel_id");
			Room room = new Room(Integer.toString(room_no), Boolean.toString(room_status), room_city,price,extend,capacity,damages,amenities,hotel_id);
			//String room_no, String room_status, String room_city,int price,boolean isextendable,int capacity,String capcity,String damages,String amenities,boolean available,int hotel_id
			Rooms.add(room);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		closeDB();
	}

	return Rooms;

}

public  ArrayList<Room> getAllAvailRoomsEmp(int param){

	getConn();

	ArrayList<Room> Rooms = new ArrayList<Room>();

	try {
		ps = db.prepareStatement("SELECT * FROM hotelappdb.room NATURAL JOIN hotelappdb.employee WHERE room.hotel_id=employee.hotel_id AND employee.ssn='"+param+"'" );
		rs = ps.executeQuery();
		while(rs.next()){
			Integer room_no = rs.getInt("room_num");
			boolean room_status = rs.getBoolean("available");
			String room_city = rs.getString("city");
			String view=rs.getString("rview");
			int price=rs.getInt("price");
			boolean extend=rs.getBoolean("isextendable");
			int capacity=rs.getInt("capacity");
			String damages=rs.getString("damages");
			String amenities=rs.getString("amenities");
			int hotel_id=rs.getInt("hotel_id");
			Room room = new Room(Integer.toString(room_no), Boolean.toString(room_status), room_city,price,extend,capacity,damages,amenities,hotel_id);
			//String room_no, String room_status, String room_city,int price,boolean isextendable,int capacity,String capcity,String damages,String amenities,boolean available,int hotel_id
			Rooms.add(room);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		closeDB();
	}

	return Rooms;

}


public  ArrayList<Room> getbookedRooms(String custSSN){

	getConn();

	ArrayList<Room> Rooms = new ArrayList<Room>();

	try {
		ps = db.prepareStatement("select * from hotelappdb.room natural join hotelappdb.customer natural join hotelappdb.booking where customer.SSN='"+custSSN+"' and customer.ssn=booking.ssn and room.room_num=booking.room_num");
		rs = ps.executeQuery();
		while(rs.next()){
			Integer room_no = rs.getInt("room_num");
			boolean room_status = rs.getBoolean("available");
			String room_city = rs.getString("city");
			String view=rs.getString("rview");
			int price=rs.getInt("price");
			boolean extend=rs.getBoolean("isextendable");
			int capacity=rs.getInt("capacity");
			String damages=rs.getString("damages");
			String amenities=rs.getString("amenities");
			int hotel_id=rs.getInt("hotel_id");
			Room room = new Room(Integer.toString(room_no), Boolean.toString(room_status), room_city,price,extend,capacity,damages,amenities,hotel_id);
			Rooms.add(room);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		closeDB();
	}

	return Rooms;


}

public String bookRoom(int custName, String roomno){
	getConn();
	String custSSN="";

	try{

		ps = db.prepareStatement("select SSN from hotelappdb.customer where SSN='"+custName+"'");
		rs = ps.executeQuery();

		while(rs.next()){
			custSSN = rs.getString("SSN");
		}


		st = db.createStatement();
		sql = "update hotelappdb.room set room_status='booked' where room_no='"+roomno+"'";
		st.executeUpdate(sql);


		return custSSN;

	}catch(SQLException e){
		e.printStackTrace();
		return "";	 
	}finally {
		closeDB();
	}

}

public ArrayList<String> chains(){
	getConn();
	ArrayList<String>chains = new ArrayList<String>();
	try{

		ps = db.prepareStatement("select distinct chain_name from hotelappdb.hotel_chain");
		rs = ps.executeQuery();
		
		while(rs.next()){
			chains.add(rs.getString("chain_name"));
			System.out.print(rs.getString("chain_name"));
		}

		return chains;

	}catch(SQLException e){
		e.printStackTrace();
		return chains;	 
	}finally {
		closeDB();
	}

}


public ArrayList<Room> search(String city, int capacity, double price){
	getConn();
	ArrayList<Room> result = new ArrayList<Room>();
	
	try {
		ps = db.prepareStatement("select * from hotelappdb.hotel natural join hotelappdb.room where hotel.city = '"+city+"'and room.price='"+price+"'and room.capacity='"+capacity+"' and room.hotel_id=hotel.hotel_id");
		
		rs = ps.executeQuery();
		
		while(rs.next()) {
			Integer room_no = rs.getInt("room_num");
			boolean room_status = rs.getBoolean("available");
			String room_city = rs.getString("city");
			String view=rs.getString("rview");
			double price1=rs.getDouble("price");
			boolean extend=rs.getBoolean("isextendable");
			int capacity1=rs.getInt("capacity");
			String damages=rs.getString("damages");
			String amenities=rs.getString("amenities");
			int hotel_id=rs.getInt("hotel_id");
			Room room = new Room(Integer.toString(room_no), Boolean.toString(room_status), room_city,price,extend,capacity,damages,amenities,hotel_id);
			result.add(room);
			
		}
	
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		closeDB();
	}
	
	return result;
	
	
}



//		public static void main(String []args) {
//			PostgreSqlConn con = new PostgreSqlConn();
//			con.getConn();
//			String pwd = con.getpwdbyUname("8366341");
//			
//			System.out.println(pwd);
//				
//			
//			
//		}


}

