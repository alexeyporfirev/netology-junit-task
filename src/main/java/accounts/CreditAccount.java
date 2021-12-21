package accounts;

public class CreditAccount extends  Account{

    public CreditAccount(int accountID, String accountName) {
        super(0, accountID, accountName);
    }

    @Override
    public boolean pay(int amount) {
        setAmount(this.getAmount() - amount);
        System.out.println("Оплачена покупка на " + amount + ". Новое значение баланса после пополнения: "
                + this.getAmount() + ".");
        return true;

    }

    @Override
    public boolean transfer(Account account, int amount) {
        if ( account.addMoney(amount) ) {
            this.setAmount(this.getAmount() - amount);
            System.out.println("Деньги в размере " + amount + " успешно переведены пользователю "
                    + account.getAccountName() + ".");
            System.out.println("Новое значение баланса пользователя " + this.getAccountName() + " после перевода: "
                    + this.getAmount() + ".");
            return true;
        } else {
            System.out.println("Невозможно перевести сумму в размере " + amount + " пользователю " +
                    account.getAccountName() + ". Выберите меньшую сумму для перевода.");
            return false;
        }
    }

    @Override
    public boolean addMoney(int amount) {
        int newAmount = this.getAmount() + amount;
        if (newAmount <= 0) {
            this.setAmount(newAmount);
            System.out.println("Новое значение баланса пользователя " + this.getAccountName() + " после пополнения: "
                    + this.getAmount() + ".");
            return true;
        } else {
            System.out.println("Введна слишком большая сумма пополнения! Необходимо ввести сумму, не превышающую "
                    + (-this.getAmount()) + "!");
            return false;
        }
    }
}
