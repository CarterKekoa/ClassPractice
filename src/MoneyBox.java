/**
 A class for keeping money that was placed in the machine
 */
public class MoneyBox {

    int keepAmount;
    private int holdingAmount;

    /**
     Returns the amount that has been deposited to buy the current item
     @return the amount deposited
     */
    public int getAmount(){
        return holdingAmount;
    }

    /**
     Deposits a coin to buy the current item
     */
    public void addCoin(){
        holdingAmount++;
        System.out.println("Your balance is: " + this.getAmount());
    }

    /**
     Returns the deposited coins to the user
     */
    public void returnCoins(){
        System.out.println("Returning " + this.getAmount() + " coins.");
        holdingAmount = 0;
    }

    /**
     Moves the deposited coins into the storage area
     */
    public void keepCoins(){
        keepAmount = keepAmount + holdingAmount;
        System.out.println("Keeping: " + this.getAmount() + " coins.");
        holdingAmount = 0;
    }

    /**
     Takes out all of the deposited coins and the coins in the storage area
     */
    public void removeCoins(){
        keepAmount = keepAmount + holdingAmount;
        holdingAmount = 0;
        System.out.println("Removing " + keepAmount + " from the money box.");
        keepAmount = 0;
    }

}
