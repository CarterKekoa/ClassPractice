import java.util.Scanner;

/**
 A class for accessing a VendingMachine
 */
public class MachineUI
{
    private VendingMachine machine;
    private Scanner in  = new Scanner(System.in);
    /**
     Constructs a console user interface for the vending machine
     @param machine the vending machine to access
     */
    public MachineUI(VendingMachine machine)
    {
        this.machine = machine;
    }

    /**
     Display and process the main menu commands
     */
    public void doMainMenu()
    {
        VendingMachine m = new VendingMachine();

        System.out.println("Welcome to the vending machine program!");
        System.out.println("Please enter your command");
        while (true)
        {
            System.out.print (
                    "A)dd coin, L)ist items, S)elect item, E)mpty, R)estock, or Q)uit: "
            );
            try
            {
                char command = in.nextLine().trim().toUpperCase().charAt(0) ;
                if (command == 'A')
                    this.addCoin();
                else if (command == 'L')
                    this.listItems();
                else if (command == 'S')
                    this.selectItem();
                else if (command == 'E')
                    machine.emptyMoneyBox();
                else if (command == 'R')
                    machine.restock();
                else if (command == 'Q')
                {
                    System.out.println("Goodbye");
                    System.exit(0);
                }
                else
                    System.out.println("Invalid command");
            }
            catch(java.io.IOException e)
            {
                System.out.println("An error occurred.  Try again.");
            }
            catch(java.lang.IllegalArgumentException e)
            {
                System.out.println("Your selection is invalid.  Try again.");
            }
        }
    }

    private void addCoin() throws java.io.IOException
    {
        machine.addCoin();
    }

    private void listItems()
    {
        machine.listItems();
    }

    private void selectItem()
    {
        boolean done = false;
        int itemNum=-1;
        while (!done)
        {
            System.out.print("Enter number of item you would like: ");
            itemNum = Integer.parseInt(in.nextLine()) ;

            if (machine.isSelectionValid(itemNum))
                done = true;
            else
                System.out.println("Invalid input.  Try again.");
        }

        machine.selectItem(itemNum);
    }
}
