import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BudgetApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // while(scan.hasNextLine()) {
        //     String category = scan.nextLine();
        //     double limit = scan.nextDouble();
        //     double spent = scan.nextDouble();

        //     // Consume \n after spent input 
        //     if(scan.hasNextLine()) scan.nextLine();

        //     String limitString = String.format("$%.2f", limit);
        //     String spentString = String.format("$%.2f", spent);
        //     System.out.println("The budget limit for " + category + " was: " + limitString + 
        //                        " but the actual spend was " + spentString);
        // }

        //an array list of budget category objects or instances of budget category
        List<BudgetCategory> list = new ArrayList<>();

        while(scan.hasNextLine()) {
            String category = scan.nextLine();
            double limit = scan.nextDouble();
            double spent = scan.nextDouble();

            //class TA helped me build out this logic through 15 minutes of chatting            
            list.add(new BudgetCategory(category, limit, spent));

            if(scan.hasNextLine()) scan.nextLine();
        }

        //wave 4 sort
        Collections.sort(list, Collections.reverseOrder());


        for (BudgetCategory b : list) {
            String print = b.toString();
            System.out.println(print);
        }


        // BudgetCategory groceries = new BudgetCategory("Groceries", 500, 401);
        // String testingTesting = groceries.toString();
        // System.out.println(testingTesting);

        System.out.println(budgetDifference(list));


    }

    /**
     * Returns overall how much over/under budget a person is given a list of their
     * categories.
     * 
     * This should be the sum of how much over/under budget each individual category is.
     * 
     * If the person is under budget, the result will be negative. If they are over budget, the
     * result will be positive.
     * 
     * @param categories the budget categories with the spend
     * @return the total amount over/under budget
     */
    public static int budgetDifference(List<BudgetCategory> categories) {
        int diff = 0;
        for (BudgetCategory cat : categories) {
            diff += (int) cat.getDifference(); //casting to remove decimals and become int
        }
        return diff;
    }
}
