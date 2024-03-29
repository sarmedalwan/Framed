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
     
    private static void test_creation() {
	BankAccount a = new BankAccount(100.0f,31,0.0001f);
	assert a.balance==100.0f : "Incorrect balance!";
	// Add tests for the remaining fields of BankAccount 
	//
	// .... your code should go here ....
	//
    }
        
    public void deposit(float amount, int dayDeposited){
	//
	// .... your code should go here ....
	// Ensure interests are correctly dealt with
	// 
    }
    
    private static void test_deposit(){
	BankAccount a = new BankAccount(100.0f,31,0.0001f);
	a.deposit(50f, 61);
	assert a.balance==150f;
	assert a.interestEarned>0.299999f && a.interestEarned<0.3000001f;
	assert a.dayLastOp == 61;
    }
    
    public void withdraw(float amount, int dayWithdrawn){
	//
	// .... your code should go here ....
	// Ensure interests are correctly dealt with
	// 
    }
    
    private static void test_withdraw(){
	//
	// .... your code should go here ....
	// 
    }
    
    public void credit_interest() {
	//
	// .... your code should go here ....
	// Ensure interests are correctly dealt with
	// 
    }
    
    private static void test_credit_interest() {
	//
	// .... your code should go here ....
	// 
    }
    
    public static void main(String[] args) {
	test_creation();
	test_deposit();
	test_withdraw();
	test_credit_interest();
	System.out.println("Success!");
    }
}
