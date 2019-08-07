import org.joda.time.Days;
import org.joda.time.LocalDate;

public class BankAccount {
    String accountHolder;
    float balance, interestEarned, interestRate;
    LocalDate dayLastOp;
    int accountNumber;

    public BankAccount(float initialBalance, LocalDate dayCreated, float rate, String accountHolder, int accountNumber) {
        balance = initialBalance;
        dayLastOp = dayCreated;
        interestEarned = 0.0f;
        interestRate = rate;
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
    }

    public void deposit(float amount, LocalDate dayDeposited){
        Days daysInterest = Days.daysBetween(dayLastOp,dayDeposited);
        interestEarned += daysInterest.getDays() * interestRate * balance;
        balance += amount;
        dayLastOp = dayDeposited;
    }

    public void withdraw(float amount, LocalDate dayWithdrawn){
        deposit(-amount,dayWithdrawn);
    }

    public void credit_interest() {
        balance += interestEarned;
        interestEarned = 0.0f;
    }

}
