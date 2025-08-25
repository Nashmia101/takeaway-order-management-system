/**
 * The Pizza class represents a customizable pizza item in the menu.
 * It supports a list of toppings that affect both its price and meal type.
 * The meal type can be:
 * - MEAT: if toppings include ham or seafood
 * - VEGETARIAN: if toppings include cheese but no meat
 * - VEGAN: if no meat or cheese is present
 * This class extends FoodItem and participates in promotional discounts
 * via the FreeInterface contract.
 * Author: Nashmia Shakeel
 * Version: 1.0
 */

import java.util.ArrayList;
import java.util.HashMap;

public class Pizza extends FoodItem {


    private ArrayList<PizzaToppings> toppingsOnPizza;


    private static final HashMap<PizzaToppings, Double> TOPPING_PRICES = new HashMap<>();


    static {
        TOPPING_PRICES.put(PizzaToppings.HAM, 2.0);
        TOPPING_PRICES.put(PizzaToppings.CHEESE, 2.0);
        TOPPING_PRICES.put(PizzaToppings.MUSHROOMS, 2.0);
        TOPPING_PRICES.put(PizzaToppings.TOMATO, 2.0);
        TOPPING_PRICES.put(PizzaToppings.PINEAPPLE, 2.5);
        TOPPING_PRICES.put(PizzaToppings.SEAFOOD, 3.5);
    }

    /**
     * Constructs a Pizza object with no toppings.
     */
    public Pizza() {
        this.toppingsOnPizza = new ArrayList<>();
        calculatePrice();
        fixFoodType();
    }

    /**
     * Constructs a Pizza object with a list of toppings.
     *
     * @param toppings The list of toppings to add
     */
    public Pizza(ArrayList<PizzaToppings> toppings) {
        this.toppingsOnPizza = toppings;
        calculatePrice();
        fixFoodType();
    }

    /**
     * Calculates the total price of the pizza based on base price
     * and the price of each topping.
     */
    @Override
    public void calculatePrice() {
        double totalPrice = getBasePrice();

        for (PizzaToppings top : toppingsOnPizza) {
            Double costOfTopping = TOPPING_PRICES.get(top);
            if (costOfTopping != null) {
                totalPrice = totalPrice + costOfTopping;
            }
        }

        setPrice(totalPrice);
    }

    /**
     * Determines and sets the meal type of the pizza based on toppings.
     * - MEAT: contains ham or seafood
     * - VEGETARIAN: contains cheese (but no meat)
     * - VEGAN: no cheese or meat
     */
    @Override
    public void fixFoodType() {
        boolean meatTopping = false;
        boolean vegetarianTopping = false;

        for (PizzaToppings top : toppingsOnPizza) {
            if (top == PizzaToppings.HAM || top == PizzaToppings.SEAFOOD) {
                meatTopping = true;
            } else if (top == PizzaToppings.CHEESE) {
                vegetarianTopping = true;
            }
        }

        if (meatTopping) {
            setMealType(FoodType.MEAT);
        } else if (vegetarianTopping) {
            setMealType(FoodType.VEGETARIAN);
        } else {
            setMealType(FoodType.VEGAN);
        }
    }

    /**
     * Returns a string representation of the pizza including toppings,
     * meal type, and price.
     *
     * @return a formatted description of the pizza
     */
    @Override
    public String toString() {
        String toppingName;

        if (toppingsOnPizza.isEmpty()) {
            toppingName = "No Toppings";
        } else {
            toppingName = toppingsOnPizza.toString();
        }

        return "Pizza with toppings: " + toppingName
                + "\nMeal Type: " + getFoodType()
                + "\nPrice: $" + String.format("%.2f", getPrice());
    }

    /**
     * Determines how many free pizzas a customer gets based on quantity ordered.
     *
     * @param itemCount number of pizzas ordered
     * @return 1 if eligible (2 or more), otherwise 0
     */
    @Override
    public int getFreeItemCount(int itemCount) {
        if (itemCount >= 2) {
            return 1;
        }
        return 0;
    }

    /**
     * Generates a free pizza item with no toppings.
     *
     * @return a new plain Pizza object
     */
    @Override
    public FoodItem generateFreeItem() {
        return new Pizza(new ArrayList<>(this.toppingsOnPizza));
    }
}





