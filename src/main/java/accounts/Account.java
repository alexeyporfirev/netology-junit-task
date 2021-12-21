package accounts;

public abstract class Account {

    private int amount;
    private int accountID;
    private String accountName;

    public Account(int amount, int accountID, String accountName) {
        this.amount = amount;
        this.accountID = accountID;
        this.accountName = accountName;
    }

    public abstract boolean pay(int amount);

    public abstract boolean transfer(Account account, int amount);

    public abstract boolean addMoney(int amount);


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
