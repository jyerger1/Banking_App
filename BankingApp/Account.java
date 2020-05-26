
public abstract class Account implements IBaseRate {
    // abstract because we wont be creating objects from account class. They will be
    // inherited. Checking and saving are the child classes.

    // List Common properties for savings and checking account / everything thats
    // shared
    private String name;
    private String sSN;
    private double balance;

    private static int index = 10000;
    // this will be incremented everytime we create a new account
    protected String accountNumber;
    protected double rate;

    // constructor to set base properties and initilaize the account
    public Account(String name, String sSN, double initDeposit) {
        // System.out.println("NAME: " + name);
        // System.out.print("NEW ACCOUNT: ");
        this.name = name;
        this.sSN = sSN;
        balance = initDeposit;
        // System.out.println("NAME: " + name + " SSN: " + sSN + " BALANCE: " +
        // balance);

        // this class (SUPER CLASS) is called first. Then it's extensions

        // set account number
        // incrememnt account number
        index++;
        this.accountNumber = setAccountNumber();
        // we can call this in parent class
        setRate();

    }

    // abstract means we cant create an object from this class / we're creating the
    // arcitecture / not defineing antyhing

    public abstract void setRate();

    private String setAccountNumber() {
        String lastTwoOfSSN = sSN.substring(sSN.length() - 2, sSN.length());
        // we want last two of SSN / length-2 will start at the second to last position
        // and go till the end
        int uniqueID = index;
        // math random will generate a number between 0 and 1
        // multiply by 10 to the third to get a three digit
        // cast as integer (int)
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));
        return lastTwoOfSSN + uniqueID + randomNumber;
    }

    public void compound() {
        double accruedInterest = balance * (rate / 100);
        balance = balance + accruedInterest;
        System.out.println("ACCRUED INTEREST: $" + accruedInterest);
        printBalance();
    }

    // list common methods / transactions

    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposition $" + amount);
        printBalance();
    }

    public void withdraw(double amount) {
        balance = balance - amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();

    }

    public void transfer(String toWhere, double amount) {
        balance = balance - amount;
        System.out.println("Transferring $" + amount + " to " + toWhere);
        printBalance();

    }

    public void printBalance() {
        System.out.println("Your balance is now $" + balance);
    }

    public void showInfo() {
        System.out.println("NAME: " + name + "\nACCOUNT NUMBER: " + accountNumber + "\nBALANCE: " + balance + "\nRATE: "
                + rate + "%"

        );
    }

}