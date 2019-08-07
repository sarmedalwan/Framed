import org.joda.time.LocalDate;

import java.util.ArrayList;

public class Bank {
    private ArrayList<BankAccount> accounts;

    public Bank(){
        accounts = new ArrayList<>();
    }

    public BankAccount findAccount(int accountNumber) {
        return accounts.stream().filter((BankAccount o) -> o.accountNumber == accountNumber).findFirst().get();

    }

    public void addAccount(BankAccount bankAccount){
        accounts.add(bankAccount);
    }

    public int getNumAccounts(){
        return accounts.size();
    }

    public void depositToAccount(int accountNumber, float amount, LocalDate dayOfLastOp) {
        BankAccount acc = findAccount(accountNumber);
        acc.deposit(amount, dayOfLastOp);
    }
}
