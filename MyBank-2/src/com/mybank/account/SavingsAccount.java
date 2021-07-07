package com.mybank.account;

public class SavingsAccount extends AbstractAccount {

    public SavingsAccount(String customer, String accountName, double balance, String accountNumber) {
        super(customer, accountName, balance, accountNumber);
    }

    @Override
    public Double deposit(double amount) throws IllegalArgumentException {
        // validate amount is good
        checkAmountIsGreaterThanZeroElseThrow(amount);

        return super.deposit(amount);
    }

    @Override
    public Double withdraw(double amount) {
        System.out.println("Cannot withdraw from a savings account.");
        return null;
    }

    @Override
    public Double transfer(AbstractAccount toAccount, double amount) {
        if (amount > 0.0) {
            if (this.getBalance() >= amount) {
                return super.transfer(toAccount, amount);
            } else {
                System.out.println("Insufficient funds: " + this.getBalance());
                return null;
            }
        } else {
            System.out.println("Invalid amount to transfer: " + amount);
            return null;
        }
    }
}
