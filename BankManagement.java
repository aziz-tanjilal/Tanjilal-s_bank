import java.util.Scanner;

public class BankManagement 
{
    
    private Bank bank; // Bank object to manage accounts and transactions
    private Scanner scanner; // Scanner object to get user input
    
    // Constructor to initialize Bank and Scanner objects
    public BankManagement() 
    {
        bank = new Bank();
        scanner = new Scanner(System.in);
    }
    
    // Method to start the bank management system
    public void run() 
    {
        // Welcome message
        System.out.println("Welcome to Tanjilal's Bank");
        
        // Get user account number, username, and password
        int accountNumber = promptAccountNumber();
        String username = promptUsername();
        String password = promptPassword();
        
        // Authenticate user with account number, username, and password
        boolean authenticated = bank.authenticateUser(accountNumber, username, password);
        if (!authenticated) 
        {
            // If user authentication fails, print error message and exit
            System.out.println("Invalid account number, username, or password. Exiting.");
            return;
        }
        
        // If user authentication succeeds, display menu and process user choice
        while (true) 
        {
            int choice = promptMenu();
            switch (choice) 
            {
                case 1:
                    deposit(accountNumber);
                    break;
                case 2:
                    withdraw(accountNumber);
                    break;
                case 3:
                    takeLoan(accountNumber);
                    break;
                case 4:
                    // If user selects Exit, print goodbye message and exit
                    System.out.println("Thank you for banking with Tanjilal's Bank. Goodbye!");
                    return;
                default:
                    // If user selects an invalid choice, print error message and display menu again
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
                    break;
            }
        }
    }
    
    // Method to prompt user for account number and return it as an int
    private int promptAccountNumber() 
    {
        System.out.print("Enter your account number: ");
        return scanner.nextInt();
    }
    
    // Method to prompt user for username and return it as a String
    private String promptUsername()
    {
        System.out.print("Enter your username: ");
        return scanner.next();
    }
    
    // Method to prompt user for password and return it as a String
    private String promptPassword() 
    {
        System.out.print("Enter your password: ");
        return scanner.next();
    }
    
    // Method to display menu and prompt user for choice, then return the choice as an int
    private int promptMenu()
    {
        System.out.println("Please select an option:");
        System.out.println("1. Deposit money");
        System.out.println("2. Withdraw money");
        System.out.println("3. Take a loan");
        System.out.println("4. Exit");
        System.out.print("Your choice: ");
        return scanner.nextInt();
    }
    
    // Method to prompt user for deposit amount, deposit it into the account, and print the new balance
    private void deposit(int accountNumber) 
    {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        bank.deposit(accountNumber, amount);
        System.out.println("Deposit successful. Your new balance is " + bank.getBalance(accountNumber));
    }
    
    // Method to prompt user for withdrawal amount, withdraw it from the account, and print the new balance
    private void withdraw(int accountNumber) 
    {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        bank.withdraw(accountNumber, amount);
        System.out.println("Withdrawal successful. Your new balance is " + bank.getBalance(accountNumber));
    }
   
    // Method to prompt user for loan amount, check eligibility, deposit it into the account, and print the new balance
    private void takeLoan(int accountNumber) 
{
   // Prompt user for loan amount
   System.out.print("Enter the amount of the loan: ");
   double amount = scanner.nextDouble();

   // Get current balance of the account
    double balance = bank.getBalance(accountNumber);

   // Check if the user is eligible for the loan
    if (amount > balance / 2) 
{   
    // If user is not eligible, print error message
    System.out.println("Sorry, you are not eligible for a loan of that amount.");
} 
     else
 {   // If user is eligible, deposit the loan amount into the account and print new balance
    bank.deposit(accountNumber, amount);
    System.out.println("Loan received. Your new balance is " + bank.getBalance(accountNumber));
}
}
    
} 