class BankAccount:
    def __init__(self, initialBalance, dayCreated, interestRate):
        self.balance = initialBalance
        self.dayLastOp = dayCreated
        self.interestRate=interestRate
        self.interestEarned = 0.0
    
    def deposit(self, amount, dayDeposited ):
        pass # REPLACE WITH YOUR CODE
             # Ensure interests are correctly dealt with

    def withdraw(self, amount, dayWithdrawn):
        pass # REPLACE WITH YOUR CODE
             # Ensure interests are correctly dealt with
            
    def addInterestToBalance(self):
        pass # REPLACE WITH YOUR CODE
             # Ensure interests are correctly dealt with

def test_creation(): 
    a = BankAccount(100.0,31,0.0001)
    assert a.balance==100.0, "Incorrect balance!"
    # Add tests for the remaining fields of BankAccount 
    #
    # .... your code should go here ....
    #
    
def test_deposit():
    a = BankAccount(100.0,31,0.0001)
    a.deposit(50,61)
    assert a.balance==150.0, "Incorrect balance!"
    assert a.interestEarned==0.3, "Incorrect interest!"
    assert a.dayLastOp == 61, "Incorrect day of last operation!"
        
def test_withdrawal():
    pass # REPLACE WITH YOUR TESTING CODE
    

def test_addInterestToBalance():
    pass # REPLACE WITH YOUR TESTING CODE

# Now we invoke the tests
test_creation()
test_deposit()
test_withdrawal()
test_addInterestToBalance()
print "Success!"

