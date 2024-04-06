import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    
    static LinkedList<Users> users = new LinkedList<>();
    static Users customer;

    public static void main(String[] args) {
        display();
        main();
    }

    public static void main() {

        while (true) {
            customer = new Users();
            displayMenu();
        
            try {
                System.out.print("Enter Here: ");
                int choice = sc.nextInt();
    
                switch (choice) {
                    
                    case 1:
                        deleteAccount();
                        break;
                    case 2:
                        createAccount();
                        break;
                    case 3:
                        displayAll();
                        break;
                    case 4:
                        String firstNameChecker;
                        System.out.println("=================");
                        System.out.print("Enter First Name: "); firstNameChecker = sc.next();
                        
                        int j = 0;
                        for(Users temp:users){
                            if (firstNameChecker.equals(temp.getFirstName()) && j < 10) {
                                System.out.println("=================");
                                System.out.println(temp.adminGetFullName());
                                System.out.println(temp.getUserID());
                                j++;
                            }
                        }
                        System.out.println("None or no more results found");
                        break;
                    default:
                        System.out.println("\nInvalid Choice. Enter a number from 1-4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice. Enter a number.");
                sc.next(); 
            }
        }
    }        

    //Display Functions
    public static void display() {
        System.out.println("\r\n" + //
        "██████╗░░█████╗░███╗░░██╗██╗░░██╗  ░█████╗░░█████╗░░█████╗░░█████╗░██╗░░░██╗███╗░░██╗████████╗\r\n" + //
        "██╔══██╗██╔══██╗████╗░██║██║░██╔╝  ██╔══██╗██╔══██╗██╔══██╗██╔══██╗██║░░░██║████╗░██║╚══██╔══╝\r\n" + //
        "██████╦╝███████║██╔██╗██║█████═╝░  ███████║██║░░╚═╝██║░░╚═╝██║░░██║██║░░░██║██╔██╗██║░░░██║░░░\r\n" + //
        "██╔══██╗██╔══██║██║╚████║██╔═██╗░  ██╔══██║██║░░██╗██║░░██╗██║░░██║██║░░░██║██║╚████║░░░██║░░░\r\n" + //
        "██████╦╝██║░░██║██║░╚███║██║░╚██╗  ██║░░██║╚█████╔╝╚█████╔╝╚█████╔╝╚██████╔╝██║░╚███║░░░██║░░░\r\n" + //
        "╚═════╝░╚═╝░░╚═╝╚═╝░░╚══╝╚═╝░░╚═╝  ╚═╝░░╚═╝░╚════╝░░╚════╝░░╚════╝░░╚═════╝░╚═╝░░╚══╝░░░╚═╝░░░");
    }

    public static void displayMenu() {
        System.out.println("\t\t\t\t╔════════════════════════════╗");
        System.out.println("\t\t\t\t║       Bank Main Menu       ║");
        System.out.println("\t\t\t\t╠════════════════════════════╣");
        System.out.println("\t\t\t\t║ 1. Login                   ║");
        System.out.println("\t\t\t\t║ 2. Create New Account      ║");
        System.out.println("\t\t\t\t║ 3. Admin                   ║");
        System.out.println("\t\t\t\t║ 4. Exit                    ║");
        System.out.println("\t\t\t\t╚════════════════════════════╝");
    }

    public static void createAccountMenu() {
        System.out.println("\t\t\t\t╔════════════════════════════╗");
        System.out.println("\t\t\t\t║       Create Account       ║");
        System.out.println("\t\t\t\t╚════════════════════════════╝");
    }

    public static void typeOfAccount() {
        System.out.println("\t\t\t\t╔════════════════════════════╗");
        System.out.println("\t\t\t\t║    Choose your Account     ║");
        System.out.println("\t\t\t\t╠════════════════════════════╣");
        System.out.println("\t\t\t\t║ 1. Savings Account         ║");
        System.out.println("\t\t\t\t║ 2. Checking Account        ║");
        System.out.println("\t\t\t\t║ 3. Credit Account          ║");
        System.out.println("\t\t\t\t╚════════════════════════════╝");
    }

    public static void accountSummaryDisplay() {
        System.out.println("\t\t\t\t╔════════════════════════════╗");
        System.out.println("\t\t\t\t║       Account Summary      ║");
        System.out.println("\t\t\t\t╚════════════════════════════╝");
    }

    //Program Functions
    public static void createAccount() {
        boolean notMatch = true; int type = 0; boolean invalid = true;
        createAccountMenu();
            
        System.out.println();
        System.out.println("=================================");
        System.out.println("Please complete the following\n");
        System.out.print("Enter First Name: "); String firstName = sc.next();
        System.out.print("Enter Middle Name: "); String middleName = sc.next();
        System.out.print("Enter Last Name: "); String lastName = sc.next();
        System.out.print("Enter Birth Date (DD/MM/YYYY): "); String birthDate = sc.next();
        System.out.print("Enter Phone Number: "); String phoneNumber = sc.next();
        System.out.print("Enter Address: "); String address = sc.next();
        System.out.println();
        System.out.print("Create A Username: "); String username = sc.next();
        System.out.print("Create A Password: "); String pass = sc.next();

        while (notMatch) {
            System.out.print("Re-Enter Your Password: "); String pass2 = sc.next();

            if (pass.equals(pass2)) {
                System.out.println("\nPassword Created!");
                typeOfAccount();
                notMatch = false;
            } 
            else {
                System.out.println("\nPasswords do not match. Please Try Again");
            } 
        }
        
        while (invalid) {
            System.out.print("Choose Account Type (1-3): "); String check = sc.next();
            if (check.equals("1") || check.equals("2")) {
                type = Integer.parseInt(check);
                invalid = false;
            } 
            else {
                System.out.println("\nInvalid Input. Please Try Again.");
            }
        }
        
        customer.setFullName(firstName, middleName, lastName);
        customer.setBDay(birthDate);
        customer.setPhoneNumber(phoneNumber);
        customer.setAddress(address);
        customer.setUsername(username);
        customer.setPassword(pass);
        customer.setAccountType(type);

        users.add(customer);
        System.out.println("\nAccount Successfully Created!");
        System.out.println();

        accountSummaryDisplay();

        for(Users temp : users){
            if (firstName.equals(temp.getFirstName())) {
                System.out.println("Account Number: " + temp.getUserID());
                System.out.println("Account Name: " + temp.adminGetFullName());
                System.out.println("Username: " + temp.getUsername());
                System.out.println("Password: " + temp.getPassword());
                System.out.println("Birth Date: " + temp.getBDay());
                System.out.println("Phone Number: " + temp.getPhoneNumber());
                System.out.println("Address: " + temp.getAddress());
                System.out.println("Account Type: " + temp.displayType(temp.getAccountType()));
                System.out.println();
            }
        }
    }

    public static void adminCheck() {
        System.out.println();
        System.out.println("=================================");
    }

    public static void displayAll() {
        for (Users temp : users) {
            System.out.println();
            System.out.println("=================================");
            System.out.println("Account Number: " + temp.getUserID());
            System.out.println("Account Name: " + temp.adminGetFullName());
            System.out.println("Username: " + temp.getUsername());
            System.out.println("Birth Date: " + temp.getBDay());
            System.out.println("Phone Number: " + temp.getPhoneNumber());
            System.out.println("Address: " + temp.getAddress());
            System.out.println("Account Type: " + temp.displayType(temp.getAccountType()));
            System.out.println();
        }

        if (users.isEmpty()) {
            System.out.println();
            System.out.println("=================================");
            System.out.println("No Accounts Found.");
        }
    }

    public static void deleteAccount() {
        boolean found = false;
        System.out.print("Enter Account Number Of The Account To Delete: "); String accountNumber = sc.next();
    
        for (int i = 0; i < users.size(); i++) {
            Users temp = users.get(i);
            if (temp.getUserID().equals(accountNumber)) {
                users.remove(i);
                System.out.println("Account Deleted.");
                found = true;
                break;
            }
        }
    
        if (!found) {
            System.out.println("No Account Found with the given account number.");
        }
    }
}
