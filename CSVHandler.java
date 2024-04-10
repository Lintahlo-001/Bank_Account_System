import java.io.*;
import java.util.*;

public class CSVHandler {
    public static LinkedList<Users> readUsersFromCSV (String filename) {
        LinkedList<Users> users = new LinkedList<>();

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String [] fields = line.split(",");

                String accountNumber = fields[0];
                String firstName = fields[1];
                String middleName = fields[2];
                String lastName = fields[3];
                String birthDate = fields[4];
                String phoneNumber = fields[5];
                String address = fields[6];
                String username = fields[7];
                String password = fields[8];
                int accountType = Integer.parseInt(fields[9]);
                double initialBalance = Double.parseDouble(fields[10]);

                Users user = new Users();
                user.setUserID(accountNumber);
                user.setFullName(firstName, middleName, lastName);
                user.setBDay(birthDate);
                user.setPhoneNumber(phoneNumber);
                user.setAddress(address);
                user.setAccountType(accountType);
                user.setUsername(username);
                user.setPassword(password);
                user.setBalance(initialBalance);
                users.add(user);
            }
        } catch (FileNotFoundException e) {
            System.err.println("CSV file not found: " + filename);
        }

        return users;
    }

    public static void writeUsersToCSV(String filename, LinkedList<Users> users) {
        try (PrintWriter writer = new PrintWriter(new File(filename))) {
            for (Users user : users) {
                String line = userToCSVLine(user);
                writer.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error writing to CSV file: " + filename);
        }
    }

    private static String userToCSVLine(Users user) {
        return user.getUserID() + "," + user.getFirstName() + "," + user.getMiddleName() + "," + user.getLastName()
                + "," + user.getBDay() + "," + user.getPhoneNumber() + ","
                + user.getAddress() + ","
                + user.getUsername() + "," + user.getPassword() + "," + user.getAccountType() + "," + user.getBalance();
    }
}