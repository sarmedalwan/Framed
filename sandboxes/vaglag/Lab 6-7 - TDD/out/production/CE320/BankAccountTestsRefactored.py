from BankAccountRefactored import BankAccount

class BankAccountTest:
    def run_all_tests(self):
        self.test_creation()
        self.test_creation()
        self.test_withdrawal()
        self.test_addInterestToBalance()
        print "Success!"

    def test_creation(self):
        a = self.create_default_account()
        self.assert_account(a,100,31,0)
        assert a.interestRate==0.0001

    def test_deposit(self):
        a = self.create_default_account()
        a.deposit(50,61)
        self.assert_account(a, 150, 61, 0.3)

    def test_withdrawal(self):
        a = self.create_default_account()
        a.withdraw(50,61)
        self.assert_account(a, 50.0, 61, 0.3)

    def test_addInterestToBalance(self):
        a = self.create_default_account()
        a.deposit(50,61)
        a.credit_interest()
        self.assert_account(a,150.3,61,0)

    def create_default_account(self):
        return BankAccount(100.0, 31, 0.0001)

    def assert_account(self, account, expected_balance, expected_day_last_op, expected_interest_earned):
        assert account.balance == expected_balance, "Incorrect balance!"
        assert account.interestEarned == expected_interest_earned, "Incorrect interest!"
        assert account.dayLastOp == expected_day_last_op, "Incorrect day of last operation!"

bt = BankAccountTest()
bt.run_all_tests()