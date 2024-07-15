import java.util.Scanner;

public class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    // Constructor to initialize ATM with a bank account
    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    // Method to display the ATM menu
    public void displayMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                System.out.println("Thank you for using the ATM.");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    // Method to check and display account balance
    private void checkBalance() {
        double balance = bankAccount.getBalance();
        System.out.println("Current Balance: $" + balance);
    }

    // Method to deposit funds into the account
    private void deposit() {
        System.out.print("Enter deposit amount: $");
        double amount = scanner.nextDouble();
        bankAccount.deposit(amount);
    }

    // Method to withdraw funds from the account
    private void withdraw() {
        System.out.print("Enter withdrawal amount: $");
        double amount = scanner.nextDouble();
        bankAccount.withdraw(amount);
    }

    // Main method to start the ATM application
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // Initial balance $1000
        ATM atm = new ATM(account);

        while (true) {
            atm.displayMenu(); // Display ATM menu
            if (atm.scanner.nextInt() == 4) { // Exit condition
                break;
            }
        }
    }
}
