/**
 * The Pasta class represents a food item of type pasta in the takeaway system.
 * Each pasta may optionally have a single topping which determines its price and
 * meal type (VEGAN, VEGETARIAN, or MEAT).
  * This class extends the abstract FoodItem class and implements the FreeInterface
 * to support promotional logic such as "Buy 2 Get 1 Free".
 * Author: Nashmia Shakeel
 * Version: 1.0
 */

import java.util.HashMap;

public class Pasta extends FoodItem {

    // Fields
    private PastaTopping toppingsOnPasta;

    private static final HashMap<PastaTopping, Double> TOPPING_PRICES = new HashMap<>();


    static {
        TOPPING_PRICES.put(PastaTopping.BOLOGNESE, 5.20);
        TOPPING_PRICES.put(PastaTopping.MARINARA, 6.80);
        TOPPING_PRICES.put(PastaTopping.PRIMAVERA, 5.20);
        TOPPING_PRICES.put(PastaTopping.TOMATO, 4.00);
    }

    /**
     * Constructs a Pasta item with a specific topping.
     *
     * @param topping The topping to add to the pasta
     */
    public Pasta(PastaTopping topping) {
        this.toppingsOnPasta = topping;
        calculatePrice();
        fixFoodType();
    }

    /**
     * Constructs a plain Pasta item with no topping (default: VEGAN).
     */
    public Pasta() {
        this.toppingsOnPasta = null;
        calculatePrice();
        fixFoodType();
    }

    /**
     * Calculates the total price of the pasta by adding topping price
     * to the base price.
     */
    @Override
    public void calculatePrice() {
        double totalPrice = getBasePrice();

        if (toppingsOnPasta != null) {
            Double costOfTopping = TOPPING_PRICES.get(toppingsOnPasta);
            if (costOfTopping != null) {
                totalPrice = totalPrice + costOfTopping;
            }
        }

        setPrice(totalPrice);
    }

    /**
     * Determines the meal type based on the topping selected.
     * - VEGAN: No topping or TOMATO
     * - MEAT: BOLOGNESE or MARINARA
     * - VEGETARIAN: PRIMAVERA
     */
    @Override
    public void fixFoodType() {
        if (toppingsOnPasta == null || toppingsOnPasta == PastaTopping.TOMATO) {
            setMealType(FoodType.VEGAN);
        } else if (toppingsOnPasta == PastaTopping.BOLOGNESE
                || toppingsOnPasta == PastaTopping.MARINARA) {
            setMealType(FoodType.MEAT);
        } else if (toppingsOnPasta == PastaTopping.PRIMAVERA) {
            setMealType(FoodType.VEGETARIAN);
        }
    }

    /**
     * Checks if the customer is eligible for a free pasta item.
     *
     * @param itemCount Number of pasta items purchased
     * @return 1 if eligible (2 or more pastas), else 0
     */
    @Override
    public int getFreeItemCount(int itemCount) {
        if (itemCount >= 2) {
            return 1;
        }
        return 0;
    }

    /**
     * Generates a free plain pasta (no topping).
     *
     * @return A new Pasta object with no topping
     */
    @Override
    public FoodItem generateFreeItem() {
        return new Pasta();
    }

    /**
     * Returns a string representation of the pasta, including its
     * topping, meal type, and price.
     *
     * @return Formatted string of the pasta item
     */
    @Override
    public String toString() {
        String toppingName;
        if (toppingsOnPasta == null) {
            toppingName = "No Topping";
        } else {
            toppingName = toppingsOnPasta.toString();
        }

        return "Pasta with topping: " + toppingName
                + "\nMeal Type: " + getFoodType()
                + "\nPrice: $" + String.format("%.2f", getPrice());
    }
}