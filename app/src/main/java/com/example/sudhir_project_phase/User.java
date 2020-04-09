public class User {
    private String id;
    private String email;
    private String phone;
    private String  gender;
    private String password;
    private String username;

    public User(String id, String email, String phone, String gender, String password, String username) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.password = password;
        this.username = username;
    }
}
