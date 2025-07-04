import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.print("How many accounts will be held in this bank?");
        int accounts = scanner.nextInt();
        Account[] account = new Account[accounts];
        for (int i = 0; i < accounts; i++) {
            System.out.print("Enter the name for the account: ");
            String name = scanner.next();
            System.out.print("Enter the initial balance for " + name + ": "); 
            double initialBalance = scanner.nextDouble();
        
            account[i] = new Account(name, initialBalance);
            System.out.println("Account created for " + name + " with initial balance: " + initialBalance);
        }
        System.out.println("Accounts created successfully!");
        System.out.println("Select an account to check balance, withdrawal, or deposit into: ");
        for (int i = 0; i < accounts; i++) {
            System.out.println((i + 1) + ". " + account[i].getName() + " With a balance of " + account[i].getBalance());
        }
        int selectedAccount = scanner.nextInt() - 1;

        System.out.print("What would you like to do? 1. Check Balance 2. Deposit 3. Withdraw: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Current balance for " + account[selectedAccount].getName() + " is " + account[selectedAccount].getBalance());
                break;
            case 2:
                System.out.print("How much would you like to deposit? ");
                double Amount = scanner.nextDouble();
                account[selectedAccount].deposit(Amount);
                System.out.println("You have depositited " + Amount + " into the account of " + account[selectedAccount].getName() + "Bringing their new balance to " + account[selectedAccount].getBalance());
                break;
            case 3:
                while (true) {
                    System.out.print("How much will you be withdrawing? ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount > account[selectedAccount].getBalance() + 5) {
                        System.out.println("Man are you trying to rob us? You can't take out more than the 5 dollar overdraft limit without closing your account all together, and we won't let you do that...");
                    } else {
                        account[selectedAccount].withdraw(withdrawAmount);
                        System.out.println("You have withdrawn " + withdrawAmount + " from the account of " + account[selectedAccount].getName() + ". New balance is " + account[selectedAccount].getBalance());
                        break;
                    }
                }
                break;
            default:
                System.out.println("please select a valid option");
                break;
            
        }
    }
}