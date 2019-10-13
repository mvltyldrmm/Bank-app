package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
         ArrayList<String> hesap_gecmisi = new ArrayList<>(); //HESAP GECMİSİNİN TUTULACAGI STRİNG TURUNDEN LİSTE
        /*Random sayi = new Random();
        System.out.println(sayi.nextInt((1000000000)+1));
         */

        
        Bank liste = new Bank(); // BANK SINIFINDAN NESNEMİZ. 
        do {
            System.out.println("BANKAMIZA HOŞ GELDİNİZ.");
            System.out.println("-------------------------------");

            System.out.println("Yeni hesap için : 1 \n"
                    + "Giriş için : 2 \n"
                    + "Programdan çıkış için : 3");

            int sayi1 = input.nextInt();
            
            switch (sayi1) {
                case 1: //HANGİ TUR HESAP ACILACAGI KULLANICIYA SORULUYOR..
                    System.out.println("Kısa vade için : 1 \n"
                            + "Uzun vade için : 2 \n"
                            + "Cari hesap için : 3");
                    int sayi2 = input.nextInt();
                    if (sayi2 == 1) {
                        int rastgele1 = liste.İd_uret();
                        System.out.println("Rastgele id oluşturuldu. Lütfen bakiyenizi girin.");
                        int bakiye = input.nextInt();
                        if(bakiye>=1000){
                            LocalDate now0 = LocalDate.now();
                            ShortTerm yeni_hesap1 = new ShortTerm(rastgele1, bakiye,now0); //SHORTTERM SINIFINDAN NESNE OLUSTURULDU
                            liste.hesaplar.add(yeni_hesap1); //OLUSTURULAN NESNE BANK TURUNDEN BİR ARRAYLİSTE ATİLDİ.
                            System.out.println("Olusturulan İD :" + yeni_hesap1.getId()+" (GİRİS İCİN NOT ALMAYİ UNUTMAYİN..)");
                            System.out.println("Actıgınız gundan beri getilrecek olan kar :" + yeni_hesap1.Benefit()); //KAR HESAPLANIYOR
                            System.out.println("Kariniz bakiyenize eklendi.");
                            String tutulan1 = "Hesap acma islemi , acilan id : "+ yeni_hesap1.getId()+ " Girilen bakiye: " + yeni_hesap1.getBalance();
                            hesap_gecmisi.add(tutulan1); //STRİNG TURUNDEN BİR TUTUCU AYARLANDI VE HESAPLARI TUTMAK İCİN ACTIGIMIZ ARRAYLİSTE ATİLDİ.
                            
                            break;
                            
                        }
                        else //KISA VADE SARTI EKLENDİ.
                            System.out.println("Kısa vade için bakiyeniz 1000Tl den aşağıda olamaz.");
                            break;
                        
                    }
                    else if (sayi2 == 2) {
                        int rastgele2 = liste.İd_uret();
                        System.out.println("Rastgele id oluşturuldu. Lütfen bakiyenizi girin.");
                        int bakiye2 = input.nextInt();
                        if(bakiye2>=1500){
                            LocalDate now2 = LocalDate.now();
                            LongTerm yeni_hesap2 = new LongTerm(rastgele2,bakiye2, now2); //LONGTERM SHORTTERM SINIFINDAN NESNE OLUSTURULDU
                            liste.hesaplar.add(yeni_hesap2); //OLUSTURULAN NESNE BANK TURUNDEN BİR ARRAYLİSTE ATİLDİ.
                            System.out.println("Olusturulan İD :" + yeni_hesap2.getId()+" (GİRİS İCİN NOT ALMAYİ UNUTMAYİN..)");
                            System.out.println("Actıgınız gundan beri getilrecek olan kar :" + yeni_hesap2.Benefit()); // KAR HESAPLAMA
                            System.out.println("Kariniz bakiyenize eklendi.");
                            String tutulan2 = " Hesap acma islemi , acilan id : "+ yeni_hesap2.getId()+ " Girilen bakiye: " + yeni_hesap2.getBalance();
                            hesap_gecmisi.add(tutulan2); //STRİNGLER GECMİSİN TUTTUGU LİSTEYE EKLENMEYE DEVAM EDİYOR
                            break;
                            
                        }
                        else //UZUN DONEM HESAP SARTI
                            System.out.println("Uzun vade için bakiyeniz 1500Tl den aşağıda olamaz.");
                            break;
                        
   
                    }

                    else if (sayi2 == 3) {
                        int rastgele3 = liste.İd_uret(); //RASTGELE İD URETME METODU KULLANILARAK BİR ONCEKİNDEN FARKLI İD LER URETİLDİ.
                        System.out.println("Rastgele id oluşturuldu. Lütfen bakiyenizi girin.");
                        int bakiye3 = input.nextInt();
                        LocalDate now2 = LocalDate.now(); //SUANKİ ZAMAN ALINDI
                        Current yeni_hesap3 = new Current(rastgele3,bakiye3, now2); //CARİ HESAP İCİN NESNE OLUSTURULDU.
                        liste.hesaplar.add(yeni_hesap3); // OLUSTURULAN NESNE LİSTEYE ATILDI
                        System.out.println("Olusturulan İD :" + yeni_hesap3.getId()+" (GİRİS İCİN NOT ALMAYİ UNUTMAYİN..)");
                        System.out.println("Cari hesapda kar yoktur.");
                        String tutulan3 = "Hesap acma islemi , acilan id : "+ yeni_hesap3.getId()+ " Girilen bakiye: " + yeni_hesap3.getBalance();
                        hesap_gecmisi.add(tutulan3);
                        break;
                    }
                    else //SART DURUMLARI
                        System.out.println("Yanlıs bir tusa bastınız. Program yeniden baslıyor..");
                        continue;

                case 2:
                    System.out.println("Lütfen Banka İD'nizi giriniz:");
                    int id = input.nextInt();
                    if(liste.hesaplar.size() == 0){ //HESAP OLUSTURULMADAN GİRİS YAPMA DURUMUNA KARSI ONLEM ALİNDİ

                        System.out.println("OLUSTURULMUS HESAP YOK ! ONCE LUTFEN HESAP OLUSTURUN.");
                        break;
                    }
                    else if(liste.hesaplar.size()>0){ //İD LER İLE GİRİLEN İD KARSİLASTİRİLİP İSLEMLER YAPILIYOR ( YATİRMA-CEKME)
                        
                        int i ;
                        for (i = 0 ; i < liste.hesaplar.size(); i++) {
                            if (id ==liste.hesaplar.get(i).getId() ) {
                                int tutucu = i;
                                System.out.println("Başarı ile giriş yapıldı. Hesap bilgileriniz ekrana geliyor..");
                                System.out.println("Bakiyeniz:" + liste.hesaplar.get(i).getBalance());
                                System.out.println("HANGİ İSLEMİ YAPMAK İSTERSİNİZ ?  \n"
                                        + "PARA YATİRMA :  1 \n"
                                        + "PARA CEKME : 2 ");
                                int sayi7 = input.nextInt();
                                switch (sayi7) {
                                    case 1:
                                        System.out.println("YATİRİLACAK MİKTARI GİRİN:");
                                        int yatirma = input.nextInt();
                                        liste.hesaplar.get(i).Deposit(yatirma);
                                        String tutulan4 = "İd'si"+ liste.hesaplar.get(i).getId() + " olan hesaba "+ yatirma + " TL eklendi.";
                                        hesap_gecmisi.add(tutulan4);
                                        break;
                                    case 2:
                                        System.out.println("CEKİLECEK MİKTARİ GİRİN::");
                                        int cekme = input.nextInt();
                                        liste.hesaplar.get(i).Withdraw(cekme); //yazilan miktar cekme metodu parametresi olarak verilir, metod cagrılıyor..
                                        String tutulan5 = "İd'si"+ liste.hesaplar.get(i).getId() + " olan hesaba "+ cekme + " TL cekildi.";
                                        hesap_gecmisi.add(tutulan5);
                                        break;
                                        

                                }
                                break;
                           
                            } 
                        }//end of for
                        
                        if( i == liste.hesaplar.size()){
                                System.out.println("Boyle bir id yok veya olusturulmadı.");
                        }
                            
                            
                            
                            
                        
                        
                        
                        
                    
                    
                    }
                    
                    
                    
                    
                    
                case 3 :
                    break;
            
                default :
                    System.out.println("Yanlış bir tuşa bastınız, Program tekrar basliyor");
                    continue;
                       
                    
            }
            System.out.println("Şimdi ne yapmak istersiniz ? Programı tekrar başlat : 1 \n"
                    + "Programı kapat : 2 \n"
                    + "Hesapları listele : 3 \n"
                    + "Hesap gecmisi icin : 4 \n"
                    + "Son 5 islem gecmisi icin : 5");
            int cikis_secimi = input.nextInt();
            if(cikis_secimi == 1){
                continue;
            }
            else if(cikis_secimi == 2){
                break;
        }
            else if(cikis_secimi == 3){
                if(liste.hesaplar.size()== 0){
                    System.out.println("Olusturulmus hesap bulunmuyor.");
                    
                }
                else
                    liste.getAccount();
            }
            else if(cikis_secimi == 4){
                if(hesap_gecmisi.size() == 0){
                    System.out.println("HESAP GECMİSİ YOK");
                }
                else
                    
                    for (int i = 0; i < hesap_gecmisi.size(); i++) {
                        System.out.println("YAPİLAN İSLEM : "+hesap_gecmisi.get(i) );
                    
                }
                
            }
            
            else if(cikis_secimi == 5){
                if(hesap_gecmisi.size()<5){
                    System.out.println("HESAP GECMİSİNİZ 5 DEN KUCUKTUR..");
                    
                }
                else if(hesap_gecmisi.size()>5){
                    for (int i = hesap_gecmisi.size()-1; i > hesap_gecmisi.size()-6; i--) {
                        System.out.println(i+". "+"YAPILAN İSLEM :"+ hesap_gecmisi.get(i));
                        
                    }
                    
                }
                
                
            }
            else 
                System.out.println("Yanlıs tusa bastınız");
            System.out.println("*****************************************");
            System.out.println("Cıkıs yapmadınız. Program basa donuyor.");
            System.out.println("******************************************");

        } while (true);

    }

}
