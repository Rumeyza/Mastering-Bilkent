package ApplicationLogic;

import Storage.DatabaseManager;
public class User {

    //private static int ID = 0;
	DatabaseManager dbms = new DatabaseManager();
    //private int userId = 0;
    private String userName = "";
    private String userSurname = "";
    private String userPassword = "";
    private String userEmail = "";
    private String userInstitution = "";
    private String userDepartment = "";
    private String userRole = "";
    private String userTitle = "";

    public User() {
       // userId = ID++;
        userName = "";
        userSurname = "";
        userPassword = "";
        userEmail = "";
        userInstitution ="";
        userDepartment ="";
        userRole = "";
        userTitle = "";
    }

    public User(String name, String surname, String pass, String email, String inst, String dept, String role, String title) {
      //  this.userId = ID++;
        this.userName = name;
        this.userSurname = surname;
        this.userPassword = pass;
        this.userEmail = email;
        this.userInstitution = inst;
        this.userDepartment = dept;
        this.userRole = role;
        this.userTitle = title;
    }

   /* public static int getID() {
        return ID;
    }*/

    /*public static void setID(int ID) {
        User.ID = ID;
    }*/

   /* public int getUserId() {
        return userId;
    }*/

    /*public void setUserId(int userId) {
        this.userId = userId;
    }*/

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserInstitution() {
        return userInstitution;
    }

    public void setUserInstitution(String userInstitution) {
        this.userInstitution = userInstitution;
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment;
    }
    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }
    public boolean enrollCourse(String contentName) throws Exception{

        try {
			dbms.insertToTakes(contentName, userName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return true;
    }
}
