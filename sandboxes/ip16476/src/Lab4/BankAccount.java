package Lab4;

// Remember: compile with javac BankAccount.java and run with java -ea BankAccount
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
        //
        // .... your code should go here ....
        // Ensure interests are correctly dealt with
        //
        int today = dayDeposited;
        int daysInterest = today - dayLastOp;
        float interestSinceLastOp = balance * daysInterest * interestRate;
        interestEarned +=  interestSinceLastOp;
        balance += amount;
        dayLastOp = today;
    }

    public void withdraw(float amount, int dayWithdrawn){
        //
        // .... your code should go here ....
        // Ensure interests are correctly dealt with
        //
        deposit(-amount, dayWithdrawn);
}

    public void credit_interest() {
        //
        // .... your code should go here ....
        // Ensure interests are correctly dealt with
        //
        balance += interestEarned;
        interestEarned = 0f;
    }
}
