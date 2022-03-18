// Bryce Doyle

package paneracheese;

public class Order {
    
    // Mah Attributes
    protected String customerDescription;
    protected String customerName;
    protected String customerTimestamp;
    
    public Order() { }
    
    // Constructor for when I add orders
    public Order(String description, String name, String timestamp)
    {
        customerDescription = description;
        customerName = name;
        customerTimestamp = timestamp;
    }
    
    
    
}
