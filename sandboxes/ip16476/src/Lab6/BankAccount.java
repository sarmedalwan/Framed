package Lab6;

import org.joda.time.Days;
import org.joda.time.LocalDate;

public class BankAccount {
    final String holder;
    private final int number;
    float balance, interestEarned, interestRate;
    LocalDate dayLastOp;

    public BankAccount(String accountHolder, int accountNumber,float initialBalance,
                       LocalDate dayCreated, float rate) {
        balance = initialBalance;
        dayLastOp = dayCreated;
        interestEarned = 0.0f;
        interestRate = rate;
        holder = accountHolder;
        number = accountNumber;
    }

    public void deposit(float amount, LocalDate dayDeposited){
        updateEarnedInterest(dayDeposited);
        balance += amount;
    }


    public void withdraw(float amount, LocalDate dayWithdrawn) throws InsufficientFunds {
        if(amount > balance){
            throw new InsufficientFunds(balance);
        }
        updateEarnedInterest(dayWithdrawn);
        balance -= amount;

    }

    public void credit_interest() {
        balance += interestEarned;
        interestEarned = 0.0f;
    }
    void updateEarnedInterest(LocalDate dayOperation) {
        int daysInterest = Days.daysBetween(dayLastOp, dayOperation).getDays();
        interestEarned += daysInterest * interestRate * balance;
        dayLastOp = dayOperation;
    }

}
