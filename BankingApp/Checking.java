public class Checking extends Account {

    // list properties specific to a checking account
    private int debitCardNumber;
    private int debitCardPIN;

    // constructor to initialize checking account properties
    public Checking(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        // we have access to account number because Checking extends Account
        accountNumber = "2" + accountNumber;
        // System.out.println("ACCOUNT NUMBER: " + this.accountNumber);
        // System.out.println("New Checking Account");
        // System.out.println("Name: " + name);

        setDebitCard();
    }

    @Override
    public void setRate() {
        // System.out.println("IMPLEMENT RATE FOR CHECKING");
        rate = getBaseRate() * .15;
    }

    // list any methods specific to the checking account
    private void setDebitCard() {
        debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
        debitCardPIN = (int) (Math.random() * Math.pow(10, 4));

        // System.out.println("CARD: " + this.debitCardNumber);
        // System.out.println("PIN: " + this.debitCardPIN);

    }

    public void showInfo() {
        // without superShowInfo() showInfo will overwrite super Account showInfo()
        // bring in super.showInfo to be able to use both showInfo methods
        super.showInfo();
        System.out.println("Your Checking Account Features:" + "\n Debit Card Number: " + debitCardNumber
                + "\n Debit Card PIN" + debitCardPIN);
    }

}