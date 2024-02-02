package CodSoft;
import java.util.Scanner;

public class ATMinterface {

    private BankAcc acc;

    private static final int withdraw = 1;

    private static final int deposit = 2;

    private static final int balance = 3;

    private static final int exit = 4;

    public ATMinterface(BankAcc account) {

        this.acc = account;

    }
    public void start() {

        Scanner sc = new Scanner(System.in);

        while (true) {

            displayMenu();

            int ch = Choice(sc);

            switch (ch) {

                case withdraw:

                    Withdrawal(sc);

                    break;

                case deposit:

                    Deposit(sc);

                    break;

                case balance:

                    checkAccountBalance();

                    break;

                case exit:

                    System.out.println("Exiting ATM...");

                    return;

                default:

                    System.out.println("Invalid choice. Please try again.");

            }

        }

    }

    private int Choice(Scanner sc1) {

        System.out.print("Enter your choice: ");

        while (!sc1.hasNextInt()) {

            System.out.println("Invalid input. Please enter a number.");

            sc1.next();

        }

        return sc1.nextInt();

    }

    private void displayMenu() {

        System.out.println("Welcome to the ATM!");

        System.out.println(withdraw + ". Withdraw");

        System.out.println(deposit + ". Deposit");

        System.out.println(balance + ". Check balance");

        System.out.println(exit + ". Exit");

    }

    private void Withdrawal(Scanner sc1) {

        System.out.print("Enter withdrawal amount: ");

        double amt;

        while (true) {

            try {

                amt = Double.parseDouble(sc1.next());

                break;

            } catch (NumberFormatException e) {

                System.out.println("Invalid input. Please enter a valid number.");

                System.out.print("Enter withdrawal amount: ");

            }

        }

        if (acc.withdraw(amt)) {

            System.out.println("Withdrawal successful.");

        } else {

            System.out.println("Insufficient balance.");

        }

    }

    private void Deposit(Scanner sc1) {

        System.out.print("Enter deposit amount: ");

        double amount;

        while (true) {

            try {

                amount = Double.parseDouble(sc1.next());

                break;

            } catch (NumberFormatException e) {

                System.out.println("Invalid input. Please enter a valid number.");

                System.out.print("Enter deposit amount: ");

            }

        }

        acc.deposit(amount);

        System.out.println("Deposit successful.");

    }

    private void checkAccountBalance() {

        System.out.println("Your account balance is: " + acc.getBalance());

    }

    private static class BankAcc {

        private double bal;

        public BankAcc(double initBal) {

            this.bal = initBal;

        }

        public boolean withdraw(double amt) {

            if (amt <= bal) {

                bal -= amt;

                return true;

            } else {

                return false;

            }

        }

        public void deposit(double amt) {

            bal += amt;

        }

        public double getBalance() {

            return bal;

        }

    }

    public static void main(String[] args) {

        BankAcc account = new BankAcc(1000.0);

        ATMinterface atm = new ATMinterface(account);

        atm.start();

    }

}


