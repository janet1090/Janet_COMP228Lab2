package exercise2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainDriver {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        BankAccount[] accounts = new BankAccount[3];

        for (int i = 0; i < accounts.length; i++) {

            try {
                System.out.println("\nEnter details for Account " + (i + 1));

                System.out.print("Enter 9-digit account number: ");
                long accountNumber = input.nextLong();
                input.nextLine();

                System.out.print("Enter account holder name: ");
                String name = input.nextLine();

                System.out.print("Enter starting balance: ");
                double balance = input.nextDouble();

                accounts[i] = new BankAccount(
                        accountNumber, name, balance);

                System.out.print("Enter deposit amount: ");
                double depositAmount = input.nextDouble();
                accounts[i].deposit(depositAmount);

                System.out.print("Enter withdrawal amount: ");
                double withdrawalAmount = input.nextDouble();
                accounts[i].withdraw(withdrawalAmount);

                System.out.println("\nAccount Details:");
                accounts[i].displayDetails();

            } catch (InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (InputMismatchException e) {
                System.out.println(
                        "Error: Invalid input. Please enter the correct data type.");
                input.nextLine();

            } finally {
                System.out.println("Transaction has been processed.");
            }
        }

        input.close();
    }
}