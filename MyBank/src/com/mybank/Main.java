package com.mybank;

import com.mybank.account.CheckingAccount;
import com.mybank.account.SavingsAccount;

public class Main {

    public static void main(String[] args) {
        // two bank account, please
        CheckingAccount one = new CheckingAccount(
                "customer one",
                "customer one account",
                100.0,
                "c1");

        SavingsAccount two = new SavingsAccount(
                "saver two",
                "saver's savings account",
                21.0,
                "s2"
        );

        two.withdraw(1.0);
        two.transfer(one, 5.13);

        System.out.println("Account one balance: " + one.getBalance());
        System.out.println("Account two balance: " + two.getBalance());
    }
}
