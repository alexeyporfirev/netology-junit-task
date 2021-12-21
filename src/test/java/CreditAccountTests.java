import accounts.Account;
import accounts.CreditAccount;
import accounts.SavingsAccount;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CreditAccountTests {
    CreditAccount sut;

    @BeforeEach
    public void init() {
        System.out.println("Test started!");
        sut = new CreditAccount(123, "Сидр Сидоров");
    }

    @BeforeAll
    public static void started() {
        System.out.println("Tests started!");
    }

    @AfterEach
    public void finished() {
        System.out.println("Test completed!");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("Tests completed!");
    }

    /**
     * Проверка того, что возможность оплаты на 20000 должна быть доступна для данного счета. Это кредитный счет, он
     * может уодить в минуса
     */
    @Test
    public void testPay() {
        //arrange
        boolean expected = true;
        //act
        boolean result = sut.pay(20000);
        //assert
        assertEquals(expected, result);

    }

    /**
     * Проверка того, что будет выброшено исключение NullPointerException при попытке перевести деньги на счет, который
     * не существует
     */
    @Test
    public void testTransferThrowsNullPointerException() {
        //arrange
        Account acc = null;
        //act
        Class<NullPointerException> expected = NullPointerException.class;
        //assert
        assertThrows(expected, () -> sut.transfer(acc, 10000));
    }

    /**
     * Проверка того, что возможно осуществить перевод денег на другой существующий банковский аккаунт. А также
     * проверка того, что в этом случае не будет выброшено никакое исключение
     */
    @Test
    public void testTransfer() {
        //arrange
        Account acc = new SavingsAccount(10000, 123, "Иван Иванов");
        //act
        boolean result = sut.transfer(acc, 100);
        //assert
        assertDoesNotThrow(() -> sut.transfer(acc, 100));
        assertTrue(result);
    }

    /**
     * Проверка того, что на новый пустой кредитный счет (баланс = 0) нельзя добавить деньги
     */
    @Test
    public void testAddMoney() {
        //arrange
        int money = 100000;
        //act
        boolean result = sut.addMoney(money);
        //assert
        assertFalse(result);
    }


    /**
     * Использование Hamcrest для проверки того, что объект созданного кредитного счета является подтипом класса Account
     */
    @Test
    public void testSUTClassIsAccountType() {
        //assert
        assertThat(sut.getClass(), typeCompatibleWith(Account.class));
    }

    /**
     * Использование Hamcrest для проверки того, что кол-во денег на новом кредитном счете больше -100000 и меньше или равно 0
     */
    @Test
    public void testAccountAmount() {
        //arrange
        Integer intVal = sut.getAmount();
        //assert
        assertThat(intVal, allOf(greaterThan(-100000), lessThanOrEqualTo(0)));
    }

    /**
     * Использование Hamcrest для проверки того, что имя созданного аккаунта начинается на "Сидр" и заканчивается на "ров"
     */
    @Test
    public void givenString_whenConditions_thenCorrect() {
        //arrange
        String string = sut.getAccountName();
        //assert
        assertThat(string, allOf(containsString("Сидр"), endsWith("ров")));
    }

    /**
     * Использование Hamcrest для проверки того, что новый созданный объект кредитного счета не равен null
     */
    @Test
    public void whenNotNull_thenCorrect() {
        //assert
        assertThat(sut, notNullValue());
    }

}
