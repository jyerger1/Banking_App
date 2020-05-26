import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) {

        List<Account> accounts = new LinkedList<Account>();

        // Auto-generate method stub

        // Read a CSV file then crate new accounts based on that data

        // Checking chkacc1 = new Checking("Tom Wilson", "23484904", 1500);

        // Savings savacc1 = new Savings("Rich Lowe", "234558494", 25000);

        // savacc1.compound();

        // savacc1.showInfo();

        // System.out.println("**************");

        // chkacc1.showInfo();

        // savacc1.deposit(5000);
        // savacc1.withdraw(200);
        // savacc1.transfer("Brokerage", 3000);

        // READ A CSV FILE
        String file = "/Users/johnyerger/desktop/BankingAppMain/Utilities/info.csv";
        List<String[]> newAccountHolders = CSV.read(file);
        for (String[] accountHolder : newAccountHolders) {

            // System.out.println("NEW ACCOUNT");
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            // change string to double with parse
            double initDeposit = Double.parseDouble(accountHolder[3]);
            // System.out.println(name + " " + sSN + " " + accountType + " " + initDeposit);
            if (accountType.equals("Savings")) {
                // System.out.println("OPEN A SAVINGS ACCOUNT");
                accounts.add(new Savings(name, sSN, initDeposit));
            } else if (accountType.equals("Checking")) {
                // System.out.println("OPEN A CHECKING ACCOUNT");
                accounts.add(new Checking(name, sSN, initDeposit));
            } else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
            // System.out.println(newAccountHolder[0]);
            // System.out.println(newAccountHolder[1]);
            // System.out.println(newAccountHolder[2]);
            // System.out.println(newAccountHolder[3]);
        }
        // accounts.get(5).showInfo();

        for (Account acc : accounts) {
            System.out.println("\n*********");
            acc.showInfo();

        }

    }

}