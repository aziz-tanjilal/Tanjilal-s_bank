public class Bank 
{

    private final int MAX_ACCOUNTS = 100;
    private BankAccount[] accounts = new BankAccount[MAX_ACCOUNTS];

    // Add some dummy accounts for testing
    public Bank() 
    {
        accounts[0] = new BankAccount(1001, "Roger", "password", 1000);
        accounts[1] = new BankAccount(1002, "Litton", "password", 5000);
        accounts[2] = new BankAccount(1003, "Shakib", "password", 200);
        accounts[3] = new BankAccount(1004, "Latham", "password", 10000);
    }

    // Authenticate user
    public boolean authenticateUser(int accountNumber, String username, String password) 
    {
        for (int i = 0; i < MAX_ACCOUNTS; i++) 
        {
            if (accounts[i] != null && accounts[i].
            getAccountNumber() == accountNumber && accounts[i].
            getUsername().equals(username) && accounts[i].getPassword().equals(password)) 
            {
                return true;
            }
        }
        return false;
    }

    // Get balance for a given account
    public double getBalance(int accountNumber) 
    {
        for (int i = 0; i < MAX_ACCOUNTS; i++) 
        {
            if (accounts[i] != null && accounts[i].getAccountNumber() == accountNumber) 
            {
                return accounts[i].getBalance();
            }
        }
        // Account not found
        return -1;
    }

    // Deposit money into a given account
    public void deposit(int accountNumber, double amount) 
    {
        for (int i = 0; i < MAX_ACCOUNTS; i++)
        {
            if (accounts[i] != null && accounts[i].getAccountNumber() == accountNumber) 
            {
                accounts[i].deposit(amount);
                break;
            }
        }
    }

    // Withdraw money from a given account
    public void withdraw(int accountNumber, double amount) 
    {
        for (int i = 0; i < MAX_ACCOUNTS; i++) 
        {
            if (accounts[i] != null && accounts[i].getAccountNumber() == accountNumber) {
                accounts[i].withdraw(amount);
                break;
            }
        }
    }
}