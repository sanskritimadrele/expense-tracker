import java.util.ArrayList;
import java.util.Scanner;

public class expensetracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<expense> expenses = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n=== Expense Tracker ===");
            System.out.println("1. Add Expense");
System.out.println("2. Show All Expenses");
System.out.println("3. Show Total Expenses");
System.out.println("4. Show Category-wise Summary");
System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice) {
                case 1:
                    System.out.print("Enter expense name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter category: ");
                    String category = sc.nextLine();

                    expenses.add(new expense(name, amount, category));
                    System.out.println("Expense added successfully!");
                    break;

                case 2:
                    System.out.println("\nAll Expenses:");
                    for (expense e : expenses) {
                        System.out.println(e.name + " | " + e.amount + " | " + e.category);
                    }
                    break;

                case 3:
                    double total = 0;
                    for (expense e : expenses) total += e.amount;
                    System.out.println("Total Expenses: " + total);
                    break;
                case 4:
    if (expenses.isEmpty()) {
        System.out.println("No expenses added yet.");
        break;
    }

    System.out.println("\nCategory-wise Summary:");
    for (int i = 0; i < expenses.size(); i++) {
        expense current = expenses.get(i);
        double categoryTotal = 0;

        for (int j = 0; j < expenses.size(); j++) {
            if (expenses.get(j).category.equalsIgnoreCase(current.category)) {
                categoryTotal += expenses.get(j).amount;
            }
        }

        // Print only once per category
        boolean printedBefore = false;
        for (int k = 0; k < i; k++) {
            if (expenses.get(k).category.equalsIgnoreCase(current.category)) {
                printedBefore = true;
                break;
            }
        }

        if (!printedBefore) {
            System.out.println(current.category + " : " + categoryTotal);
        }
    }
    break;    

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while(choice != 0);

        sc.close();
    }
}