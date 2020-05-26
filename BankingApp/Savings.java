
public class Savings extends Account {

    // list properties specific to the savings account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    // constructor to initialize settings for the savings properties
    public Savings(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        // we have access to account number because Savings extends Account
        accountNumber = "1" + accountNumber;
        // System.out.println("ACCOUNT NUMBER: " + this.accountNumber);
        // System.out.println("New Savings Account");
        // System.out.println(name);
        setSafetyDepositBox();
    }

    @Override
    public void setRate() {
        // System.out.println("IMPLEMENT RATE FOR SAVINGS");
        rate = getBaseRate() - .25;
    }

    private void setSafetyDepositBox() {
        // generate numbers to have a 3 digit box id and a 4 digit key
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
    }
    // list any methods specific to savings account

    public void showInfo() {
        // System.out.println("ACCOUNT TYPE: Savings");
        super.showInfo();
        System.out.println("Your Savings Account Features:" + "\n Safety Deposit Box ID: " + safetyDepositBoxID
                + "\n Safety Deposit Box Key: " + safetyDepositBoxKey);

    }

}