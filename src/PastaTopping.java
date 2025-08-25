/**
 * Enum representing the available toppings for a Pasta dish.
 * Each topping affects both the price and the classification of the meal
 * as MEAT, VEGETARIAN, or VEGAN depending on its ingredients.
 * - BOLOGNESE: A meat-based topping (MEAT).
 * - MARINARA: A seafood-based topping (MEAT).
 * - PRIMAVERA: A vegetable-based topping (VEGETARIAN).
 * - TOMATO: A plain tomato sauce (VEGAN).
 * Used in: Pasta class for determining meal type and pricing.
 * @author Nashmia Shakeel
 * @version 1.0
 */
public enum PastaTopping {
    BOLOGNESE,
    MARINARA,
    PRIMAVERA,
    TOMATO
}