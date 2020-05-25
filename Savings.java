package bankingapp;

public class Savings extends Account{
    // list properties exclusive to savings account
    private int depositBoxID;
    private int depositBoxKey;
    //generate safety deposit box - 3 digit ID number, 4 digit access code
    //.25 less than base interest rate

    // constructor to initialize savings account properties
    public Savings(String name, String ssn, double initDeposit){
        super(name, ssn, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }
    private void setSafetyDepositBox(){
        depositBoxID = (int)(Math.random() * Math.pow(10, 3));
        depositBoxKey = (int)(Math.random() * Math.pow(10, 4));
    }
    
    // we are to implement the abstract method below the constructors but above the specific methods
    public void setRate() {
        //debugtest-System.out.println("Implement rate for savings");
        rate = getBaseRate() - .25;
    }

    // list any methods specific to savings account
    public void showInfo() {
        super.showInfo();
        System.out.println("Account Type: Savings");
        System.out.println("    Deposit Box: " + depositBoxID);
        System.out.println("    Deposit Box Key: " + depositBoxKey);
        System.out.println(" ");
    }
}