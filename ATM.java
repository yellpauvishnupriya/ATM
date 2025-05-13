import java.util.Scanner;

public class ATM {
    private static double balance = 1000.00;
    private static final String userPIN = "1234";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // PIN Verification
        System.out.print("Enter your PIN: ");
        String inputPIN = sc.nextLine();

        if (!inputPIN.equals(userPIN)) {
            System.out.println("Incorrect PIN. Access Denied.");
            return;
        }

        int choice;
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(sc);
                    break;
                case 3:
                    withdraw(sc);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 4);

        sc.close();
    }

    private static void checkBalance() {
        System.out.printf("Current balance: ₹%.2f%n", balance);
    }

    private static void deposit(Scanner sc) {
        System.out.print("Enter deposit amount: ");
        double amount = sc.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.printf("₹%.2f deposited. New balance: ₹%.2f%n", amount, balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private static void withdraw(Scanner sc) {
        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("₹%.2f withdrawn. New balance: ₹%.2f%n", amount, balance);
        } else {
            System.out.println("Invalid or insufficient amount.");
        }
    }
}
