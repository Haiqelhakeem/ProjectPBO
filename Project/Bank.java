package Project;
import java.util.*;

class Bank{
    public String username;
    public String UID;
    public String PIN;

    private boolean flagTagihan1 = false;
    private boolean flagTagihan2 = false;
    private boolean flagTagihan3 = false;
    
    //user list
    User user1 = new User("Haiqel", "123456", 1500000);
    User user2 = new User("Aziizul", "121212", 2000000);

    //tagihan list
    Tagihan tagihan1 = new TagihanWifi("Tagihan wifi", 300000);
    Tagihan tagihan2 = new TagihanListrik("Tagihan listrik", 450000);
    Tagihan tagihan3 = new TagihanAir("Tagihan air", 250000);
    
    //get informasi saldo
    public void getSaldo(String username){
        if (username.equals(user1.getUID())) {
            System.out.println("Saldo anda: " + user1.saldo);
        }
        if (username.equals(user2.getUID())) {
            System.out.println("Saldo anda: " +user2.saldo);
        }
    }

    //transfer function
    public void transfer(String username){
        Scanner inTrf = new Scanner(System.in);
        Scanner inUID = new Scanner(System.in);
        Scanner inPin = new Scanner(System.in);
        String tujuanTrf;
        int jumlahTransfer;
        String pinKonfirmasi;

        //transfer dari user 1
        if (username.equals(user1.getUID())) {
            System.out.print("Masukkan UID tujuan: ");
            tujuanTrf = inUID.nextLine();
            if (tujuanTrf.equals(user2.getUID())) {
                System.out.print("Masukkan jumlah transfer: ");
                jumlahTransfer = inTrf.nextInt();
                System.out.print("Masukkan PIN anda: ");
                pinKonfirmasi = inPin.nextLine();
                if (pinKonfirmasi.equals(user1.getPIN())) {
                    if (jumlahTransfer <= user1.saldo) {
                        user1.saldo -= jumlahTransfer;
                        user2.saldo += jumlahTransfer;
                    }
                    System.out.println("Transfer berhasil");
                } else {
                    System.out.println("PIN anda salah");
                }
            } else{
                System.out.println("UID yang anda masukkan salah");
            }
        }

        //transfer dari user 2
        if (username.equals(user2.getUID())) {
            System.out.print("Masukkan UID tujuan: ");
            tujuanTrf = inUID.nextLine();
            if (tujuanTrf.equals(user1.getUID())) {
                System.out.print("Masukkan jumlah transfer: ");
                jumlahTransfer = inTrf.nextInt();
                System.out.println("Masukkan PIN anda: ");
                pinKonfirmasi = inPin.nextLine();
                if (pinKonfirmasi.equals(user2.getPIN())) {
                    if (jumlahTransfer <= user2.saldo) {
                        user2.saldo -= jumlahTransfer;
                        user1.saldo += jumlahTransfer;
                    }
                } else {
                    System.out.println("PIN Anda salah");
                }                
            } else{
                System.out.println("UID yang anda masukkan salah");
            }
        }
    }

    //function bayar tagihan
    public void bayar(String username){
        Scanner inBayarTagihan = new Scanner(System.in);    
        Scanner inPilihTagihan = new Scanner(System.in);    
        int pilBayar;
        
        //user 1
        if (username.equals(user1.getUID())) {
            System.out.println("Daftar tagihan:");
            System.out.println("1. Tagihan wifi");
            System.out.println("2. Tagihan listrik");
            System.out.println("3. Tagihan air");
            pilBayar = inPilihTagihan.nextInt();
            switch (pilBayar) {
                case 1:
                    if (flagTagihan1 == true) {
                        System.out.println("Anda sudah membayar tagihan ini");
                    } else {
                        System.out.println(tagihan1.getNamaTagihan() + ": " + tagihan1.getTotalTagihan());
                        System.out.print("Apakah anda ingin membayar sekarang?: (1.Ya / 2.Tidak)");
                        pilBayar = inBayarTagihan.nextInt();
                        if (pilBayar == 1 && user1.saldo >= tagihan1.getTotalTagihan()) {
                            user1.saldo -= tagihan1.getTotalTagihan();
                            flagTagihan1 = true;
                            System.out.println("Pembayaran berhasil");
                        } else if(pilBayar == 1 && user1.saldo < tagihan1.getTotalTagihan()){
                            System.out.println("Maaf saldo anda tidak mencukupi");
                        }
                    }
                    break;
                
                case 2:
                    if (flagTagihan2 == true) {
                        System.out.println("Anda sudah membayar tagihan ini");
                    } else {
                        System.out.println(tagihan2.getNamaTagihan() + ": " + tagihan2.getTotalTagihan());
                        System.out.print("Apakah anda ingin membayar sekarang?: (1.Ya / 2.Tidak)");
                        pilBayar = inBayarTagihan.nextInt();
                        if (pilBayar == 1 && user1.saldo >= tagihan2.getTotalTagihan()) {
                            user1.saldo -= tagihan2.getTotalTagihan();
                            flagTagihan2 = true;
                            System.out.println("Pembayaran berhasil");
                        } else if(pilBayar == 1 && user1.saldo < tagihan2.getTotalTagihan()){
                            System.out.println("Maaf saldo anda tidak mencukupi");
                        }
                    }
                    break;
                
                case 3:
                    if (flagTagihan3 == true) {
                        System.out.println("Anda sudah membayar tagihan ini");
                    } else {
                        System.out.println(tagihan3.getNamaTagihan() + ": " + tagihan3.getTotalTagihan());
                        System.out.print("Apakah anda ingin membayar sekarang?: (1.Ya / 2.Tidak)");
                        pilBayar = inBayarTagihan.nextInt();
                        if (pilBayar == 1 && user1.saldo >= tagihan3.getTotalTagihan()) {
                            user1.saldo -= tagihan3.getTotalTagihan();
                            flagTagihan3 = true;
                            System.out.println("Pembayaran berhasil");
                        } else if(pilBayar == 1 && user1.saldo < tagihan3.getTotalTagihan()){
                            System.out.println("Maaf saldo anda tidak mencukupi");
                        }
                    }
                    break;

                default:
                    break;
            }
        }

        //user 2
        if (username.equals(user2.getUID())) {
            System.out.println("Daftar tagihan: ");
            System.out.println("1. Tagihan listrik");
            System.out.println("2. Tagihan air");
            pilBayar = inPilihTagihan.nextInt();
            switch (pilBayar) {
                case 1:
                    System.out.println(tagihan2.getNamaTagihan() + ": " + tagihan2.getTotalTagihan());
                    if (flagTagihan2 == true) {
                        System.out.println("Anda sudah membayar tagihan ini");
                    } else {
                        System.out.print("Apakah anda ingin membayar sekarang?: (1.Ya / 2.Tidak)");
                        pilBayar = inBayarTagihan.nextInt();
                        if (pilBayar == 1 && user2.saldo >= tagihan2.getTotalTagihan() && flagTagihan2 == false) {
                            user2.saldo -= tagihan2.getTotalTagihan();
                            flagTagihan2 = true;
                            System.out.println("Pembayaran berhasil");
                        } else if(pilBayar == 1 && user2.saldo < tagihan2.getTotalTagihan()){
                            System.out.println("Maaf saldo anda tidak mencukupi");
                        }
                    }
                    break;
                
                case 2:
                    System.out.println(tagihan3.getNamaTagihan() + ": " + tagihan3.getTotalTagihan());
                    if (flagTagihan3 == true) {
                        System.out.println("Anda sudah membayar tagihan ini");
                    } else {
                        System.out.print("Apakah anda ingin membayar sekarang?: (1.Ya / 2.Tidak)");
                        pilBayar = inBayarTagihan.nextInt();
                        if (pilBayar == 1 && user2.saldo >= tagihan3.getTotalTagihan()) {
                            user2.saldo -= tagihan3.getTotalTagihan();
                            flagTagihan3 = true;
                            System.out.println("Pembayaran berhasil");
                        } else if(pilBayar == 1 && user2.saldo < tagihan3.getTotalTagihan()){
                            System.out.println("Maaf saldo anda tidak mencukupi");
                        }
                    }
                    break;
                
                default:
                    break;
                }    
            }
    }   

    //function tarik tunai tanpa kartu ATM
    public void tarikTunai(String username){        
        Scanner inTarik = new Scanner(System.in);
        if (username.equals(user1.getUID())) {
            int tarik;
            System.out.print("Masukkan jumlah yang ingin ditarik: ");
            tarik = inTarik.nextInt();

            if (tarik <= user1.saldo) {
                user1.saldo = user1.saldo - tarik;
                System.out.println("Anda telah berhasil menarik tunai sebanyak " + tarik);
                System.out.println("Total saldo anda sekarang: " + user1.saldo);
            } else {
                System.out.println("Saldo anda tidak mencukupi");
            }
        }
        if (username.equals(user2.getUID())) {
            int tarik;
            System.out.print("Masukkan jumlah yang ingin ditarik: ");
            tarik = inTarik.nextInt();

            if (tarik <= user2.saldo) {
                user2.saldo = user2.saldo - tarik;
                System.out.println("Anda telah berhasil menarik tunai sebanyak " + tarik);
                System.out.println("Total saldo anda sekarang: " + user2.saldo);
            } else {
                System.out.println("Saldo anda tidak mencukupi");
            }
        }
    }

    public void isiPulsa(String username){
        int pilihanPulsa;
        String nomorHP;
        Scanner inPulsa = new Scanner(System.in);
        Scanner inNomorHP = new Scanner(System.in);
        
        System.out.print("Masukkan nomor anda: ");
        nomorHP = inNomorHP.nextLine();
        
        System.out.println("Daftar Pulsa:");
        System.out.println("1. 15.000");
        System.out.println("2. 20.000");
        System.out.println("3. 50.000");
        System.out.println("4. 100.000");
        System.out.println("5. Keluar");
        System.out.print("Pilihan: ");
        pilihanPulsa = inPulsa.nextInt();

        if (username.equals(user1.getUID())) {
            switch (pilihanPulsa) {
                case 1:
                    user1.saldo -= 15000;
                    System.out.println("Transaksi berhasil");
                    break;
                
                case 2:
                    user1.saldo -= 20000;
                    System.out.println("Transaksi berhasil");
                    break;
                
                case 3:
                    user1.saldo -= 50000;
                    System.out.println("Transaksi berhasil");
                    break;
                
                case 4:
                    user1.saldo -= 100000;
                    System.out.println("Transaksi berhasil");
                    break;
            
                default:
                    break;
            }
        }

        if (username.equals(user2.getUID())) {
            switch (pilihanPulsa) {
                case 1:
                    if (user2.saldo >= 15000) {
                        user2.saldo -= 15000;
                        System.out.println("Transaksi berhasil");
                    } else {
                        System.out.println("Saldo anda tidak mencukupi");
                    }                    
                    break;
                
                case 2:
                    if (user2.saldo >= 20000) {
                        user2.saldo -= 20000;
                        System.out.println("Transaksi berhasil");
                    } else {
                        System.out.println("Saldo anda tidak mencukupi");
                    }                    
                    break;
                
                case 3:
                    if (user2.saldo >= 50000) {
                        user2.saldo -= 50000;
                        System.out.println("Transaksi berhasil");
                    } else {
                        System.out.println("Saldo anda tidak mencukupi");
                    }                    
                    break;
                
                case 4:
                    if (user2.saldo >= 100000) {
                        user2.saldo -= 100000;
                        System.out.println("Transaksi berhasil");
                    } else {
                        System.out.println("Saldo anda tidak mencukupi");
                    }                    
                    break;
            
                default:
                    break;
            }
        }
    }
    
    public void topUp(){

    }
}
