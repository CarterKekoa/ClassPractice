
 //An item in the vending machine
public class VendingMachineItem
{
    private static final int RESTOCK_AMOUNT=10;

    private String name;
    private int cost;
    private int quantity;

    /**
     Construct a VendingMachine object
     @arg name the item's name
     @arg the cost of the item
     */
    public VendingMachineItem(String name, int cost)
    {
        this.name = name;
        this.cost = cost;
        this.quantity = RESTOCK_AMOUNT;
    }

    /**
     Get the item's name
     @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     Get the item's cost
     @return the cost
     */
    public int getCost()
    {
        return cost;
    }

    /**
     Get the number remaining of the item
     @return the number remaining
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     Restock this item
     */
    public void restock()
    {
        quantity = RESTOCK_AMOUNT;
    }

    /**
     Dispense one of this item
     */
    public void dispense()
    {
        // Precondition: Quantity > 0
        quantity = quantity - 1;
        System.out.println("Here is your " + this.getName());
    }
}