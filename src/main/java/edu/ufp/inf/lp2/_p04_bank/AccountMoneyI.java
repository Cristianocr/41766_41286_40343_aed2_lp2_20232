package edu.ufp.inf.lp2._p04_bank;

public interface AccountMoneyI  {

    public double withdraw(double amount) throws OverWithdrawException;

    public double deposit(double amount) throws IllicitDepositException;

    public double transfer(AccountMoneyI destination, double amount) throws OverWithdrawException, IllicitDepositException;

    public double balance();
}
