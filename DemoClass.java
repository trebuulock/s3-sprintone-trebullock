import java.util.ArrayList;

public class DemoClass {
    public static void main(String[] args) {
        // Create customers
        Customer customer1 = new Customer("Alice", true, "Premium");
        Customer customer2 = new Customer("Bob", true, "Gold");
        Customer customer3 = new Customer("Charlie", true, "Silver");
        Customer customer4 = new Customer("David", false, "");
        Customer customer5 = new Customer("Eve", false, "");

        // Create visits
        Visit visit1 = new Visit(customer1, 100.0, 50.0);
        Visit visit2 = new Visit(customer2, 200.0, 75.0);
        Visit visit3 = new Visit(customer3, 150.0, 100.0);
        Visit visit4 = new Visit(customer4, 80.0, 30.0);
        Visit visit5 = new Visit(customer5, 120.0, 60.0);

        // Store visits in an ArrayList
        ArrayList<Visit> visits = new ArrayList<>();
        visits.add(visit1);
        visits.add(visit2);
        visits.add(visit3);
        visits.add(visit4);
        visits.add(visit5);

        // Calculate and display the total bill for each visit
        for (Visit visit : visits) {
            Customer customer = visit.getCustomer();
            String memberStatus = customer.isMember() ? "Member" : "Non-member";

            System.out.println("Customer: " + customer.getName());
            System.out.println("Membership: " + memberStatus);
            System.out.println("Service Expense: $" + visit.getServiceExpense());
            System.out.println("Product Expense: $" + visit.getProductExpense());
            System.out.println("Total Bill: $" + visit.getTotalExpense());
            System.out.println();
        }
    }
}
