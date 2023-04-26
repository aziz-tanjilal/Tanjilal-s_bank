public class BankAccount 
{
    // Instance variables
    private int accountNumber;
    private String username;
    private String password;
    private double balance;

    // Constructor
    public BankAccount(int accountNumber, String username, String password, double balance) 
    {
        this.accountNumber = accountNumber;
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    // Getters and setters
    public int getAccountNumber() 
    {
        return accountNumber;
    }

    public String getUsername() 
    {
        return username;
    }

    public String getPassword() 
    {
        return password;
    }

    public double getBalance() 
    {
        return balance;
    }

    public void setBalance(double balance) 
    {
        this.balance = balance;
    }

    // Methods to deposit and withdraw money
    public void deposit(double amount) 
    {
        balance += amount;
    }

    public void withdraw(double amount) 
    {
        balance -= amount;
    }
}