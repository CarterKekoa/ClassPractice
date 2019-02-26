/**
 A class for testing the vending machine classes
 */
public class VendingMachineTester
{
    /**
     creates a vending machine object, and a vending machine
     console interface, and runs the interface
     */
    public static void main(String[] args)
    {
        VendingMachine machine = new VendingMachine();
        MachineUI u = new MachineUI(machine);
        u.doMainMenu();
    }
}
