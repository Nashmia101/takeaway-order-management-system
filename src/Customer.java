/**
 * Class representing a customer placing an order.
 * Stores the customer's name, phone number, and delivery address.
 * Used in conjunction with the Order class to link customer details with orders.
 * @author Nashmia Shakeel
 * @version 1.0
 */
public class Customer {

    // Instance variables
    private String customerName;
    private int customerPhoneNumber;
    private String customerDeliveryAddress;

    /**
     * Default constructor for creating a customer with placeholder values.
     */
    public Customer() {
        this.customerName = "N/A";
        this.customerPhoneNumber = 0;
        this.customerDeliveryAddress = "N/A";
    }

    /**
     * Parameterized constructor to initialize a customer with actual values.
     *
     * @param customerName            the name of the customer
     * @param customerPhoneNumber     the contact number of the customer
     * @param customerDeliveryAddress the delivery address for the order
     */
    public Customer(String customerName, int customerPhoneNumber, String customerDeliveryAddress) {
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerDeliveryAddress = customerDeliveryAddress;
    }

    /**
     * Gets the customer's name.
     *
     * @return the name of the customer
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Gets the customer's phone number.
     *
     * @return the contact number of the customer
     */
    public int getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    /**
     * Gets the customer's delivery address.
     *
     * @return the delivery address
     */
    public String getDeliveryAddress() {
        return customerDeliveryAddress;
    }

    /**
     * Sets the customer's name.
     *
     * @param customerName the name to assign
     */
    public void setName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Sets the customer's phone number.
     *
     * @param customerPhoneNumber the contact number to assign
     */
    public void setCustomerPhoneNumber(int customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    /**
     * Sets the customer's delivery address.
     *
     * @param deliveryAddress the delivery address to assign
     */
    public void setDeliveryAddress(String deliveryAddress) {
        this.customerDeliveryAddress = deliveryAddress;
    }

    /**
     * Returns a string representation of the customer's details.
     *
     * @return a formatted string containing name, number, and address
     */
    @Override
    public String toString() {
        return "Customer Name: " + customerName +
                "\nPhone Number: " + customerPhoneNumber +
                "\nDelivery Address: " + customerDeliveryAddress;
    }
}