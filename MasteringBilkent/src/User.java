/**
 * Created by Asus on 21.4.2017.
 */
public class User {

    private static int ID = 0;

    private int userId = 0;
    private String userName = "";
    private String userSurname = "";
    private String userPassword = "";
    private String userEmail = "";
    private String userInstitution = "";
    private String userDepartment = "";
    private String userTitle = "";

    public User() {
        userId = ID++;
        userName = "Furkan Arif";
        userSurname = "BozdaÄŸ";
        userPassword = "12345";
        userEmail = "bozdag.arif@gmail.com";
        userInstitution = "Bilkent University";
        userDepartment = "CS";
        userTitle = "Undergraduate";
    }

    public User(String name, String surname, String pass, String email, String inst, String dept, String title) {
        this.userId = ID++;
        this.userName = name;
        this.userSurname = surname;
        this.userPassword = pass;
        this.userEmail = email;
        this.userInstitution = inst;
        this.userDepartment = dept;
        this.userTitle = title;
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        User.ID = ID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }
}
