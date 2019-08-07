package Bank;

public class BankAccount {
    float balance, interestEarned, interestRate;
    int dayLastOp;

    public BankAccount(float initialBalance, int dayCreated, float rate) {
        balance = initialBalance;
        dayLastOp = dayCreated;
        interestEarned = 0.0f;
        interestRate = rate;
    }

    public void deposit(float amount, int dayDeposited){
       int daysInterest = dayDeposited - this.dayLastOp;
       float interestSinceLastOp = this.balance * daysInterest * this.interestRate;
       this.interestEarned += interestSinceLastOp;
       this.balance += amount;
       this.dayLastOp = dayDeposited;
    }


    public void withdraw(float amount, int dayWithdrawn){
        int daysInterest = dayWithdrawn - this.dayLastOp;
        float interestSinceLastOp = this.balance * daysInterest * this.interestRate;
        this.interestEarned += interestSinceLastOp;
        this.balance -= amount;
        this.dayLastOp = dayWithdrawn;
    }


    public void credit_interest() {
        balance += interestEarned;
        interestEarned = 0.0f;
    }
}

