package bankingapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();

        //helpful hint... hold OPTION then right click file on MAC to get the 'copy as file path' option for this part 
        String file = "/Users/aj/WINWorkspace/Java/JavaBuild3/bankingapp/bankingapp/utilities/original.csv";
        /*Debug- test info Checking chkacct1 = new Checking("Sam Wilson", "123456789", 150000);
        Savings savacct1 = new Savings("Tony Stark", "918273645", 500000000);
        
        chkacct1.showInfo();
        savacct1.showInfo();
        chkacct1.deposit(2000);
        chkacct1.withdraw(500);
        chkacct1.transfer("Steve's Account", 1200); 
        chkacct1.compoundInterest();
        savacct1.compoundInterest(); */

        //Read a CSV file and create new accounts based on the data
        List<String[]> newAccountHolders = bankingapp.utilities.CSV.read(file);
        for (String[] accountHolder : newAccountHolders){
            
            String name = accountHolder[0];
            String ssn = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            System.out.println(name + " " + ssn + " " + accountType + " $" + initDeposit );
            System.out.println(" ");
            if (accountType.equals("Savings")){//use this '.equals()' for a String instead of '=='
                accounts.add(new Savings(name, ssn, initDeposit));
            } else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, ssn, initDeposit));
            } else {
                System.out.println("Error Reading Account Type");
            }
        }
    
    //accounts.get(index) - when i'm trying to access an element
    /*accounts.get(5).showInfo() - executes the showinfo method on the 6th 
    index in accounts - don't forget they're zero indexed*/
    
    //for each 
    for (Account acc : accounts){
        System.out.println(" ");
        acc.showInfo(); 
    }
    
}
}