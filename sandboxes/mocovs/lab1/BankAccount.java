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
        int daysInterest = dayDeposited - this.dayLastOp;
        float interestSinceLastOp = this.balance * daysInterest * this.interestRate;
        this.interestEarned += interestSinceLastOp;
        this.balance += amount;
        this.dayLastOp = dayDeposited;
	// 
    }
    

    
    public void withdraw(float amount, int dayWithdrawn){
       this.deposit(-amount, dayWithdrawn);
    }
    

    
    public void creditInterest() {

        this.balance += this.interestEarned;
        this.interestEarned = 0f;
    }
    

    

}
