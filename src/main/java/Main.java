import accounts.Account;
import accounts.CheckingAccount;
import accounts.CreditAccount;
import accounts.SavingsAccount;

public class Main {

    public static void main(String[] args) {

        Account savingAccount = new SavingsAccount(10000, 123, "Иван Иванов");
        Account creditAccount = new CreditAccount(123, "Петр Петров");
        Account checkingAccount = new CheckingAccount(10000, 123, "Сидр Сидоров");

        savingAccount.addMoney(100);
        savingAccount.pay(20000);
        savingAccount.transfer(checkingAccount, 10000);
        savingAccount.transfer(checkingAccount, 1000);

        System.out.println();

        creditAccount.addMoney(100);
        creditAccount.pay(30000);
        creditAccount.transfer(checkingAccount, 30000);
        creditAccount.transfer(checkingAccount, 3000);
        creditAccount.addMoney(100000);
        creditAccount.addMoney(43000);

        System.out.println();

        checkingAccount.addMoney(1000);
        checkingAccount.pay(200000);
        checkingAccount.transfer(savingAccount, 10000);
        checkingAccount.transfer(creditAccount, 30000);
    }
}