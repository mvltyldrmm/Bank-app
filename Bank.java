
package main;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Random;


public class Bank {
    public ArrayList<Account> hesaplar = new ArrayList<>();
    private LocalDate anlik_tarih;
    
    

    public Bank() {
        this.anlik_tarih = LocalDate.now();
        
    }
    public ArrayList<Account> getHesaplar() {
        return hesaplar;
        
    }

    public void setHesaplar(ArrayList<Account> hesaplar) {
        this.hesaplar = hesaplar;
    }
    
    public int İd_uret(){ //Rastgele id uretme metodu. Bir onceki id'lere bakarak id uretiyor..
        boolean sart = true;
        int rastgele1 = 0;
        if(hesaplar.size() == 0){
            Random sayi = new Random();
            rastgele1 = sayi.nextInt(1000000000)+1;
            
        }
        else
            do{
            
            Random sayi= new Random();
            int rastgele = sayi.nextInt(1000000000)+1;
            for (int i = 0; i < hesaplar.size(); i++) {
                if(rastgele == hesaplar.get(i).getId()){
                    sart = true;
                    break;
                    
                    
                }
                else 
                    sart = false;
                    rastgele1 = rastgele;
  
            }
             

        }while(sart);
        return rastgele1;
    }
    
    
    
    public void getAccount(){ //tum hesapların listesi
        for (int i = 0; i < hesaplar.size(); i++) {
            System.out.println("HESAP İD'Sİ :" + hesaplar.get(i).getId()+"\n"
                    + "HESAP BAKİYESİ :"+ hesaplar.get(i).getBalance()+"TL"+ "\n"
                            + "HESAP AÇILIŞ TARİHİ :"+ hesaplar.get(i).getDate());
                            
            
        }
    }
    
    public LocalDate getDate(){ //sistemin suanki tarihini donduruyor..
        LocalDate now = LocalDate.now(); //sistemin anlık tarihi
        return now;
    }
    
    
}
