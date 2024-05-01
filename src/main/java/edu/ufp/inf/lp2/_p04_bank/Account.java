package edu.ufp.inf.lp2._p04_bank;

import edu.ufp.inf.lp2.p01_intro.Date;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Account implements AccountMoneyI, AccountOwnershipsI {
    private String accountNumber;

    private double balance;

    private Client owner;


    public Account() {

    }

    public Account(String accountNumber, double balance, Client owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
    }


    public static void main(String[] args) {
        ArrayList<Account> acc = new ArrayList<>();
        Date d = new Date((short) 17, (short) 3, 2002);

        Client c = new Client("1", "Cristiano", "Rua 123", d, "23124", acc);
        AccountSafe as = new AccountSafe("1111", 500, c);

        try {
            System.out.println(as.withdraw(200));
            System.out.println(as.withdraw(400));
        } catch (OverWithdrawException owe) {
            System.out.println(owe);
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public abstract double withdraw(double amount) throws OverWithdrawException;

    @Override
    public abstract double deposit(double amount) throws IllicitDepositException;
    @Override
    public abstract double transfer(AccountMoneyI destination, double amount) throws OverWithdrawException, IllicitDepositException;

    @Override
    public double balance() {
        return balance;
    }

    protected double getBalance() {
        return this.balance;
    }

    protected void setBalance(double balance) {
        this.balance += balance;
    }

    @Override
    public void setAccountOwner(Client owner) {
        this.owner = owner;
    }

    @Override
    public Client getAccountOwner() {
        return this.owner;
    }


    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", owner=" + owner +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(balance, account.balance) == 0 && Objects.equals(accountNumber, account.accountNumber) && Objects.equals(owner, account.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, balance, owner);
    }
}
