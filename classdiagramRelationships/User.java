class User extends Login {
    private int user_id;
    private int department_id;
    private String user_name;
    private Gender user_gender;
    private String user_email;
    private RoleUser user_role;

    
    public User() {}

    public int getUser_id() { return user_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }

    public String getUser_name() { return user_name; }
    public void setUser_name(String user_name) { this.user_name = user_name; }

    public Gender getUser_gender() { return user_gender; }
    public void setUser_gender(Gender gender) { this.user_gender = gender; }

    public RoleUser getUser_role() { return user_role; }
    public void setUser_role(RoleUser role) { this.user_role = role; }

    public String getUser_email() { return user_email; }
    public void setUser_email(String user_email) { this.user_email = user_email; }
}

class Login {
    private String username;
    private String password;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}