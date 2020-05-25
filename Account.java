package bankingapp;


/*making it abstract means we are not going to be creating objects 
from 'Account'. Instead both Checking and Savings will inherit
from Account and we will generate objects from there
Account = parent, Checking and Savings = child elements*/
public abstract class Account implements IBaseRate{

    
    //List common properties for savings and checking accounts
    /*making elements private means they are only available to the class
    not the subclass*/
    private String name;
    private String ssn;
    private double balance;
    protected String accountNumber;
    protected double rate;
    private static int index = 10000;

    //Constructor to set base properties and initialize the account
        //constructor public + nameofclass()
        public Account(String name, String ssn, double initDeposit){
            this.name = name;
            this.ssn = ssn;
            balance = initDeposit;
            System.out.println("Name: " + name + "\nSSN: " + ssn + "\nBalance: " + balance);

            //set account number
            index++;
            this.accountNumber = setAccountNumber();
            
            //because the name of the method is the same here and in checking, and savings, we can call setRate here
            setRate();
        }
        /*abstract class means we can't create an object from this class
        but we are creating the architecture in the account*/
        public abstract void setRate();

        private String setAccountNumber(){
            /*substring method accesses a portion of the string ssn
            because we are looking for the last 2 digits of the SSN, 
            instead of hardcoding position 8 & 9 (ssn is usually 9 digits
            written in a 123-45-6789 format, we are adopting the approach
            of using the length-2, to pull the 8th and 9th characters.
            the former would work if you know exactly what to look for/where
            to look but the latter is more helpful if you don't know specifically how long the string is that you're usuing.*/
            String last2ofSSN = ssn.substring(ssn.length()-2, ssn.length());
            /*Generate 11-digit account 1 or 2 depending on savings or
            checking account + last 2 of SSN + unique 5-digit #+ random digit number*/
            int uniqueID = index;
            /*Math.random generates a random number between 0 and 1
            Math.pow is a new function I've never heard of, but it takes 2
            inputs and raises the first to the power of the second, so math.
            powo(10, 3) represents 10^3. So in this case, math.random * math.
            pow should give me a 3-digit number*/
            int randomNumber = (int)(Math.random() * Math.pow(10, 3));
            return last2ofSSN + uniqueID + randomNumber;
        }
        public void compoundInterest(){
            double accruedInterest = balance * (rate/100);
            balance += accruedInterest;
            System.out.println("Accrued Interest: " + accruedInterest);
            printBalance();
        }
        public void showInfo(){
            System.out.println("Name: " + name +"\nAccount Number: " + accountNumber + "\nBalance: $" + balance + "\nInterest Rate: " + rate + "%");
            
        }

    //Common methods - deposit(), withdraw(), transfer(), showInfo()
        public void deposit(double amount) {
            balance += amount;
            System.out.println("Depositing $" + amount);
            printBalance();
        }

        public void withdraw(double amount) {
            balance -= amount;
            System.out.println("Withdrawing $" + amount);
            printBalance();
        }

        public void transfer(String toWhere, double amount) {
            balance -= amount;
            System.out.println("Transferring $" + amount + " to " + toWhere);
            printBalance();
        }

        public void printBalance(){
            System.out.println("Current balance: $" + balance);
        }
}