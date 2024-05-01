package edu.ufp.inf.lp2._p04_bank;

public class AccountUnsafe extends Account {


    public AccountUnsafe() {
    }

    public AccountUnsafe(String accountNumber, double balance, Client owner) {
        super(accountNumber, balance, owner);
    }

    @Override
    public double withdraw(double amount) {
        super.setBalance(super.getBalance() - amount);
        return balance();
    }

    @Override
    public double deposit(double amount) {
        super.setBalance(super.getBalance() + amount);
        return balance();
    }

    @Override
    public double transfer(AccountMoneyI destination, double amount) {
        double b = this.withdraw(amount);
        ((AccountUnsafe)destination).deposit(amount);
        return b;
    }

    @Override
    public double balance() {
        return super.getBalance();
    }
}
