import java.util.ArrayList;

/**
 * Represents a customer order containing multiple food items.
 * It calculates the total cost, applies discount offers,
 * and determines the meal type based on the included food.
 *
 * @author Nashmia Shakeel
 * @version 1.0
 */
public class Order {

    private ArrayList<FoodItem> foodItems;
    private String customerName;
    private int customerContactNumber;
    private String customerDeliveryAddress;
    private FoodType mealType;
    private double totalCost;

    private boolean freePizzaApplied = false;
    private boolean freePastaApplied = false;

    /**
     * Constructs an Order with customer details.
     *
     * @param customerName The name of the customer.
     * @param customerContactNumber The contact number of the customer.
     * @param customerDeliveryAddress The delivery address for the order.
     */
    public Order(String customerName, int customerContactNumber, String customerDeliveryAddress) {
        this.customerName = customerName;
        this.customerContactNumber = customerContactNumber;
        this.customerDeliveryAddress = customerDeliveryAddress;
        this.foodItems = new ArrayList<>();
        this.totalCost = 0.0;
        this.mealType = FoodType.VEGAN;
    }

    /**
     * Adds a food item to the order.
     * Recalculates total cost and meal type.
     *
     * @param item The food item to add.
     */
    public void addFoodItem(FoodItem item) {
        foodItems.add(item);
        calculateTotalCost();
        fixMealType();
    }

    /**
     * Calculates the total cost of the order.
     * Applies "Buy 2 Get 1 Free" by adding a free item instead of reducing the price.
     */
    public void calculateTotalCost() {
        int pizzaCount = 0;
        int pastaCount = 0;
        double total = 0.0;

        // Count pizzas and pastas and calculate running total
        for (FoodItem item : foodItems) {
            if (item instanceof Pizza) pizzaCount++;
            if (item instanceof Pasta) pastaCount++;
            total += item.getPrice();
        }

        // Add a free pizza if 2 or more pizzas ordered and free not yet applied
        if (pizzaCount >= 2 && !freePizzaApplied) {
            Pizza freePizza = new Pizza();
            freePizza.setPrice(0.0); // Ensure free item has no cost
            foodItems.add(freePizza);
            freePizzaApplied = true;
            System.out.println("You've received a FREE Pizza for ordering 2 or more pizzas!");
        }

        // Add a free pasta if 2 or more pastas ordered and free not yet applied
        if (pastaCount >= 2 && !freePastaApplied) {
            Pasta freePasta = new Pasta();
            freePasta.setPrice(0.0); // Ensure free item has no cost
            foodItems.add(freePasta);
            freePastaApplied = true;
            System.out.println("You've received a FREE Pasta for ordering 2 or more pastas!");
        }

        // Recalculate total with any new free items (added above)
        totalCost = 0;
        for (FoodItem item : foodItems) {
            totalCost += item.getPrice();
        }
    }

    /**
     * Determines the overall meal type of the order.
     * Priority: MEAT > VEGETARIAN > VEGAN.
     */
    public void fixMealType() {
        boolean containsMeat = false;
        boolean isVegetarian = false;

        for (FoodItem item : foodItems) {
            if (item.getFoodType() == FoodType.MEAT) {
                containsMeat = true;
                break;
            } else if (item.getFoodType() == FoodType.VEGETARIAN) {
                isVegetarian = true;
            }
        }

        if (containsMeat) mealType = FoodType.MEAT;
        else if (isVegetarian) mealType = FoodType.VEGETARIAN;
        else mealType = FoodType.VEGAN;
    }

    /**
     * Returns a string representation of the order.
     * Includes customer info, food items, discounts, and total cost.
     *
     * @return A formatted string of the order.
     */
    public String toString() {
        String result = "Customer Name: " + customerName + "\n"
                + "Contact Number: " + customerContactNumber + "\n"
                + "Delivery Address: " + customerDeliveryAddress + "\n\n";

        // List all food items in the order
        for (FoodItem item : foodItems) {
            result += item + "\n";
        }

        // Mention applied discounts
        if (freePizzaApplied) {
            result += "You've received a FREE Pizza for ordering 2 or more pizzas!\n";
        }
        if (freePastaApplied) {
            result += "You've received a FREE Pasta for ordering 2 or more pastas!\n";
        }

        result += "Meal Type: " + mealType + "\n"
                + "Total Cost: $" + String.format("%.2f", totalCost);

        return result;
    }

    // ================= Getters and Setters ================= //

    /**
     * Returns the list of food items in the order.
     *
     * @return A list of FoodItem objects.
     */
    public ArrayList<FoodItem> getFoodItems() {
        return foodItems;
    }

    /**
     * Sets the list of food items for the order.
     *
     * @param foodItems The list of FoodItem objects.
     */
    public void setFoodItems(ArrayList<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    /**
     * Returns the customer's name.
     *
     * @return The customer's name.
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the customer's name.
     *
     * @param customerName The customer's name.
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Returns the customer's contact number.
     *
     * @return The contact number.
     */
    public int getCustomerContactNumber() {
        return customerContactNumber;
    }

    /**
     * Sets the customer's contact number.
     *
     * @param customerContactNumber The contact number.
     */
    public void setCustomerContactNumber(int customerContactNumber) {
        this.customerContactNumber = customerContactNumber;
    }

    /**
     * Returns the customer's delivery address.
     *
     * @return The delivery address.
     */
    public String getCustomerDeliveryAddress() {
        return customerDeliveryAddress;
    }

    /**
     * Sets the customer's delivery address.
     *
     * @param customerDeliveryAddress The delivery address.
     */
    public void setCustomerDeliveryAddress(String customerDeliveryAddress) {
        this.customerDeliveryAddress = customerDeliveryAddress;
    }

    /**
     * Returns the overall meal type of the order.
     *
     * @return The meal type (MEAT, VEGETARIAN, VEGAN).
     */
    public FoodType getMealType() {
        return mealType;
    }

    /**
     * Sets the overall meal type of the order.
     *
     * @param mealType The meal type to set.
     */
    public void setMealType(FoodType mealType) {
        this.mealType = mealType;
    }
}