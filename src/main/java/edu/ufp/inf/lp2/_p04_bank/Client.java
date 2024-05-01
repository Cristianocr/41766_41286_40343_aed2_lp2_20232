package edu.ufp.inf.lp2._p04_bank;

import edu.ufp.inf.lp2.p01_intro.Date;
import edu.ufp.inf.lp2.p01_intro.Person;

import java.util.ArrayList;
import java.util.Objects;

public class Client extends Person implements ClientRelationshipsI {

    private String vatNumber;

    private ArrayList<Account> accounts;

    public Client(String idNumber, String name, String address, Date birth) {
        super(idNumber, name, address, birth);
    }

    public Client(String idNumber, String name, String address, Date birth, String vatNumber, ArrayList<Account> accounts) {
        super(idNumber, name, address, birth);
        this.vatNumber = vatNumber;
        this.accounts = accounts;
    }

    @Override
    public void addAccount(Account newAccount) {
        this.accounts.add(newAccount);
    }

    public void listAccount() {
        for (Account a : this.accounts) {
            System.out.println(a);
        }
    }

    @Override
    public Account getAccount(int number) {
        return this.accounts.get(number);
    }

    @Override
    public String toString() {
        return "Client{" +
                "vatNumber='" + vatNumber + '\'' +
                ", accounts=" + accounts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(vatNumber, client.vatNumber) && Objects.equals(accounts, client.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vatNumber, accounts);
    }
}
