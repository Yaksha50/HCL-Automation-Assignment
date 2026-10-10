package Assignment1.Task5;

public class Accounts {
    private double balance;
    private String name;
    private int accountNumber;
    private static int totalAcc = 0;

    public Accounts(String name, double balance) {
        this.name = name;
        this.balance = balance;
        totalAcc++;
        accountNumber = totalAcc;
    }

    public double checkBalance() {
        return balance;
    }

    public void deposit(double amount) throws InvalidInput {
        if (amount <= 0) {
            throw new InvalidInput("Amount should be greater than zero.");
        }

        balance += amount;
    }

    public void withdrawal(double amount)
            throws InsufficientBalance, InvalidInput {
        if (amount <= 0) {
            throw new InvalidInput("Withdrawal amount should be greater than zero.");
        }

        if (amount > balance) {
            throw new InsufficientBalance("Insufficient balance.");
        }

        balance -= amount;
    }

    public void displayDetails() {
        System.out.println("User Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}
