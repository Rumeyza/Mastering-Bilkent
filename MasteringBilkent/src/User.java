
public class User {

    private static int ID = 0;

    private int userId = 0;
    private String userName = "";
    private String userSurname = "";
    private String userPassword = "";
    private String userEmail = "";
    private String UserInstitution = "";
    private String UserTitle = "";

    public User() {
        userId = ID++;
        userName = "Furkan Arif";
        userSurname = "Bozdağ";
        userPassword = "12345";
        userEmail = "bozdag.arif@gmail.com";
        UserInstitution = "Bilkent University";
        UserTitle = "Undergraduate Student";
    }

    public User(String name, String surname, String pass, String email, String inst, String title) {
        this.userId = ID++;
        this.userName = name;
        this.userSurname = surname;
        this.userPassword = pass;
        this.userEmail = email;
        this.UserInstitution = inst;
        this.UserTitle = title;
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
        return UserInstitution;
    }

    public void setUserInstitution(String userInstitution) {
        UserInstitution = userInstitution;
    }

    public String getUserTitle() {
        return UserTitle;
    }

    public void setUserTitle(String userTitle) {
        UserTitle = userTitle;
    }
}
