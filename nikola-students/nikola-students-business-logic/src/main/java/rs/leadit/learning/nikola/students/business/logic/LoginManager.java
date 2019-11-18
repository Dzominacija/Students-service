package rs.leadit.learning.nikola.students.business.logic;

import javax.enterprise.context.Dependent;

@Dependent
public class LoginManager {
    private static int counter = 0;
    private String username;
    private String password;

    public LoginManager() {
        System.out.println("Creating login manager " + ++counter);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Deleting login manager");
        super.finalize();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Checking if username and password are valid.
     *
     * @return true if username/password combination is valid
     */
    public boolean login() {
        System.out.println("Received request");
        String un = username;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String pw = password;

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Username and password are: " + un + "/" + pw);
        return "pera".equals(un) && "peraaaa".equals(pw);
    }
}
