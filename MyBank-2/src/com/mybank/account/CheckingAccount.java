package com.mybank.account;

public class CheckingAccount extends AbstractAccount {
    public CheckingAccount(String customer, String accountName, double balance, String accountNumber) {
        super(customer, accountName, balance, accountNumber);
    }

    @Override
    public Double deposit(double amount) throws IllegalArgumentException {
        // validate amount is good
        checkAmountIsGreaterThanZeroElseThrow(amount);

        return super.deposit(amount);
    }

    // returns the amount after withdrawing, if successful. Otherwise null
    @Override
    public Double withdraw(double amount) {
        if (amount > 0.0) {
            if (this.getBalance() >= amount) {
                super.withdraw(amount);
                return amount;
            } else {
                // no money for you, sadge
                System.out.println("Insufficient funds: " + this.getBalance());
                return null;
            }
        } else {
            System.out.println("Invalid amount to withdraw: " + amount);
            return null;
        }
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
