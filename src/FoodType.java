/**
 * Enum representing the type of meal based on ingredients used.
 * This is used to classify food items in the system.
 * MEAT       – Item contains meat or seafood.
 * VEGETARIAN – Item contains no meat but may include cheese or other non-vegan items.
 * VEGAN      – Item contains no animal products.
 * Used in: FoodItem, Pizza, Pasta, Order classes.
 * @author Nashmia Shakeel
 * @version 1.0
 */
public enum FoodType {
    MEAT,
    VEGETARIAN,
    VEGAN
}