package BankAccountRefactoredTesting;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;

public class BankAccountRefactored {
    float balance, interestEarned, interestRate;
    LocalDate dayLastOp;

    public BankAccountRefactored(float initialBalance, LocalDate dayCreated, float rate) {
        balance = initialBalance;
        dayLastOp = dayCreated;
        interestEarned = 0.0f;
        interestRate = rate;
    }

    public void deposit(float amount, LocalDate dayDeposited){
        int daysInterest = Days.daysBetween(dayLastOp, dayDeposited).getDays();
        interestEarned += daysInterest * interestRate * balance;
        balance += amount;
        dayLastOp = dayDeposited;
    }

    public void withdraw(float amount, LocalDate dayWithdrawn){
        int daysInterest = Days.daysBetween(dayLastOp, dayWithdrawn ).getDays();
        interestEarned += daysInterest * interestRate * balance;
        balance -= amount;
        dayLastOp = dayWithdrawn;
    }

    public void credit_interest() {
        balance += interestEarned;
        interestEarned = 0.0f;
    }

}
