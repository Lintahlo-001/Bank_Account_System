public class Admin {
    private String password;

    public Admin() {
        password = "admin123";
    }
    
    // Setters
    public void setPass(String pass) {
        this.password = pass;
    }

    // Getters
    public String getPass() {
        return this.password;
    }
}