import Model.Account;
import Model.Bank;
import Model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BankManagement {
    int accountNumber = 0;
    HashMap<Integer, Account> accountMap = new HashMap<>();
    HashMap<String, Customer> customerMap = new HashMap<>();
    ArrayList<Bank> bankList = new ArrayList<>();
    
    public Customer createNewCustomer() {
        // this method will create a new customer
        // 1. create new customer
        // 2. add new customer to customerMap with email as key
        Customer customer = new Customer();
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nCustomer name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Customer address: ");
        String address = scanner.nextLine().trim();

        System.out.print("Customer contact: ");
        String contact = scanner.nextLine().trim();

        System.out.print("Customer email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Customer password: ");
        String password = scanner.nextLine().trim();

        customer.setName(name);
        customer.setAddress(address);
        customer.setContact(contact);
        customer.setEmail(email);
        customer.setPassword(password);

        customerMap.put(email,customer);
        return customer;
    }

    public int bankChoice() {
        // this method will show all available bank out of which user will select one
        // this method will return choice number
        System.out.println();
        int index = 0;
        for (Bank bank : bankList) {
            System.out.println(index+". - Name: "+bank.getBankName()
                    +" | Branch Name: "+bank.getBranchName()
                    +" | IFSC: "+bank.getIFSC()
                    +" | Address: "+bank.getAddress());
            index++;
        }

        System.out.print("Select any branch: ");

        int choice;
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();

        return choice;
    }

    public void showAllAccount() {
        // this method will show all account of user
        for (Map.Entry<Integer, Account> accountEntry : accountMap.entrySet()) {
            System.out.println("\nAccount no: "+accountEntry.getValue().getAccount_no());
            System.out.println("Bank Name: "+accountEntry.getValue().getBank().getBankName());
            System.out.println("Branch Name: "+accountEntry.getValue().getBank().getBankName());
            System.out.println("IFSC code: "+accountEntry.getValue().getBank().getIFSC());
            System.out.println("Bank Address: "+accountEntry.getValue().getBank().getAddress());
            System.out.println("Name: "+accountEntry.getValue().getCustomer().getName());
            System.out.println("Contact: "+accountEntry.getValue().getCustomer().getContact());
            System.out.println("Email: "+accountEntry.getValue().getCustomer().getEmail());
            System.out.println("Address: "+accountEntry.getValue().getCustomer().getAddress());
            System.out.println("Current balance: "+accountEntry.getValue().getBalance());
        }
    }

    public void openAccount(Bank bank, Customer customer) {
        // this method will open a bank account
        // 1. ask what type of account to open i.e. Saving or Current
        System.out.println("1. Saving");
        System.out.println("2. Current");
        System.out.print("What type of account you want to open: ");
        int choice;
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        Account account = null;

        switch (choice) {
            case 1:
                // saving account
                account = new SavingAccount();
                break;
            case 2:
                // current account
                account = new CurrentAccount();
                break;
            default:
                System.out.println("Invalid choice");
        }
        // inheritance
        // abstraction
        // method overriding
        // hashmap
        // arraylist

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        if (account != null) {
            account.setBank(bank);
            account.setCustomer(customer);
            account.setBalance(initialBalance);
            account.setAccount_no(accountNumber);
            accountMap.put(accountNumber++, account);
        }
        System.out.println("\nAccount of "+customer.getName()+" created successfully");
    }

    public Map.Entry<Integer, Account> login(String email, String password) {
        // this method will authenticate user with provided email and password
        // 1. match email and password
        for (Map.Entry<Integer, Account> accountEntry : accountMap.entrySet()) {
            if (accountEntry.getValue()
                            .getCustomer()
                            .getEmail()
                            .trim()
                            .toLowerCase()
                            .equals(email) &&
                    accountEntry.getValue()
                            .getCustomer()
                            .getPassword()
                            .trim()
                            .toLowerCase()
                            .equals(password)) {
                return accountEntry;
            }
        }
        return null;
    }
    public void dashboard() {

        bankList.add(new Bank("BOB", "abc-road-bhuj", "college-road", "BANK01"));
        bankList.add(new Bank("BOB", "xyz-road-rajkot", "main-road", "BANK02"));
        bankList.add(new Bank("BOB", "pqr-road-rajkot", "random-road", "BANK03"));

        System.out.println("\n1. Open account");
        System.out.println("2. Delete account");
        System.out.println("3. View all account");
        System.out.println("4. Debit");
        System.out.println("5. Credit");
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        while (choice != 99) {
            switch (choice) {
                case 1:
                    // open account
                    // 1. create new customer object
                    // 2. associate newly create customer to available bank
                    //    for this show all available bank details
                    // 3. Open account ( saving or current )

                    Customer customer = createNewCustomer();
                    if (customer != null) {
                        System.out.println("Customer created successfully");
                    }
                    int bankChoiceIndex = bankChoice();
                    openAccount(bankList.get(bankChoiceIndex), customer);

                    break;
                case 2:
                    // delete account
                    // 1. ask user to enter account number
                    // 2. remove account from accountMap

                    System.out.print("\nEnter account number: ");
                    int accountNumber = scanner.nextInt();

                    if (accountMap.remove(accountNumber) == null) {
                        System.out.println("Delete account operation unsuccessful\n");
                    } else {
                        System.out.println("Delete account operation successful\n");
                    }
                    break;
                case 3:
                    // view all account
                    showAllAccount();
                    break;
                case 4:
                    // debit
                    System.out.print("Enter email: ");
                    scanner.nextLine();
                    String email = scanner.nextLine();
                    System.out.println("Enter Password: ");
//                    String password = System.console().readPassword().toString();
                    String password = scanner.nextLine();

                    Map.Entry<Integer, Account> customerAccount = login(email.trim().toLowerCase(), password.trim().toLowerCase());
                    if (customerAccount != null) {
                        System.out.println("\nLogin successful");
                        System.out.print("Enter amount to debit: ");
                        double amount = scanner.nextDouble();
                        int result = customerAccount.getValue().debit(amount);
                        if (result == 1) {
                            System.out.println("Debit operation successful");
                        } else {
                            System.out.println("Debit operation failed");
                        }
                    } else {
                        System.out.println("\nLogin unsuccessful");
                    }
                    break;
                case 5:
                    // credit
                    System.out.print("Enter email: ");
                    email = scanner.nextLine();
                    System.out.println("Enter Password: ");
                    password = scanner.nextLine();

                    customerAccount = login(email.trim().toLowerCase(), password.trim().toLowerCase());
                    if (customerAccount != null) {
                        System.out.println("\nLogin successful");
                        System.out.print("Enter amount to debit: ");
                        double amount = scanner.nextDouble();
                        int result = customerAccount.getValue().credit(amount);
                        if (result == 1) {
                            System.out.println("Debit operation successful");
                        } else {
                            System.out.println("Debit operation failed");
                        }
                    } else {
                        System.out.println("\nLogin unsuccessful");
                    }
                    break;
                default:
                    System.out.print("Invalid choice.");
                    break;
            }

            System.out.println("1. Open account");
            System.out.println("2. Delete account");
            System.out.println("3. View all account");
            System.out.println("4. Debit");
            System.out.println("5. Credit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
        }
    }
}
public class Main {
    public static void main(String[] args) {
        BankManagement bankManagement = new BankManagement();
        bankManagement.dashboard();
    }
}