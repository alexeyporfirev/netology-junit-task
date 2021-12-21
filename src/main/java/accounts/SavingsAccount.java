package accounts;

public class SavingsAccount extends  Account{

    public SavingsAccount(int amount, int accountID, String accountName) {
        super(amount, accountID, accountName);
    }

    @Override
    public boolean pay(int amount) {
        System.out.println("Неподдерживаемая для данного типа счета операция!");
        return false;
    }

    @Override
    public boolean transfer(Account account, int amount) {
        if (this.getAmount() - amount >= 0) {
            if ( account.addMoney(amount) ) {
                this.setAmount(this.getAmount() - amount);
                System.out.println("Деньги в размере " + amount + " успешно переведены пользователю " +
                        account.getAccountName() + ".");
                System.out.println("Новое значение баланса пользователя " + this.getAccountName() +
                        " после перевода: " + this.getAmount() + ".");
                return true;
            }
            else {
                System.out.println("Невозможно перевести сумму в размере " + amount + " пользователю " +
                        account.getAccountName() + ". Выберите меньшую сумму для перевода.");
                return false;
            }
        } else {
            System.out.println("На счете недостаточно средств для осуществления перевода! Пополните счет минимум на "
                    + (amount - this.getAmount()) + "!");
            return false;
        }
    }

    @Override
    public boolean addMoney(int amount) {
        this.setAmount(this.getAmount() + amount);
        System.out.println("Новое значение баланса пользователя " + this.getAccountName() + " после пополнения: "
                + this.getAmount() + ".");
        return true;
    }
}
