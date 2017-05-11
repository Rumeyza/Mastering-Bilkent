package Storage;

//SQL imports:
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ApplicationLogic.*;
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
	/*public void createTableUser() throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE User(id int NOT NULL AUTO_INCREMENT, name varchar(64) NOT NULL, surname varchar(64) NOT NULL, password varchar(64) NOT NULL, email varchar(64) NOT NULL, institution varchar(128), department varchar(64), title varchar(64), PRIMARY KEY(id))");
			
			create.executeUpdate();
		}catch(Exception e){System.out.println(e);}
	}*/
	
	//creations
	public void createTableInstructor() throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE Instructor (i_id int NOT NULL AUTO_INCREMENT, i_name varchar(64) NOT NULL, i_surname varchar(64) NOT NULL, i_password varchar(64) NOT NULL, i_email varchar(64) NOT NULL, i_institution varchar(128), i_department varchar(64), i_role varchar(64), i_title varchar(64), PRIMARY KEY(i_id))");
			//String name, String surname, String pass, String email, String inst, String dept, String role, String title
			create.executeUpdate();
	} catch(Exception e){System.out.println(e);}
	}

	public void createTableStudent() throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE Student(s_id int NOT NULL AUTO_INCREMENT, s_name varchar(64) NOT NULL, s_surname varchar(64) NOT NULL, s_password varchar(64) NOT NULL, s_email varchar(64) NOT NULL, s_institution varchar(128), s_department varchar(64), s_role varchar(64), s_title varchar(64), s_schoolYear varchar(64), s_semester varchar(64), PRIMARY KEY(s_id))");
																					
			create.executeUpdate();
	} catch(Exception e){System.out.println(e);}
	}

	public void createTableCourse() throws Exception{
		try{
			Connection con = getConnection();
			
			PreparedStatement create = con.prepareStatement("CREATE TABLE Course(course_id int NOT NULL AUTO_INCREMENT, courseName varchar(255) NOT NULL, instr varchar(128), courseKey varchar(64), visibility boolean NOT NULL DEFAULT TRUE, PRIMARY KEY(course_id))");
																														

			create.executeUpdate();
		} catch(Exception e){System.out.println(e);}
	}
	public void createTableGives() throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE Gives(course_id int NOT NULL, i_id int NOT NULL, PRIMARY KEY(course_id, i_id), FOREIGN KEY(course_id) REFERENCES Course(course_id), FOREIGN KEY(i_id) REFERENCES Instructor(i_id))");
			
			create.executeUpdate();
		}catch(Exception e){System.out.println(e);}
	}
	public void createTableTakes() throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE Takes(course_id int NOT NULL, s_id int NOT NULL, PRIMARY KEY(course_id, s_id), FOREIGN KEY(course_id) REFERENCES Course(course_id), FOREIGN KEY(s_id) REFERENCES Student(s_id))");
			
			create.executeUpdate();
		}catch(Exception e){System.out.println(e);}
	}
//insertions
	public void insertToCourse(String contentName, String instr, String key, boolean v) throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement insert  = con.prepareStatement("INSERT INTO Course (courseName, instr, courseKey, visibility) VALUES ('" +contentName+ "', '" +instr+ "', '" +key+ "' , "+v+")");
			//PreparedStatement insert2  = con.prepareStatement("INSERT INTO Gives (courseName, instr, courseKey, visibility) VALUES ('" +contentName+ "', '" +instr+ "', '" +key+ "' , "+v+")");												
			
			insert.executeUpdate();
			//insert2.executeUpdate();
		} catch(Exception e){System.out.println(e);}
	}
	
	public int givesCourseId(String contentName)throws Exception{
		
		int id;
		try{
			Connection con = getConnection();
			PreparedStatement gives = con.prepareStatement("SELECT course_id FROM Course WHERE courseName = '"+contentName+"'");
			ResultSet result = gives.executeQuery();
			if(result.next()){
				id = result.getInt("course_id");
				return id;
			}
				
		} catch(Exception e){System.out.println(e);}
		return 0;
	}
	
	public int givesInstructorId(String name)throws Exception{
			
			int id;
			try{
				Connection con = getConnection();
				PreparedStatement gives = con.prepareStatement("SELECT i_id FROM Instructor WHERE i_name = '"+name+"'");
				ResultSet result = gives.executeQuery();
				if(result.next()){
					id = result.getInt("i_id");
				return id;
			}
					
		} catch(Exception e){System.out.println(e);}
		return 0;
	}
	
	public int givesInstructorId(String email, String pass)throws Exception{
		
		int id;
		try{
			Connection con = getConnection();
			PreparedStatement gives = con.prepareStatement("SELECT i_id FROM Instructor WHERE i_email = '"+email+"' AND i_password = '"+pass+"'");
			ResultSet result = gives.executeQuery();
			if(result.next()){
				id = result.getInt("i_id");
					return id;
			}
				
		} catch(Exception e){System.out.println(e);}
		return -1;
	}
		
	public void insertToCourse(String contentName, String instr, boolean v){
			
		try {
			Connection con = getConnection();
			PreparedStatement insert  = con.prepareStatement("INSERT INTO Course (courseName, instr,visibility) VALUES ('" +contentName+ "','" +instr+ "',"+v+")");
				
			insert.executeUpdate();
		} catch (Exception e) {System.out.println(e);}
			
	}
	public void insertToCourse(String contentName, String instr){
		
		try {
			Connection con = getConnection();
			PreparedStatement insert  = con.prepareStatement("INSERT INTO Course (courseName, instr) VALUES ('" +contentName+ "','" +instr+ "'");
			
			insert.executeUpdate();
		} catch (Exception e) {System.out.println(e);}
		
	}


	public void insertToInstructor(String name, String surname, String pass, String email, String inst, String dept, String role, String title) throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement insert  = con.prepareStatement("INSERT INTO Instructor (i_name, i_surname, i_password, i_email, i_institution, i_department, i_role, i_title) VALUES ('"+name+"', '"+surname+"', '"+pass+"', '"+email+"', '"+inst+"', '"+dept+"','"+role+"' ,'"+title+"')");

			insert.executeUpdate();
		} catch(Exception e){System.out.println(e);}
	}

	public void insertToStudent(String name, String surname, String pass, String email, String inst, String dept, String role, String title, String schoolYear, String semester) throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement insert  = con.prepareStatement("INSERT INTO Student (s_name, s_surname, s_password, s_email, s_institution, s_department, s_role, s_title, s_schoolYear, s_semester) VALUES ('"+name+"', '"+surname+"', '"+pass+"', '"+email+"', '"+inst+"', '"+dept+"', '"+role+"', '"+title+"', '"+schoolYear+"', '"+semester+"')");

			insert.executeUpdate();
		} catch(Exception e){System.out.println(e);}
	}
	
	public boolean isExisting(String email, String password){
    	try{
    		Connection con = getConnection();
    		PreparedStatement statement = con.prepareStatement("SELECT s_email, s_password FROM student");
    		
    		ResultSet result = statement.executeQuery();
    		
    		//ArrayList<String> arrlist = new ArrayList<String>();
    		
    		while(result.next()){
    			System.out.print(result.getInt("id"));
    			System.out.println( " ");
    			System.out.println(result.getString("email"));
    			
    			if(result.getString("s_email") == email && result.getString("s_password") == password)
    				return true;
    			
    			//arrlist.add(result.getString("email"));
    		}
    		return false;
    		//System.out.println("selection complete.");
    		
    		//return arrlist;
    	}catch(Exception e){ System.out.println(e);}
    	return false;
    }
	
	public Student getStudent(String email, String password) throws Exception{
		Student student;
		
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM student WHERE s_email = '"+email+"' AND s_password = '"+password+"'" );
		ResultSet result = statement.executeQuery();
		
		if(result.next()){
			
				student = new Student(result.getString("s_name"), result.getString("s_surname"), result.getString("s_password"), result.getString("s_email"), result.getString("s_institution"), result.getString("s_department"), result.getString("s_role"), result.getString("s_title"), result.getString("s_schoolYear"), result.getString("s_semester"));
				return student;

		}
		
		
		return null;
	}
	public Instructor getInstructor(String email, String password) throws Exception{
		Instructor instructor;
		
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM instructor WHERE i_email = '"+email+"' AND i_password = '"+password+"'" );
		ResultSet result = statement.executeQuery();
		
		if(result.next()){
			
				instructor = new Instructor(result.getString("i_name"), result.getString("i_surname"), result.getString("i_password"), result.getString("i_email"), result.getString("i_institution"), result.getString("i_department"), result.getString("i_role"), result.getString("i_title"));
				return instructor;

		}
		return null;
	}
	
	/*public Course getCourse(String courseName, String key) throws Exception{
		Course course;
		Connection con = getConnection();
		
		PreparedStatement statement = con.prepareStatement("SELECT * FROM course WHERE courseName = '"+courseName+"' AND courseKey = '"+key+"'" );
		ResultSet result = statement.executeQuery();
		
		if(result.next()){
			course = new Course(result.getString("courseName"), result.getString("instr"), result.getString("courseKey"), result.getBoolean("visibility"));
			return course;
		}
		return null;
		
	}*/
	
	public Course getCourse(String courseName) throws Exception{
		Course course;
		Connection con = getConnection();
		
		PreparedStatement statement = con.prepareStatement("SELECT * FROM course WHERE courseName = '"+courseName+"'" );
		ResultSet result = statement.executeQuery();
		
		if(result.next()){
			course = new Course(result.getString("courseName"), result.getString("instr"), result.getString("courseKey"), result.getBoolean("visibility"));
			return course;
		}
		return null;
		
	}
	
	
	/*public ArrayList<String> getAllCourses() throws Exception{
		try{
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT courseName, instr FROM course");

		ResultSet result = statement.executeQuery();

		ArrayList<String> array = new ArrayList<String>();
		while(result.next()){
			String str = result.getString("courseName") + " "+ result.getString("instr");

			array.add(str);
		}
		return array;
	}catch(Exception e){System.out.println(e);}
	return null;
	}*/
	public ArrayList<Course> getAllCourses() throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT courseName FROM course");
	
			ResultSet result = statement.executeQuery();
	
			ArrayList<Course> courseList = new ArrayList<Course>();
			while(result.next()){
				String crsName = result.getString("courseName");
				//String crsKey = result.getString("courseKey");
				
				Course course = getCourse(crsName);
				courseList.add(course);
			}
			return courseList;
		}catch(Exception e){System.out.println(e);}
		return null;
	}
	
	public ArrayList<Course> getRegisteredCourses(int student_id) throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT courseName FROM Course WHERE course_id IN (SELECT course_id FROM Takes WHERE s_id = "+student_id+")");
	
			ResultSet result = statement.executeQuery();
	
			ArrayList<Course> courseList = new ArrayList<Course>();
			while(result.next()){
				String crsName = result.getString("courseName");
				//String crsKey = result.getString("courseKey");
				
				Course course = getCourse(crsName);
				courseList.add(course);
			}
			return courseList;
		}catch(Exception e){System.out.println(e);}
		return null;
	}
	
	public ArrayList<Course> getGivenCourses(int instructor_id) throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT courseName FROM Course WHERE course_id IN (SELECT course_id FROM Gives WHERE i_id = "+instructor_id+")");
	
			ResultSet result = statement.executeQuery();
	
			ArrayList<Course> courseList = new ArrayList<Course>();
			while(result.next()){
				String crsName = result.getString("courseName");
				//String crsKey = result.getString("courseKey");
				
				Course course = getCourse(crsName);
				courseList.add(course);
			}
			return courseList;
		}catch(Exception e){System.out.println(e);}
		return null;
	}


}



