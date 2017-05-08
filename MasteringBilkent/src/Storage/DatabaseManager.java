package Storage;

//SQL imports:
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class DatabaseManager {
		
	public Connection getConnection() throws Exception{
  	
  	try{
  		String driver = "com.mysql.jdbc.Driver";
  		String url = "jdbc:mysql://localhost:3306/masteringbilkentdb";
  		String username = "ertanaday";
  		String password = "ertanmbdpass";
  		
  		Class.forName(driver);
  		
  		Connection conn = DriverManager.getConnection(url, username, password);
  		
  		System.out.println( "connected.");
  		return conn;
  	}catch(Exception e){System.out.println(e);}
  	return null;
  }
	
	//creations
	public void createTableInstructor() throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE Instructor (i_id int NOT NULL, i_name varchar(64) NOT NULL, i_surname varchar(64) NOT NULL, i_password varchar(64) NOT NULL, i_email varchar(64) NOT NULL, i_institution varchar(128), i_department varchar(64), i_title varchar(64), PRIMARY KEY(i_id))");

			create.executeUpdate();
	} catch(Exception e){System.out.println(e);}
	}

	public void createTableStudent() throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE Student(s_id int NOT NULL, s_name varchar(64) NOT NULL, s_surname varchar(64) NOT NULL, s_password varchar(64) NOT NULL, s_email varchar(64) NOT NULL, s_institution varchar(128), s_department varchar(64), s_title varchar(64), s_schoolYear varchar(64), s_semester varchar(64), PRIMARY KEY(s_id))");
																								//String name, String surname, String pass, String email, String inst, String dept, String role, String title,
																										//String schoolYear, String semester

			create.executeUpdate();
	} catch(Exception e){System.out.println(e);}
	}

	public void createTableCourse() throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE Course(course_id int NOT NULL, i_id int NOT NULL, courseType varchar(50) NOT NULL, courseKey varchar(50), courseName varchar(50) NOT NULL, PRIMARY KEY(i_id, course_id))");

			create.executeUpdate();
		} catch(Exception e){System.out.println(e);}
	}

//insertions
	public void insertToCourse(int id, String visibility, String key, int c_id, String name) throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement insert  = con.prepareStatement("INSERT INTO Course (course_id, i_id, courseType, courseKey, courseName) VALUES (" +c_id+ "," +id+ ", '" +visibility+ "', '" +key+ "', '" +name+ "')");

			insert.executeUpdate();
		} catch(Exception e){System.out.println(e);}
	}


	public void insertToInstructor(int id, String name, String surname, String pass, String email, String inst, String dept, String title) throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement insert  = con.prepareStatement("INSERT INTO Instructor (i_id, i_name, i_surname, i_password, i_email, i_institution, i_department, i_title) VALUES ("+id+", '"+name+"', '"+surname+"', '"+pass+"', '"+email+"', '"+inst+"', '"+dept+"', '"+title+"')");

			insert.executeUpdate();
		} catch(Exception e){System.out.println(e);}
	}

	public void insertToStudent(int id, String name, String surname, String pass, String email, String inst, String dept, String title, String schoolYear, String semester) throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement insert  = con.prepareStatement("INSERT INTO Student (s_id, s_name, s_surname, s_password, s_email, s_institution, s_department, s_title, s_schoolYear, s_semester) VALUES ("+id+", '"+name+"', '"+surname+"', '"+pass+"', '"+email+"', '"+inst+"', '"+dept+"', '"+title+"', '"+schoolYear+"', '"+semester+"')");

			insert.executeUpdate();
		} catch(Exception e){System.out.println(e);}
	}

}



