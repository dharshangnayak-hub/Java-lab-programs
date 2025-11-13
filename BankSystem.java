import java.util.Scanner;

// Base class for all accounts
class Account {
    protected String customerName;
    protected String accountNumber;
    protected String accountType;
    protected double balance;

    public Account(String name, String accNo, String accType, double bal) {
        this.customerName = name;
        this.accountNumber = accNo;
        this.accountType = accType;
        this.balance = bal;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
            System.out.println("Updated Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Display balance
    public void displayBalance() {
        System.out.println("Account Holder: " + customerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Current Balance: " + balance);
    }

    // Abstract behavior for derived classes
    public void withdraw(double amount) {}
    public void computeInterest() {}
}

// Derived class for Savings Account
class SavAcct extends Account {
    private final double interestRate = 0.05; // 5% annual interest

    public SavAcct(String name, String accNo, double bal) {
        super(name, accNo, "Savings", bal);
    }

    // Compute compound interest (for simplicity, assume once per period)
    @Override
    public void computeInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest of " + interest + " added. New Balance: " + balance);
    }

    // Withdraw method
    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("Updated Balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

// Derived class for Current Account
class CurAcct extends Account {
    private final double minBalance = 1000.0;
    private final double serviceCharge = 100.0;

    public CurAcct(String name, String accNo, double bal) {
        super(name, accNo, "Current", bal);
    }

    // Withdraw with penalty check
    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            checkMinBalance();
            System.out.println("Updated Balance: " + balance);
        }
    }

    // Check minimum balance
    private void checkMinBalance() {
        if (balance < minBalance) {
            balance -= serviceCharge;
            System.out.println("Balance below minimum! Service charge of " + serviceCharge + " imposed.");
        }
    }

    @Override
    public void computeInterest() {
        System.out.println("No interest for Current Account.");
    }
}

// Main class for user interaction
public class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = null;

        System.out.println("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.println("Enter Account Number: ");
        String accNo = sc.nextLine();

        System.out.println("Select Account Type (1. Savings / 2. Current): ");
        int type = sc.nextInt();

        System.out.println("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        if (type == 1)
            account = new SavAcct(name, accNo, balance);
        else if (type == 2)
            account = new CurAcct(name, accNo, balance);
        else {
            System.out.println("Invalid account type!");
            System.exit(0);
        }

        int choice;
        do {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            System.out.println("4. Compute Interest");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double wd = sc.nextDouble();
                    account.withdraw(wd);
                    break;

                case 3:
                    account.displayBalance();
                    break;

                case 4:
                    account.computeInterest();
                    break;

                case 5:
                    System.out.println("Thank you for banking with us!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}