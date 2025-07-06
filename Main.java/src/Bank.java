import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        double Amount;
        double withdrawAmount = 0.0;
        int accounts;
        int acAcounts;
        int selectedAccount;
        int actionCount;
        int choice;
        while (true) {
            System.out.print("How many accounts will be held in this bank?");
            if (scanner.hasNextDouble()) {
                double placeholder = scanner.nextDouble();
                if (isInteger(placeholder) && placeholder >= 1) {
                    accounts = (int) placeholder;
                    break;
                } else {
                    System.out.println("YOU STUPID BITCH, PUT IN AN INTEGER GREATER THAN OR EQUAL TO 1");
                }}
            else {
                System.out.println("GRRRR");
                scanner.next();
            }
        }
        scanner.nextLine();
        Account[] account = new Account[accounts];
        for (int i = 0; i < accounts; i++) {
            System.out.print("Enter the name for the account: ");
            String name = scanner.nextLine();
            double initialBalance = 0.0;

            while (true) {
                System.out.print("Enter the initial balance for " + name + ": $");
                if (scanner.hasNextDouble()) {
                    initialBalance = scanner.nextDouble();
                    if (initialBalance <5) {
                        System.out.println("You must have a balance that is greater than or equal to 5 dollars, need 5 dollars to hold an account open and we don't do credit");
                        scanner.nextLine();
                    }
                    else {
                        scanner.nextLine();
                        break;
                    }
                }
                else {
                    System.out.println("Please enter a valid balance with letters or symbols, you fuckling dumbass ");
                    scanner.nextLine();
                }
            }

            account[i] = new Account(name, initialBalance);
            System.out.println("Account created for " + name + " with initial balance: $" + initialBalance);
        }
        System.out.println("Accounts created successfully!");
        if (accounts > 1) {
            while (true) {
                System.out.print("How many accounts will you be committing actions on? ");
                if (scanner.hasNextDouble()) {
                    double placeholder = scanner.nextDouble();
                    if (isInteger(placeholder) && placeholder >= 1) {
                        acAcounts = (int) placeholder;
                        break;
                    } else {
                        System.out.println("YOU STUPID BITCH, PUT IN AN INTEGER GREATER THAN OR EQUAL TO1");
                    }}
                else {
                    System.out.println("GRRRR");
                    scanner.next();
                }
            }
        
            for (int i = 0; i < acAcounts; i++) {
                System.out.println("Select an account to check balance, withdrawal from, or deposit into: ");
                for (int j = 0; j < accounts; j++) {
                    System.out.println((j + 1) + ". " + account[j].getName());
                }
                while (true) {
                    if (scanner.hasNextDouble()) {
                        double placeholder = scanner.nextDouble();
                        if (isInteger(placeholder) && placeholder >= 1 && placeholder <= accounts) {
                            selectedAccount = (int) placeholder - 1;
                            break;
                        } else {
                            System.out.println("YOU STUPID BITCH, PUT IN AN INTEGER GREATER THAN OR EQUAL TO 1 BUT LESS THAN THE NUMBER OF ACCOUNTS YOU HAVE CREATED, WHICH IS " + accounts + "!");
                        }}
                    else {
                        System.out.println("GRRRR");
                        scanner.next();
                    }
                }
                while (true) {
                    System.out.print("how many actions will you be completing on this account? ");
                    if (scanner.hasNextDouble()) {
                        double placeholder = scanner.nextDouble();
                        if (isInteger(placeholder) && placeholder >= 1) {
                            actionCount = (int) placeholder;
                            break;
                        } else {
                            System.out.println("YOU STUPID BITCH, PUT IN AN INTEGER GREATER THAN 1");
                        }}
                    else {
                        System.out.println("GRRRR");
                        scanner.next();
                    }
                }
                for (int j = 0; j < actionCount; j++) {
                    while (true) {
                        System.out.print("What would you like to do? 1. Check Balance 2. Deposit 3. Withdraw: ");
                        if (scanner.hasNextDouble()) {
                            double placeholder = scanner.nextDouble();
                            if (isInteger(placeholder) && placeholder >= 1 && placeholder <= 3) {
                                choice = (int) placeholder;
                
                                switch (choice) {
                                    case 1:
                                        System.out.println("Current balance for " + account[selectedAccount].getName() + " is $" + account[selectedAccount].getBalance());
                                        break;
                
                                    case 2:
                                        while (true) {
                                            System.out.print("How much would you like to deposit? $");
                                            if (scanner.hasNextDouble()) {
                                                Amount = scanner.nextDouble();
                                                break;
                                            } else {
                                                System.out.println("GRRRR");
                                                scanner.next();
                                            }
                                        }
                                        account[selectedAccount].deposit(Amount);
                                        System.out.println("You have deposited $" + Amount + " into the account of " + account[selectedAccount].getName() + ". Bringing their new balance to $" + account[selectedAccount].getBalance());
                                        break;
                
                                    case 3:
                                        while (true) {
                                            System.out.print("How much will you be withdrawing? ");
                                            if (scanner.hasNextDouble()) {
                                                withdrawAmount = scanner.nextDouble();
                                                if (withdrawAmount > account[selectedAccount].getBalance() + 5) {
                                                    System.out.println("Man are you trying to rob us?");
                                                    break;
                                                } else {
                                                    account[selectedAccount].withdraw(withdrawAmount);
                                                    System.out.println("You have withdrawn $" + withdrawAmount + " from the account of " + account[selectedAccount].getName() + ". New balance is $" + account[selectedAccount].getBalance());
                                                    break;
                                                }
                                            } else {
                                                System.out.println("GRRRR");
                                                scanner.next();
                                            }
                                        }
                                        break;
                                }
                                break;
                            } else {
                                System.out.println("Please enter 1, 2, or 3.");
                            }
                        } else {
                            System.out.println("GRRRR");
                            scanner.next();
                        }
                    }
                }
            }}
        else {
            selectedAccount = 0;
            while (true) {
                System.out.print("how many actions will you be completing on this account? ");
                if (scanner.hasNextDouble()) {
                    double placeholder = scanner.nextDouble();
                    if (isInteger(placeholder) && placeholder >= 1) {
                        actionCount = (int) placeholder;
                        break;
                    } else {
                        System.out.println("YOU STUPID BITCH, PUT IN AN INTEGER GREATER THAN 1");
                    }}
                else {
                    System.out.println("GRRRR");
                    scanner.next();
                }
            }
            for (int j = 0; j < actionCount; j++) {
                while (true) {
                    System.out.print("What would you like to do? 1. Check Balance 2. Deposit 3. Withdraw: ");
                    if (scanner.hasNextDouble()) {
                        double placeholder = scanner.nextDouble();
                        if (isInteger(placeholder) && placeholder >= 1 && placeholder <= 3) {
                            choice = (int) placeholder;
            
                            switch (choice) {
                                case 1:
                                    System.out.println("Current balance for " + account[selectedAccount].getName() + " is $" + account[selectedAccount].getBalance());
                                    break;
            
                                case 2:
                                    while (true) {
                                        System.out.print("How much would you like to deposit? $");
                                        if (scanner.hasNextDouble()) {
                                            Amount = scanner.nextDouble();
                                            break;
                                        } else {
                                            System.out.println("GRRRR");
                                            scanner.next();
                                        }
                                    }
                                    account[selectedAccount].deposit(Amount);
                                    System.out.println("You have deposited $" + Amount + " into the account of " + account[selectedAccount].getName() + ". Bringing their new balance to $" + account[selectedAccount].getBalance());
                                    break;
            
                                case 3:
                                    while (true) {
                                        System.out.print("How much will you be withdrawing? ");
                                        if (scanner.hasNextDouble()) {
                                            withdrawAmount = scanner.nextDouble();
                                            if (withdrawAmount > account[selectedAccount].getBalance() + 5) {
                                                System.out.println("Man are you trying to rob us?");
                                                break;
                                            } else {
                                                account[selectedAccount].withdraw(withdrawAmount);
                                                System.out.println("You have withdrawn $" + withdrawAmount + " from the account of " + account[selectedAccount].getName() + ". New balance is $" + account[selectedAccount].getBalance());
                                                break;
                                            }
                                        } else {
                                            System.out.println("GRRRR");
                                            scanner.next();
                                        }
                                    }
                                    break;
                            }
                            break;
                        } else {
                            System.out.println("Please enter 1, 2, or 3.");
                        }
                    } else {
                        System.out.println("GRRRR");
                        scanner.next();
                    }
                }
            }
        }

        for (int k = 0; k < accounts; k++) {
            System.out.println("Account " + (k + 1) + ": " + account[k].getName() + " has a balance of $" + account[k].getBalance());
    }
        scanner.close();
    }
    public static boolean isInteger(double integer) {
        return integer == (int) integer;
    }
}
