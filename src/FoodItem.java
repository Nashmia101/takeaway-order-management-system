/**
 * Abstract base class for all food items (Pizza, Pasta).
 * Provides base price, meal type classification, and price handling.
 * Implements FreeInterface for promotional discounts.
 *
 * @author Nashmia Shakeel
 * @version 1.0
 */
public abstract class FoodItem implements FreeInterface {

    // Constants
    private static final double BASE_PRICE = 11.50;

    // Fields
    private FoodType foodType;
    private double price;

    /**
     * Returns the base price of all food items.
     *
     * @return the base price
     */
    public static double getBasePrice() {
        return BASE_PRICE;
    }

    /**
     * Sets the meal type of this food item.
     *
     * @param foodType the meal type to set
     */
    public void setMealType(FoodType foodType) {
        this.foodType = foodType;
    }

    /**
     * Gets the calculated price of the food item.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the food item.
     *
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the food type
     * @return the food type
     */
    public FoodType getFoodType() {
        return foodType;
    }

    /**
     * Abstract method
     * Calculates the final price of the food item.
     */
    public abstract void calculatePrice();

    /**
     * Abstract method
     * Determines and assigns the meal type based on ingredients.
     */
    public abstract void fixFoodType();

    /**
     * Abstract Method
     * Returns a string representation of the food item.
     *
     * @return the string description
     */
    public abstract String toString();
}