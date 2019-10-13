
package main;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;


public class LongTerm extends Account {
    private double faiz = 0.24;
    private LocalDate date3;

    public LongTerm(int id, int balance,LocalDate date) {
        super(id, balance,date);
        this.date3 = LocalDate.now();
        
    }
    
    @Override
    public void Deposit(int yatirilan) {
        int a = getBalance() + yatirilan ;
        setBalance(a);
        
       
        
    }

    @Override
    public void Withdraw(int cekilen) {
        int a = getBalance() - cekilen ;
        if(a<0){
            System.out.println("Hesabınızda girdiğiniz miktarda para bulunmuyor."); 
        }
        else if (a>0){
            setBalance(a);
        }
        
    }
    @Override
    public double Benefit() {
        long gecen_gun = DAYS.between(LocalDate.of(2019, 1, 1),LocalDate.now());
        double b =   (((getBalance()*0.24)/365)*gecen_gun);
        System.out.println("Hesap Acilis Tarihi :"+ getDate() + " Suanki tarih : "+ date3 + " Gecen gun : "+ gecen_gun);
        double g = b + getBalance();
        setBalance((int) g);
        return b;
        
    }    
}
