class BankAccount:
    def __init__(self, initialBalance, dayCreated, interestRate):
        self.balance = initialBalance
        self.dayLastOp = dayCreated
        self.interestRate=interestRate
        self.interestEarned = 0

    def deposit(self, amount, dayDeposited ):
        self.updateInterestEarned(dayDeposited)
        self.balance += amount
        self.dayLastOp = dayDeposited

    def withdraw(self, amount, dayWithdrawn):
        self.deposit(-amount, dayWithdrawn)

    def credit_interest(self):
        self.balance += self.interestEarned
        self.interestEarned = 0

    def updateInterestEarned(self, dayDeposited):
        daysInterest = dayDeposited - self.dayLastOp
        self.interestEarned += daysInterest * self.interestRate * self.balance

