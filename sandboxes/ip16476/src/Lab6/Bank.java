package Lab6;

import org.joda.time.LocalDate;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    public Map<String,BankAccount> currentAccounts;
    public LocalDate today;
    private int firstAvailableNumber;

    public Bank() {
        currentAccounts = new HashMap<String, BankAccount>();
        today = new LocalDate();
        firstAvailableNumber = 0;
    }

    public void createAccount(String holder, float initialBalance, float interestRate) {
        BankAccount a = new BankAccount(holder,firstAvailableNumber,initialBalance,today,interestRate);
        currentAccounts.put(holder, a);
        firstAvailableNumber += 1;
    }

    public void deposit(String holder, float amount) {
        currentAccounts.get(holder).deposit(amount,today);
    }

    public void nextDay() {
        today = today.plusDays(1);
    }

    public void withdraw(String holder, float amount) throws InsufficientFunds {
        currentAccounts.get(holder).withdraw(amount,today);
    }

    public void creditInterest() {
        for ( Map.Entry<String,BankAccount> me : currentAccounts.entrySet()) {
            BankAccount a = me.getValue();
            a.updateEarnedInterest(today);
            a.c
        }
    }

    public BankAccount get(String holder ) {
        return currentAccounts.get(holder);
    }
}
