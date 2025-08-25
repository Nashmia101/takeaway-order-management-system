import java.util.ArrayList;
import java.util.Scanner;

/**
 * The TakeawayDriver class serves as the main controller for the takeaway order management system.
 * It allows users to enter, deliver, and view orders consisting of pizza and pasta items.
 * This class uses console-based interaction and manages a list of customer orders.
 * Author: Nashmia Shakeel
 *  Version: 1.0
 */
public class TakeawayDriver {

    private static final Scanner scanner = new Scanner(System.in); // Used to read user input from the console
    private static final ArrayList<Order> orders = new ArrayList<>(); // List to store customer orders

    /**
     * Entry point of the program. Displays the main menu and handles user choices in a loop.
     */
    public static void main(String[] args) {
        while (true) {
            // Display the main menu
            System.out.println("\n===== TAKEAWAY ORDER SYSTEM =====");
            System.out.println("1. Enter new customer order");
            System.out.println("2. Deliver order");
            System.out.println("3. Show all orders");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = readChoice(); // Read user's menu choice

            if (choice == 1) orders.add(createOrder()); // Create and add a new order
            else if (choice == 2) deliverOrder();       // Deliver the oldest order
            else if (choice == 3) printAllOrders();     // Display all current orders
            else if (choice == 4) {
                System.out.println("Goodbye!");
                break; // Exit the program
            } else {
                System.out.println("Invalid option."); // Handle invalid menu choice
            }
        }
    }

    /**
     * Reads and returns a valid integer menu choice from the user.
     *
     * @return The user's choice as an integer, or -1 if the input is invalid.
     */
    private static int readChoice() {
        String input = scanner.nextLine().trim();
        boolean allDigits = true;

        // Check if all characters in input are digits
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c < '0' || c > '9') {
                allDigits = false;
                break;
            }
        }

        if (allDigits && !input.isEmpty()) {
            return Integer.parseInt(input); // Return parsed integer if valid
        } else {
            return -1; // Return -1 if input is invalid
        }
    }

    /**
     * Creates and returns a new customer order.
     * Prompts user to enter customer information and food items.
     *
     * @return A new Order object containing customer and food item details.
     */
    private static Order createOrder() {
        String name;

        // Read and validate customer's name
        while (true) {
            System.out.print("Customer name: ");
            name = scanner.nextLine().trim();

            if (!name.isEmpty() && name.matches("[a-zA-Z ]+")) {
                break;
            } else {
                System.out.println("Invalid name. Please enter letters and spaces only.");
            }
        }

        // Read and validate contact number (digits only, min length)
        int contact = Integer.parseInt(readValidatedInput("Contact number (min 8 digits): ", 8, true));

        // Read and validate delivery address (minimum length required)
        String address = readValidatedInput("Delivery address (min 5 characters): ", 5, false);

        ArrayList<FoodItem> items = new ArrayList<>(); // List to store food items

        // Loop to add pizza or pasta items
        while (true) {
            System.out.println("1. Add Pizza  2. Add Pasta  3. Done");
            int choice = readChoice();

            if (choice == 1) items.add(createPizza());
            else if (choice == 2) items.add(createPasta());
            else if (choice == 3) {
                if (items.isEmpty()) System.out.println("Add at least one item.");
                else break;
            } else System.out.println("Invalid choice.");
        }

        // Create order object and add all food items to it
        Order order = new Order(name, contact, address);
        for (FoodItem item : items) {
            order.addFoodItem(item);
        }

        return order;
    }

    /**
     * Reads and validates input based on minimum length and digit-only constraint.
     *
     * @param prompt      Prompt message to show user.
     * @param minLen      Minimum acceptable length for input.
     * @param digitsOnly  Whether the input must consist of digits only.
     * @return A validated input string.
     */
    private static String readValidatedInput(String prompt, int minLen, boolean digitsOnly) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.length() >= minLen && (!digitsOnly || isAllDigits(input))) {
                return input;
            }
            System.out.println("Invalid input. Try again.");
        }
    }

    /**
     * Checks whether the given string contains only numeric digits.
     *
     * @param input The string to check.
     * @return True if input is numeric; otherwise, false.
     */
    private static boolean isAllDigits(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c < '0' || c > '9') return false;
        }
        return true;
    }

    /**
     * Determines if the input is a 'yes' character ('y' or 'Y').
     *
     * @param input The user's input string.
     * @return True if input is 'y' or 'Y'; otherwise, false.
     */
    private static boolean isYes(String input) {
        input = input.trim();
        return input.length() == 1 && (input.charAt(0) == 'y' || input.charAt(0) == 'Y');
    }

    /**
     * Prompts user to select pizza toppings and returns a Pizza object.
     *
     * @return A Pizza object with selected toppings.
     */
    private static Pizza createPizza() {
        ArrayList<PizzaToppings> selectedToppings = new ArrayList<>();
        System.out.println("Choose toppings for your pizza:");

        for (PizzaToppings t : PizzaToppings.values()) {
            System.out.println("Do you want to add the topping: " + t);
            System.out.println("Type 'y' for yes or 'n' for no:");
            String input = scanner.nextLine().trim();

            if (isYes(input)) {
                selectedToppings.add(t); // Add selected topping to list
            }
        }

        return new Pizza(selectedToppings);
    }

    /**
     * Prompts user to select a pasta topping and returns a Pasta object.
     *
     * @return A Pasta object with the selected topping.
     */
    private static Pasta createPasta() {
        System.out.println("Choose a topping for your pasta:");

        int index = 1;
        for (PastaTopping topping : PastaTopping.values()) {
            System.out.println(index + ". " + topping);
            index++;
        }
        System.out.println(index + ". No topping"); // Option for no topping

        while (true) {
            System.out.print("Choose topping: ");
            String input = scanner.nextLine().trim();

            if (!input.isEmpty() && isAllDigits(input)) {
                int choice = Integer.parseInt(input);

                if (choice == index) {
                    return new Pasta(); // No topping selected
                }

                int count = 1;
                for (PastaTopping topping : PastaTopping.values()) {
                    if (count == choice) {
                        return new Pasta(topping); // Return pasta with selected topping
                    }
                    count++;
                }
            }
            System.out.println("Invalid choice.");
        }
    }

    /**
     * Delivers (removes and prints) the first order in the queue.
     * Uses FIFO strategy.
     */
    private static void deliverOrder() {
        if (orders.isEmpty()) {
            System.out.println("No orders to deliver.");
        } else {
            System.out.println("Delivered:\n" + orders.removeFirst());
        }
    }

    /**
     * Prints all current orders in the order list.
     */
    private static void printAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("No current orders.");
        } else {
            System.out.println("Orders:");
            for (Order o : orders) {
                System.out.println(o);
                System.out.println("----------");
            }
        }
    }
}