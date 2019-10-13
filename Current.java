
package main;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;


public class Current extends Account {
    private double faiz = 0.17;
    private LocalDate date4;
    

    public Current(int id, int balance,LocalDate date) {
        super(id, balance,date);
        this.date4 = LocalDate.now();
        int a = getBalance() ;
        setBalance(a);
        
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
        int b = getBalance();
        System.out.println("Hesap Acilis Tarihi :"+ getDate() + " Suanki tarih : "+ date4 + " Gecen gun : "+ gecen_gun);
        setBalance((int) b);
        return 0; //kar getirmiyor.
        
        
        
    }    
}
