package ADS_2;

import java.util.Scanner;
import java.util.LinkedList;

    public class BankingSystem {
        static MyQueue accountRequests = new MyQueue();
        static MyQueue billQueue = new MyQueue();
        static MyStack transactionHistory = new MyStack(100);
        static LinkedList<bankacc> accounts = new LinkedList<>();

        static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            runTask6();

            while (true) {
                System.out.println("\n--- MAIN MENU ---");
                System.out.println("1 – Enter Bank (Operations)");
                System.out.println("2 – Enter ATM (Balance & Withdraw)");
                System.out.println("3 – Admin Area (Process Queues)");
                System.out.println("4 – Exit");
                System.out.print("Select option: ");

                if (scanner.hasNextInt()) {
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1 -> bankMenu();
                        case 2 -> atmMenu();
                        case 3 -> adminMenu();
                        case 4 -> System.exit(0);
                        default -> System.out.println("Invalid option!");
                    }
                } else {
                    scanner.nextLine();
                    System.out.println("Please enter a number.");
                }
            }
        }

        static void bankMenu() {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Request Account Opening");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Pay a Bill (Add to queue)");
            System.out.println("5. Undo Last Action");
            System.out.print("Select: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter username: ");
                        String name = scanner.nextLine();
                        System.out.print("Initial balance: ");
                        double bal = scanner.nextDouble();
                        scanner.nextLine();
                        String accNum = "ACC" + (int) (Math.random() * 1000);
                        accountRequests.enqueue(new bankacc(accNum, name, bal));
                        System.out.println("Request added to Queue.");
                    }
                    case 2 -> {
                        bankacc acc = findAccount();
                        if (acc != null) {
                            System.out.print("Enter amount: ");
                            double amt = scanner.nextDouble();
                            scanner.nextLine();
                            acc.balance += amt;
                            transactionHistory.push("Deposit " + amt + " to " + acc.username);
                            System.out.println("Success. Balance: " + acc.balance);
                        }
                    }
                    case 3 -> {
                        bankacc acc = findAccount();
                        if (acc != null) {
                            System.out.print("Enter amount: ");
                            double amt = scanner.nextDouble();
                            scanner.nextLine();
                            if (acc.balance >= amt) {
                                acc.balance -= amt;
                                transactionHistory.push("Withdrawal " + amt + " from " + acc.username);
                                System.out.println("Success. Balance: " + acc.balance);
                            } else System.out.println("Insufficient funds!");
                        }
                    }
                    case 4 -> {
                        System.out.print("Enter bill name (Electricity/Internet): ");
                        String bill = scanner.nextLine();
                        billQueue.enqueue(bill);
                        transactionHistory.push("Bill " + bill + " queued");
                        System.out.println("Bill added to processing queue.");
                    }
                    case 5 -> {if (!transactionHistory.isEmpty()) {
                        System.out.println("Undo: " + transactionHistory.pop() + " removed.");
                    } else System.out.println("History empty.");
                    }
                    default -> System.out.println("Invalid choice!");
                }
            }
        }

        static void atmMenu() {
            System.out.println("\n--- ATM MENU ---");
            bankacc account = findAccount();
            if (account != null) {
                System.out.println("1. Check Balance");
                System.out.println("2. Quick Withdraw 5000");
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1) System.out.println("Balance: " + account.balance);
                else if (choice == 2) {
                    if (account.balance >= 5000) {
                        account.balance -= 5000;
                        transactionHistory.push("ATM Withdraw 5000 from " + account.username);
                        System.out.println("Done. Balance: " + account.balance);
                    } else System.out.println("No money.");
                }
            }
        }

        static void adminMenu() {
            System.out.println("\n--- ADMIN AREA ---");
            System.out.println("1. Process Account Requests (Queue)");
            System.out.println("2. Process Bill Payments (Queue)");
            System.out.println("3. View All Accounts (LinkedList)");
            System.out.print("Select: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                if (accountRequests.isEmpty()) System.out.println("No requests.");
                while (!accountRequests.isEmpty()) {
                    bankacc b = (bankacc) accountRequests.dequeue();
                    accounts.add(b);
                    System.out.println("Approved: " + b.username);
                }
            } else if (choice == 2) {
                if (billQueue.isEmpty()) System.out.println("No bills.");
                while (!billQueue.isEmpty()) {
                    String bill = (String) billQueue.dequeue();
                    System.out.println("Bill Processed: " + bill);
                }
            } else if (choice == 3) {
                for (bankacc acc : accounts) System.out.println(acc);
            }
        }

        static void runTask6() {
            bankacc[] physicalArray = new bankacc[3];
            physicalArray[0] = new bankacc("101", "Ali", 150000);
            physicalArray[1] = new bankacc("102", "Sara", 220000);
            physicalArray[2] = new bankacc("103", "Ivan", 50000);

            for (bankacc a : physicalArray) {
                accounts.add(a);
            }
            System.out.println("System initialized. Predefined accounts loaded from Array to LinkedList.");
        }

        static bankacc findAccount() {
            System.out.print("Enter Username: ");
            String name = scanner.nextLine();
            for (bankacc acc : accounts) {
                if (acc.username.equalsIgnoreCase(name)) return acc;
            }
            System.out.println("Not found.");
            return null;
        }
    }

