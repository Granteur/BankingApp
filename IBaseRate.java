package bankingapp;

public interface IBaseRate {
    /*interface is something from the outside that you're bringing in
    creating a contract that when implemented, all the properties are used
    in our application*/
    // write method that returns base rate
    default double getBaseRate(){
        return 2.5;
    }
}