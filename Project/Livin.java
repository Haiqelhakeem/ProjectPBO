package Project;
import java.util.*;

public class Livin{
    public static void main(String[] args) {
        Bank bank = new Bank();
        int pilihan;
        int pilihan2;
        boolean flag = true;
        boolean flagOut = true;
        Scanner input = new Scanner(System.in);
        Scanner in = new Scanner(System.in);

        String username;
        String PIN;

        System.out.println("Selamat Datang");
        System.out.println("Silakan login");

        boolean loginFlag = false;
        User loggedinUser = null;
        List <User> userList = new ArrayList<>();
        
        //daftar user
        userList.add(new User("Haiqel", "123456", 1500000));
        userList.add(new User("Aziizul", "121212", 2000000));

        while (flagOut == true) {
            //input login
            System.out.println("1. Login");
            System.out.println("2. Keluar Aplikasi");
            System.out.print("Pilihan anda: ");
            pilihan2 = input.nextInt();

            if (pilihan2 == 1) {
                System.out.print("Masukkan username: ");
                username = in.nextLine();
                System.out.print("Masukkan pin: ");
                PIN = in.nextLine();

                //cek login pada daftar user
                for (User user : userList) {
                    if (user.getUID().equals(username)) {
                        if (user.getPIN().equals(PIN)) {
                            loggedinUser = user;
                            break;
                        }
                    }
                }

                //pesan login
                if (loggedinUser != null) {
                    System.out.println("Login berhasil");
                    System.out.println("Selamat datang " + loggedinUser.getUID());
                    loginFlag = true;
                } else {
                    System.out.println("Login gagal");
                    loginFlag = false;
                }

                while (loginFlag == true) {
                    System.out.println("-----MENU-----");
                    System.out.println("1. Transfer");
                    System.out.println("2. Cek Saldo");
                    System.out.println("3. Tarik Tunai");
                    System.out.println("4. Bayar Tagihan");
                    System.out.println("5. Keluar");
    
                    do {
                        System.out.print("Masukkan pilihan anda: ");
                        pilihan = input.nextInt();
                        switch (pilihan) {    
                            case 1:
                                bank.transfer(username);
                                break;
                            
                            case 2:
                                bank.getSaldo(username);
                                break;
                            
                            case 3:
                                bank.tarikTunai(username);
                                break;

                            case 4:
                                bank.bayar(username);
                                break;
    
                            case 5:
                                System.out.println("Keluar..");
                                flag = false;
                                loginFlag = false;
                                break;
                        
                            default:
                                break;
                        }
                    } while (flag == true);
                }

            } else if (pilihan2 == 2) {
                flagOut = false;
            } else{
                System.out.println("Pilihan anda invalid");
            }
        }  
    }
}