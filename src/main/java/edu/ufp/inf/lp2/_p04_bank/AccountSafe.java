package edu.ufp.inf.lp2._p04_bank;

public class AccountSafe extends Account {
    public AccountSafe() {
    }

    public AccountSafe(String accountNumber, double balance, Client owner) {
        super(accountNumber, balance, owner);
    }

    @Override
    public double withdraw(double amount) throws OverWithdrawException {
        if (super.balance() > amount && amount > 0) {
            super.setBalance(super.getBalance() - amount);
            return balance();
        }
        throw new OverWithdrawException("NOT ENOUGH MONEY TO WITHDRAW");
    }

    @Override
    public double deposit(double amount) throws IllicitDepositException {
        if (amount > 0) {
            super.setBalance(super.getBalance() + amount);
        }else{
            throw new IllicitDepositException("Cannot deposit negative values!!");
        }
        return super.balance();
    }

    @Override
    public double transfer(AccountMoneyI destination, double amount) throws OverWithdrawException, IllicitDepositException {
        double b = this.withdraw(amount);
        try {
            destination.deposit(amount);
        } catch (IllicitDepositException ide) {
            this.setBalance(b+amount);
            throw new IllicitDepositException("Cannot transfer negative amount! Previous withdraw was correct!");
        }
        return b;
    }

}
