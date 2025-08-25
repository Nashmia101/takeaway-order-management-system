/**
 * Interface for items eligible for a 'Buy 2 Get 1 Free' promotion.
 * Provides methods to calculate eligibility and generate free items.
 *
 * @author Nashmia Shakeel
 * @version 1.0
 */
public interface FreeInterface {

    /**
     * Determines how many free items the customer is eligible for
     * based on the count of items purchased.
     *
     * @param itemCount the number of purchased items
     * @return number of free items (usually 1 if eligible, 0 otherwise)
     */
    int getFreeItemCount(int itemCount);

    /**
     * Generates and returns a free item (of the same type)
     * to be added to the order for the discount.
     *
     * @return A new FoodItem that represents a free item
     */
    FoodItem generateFreeItem();
}
