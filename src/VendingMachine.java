import java.util.ArrayList;

/**
 A vending machine with a set of items and a money box
 */
public class VendingMachine
{
    private ArrayList<VendingMachineItem> itemList
            = new ArrayList<VendingMachineItem>();

    private MoneyBox box = new MoneyBox();
    /**
     Constructs a vending machine
     */
    public VendingMachine()
    {
        itemList.add(new VendingMachineItem("Coke", 2));
        itemList.add(new VendingMachineItem("Diet Coke", 2));
        itemList.add(new VendingMachineItem("Sprite", 2));
        itemList.add(new VendingMachineItem("Ginger Ale", 4));
        itemList.add(new VendingMachineItem("Water", 1));
    }

    /**
     Print the names and costs of all the items in the machine
     */
    public void listItems()
    {
        System.out.println();
        int i = 0;
        for (VendingMachineItem x : itemList)
        {
            System.out.println("Item " + (i+1) + ": " + x.getName()
                    + ",  Cost: " + x.getCost() + " coins"
                    + ",  Quantity: " + x.getQuantity() + "."
            );
            i++;
        }
        System.out.println();
        System.out.println("You have deposited " + box.getAmount() + " coins");
        System.out.println();
    }

    /**
     Check if a selection is valid
     @return whether the selection is valid
     */
    public boolean isSelectionValid(int i)
    {
        return 1 <= i && i <= itemList.size();
    }

    /**
     Take all of the coins out of the moneybox
     */
    public void emptyMoneyBox()
    {
        box.removeCoins();
    }


    /**
     Add a coin to the money box
     */
    public void addCoin()
    {
        box.addCoin();
    }

    /**
     Restock each item in the machine
     */
    public void restock()
    {
        for (VendingMachineItem x : itemList )
        {
            x.restock();
        }
        System.out.println("All items have been restocked!\n");
    }

    /**
     Select an item from the machine
     @arg selection the number of the item to select
     */
    public void selectItem(int selection)
    {
        if (selection >= 1 & selection <= itemList.size())
        {
            VendingMachineItem i = itemList.get(selection - 1);
            if (box.getAmount() < i.getCost())
            {
                System.out.println("You have not entered enough coins!\n");
                box.returnCoins();
            }
            else if (i.getQuantity() == 0)
            {
                System.out.println("This item is out of stock!\n");
                box.returnCoins();
            }
            else
            {
                box.keepCoins();
                i.dispense();
            }
        }

        else
            throw new IllegalArgumentException("Invalid selection");

        System.out.println();
    }
}