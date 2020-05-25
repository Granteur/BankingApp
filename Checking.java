package bankingapp;

public class Checking extends Account {
    //list properties exclusive to checking account
    private int debitCardNumber;
    private int debitCardPin;
    //generate debit card - 12 digit number, 4 digit pin
    //15% of base interest rate

    //constructor to initialize checking account properties
        //for constuctors, public + nameofclass()
    public Checking(String name, String ssn, double initDeposit){
        super(name, ssn, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }
    //we are to implement the abstract method below the constructors but above the specific methods
    //also add 'override'
    @Override
    public void setRate(){
        //debug test-System.out.println("Implement rate for checking");
        rate = getBaseRate() * .15;
    }

    //list any methods specific to checking account
    public void showInfo(){
        super.showInfo();
        System.out.println("Account Type: Checking");
        System.out.println("    Debit Card: " + debitCardNumber);
        System.out.println("    Card PIN: " + debitCardPin);
        System.out.println(" ");
    }
    private void setDebitCard(){
        debitCardNumber = (int)(Math.random() * Math.pow(10, 14));
        debitCardPin = (int) (Math.random() * Math.pow(10, 4));
    }
}