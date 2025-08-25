/**
 * Enum representing the available toppings for a Pizza.

 * Each topping may affect the price and the meal type classification
 * (e.g., meat, vegetarian, or vegan) of the pizza.

 * - HAM: Considered a meat topping.
 * - CHEESE: Considered a vegetarian topping.
 * - PINEAPPLE: Considered a vegan topping.
 * - MUSHROOMS: Considered a vegan topping.
 * - TOMATO: Considered a vegan topping.
 * - SEAFOOD: Considered a meat topping.

 * Used in: Pizza class to determine pricing and meal type.
 *
 * @author Nashmia Shakeel
 * @version 1.0
 */
public enum PizzaToppings {
    HAM,
    CHEESE,
    PINEAPPLE,
    MUSHROOMS,
    TOMATO,
    SEAFOOD
}