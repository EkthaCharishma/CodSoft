import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance: " + balance);
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
            return true;
        } else {
            System.out.println("Insufficient funds. Current balance: " + balance);
            return false;
        }
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\n--- ATM Menu ---");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public void processOption(int choice) {
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
                System.out.println("Exiting ATM. Thank you!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }


    private void checkBalance() {
        System.out.println("Current balance: " + account.getBalance());
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            account.deposit(amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            account.withdraw(amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void run() {
        int choice;
        do {
            displayMenu();
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                processOption(choice);
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                choice = -1;
            }
        } while (choice != 4);
    
        scanner.close();
    }
    
}

public class ATMSystem {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(1000);
        ATM atm = new ATM(myAccount);
        atm.run();
    }
}


// //Output

// --- ATM Menu ---
// 1. Check Balance
// 2. Deposit
// 3. Withdraw
// 4. Exit
// Enter your choice:
// 1
// Current balance: 1000.0

// --- ATM Menu ---
// 1. Check Balance
// 2. Deposit
// 3. Withdraw
// 4. Exit
// Enter your choice: 2
// Enter amount to deposit: 100
// Deposit successful. Current balance: 1100.0

// --- ATM Menu ---
// 1. Check Balance
// 2. Deposit
// 3. Withdraw
// 4. Exit
// Enter your choice: 3
// Enter amount to withdraw: 200
// Withdrawal successful. Current balance: 900.0

// --- ATM Menu ---
// 1. Check Balance
// 2. Deposit
// 3. Withdraw
// 4. Exit
// Enter your choice: 4
// Exiting ATM. Thank you!