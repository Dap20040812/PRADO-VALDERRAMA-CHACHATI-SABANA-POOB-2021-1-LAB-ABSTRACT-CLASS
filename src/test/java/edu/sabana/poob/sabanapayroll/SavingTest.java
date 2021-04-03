package edu.sabana.poob.sabanapayroll;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class SavingTest {

    @Test
    public void shouldGetDepositDiscount() {
        Savings account = new Savings();

        assertTrue(Double.compare(2000, account.getDepositDiscount()) == 0);
    }

    @Test
    public void shouldDepositAmount() {
        Savings account = new Savings();
        boolean result = account.deposit(10000);

        assertTrue(result);
        assertTrue(Double.compare(8000, account.getBalance()) == 0);
    }

    @Test
    public void shouldNotDepositAmount() {
        Savings account = new Savings();

        assertFalse(account.deposit(1000));
        assertFalse(account.deposit(2000));
        assertTrue(Double.compare(0, account.getBalance()) == 0);
    }

    @Test
    public void shouldDepositMontlyInterest() {
        Savings account = new Savings();
        assertTrue(Double.compare(account.getBalance()* account.ANNUAL_INTEREST_RATE/12, account.depositMontlyInterest()) == 0);
        assertTrue(Double.compare(account.getBalance()* account.ANNUAL_INTEREST_RATE/12, account.getBalance()) == 0);
    }

    @Test
    public void shouldWithdraw() {
        Savings account = new Savings();

        assertTrue(account.deposit(10000));
        assertTrue(Double.compare(8000, account.getBalance()) == 0);

        assertTrue(account.withdraw(4000));
        assertTrue(Double.compare(3000, account.getBalance()) == 0);

    }
    @Test
    public void shouldNotWithdraw() {
        Savings account = new Savings();

        assertTrue(account.deposit(10000));
        assertTrue(Double.compare(8000, account.getBalance()) == 0);

        assertFalse(account.withdraw(8000));
        assertTrue(Double.compare(8000, account.getBalance()) == 0);

    }

    @Test
    public void shouldKeepBalance() {
        Savings account = new Savings();

        assertTrue(account.deposit(11000)); //9000
        assertFalse(account.deposit(1000));
        assertFalse(account.deposit(2000));
        assertTrue(account.deposit(21000)); // 19000
        account.depositMontlyInterest();

        assertEquals((int)(28000 + account.getBalance() * account.ANNUAL_INTEREST_RATE / 12), (int)(account.getBalance()));
    }

}
