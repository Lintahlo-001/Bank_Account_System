import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("#,##0");
    
    static LinkedList<Users> users = new LinkedList<>();
    static Users customer;
    static Admin admin = new Admin();

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
                        break;
                    case 2:
                        createAccount();
                        break;
                    case 3:
                        System.out.println();
                        System.out.println("=================================");
                        System.out.print("Enter Password: "); String adminPass = sc.next();

                        if (adminCheck(adminPass)) {
                            adminMenu(); 
                        }
                        else {
                            System.out.println("Incorrect Password.\n");
                        }
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\nInvalid Choice. Enter a number from 1-4.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice. Enter a number.\n");
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
        System.out.println("\t\t\t\t╚════════════════════════════╝");
        System.out.println("Minimum Initial Deposit:");
        System.out.println("Savings: 3,000\nChecking: 10,000");
    }

    public static void accountSummaryDisplay() {
        System.out.println("\t\t\t\t╔════════════════════════════╗");
        System.out.println("\t\t\t\t║       Account Summary      ║");
        System.out.println("\t\t\t\t╚════════════════════════════╝");
    }

    public static void adminMenuDisplay() {
        System.out.println("\t\t\t\t╔════════════════════════════╗");
        System.out.println("\t\t\t\t║           Admin            ║");
        System.out.println("\t\t\t\t╠════════════════════════════╣");
        System.out.println("\t\t\t\t║ 1. Search                  ║");
        System.out.println("\t\t\t\t║ 2. Display All Accounts    ║");
        System.out.println("\t\t\t\t║ 3. Delete An Account       ║");
        System.out.println("\t\t\t\t║ 4. Change Admin Password   ║");
        System.out.println("\t\t\t\t║ 5. Return To Main Menu     ║");
        System.out.println("\t\t\t\t╚════════════════════════════╝");
    }

    public static void searchOptions() {

    }

    //Program Functions
    public static void createAccount() {
        boolean notMatch = true; int type = 0; boolean invalid = true; double deposit = 0; boolean insufficient = true;
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
            System.out.print("Choose Account Type (1-2): "); String check = sc.next();
            if (check.equals("1") || check.equals("2")) {
                type = Integer.parseInt(check);
                invalid = false;
            } 
            else {
                System.out.println("\nInvalid Input. Please Try Again.");
            }
        }
        
        while (minimumCheck(deposit, type)) {
            insufficient = true;
            try {
                System.out.print("\nInput Initial Deposit: "); deposit = sc.nextDouble();
            } catch (Exception e) {
                System.out.println("Invalid Input. Only Enter Numbers.\n");
                sc.next();
                insufficient = false;
            }

            if (!minimumCheck(deposit, type)) {
                break;
            }
            else if (insufficient) {
                System.out.println("Invalid Amount. Please Try Again.");
            }
        }
        
        customer.setFullName(firstName, middleName, lastName);
        customer.setBDay(birthDate);
        customer.setPhoneNumber(phoneNumber);
        customer.setAddress(address);
        customer.setUsername(username);
        customer.setPassword(pass);
        customer.setAccountType(type);
        customer.setInitialBalance(deposit);

        users.add(customer);
        System.out.println("\nAccount Successfully Created!");
        System.out.println();

        accountSummaryDisplay();

        for(Users temp : users){
            if (firstName.equals(temp.getFirstName())) {
                System.out.println("Account Number: " + temp.getUserID());
                System.out.println("Account Name: " + temp.getFullName());
                System.out.println("Username: " + temp.getUsername());
                System.out.println("Password: " + temp.getPassword());
                System.out.println("Birth Date: " + temp.getBDay());
                System.out.println("Phone Number: " + temp.getPhoneNumber());
                System.out.println("Address: " + temp.getAddress());
                System.out.println("Account Type: " + temp.displayType(temp.getAccountType()));
                System.out.println("Balance: " + df.format(temp.getBalance()));
                System.out.println();
            }
        }
    }

    public static boolean minimumCheck(double deposit, int type) {
        if (type == 1) {
            if (deposit >= 3000) {
                return false;
            }
        } 
        else if (type == 2) {
            if (deposit >= 10000) {
                return false;
            }
        }
        return true;
    }

    public static boolean adminCheck(String pass) {
        if (pass.equals(admin.getPass())) {
            System.out.println("Logged In!\n");
            return true;
        }

        return false;
    }

    public static void adminMenu() {
        boolean notMatch = true;
        while (true) {
            adminMenuDisplay();
            System.out.println();
            System.out.println("=================================");
            
            try {
                System.out.print("Enter Choice: "); int choice = sc.nextInt();
        
                    switch (choice) {
                        
                        case 1:
                            
                            break;
                        case 2:
                            displayAll();
                            break;
                        case 3:
                            deleteAccount();
                            break;
                        case 4:
                            System.out.println();
                            System.out.print("Enter New Password: "); String pass = sc.next();

                            while (notMatch) {
                                System.out.print("Re-Enter Your Password: "); String pass2 = sc.next();
                    
                                if (pass.equals(pass2)) {
                                    System.out.println("\nPassword Changed!");
                                    notMatch = false;
                                } 
                                else {
                                    System.out.println("\nPasswords do not match. Please Try Again");
                                } 
                            }
                            admin.setPass(pass);
                            break;
                        case 5:
                            System.out.println();
                            main();
                            break;
                        default:
                            System.out.println("\nInvalid Choice. Enter a number from 1-5.\n");
                    }
            } catch (Exception e) {
                System.out.println("\nInvalid Choice. Enter a number.\n");
                sc.next(); 
            }
        }
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
            System.out.println("Balance: " + df.format(temp.getBalance()));
            System.out.println();
        }

        if (users.isEmpty()) {
            System.out.println();
            System.out.println("=================================");
            System.out.println("No Accounts Found.\n");
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
                System.out.println();
                found = true;
                break;
            }
        }
    
        if (!found) {
            System.out.println("No Account Found with the given account number.");
            System.out.println();
        }
    }
}