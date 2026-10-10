package Assignment1.Task5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Accounts a = null;

        System.out.println("----------> Welcome to Console Bank <----------");

        while (true) {
            System.out.println("\\nEnter your choice");
            System.out.println("1. Create Bank Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdrawal");
            System.out.println("4. Balance Enquiry");
            System.out.println("5. Account Details");
            System.out.println("6. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (a != null) {
                        System.out.println("An account has already been created.");
                        break;
                    }

                    System.out.println("Enter the Account Holder's Name:");
                    String name = sc.nextLine();

                    System.out.println("Enter the initial deposit amount:");
                    double initialAmount = sc.nextDouble();

                    if (initialAmount < 0) {
                        System.out.println("Initial deposit cannot be negative.");
                        break;
                    }

                    a = new Accounts(name, initialAmount);
                    System.out.println("Account created successfully.");
                    break;

                case 2:
                    if (a == null) {
                        System.out.println("Create Account First");
                        break;
                    }

                    System.out.println("Enter the amount you need to deposit:");
                    double depositAmount = sc.nextDouble();

                    try {
                        a.deposit(depositAmount);
                        System.out.println("Deposit successful.");
                    } catch (InvalidInput e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    if (a == null) {
                        System.out.println("Create Account First");
                        break;
                    }

                    System.out.println("Enter the amount you need to withdraw:");
                    double withdrawalAmount = sc.nextDouble();

                    try {
                        a.withdrawal(withdrawalAmount);
                        System.out.println("Withdrawal successful.");
                    } catch (InsufficientBalance | InvalidInput e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    if (a == null) {
                        System.out.println("Create Account First");
                        break;
                    }

                    System.out.println("Your current balance is: " + a.checkBalance());
                    break;

                case 5:
                    if (a == null) {
                        System.out.println("Create Account First");
                        break;
                    }

                    a.displayDetails();
                    break;

                case 6:
                    System.out.println("Thank you for visiting Console Bank.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
