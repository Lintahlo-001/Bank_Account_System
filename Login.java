import java.util.*;

public class Login {
    public static HashMap<String, String> createUserPassList(LinkedList<Users> users) {
        HashMap<String, String> accounts = new HashMap<String, String>();
        for (Users user : users) {
            accounts.put(user.getUsername(), user.getPassword());
        }

        return accounts;
    }

    public static Boolean checkUsername(String username) {
        HashMap<String, String> accounts = createUserPassList(CSVHandler.readUsersFromCSV("users.csv"));

        String key = accounts.get(username);
        if (key != null) return true;
        else return false;
    }

    public static Boolean checkPassword(String username, String password) {
        HashMap<String, String> accounts = createUserPassList(CSVHandler.readUsersFromCSV("users.csv"));

        String key = accounts.get(username);
        if (key.equals(password)) return true;
        else return false;
    }
}
