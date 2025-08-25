# takeaway-order-management-system
Java-based restaurant order management system with automated promotions, meal classification (vegan/vegetarian/meat), and FIFO delivery queue. Features OOP design principles, input validation, and "Buy 2 Get 1 Free" promotional logic
Implements object-oriented design with abstract inheritance and interface-based promotions to manage restaurant orders with automated meal classification, FIFO delivery processing, and dynamic pricing calculations for pizza and pasta customization.
Task: Develop a takeaway order management system for pizza and pasta delivery operations.
Constraints:

Each order must contain at least one food item with validated customer information.
Orders must be processed using FIFO delivery sequence.
Meal types must be automatically classified as MEAT, VEGETARIAN, or VEGAN based on ingredient analysis.
"Buy 2 Get 1 Free" promotions must be applied automatically without manual intervention.

Approach

Modeled using abstract inheritance hierarchy with FoodItem base class and concrete Pizza/Pasta implementations.
Built interface-based promotional system through FreeInterface for consistent discount behavior.
Implemented enum-driven type safety for toppings and meal classifications with HashMap price lookups.
Applied polymorphic method dispatch for price calculation and meal type determination across different food items.
Structured using separation of concerns with TakeawayDriver controller managing Order and Customer data models.

Order Processing System

Task: Manage customer orders with automatic meal classification and promotional pricing.
Constraints: FIFO delivery order, ingredient-based meal typing, automatic discount application.
Input: Customer details (name, phone, address) and food item selections with toppings.
Output: Processed orders with calculated pricing, applied promotions, and meal type classification.

Approach

Built a queue-based order management system using ArrayList for efficient FIFO processing.
Implemented precedence-based meal classification with logic hierarchy: MEAT > VEGETARIAN > VEGAN.
Designed additive promotional system that inserts free items rather than applying percentage discounts.
Ensured efficient complexity:

Order Creation: O(n) where n = number of items added.
Price Calculation: O(t) where t = total toppings across all items.
Delivery Processing: O(1) for FIFO removal operations.



Food Item Hierarchy

Task: Create extensible food item system supporting pizzas with multiple toppings and pasta with single toppings.
Constraints: Consistent pricing model, automated meal type classification, promotional eligibility.
Implementation: Abstract FoodItem class with concrete Pizza and Pasta subclasses.

Approach

Implemented Template Method Pattern with abstract methods requiring concrete price calculation implementations.
Used HashMap-based topping price mapping for O(1) price lookups during calculation.
Applied Strategy Pattern for different meal classification rules between pizza and pasta items.
Integrated FreeInterface implementation for consistent promotional behavior across all food types.

Input Validation Framework

Character-by-character string analysis for name validation (alphabetic + spaces only).
Numeric validation with minimum length requirements for phone numbers (8+ digits).
Address validation with minimum character thresholds (5+ characters required).
Range-bounded menu selection validation with error recovery and user-friendly messaging.

Results

Implemented a working restaurant order management system that processes customer orders with automated business logic.
Implemented polymorphic food item hierarchy with consistent pricing and classification across different item types.
Both systems documented with complete object-oriented design patterns and comprehensive input validation.

Author
Nashmia Shakeel
