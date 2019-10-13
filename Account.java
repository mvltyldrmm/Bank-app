
package main;

import java.time.LocalDate;
import java.time.Month;


public abstract class Account {
    private int id;
    private int balance;
    private LocalDate date;

    public Account(int id, int balance,LocalDate date) {
        this.id = id;
        this.balance = balance;
        this.date = LocalDate.of(2019, 1, 1);
        
    }
    
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    public abstract void Deposit(int yatirilan);
    public abstract void Withdraw(int cekilen);
    public abstract double Benefit();
}
