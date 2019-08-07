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
        calcInterest(dayDeposited);
        balance+=amount;
        dayLastOp=dayDeposited;
    }
    
    public void credit_interest() {
        balance += interestEarned;
    }

    public void calcInterest(int dayOfOp){
        int daysPassed = dayOfOp-dayLastOp;
        float interestPerDay = interestRate*balance;
        interestEarned=daysPassed*interestPerDay;
    }
    
    public static void main(String[] args) {
	Tests.test_creation();
	Tests.test_deposit();
	Tests.test_withdraw();
	Tests.test_credit_interest();
	System.out.println("Success!");
    }
}
