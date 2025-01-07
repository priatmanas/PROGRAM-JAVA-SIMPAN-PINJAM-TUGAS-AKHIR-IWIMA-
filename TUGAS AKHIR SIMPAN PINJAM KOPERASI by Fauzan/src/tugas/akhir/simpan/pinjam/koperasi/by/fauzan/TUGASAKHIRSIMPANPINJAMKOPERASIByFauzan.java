package tugas.akhir.simpan.pinjam.koperasi.by.fauzan;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;  
import java.util.Date;  

/**
 * @author Fauzan Priatmana
 */

public class TUGASAKHIRSIMPANPINJAMKOPERASIByFauzan {
    
    
    static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    static Date date = new Date();  
    static Scanner input = new Scanner(System.in);
    static ArrayList<Object[]> listAnggota = new ArrayList();
    static ArrayList<Object[]> listSimpan = new ArrayList();
    static ArrayList<Object[]> listPinjaman = new ArrayList();
    static boolean running = true;
    
    public static void main(String[] args) throws IOException {
        
        boolean loggedIn = false;
        
        System.out.println("===== APLIKASI SIMPAN PINJAM =====");
        System.out.println("Silahkan login terlebih dahulu :3\nJika username & password salah maka, aplikasi aan ditutup.");
        
        while (!loggedIn) {            
            System.out.print("Username >> ");
            String username = input.nextLine();
        
            System.out.print("Password >> ");
            String password = input.nextLine();
 
            if (username.equals("Admin") && password.equals("admin")) {
                loggedIn = true;
                clearScreen();
                do {                    
                    mainMenu();
                } while (running);
            } else {
                System.out.println("Username dan password salah! Aplikasi akan ditutup");
                System.exit(0);
            }
            
        }
    }
    
    static void mainMenu() throws IOException {
        System.out.println("===== MENU SIMPAN PINJAM =====");
        System.out.println("Program Simpan Pinjam v1.0");
        System.out.println("==============================");
        System.out.println("[1] Anggota");
        System.out.println("[2] Simpan");
        System.out.println("[3] Pinjaman");
        System.out.println("[4] Info");
        System.out.println("[0] Exit");
        System.out.println("==============================");
        System.out.print(">>> ");
        
        int selMainMenu = validIntInput();
        switch (selMainMenu) {
            case 1:
                clearScreen();
                menuAnggota();
                break;
            case 2:
                clearScreen();
                menuSimpanan();
                break;
            case 3:
                clearScreen();
                menuPinjaman();
                break;
            case 4:
                clearScreen();
                informasiProgram();
                break;
            case 0:
                System.out.println("Terimakasih dan sampai jumpa!");
                System.exit(0);
            default:
                clearScreen();
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                mainMenu();
                break;
        }
    }
    
    static void listAnggota() throws IOException {
        if (listAnggota.isEmpty()) {
            System.out.println("List anggota kosong, silahkan tambah terlebih dahulu :)");
        } else {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %2s | %-25s | %-20s | %-28s | %-15s | %-15s | %-32s | %-18s |%n",
                    "NO",
                    "NAMA",
                    "NIK",
                    "ALAMAT",
                    "JENIS KELAMIN",
                    "NO TELEPON",
                    "EMAIL",
                    "TANGGAL REGISTRASI");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for ( int i = 0 ; i < listAnggota.size() ; i++ ) {
                Object[] dataAnggota = listAnggota.get(i);
                System.out.printf("| %2s | %-25s | %-20s | %-28s | %-15s | %-15s | %-32s | %-18s |%n",
                    i+1,
                    dataAnggota[0],
                    dataAnggota[1],
                    dataAnggota[2],
                    dataAnggota[3],
                    dataAnggota[4],
                    dataAnggota[5],
                    dataAnggota[6]);
            }
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }

    }
    static void menuAnggota() throws IOException {
        System.out.println("=====");
        listAnggota();
        System.out.println("=====");
        System.out.println("[1] Tambah Anggota");
        System.out.println("[2] Edit Anggota");
        System.out.println("[3] Remove Anggota");
        System.out.println("[0] Kembali Ke Menu Utama");
        System.out.println("=====");
        System.out.print(">>> ");
        
        int selMenuAnggota = validIntInput();
        
        switch (selMenuAnggota) {   
            case 1:
                input.nextLine();
                clearScreen();
                addAnggota();
                break;
            case 2:
                clearScreen();
                editAnggota();
                break;
            case 3:
                clearScreen();
                removeAnggota();
                break;
            case 0:
                clearScreen();
                mainMenu();
                break;
            default:
                clearScreen();
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                menuAnggota();
                break;
        }
    }
    static void addAnggota() throws IOException {
        
        boolean addDataAnggotaRunning = true;
        
        while (addDataAnggotaRunning) {            
            clearScreen();
            System.out.print("Masukan Nama Anggota : ");
            String namaAnggota = input.nextLine();
            clearScreen();
            System.out.print("Masukan NIK Anggota (16 Digit): ");
            String nikAnggota = input.nextLine();
            clearScreen();
            System.out.print("Masukan Alamat Anggota : ");
            String alamatAnggota = input.nextLine();
            clearScreen();
            System.out.print("Masukan Jenis Kelamin Anggota (Laki-Laki/Perempuan): ");
            String jenisKelaminAnggota = input.nextLine();
            if (!jenisKelaminAnggota.equals("Laki-Laki") && !jenisKelaminAnggota.equals("Perempuan")) {
                clearScreen();
                System.out.println("Jenis Kelamin Tidak Valid! Silahkan Masukan Jenis Kelamin Yang Valid!");
                menuAnggota();
            }
            clearScreen();
            System.out.print("Masukan No Telepon Anggota : ");
            String noTeleponAnggota = input.nextLine();
            clearScreen();
            System.out.print("Masukan E-Mail Anggota : ");
            String emailAnggota = input.nextLine();

            String currentDate = formatter.format(new Date());

            Object[] dataAnggota = {namaAnggota,
                                    nikAnggota,
                                    alamatAnggota,
                                    jenisKelaminAnggota,
                                    noTeleponAnggota,
                                    emailAnggota,
                                    currentDate};
            listAnggota.add(dataAnggota);
            
            clearScreen();
            System.out.println("Apakah anda ingin menambankan data lagi? [y/t]");
            System.out.print(">>> ");
            String jawabYt = input.nextLine();
            if (jawabYt.equalsIgnoreCase("t")) {
                addDataAnggotaRunning = false;
            }
        }
        clearScreen();
        System.out.println("Anggota telah ditambahkan :)");
        menuAnggota();
    }
    static void editAnggota() throws IOException {
        if (listAnggota.isEmpty()) {
            System.out.println("[ List anggota kosong, silahkan tambah terlebih dahulu :) ]");
            menuAnggota();
        } else {
            listAnggota();
            System.out.println("Pilih anggota yang ingin diedit.");
            System.out.print(">>> ");
            
            int selEditAnggota = validIntInput();
            int indexEditData = selEditAnggota - 1;

            if (indexEditData < 0 || indexEditData >= listAnggota.size()) {
                clearScreen();
                System.out.println("Anggota tidak valid. Silakan coba lagi.");
                menuAnggota();
                return;
            }
            
            Object[] dataAnggota = listAnggota.get(indexEditData);
            
            boolean editDataAnggotaRunning = true;
            
            while (editDataAnggotaRunning) {                
                clearScreen();
                System.out.println("Data Anggota yang dipilih:");
                System.out.println("[1] - Nama          : " + dataAnggota[0]);
                System.out.println("[2] - NIK           : " + dataAnggota[1]);
                System.out.println("[3] - Alamat        : " + dataAnggota[2]);
                System.out.println("[4] - Jenis Kelamin : " + dataAnggota[3]);
                System.out.println("[5] - No Telepon    : " + dataAnggota[4]);
                System.out.println("[6] - Email         : " + dataAnggota[5]);

                System.out.println("\nPilih atribut yang ingin diedit:");
                System.out.print(">>> ");

                int selEditAtribut = validIntInput();

                switch (selEditAtribut) {
                    case 1:
                        clearScreen();
                        input.nextLine();
                        System.out.print("Masukkan Nama Anggota baru: ");
                        String namaAnggota = input.nextLine();
                        dataAnggota[0] = namaAnggota;
                        break;
                    case 2:
                        clearScreen();
                        input.nextLine();
                        System.out.print("Masukkan NIK Anggota baru: ");
                        String nikAnggota = input.nextLine();
                        dataAnggota[1] = nikAnggota;
                        break;
                    case 3:
                        clearScreen();
                        input.nextLine();
                        System.out.print("Masukkan Alamat Anggota baru: ");
                        String alamatAnggota = input.nextLine();
                        dataAnggota[2] = alamatAnggota;
                        break;
                    case 4:
                        clearScreen();
                        input.nextLine();
                        System.out.print("Masukkan Jenis Kelamin Anggota baru (Laki-Laki/Perempuan): ");
                        String jenisKelaminAnggota = input.nextLine();
                        if (jenisKelaminAnggota.equals("Laki-Laki") || jenisKelaminAnggota.equals("Perempuan")) {
                            dataAnggota[3] = jenisKelaminAnggota;
                        } else {
                            System.out.println("Jenis Kelamin Tidak Valid! Tidak ada perubahan yang dilakukan.");
                        }
                        break;
                    case 5:
                        clearScreen();
                        input.nextLine();
                        System.out.print("Masukkan No Telepon Anggota baru: ");
                        String noTeleponAnggota = input.nextLine();
                        dataAnggota[4] = noTeleponAnggota;
                        break;
                    case 6:
                        clearScreen();
                        input.nextLine();
                        System.out.print("Masukkan Email Anggota baru: ");
                        String emailAnggota = input.nextLine();
                        dataAnggota[5] = emailAnggota;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Tidak ada perubahan yang dilakukan.");
                        break;
                }
                clearScreen();
                System.out.println("Apakah anda ingin mengubah data "+dataAnggota[0]+" lagi? [y/t]");
                System.out.print(">>> ");
                String jawabYt = input.nextLine();
                if (jawabYt.equalsIgnoreCase("t")) {
                    editDataAnggotaRunning = false;
                } 
            }
         
            clearScreen();
            System.out.println("Data anggota telah diperbarui.");
            menuAnggota();
        }
    }
    static void removeAnggota () throws IOException {
        if (listAnggota.isEmpty()) {
            System.out.println("[ List anggota kosong, silahkan tambah terlebih dahulu :) ]");
            menuAnggota();
        } else {
            listAnggota();
            System.out.println("Pilih anggota yang ingin di hapus.");
            System.out.print(">>> ");
            
            int selRemoveAnggota = validIntInput();
            int indexRemoveData = selRemoveAnggota - 1;
            
            if (indexRemoveData < 0 || indexRemoveData >= listAnggota.size()) {
                clearScreen();
                System.out.println("Anggota tidak valid. Silakan coba lagi.");
                menuAnggota();
            } else {
                listAnggota.remove(indexRemoveData);
            }
            
            clearScreen();
            menuAnggota();
        }
    }
    
    static void listSimpanan() throws IOException {
        if (listSimpan.isEmpty()) {
            System.out.println("List simpan kosong, silahkan tambah terlebih dahulu :)");
        } else {
            System.out.println("------------------------------------------------------------------------------------------------");
            System.out.printf("| %2s | %-25s | %-20s | %-15s | %-18s |%n",
                    "NO",
                    "NAMA",
                    "NIK",
                    "JUMLAH SIMPANAN",
                    "TANGGAL MASUK");
            System.out.println("------------------------------------------------------------------------------------------------");
            
            double totJumlahSimpanan = 0;
            
            for (int i = 0; i < listSimpan.size(); i++) {
                Object[] dataSimpanan = listSimpan.get(i);
                totJumlahSimpanan += (double) dataSimpanan[2];
                System.out.printf("| %2s | %-25s | %20s | Rp. %11.1f | %18s |%n",
                    i+1,
                    dataSimpanan[0],
                    dataSimpanan[1],
                    dataSimpanan[2],
                    dataSimpanan[3]);
            }
            System.out.println("------------------------------------------------------------------------------------------------");
            System.out.printf("| %-53s | Rp. %11.1f | %-18s |%n",
                    " ",
                    totJumlahSimpanan,
                    " ");
            System.out.println("------------------------------------------------------------------------------------------------");
        }
    }
    static void menuSimpanan() throws IOException {
        System.out.println("=====");
        listSimpanan();
        System.out.println("=====");
        System.out.println("[1] Tambah Simpanan");
        System.out.println("[2] Edit Simpanan");
        System.out.println("[3] Remove Simpanan");
        System.out.println("[0] Kembali Ke Menu Utama");
        System.out.println("=====");
        System.out.print(">>> ");
        
        int selMenuSimpanan = validIntInput();
        
        switch (selMenuSimpanan) {   
            case 1:
                clearScreen();
                input.nextLine();
                addSimpanan();
                break;
            case 2:
                clearScreen();
                editSimpanan();
                break;
            case 3:
                clearScreen();
                removeSimpanan();
                break;
            case 0:
                clearScreen();
                mainMenu();
                break;
            default:
                clearScreen();
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                menuSimpanan();
                break;
                
        } 
    }
    static void addSimpanan() throws IOException {     
        if (listAnggota.isEmpty()) {
            System.out.println("[ List anggota kosong, silahkan tambah terlebih dahulu :) ]");
            menuSimpanan();
        } else {
            
            boolean addDataSimpananRunning = true;
            
            while (addDataSimpananRunning) {  
                listAnggota();
                System.out.print("Pilih Anggota Yang Ingin Menyimpan >> ");

                int selAnggotaSimpanan = validIntInput();
                int indexSelAnggotaSimpanan = selAnggotaSimpanan - 1;

                if (indexSelAnggotaSimpanan < 0 || indexSelAnggotaSimpanan >= listAnggota.size()) {
                    clearScreen();
                    System.out.println("Anggota tidak valid. Silakan coba lagi.");
                    menuSimpanan();
                    return;
                }

                Object[] dataAnggota = listAnggota.get(indexSelAnggotaSimpanan);
                Object namaAnggota = dataAnggota[0];
                Object nikAnggota = dataAnggota[1];

                clearScreen();
                System.out.print("Masukkan Jumlah Simpanan untuk " + namaAnggota + " >> Rp.  ");
                double jumlahSimpanan = input.nextDouble();
                input.nextLine();

                String currentDate = formatter.format(new Date());

                Object[] dataSimpanan = {namaAnggota,
                                        nikAnggota,
                                        jumlahSimpanan,
                                        currentDate};
                listSimpan.add(dataSimpanan);

                
                clearScreen();
                System.out.printf("Simpanan sebesar Rp. %,.0f telah ditambahkan untuk %s.", jumlahSimpanan, namaAnggota);
                System.out.println("\nApakah anda ingin menambankan data lagi? [y/t]");
                System.out.print(">>> ");
                String jawabYt = input.nextLine();
                if (jawabYt.equalsIgnoreCase("t")) {
                    addDataSimpananRunning = false;
                }
            }
            clearScreen();
            menuSimpanan();
        }
    }
    static void editSimpanan() throws IOException {
        if (listSimpan.isEmpty()) {
            System.out.println("[ List anggota kosong, silahkan tambah terlebih dahulu :) ]");
            menuSimpanan();
        } else {
            listSimpanan();
            System.out.println("Pilih simpanan yang ingin diedit.");
            System.out.print(">>> ");

            int selEditSimpanan = validIntInput();
            int indexEditData = selEditSimpanan - 1;

            if (indexEditData < 0 || indexEditData >= listSimpan.size()) {
                clearScreen();
                System.out.println("Simpanan tidak valid. Silakan coba lagi.");
                menuSimpanan();
            }
            
            Object[] dataSimpanan = listSimpan.get(indexEditData);
            clearScreen();
            
            boolean editDataSimpananRunning = true;
            
            while (editDataSimpananRunning) {                
                System.out.println("Data Simpanan yang dipilih:");
                System.out.println("[1] - Nama              : " + dataSimpanan[0]);
                System.out.println("    - NIK               : " + dataSimpanan[1]);
                System.out.printf("[2] - Jumlah Simpanan   : Rp. %,.0f%n", dataSimpanan[2]);

                System.out.println("\nPilih atribut yang ingin diedit:");
                System.out.print(">>> ");

                int selEditAtribut = validIntInput();

                switch (selEditAtribut) {
                    case 1:
                        clearScreen();
                        if (listAnggota.isEmpty()) {
                            System.out.println("[ List anggota kosong, silahkan tambah terlebih dahulu :) ]");
                            menuSimpanan();
                        } else {
                            listAnggota();
                            System.out.print("Pilih Anggota Baru untuk Nama >> ");
                            int selAnggota = validIntInput();
                            int indexAnggota = selAnggota - 1;

                            if (indexAnggota < 0 || indexAnggota >= listAnggota.size()) {
                                System.out.println("Anggota tidak valid. Tidak ada perubahan yang dilakukan.");
                            } else {
                                Object[] dataAnggota = listAnggota.get(indexAnggota);
                                dataSimpanan[0] = dataAnggota[0];
                                dataSimpanan[1] = dataAnggota[1];
                            }
                            input.nextLine();
                        }
                        break;
                    case 2:
                        clearScreen();
                        System.out.print("Masukkan Jumlah Simpanan baru: Rp. ");
                        double jumlahSimpanan = input.nextDouble();
                        input.nextLine();
                        dataSimpanan[2] = jumlahSimpanan;
                        break;
                }
                clearScreen();
                System.out.println("Apakah anda ingin mengubah data lagi? [y/t]");
                System.out.print(">>> ");
                String jawabYt = input.nextLine();
                if (jawabYt.equalsIgnoreCase("t")) {
                    editDataSimpananRunning = false;
                }
            }    
            clearScreen();
            System.out.println("Data simpanan telah diperbarui.");
            menuSimpanan();
        }
    }
    static void removeSimpanan() throws IOException {
        if (listSimpan.isEmpty()) {
            System.out.println("[ List simpanan kosong, silahkan tambah terlebih dahulu :) ]");
            menuSimpanan();
        } else {
            listSimpanan();
            System.out.println("Pilih simpanan yang ingin di hapus.");
            System.out.print(">>> ");

            int selRemoveSimpanan = validIntInput();
            int indexRemoveData = selRemoveSimpanan - 1;
            
            if (indexRemoveData < 0 || indexRemoveData >= listSimpan.size()) {
                clearScreen();
                System.out.println("Simpanan tidak valid. Silakan coba lagi.");
                menuSimpanan();
            } else {
                listSimpan.remove(indexRemoveData);
            }
            
            clearScreen();
            menuSimpanan();
        }
    }
    
    static void listPinjaman() throws IOException {
        if (listPinjaman.isEmpty()) {
            System.out.println("List pinjaman kosong, silahkan tambah terlebih dahulu :)");
        } else {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %2s | %-25s | %-20s | %-15s | %-5s | %-21s | %-18s |%n",
                    "NO",
                    "NAMA",
                    "NIK",
                    "JUMLAH PINJAMAN",
                    "BUNGA",
                    "JUMLAH TOTAL PINJAMAN",
                    "TANGGAL MASUK");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
            
            double totJumlahPinjaman = 0;
            double totJumlahTotalPinjaman = 0;
            
            for (int i = 0; i < listPinjaman.size(); i++) {
                Object[] dataSimpanan = listPinjaman.get(i);
                totJumlahPinjaman += (double) dataSimpanan[2];
                totJumlahTotalPinjaman += (double) dataSimpanan[4];
                System.out.printf("| %2s | %-25s | %20s | Rp. %11.1f | %-5s | Rp. %17.1f | %18s |%n",
                    i+1,
                    dataSimpanan[0],
                    dataSimpanan[1],
                    dataSimpanan[2],
                    dataSimpanan[3],
                    dataSimpanan[4],
                    dataSimpanan[5]);
            }
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %53s | Rp. %11.1f | %-5s | Rp. %17.1f | %18s |%n",
                    " ",
                    totJumlahPinjaman,
                    " ",
                    totJumlahTotalPinjaman,
                    " ");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    static void menuPinjaman() throws IOException {
        System.out.println("=====");
        listPinjaman();
        System.out.println("=====");
        System.out.println("[1] Tambah Pinjaman");
        System.out.println("[2] Edit Pinjaman");
        System.out.println("[3] Remove Pinjaman");
        System.out.println("[0] Kembali Ke Menu Utama");
        System.out.println("=====");
        System.out.print(">>> ");
        
        int selMenuPinjaman = validIntInput();
        
        switch (selMenuPinjaman) {   
            case 1:
                clearScreen();
                input.nextLine();
                addPinjaman();
                break;
            case 2:
                clearScreen();
                editPinjaman();
                break;
            case 3:
                clearScreen();
                removePinjaman();
                break;
            case 0:
                clearScreen();
                mainMenu();
                break;
            default:
                clearScreen();
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                menuPinjaman();
                break;
        }
        
    }
    static void addPinjaman() throws IOException {
        if (listAnggota.isEmpty()) {
            System.out.println("[ List anggota kosong, silahkan tambah terlebih dahulu :) ]");
            menuPinjaman();
        } else {
            
            boolean addDataPinjamanRunning = true;
            
            while (addDataPinjamanRunning) {
                listAnggota();
                System.out.print("Pilih Anggota Yang Ingin Meminjam >> ");
                
                int selAnggotaPinjaman = validIntInput();
                int indexSelAnggotaPinjaman = selAnggotaPinjaman - 1;

                if (indexSelAnggotaPinjaman < 0 || indexSelAnggotaPinjaman >= listAnggota.size()) {
                    clearScreen();
                    System.out.println("Anggota tidak valid. Silakan coba lagi.");
                    menuPinjaman();
                    return;
                }
                
                Object[] dataAnggota = listAnggota.get(indexSelAnggotaPinjaman);
                Object namaAnggota = dataAnggota[0];
                Object nikAnggota = dataAnggota[1];
                
                clearScreen();
                System.out.print("Masukkan Jumlah Pinjaman untuk " + namaAnggota + " >> Rp.  ");
                double jumlahPinjam = input.nextDouble();
                
                clearScreen();
                System.out.print("Masukkan Bunga (%) >> ");
                double bungaPinjaman = input.nextDouble();
                input.nextLine();
                
                double totalPinjamanBunga = jumlahPinjam + (jumlahPinjam * bungaPinjaman/100);
                
                String currentDate = formatter.format(new Date());
                
                Object[] dataPinjaman = {namaAnggota,
                                        nikAnggota,
                                        jumlahPinjam,
                                        bungaPinjaman,
                                        totalPinjamanBunga,
                                        currentDate};
                listPinjaman.add(dataPinjaman);
                
                clearScreen();
                System.out.println("Apakah anda ingin menambankan data lagi? [y/t]");
                System.out.print(">>> ");
                String jawabYt = input.nextLine();
                if (jawabYt.equalsIgnoreCase("t")) {
                    addDataPinjamanRunning = false;
                }
            }
            clearScreen();
            menuPinjaman();
        }
    }
    static void editPinjaman() throws IOException {
        if (listPinjaman.isEmpty()) {
            System.out.println("[ List pinjaman kosong, silahkan tambah terlebih dahulu :) ]");
            menuPinjaman();
        } else {
            listPinjaman();
            System.out.println("Pilih pinjaman yang ingin diedit.");
            System.out.print(">>> ");

            int selEditPinjaman = validIntInput();
            int indexEditData = selEditPinjaman - 1;

            if (indexEditData < 0 || indexEditData >= listPinjaman.size()) {
                clearScreen();
                System.out.println("Pinjaman tidak valid. Silakan coba lagi.");
                menuPinjaman();
                return;
            }

            Object[] dataPinjaman = listPinjaman.get(indexEditData);
            clearScreen();

            boolean editDataPinjamanRunning = true;

            while (editDataPinjamanRunning) {
                System.out.println("Data Pinjaman yang dipilih:");
                System.out.println("[1] - Nama                  : " + dataPinjaman[0]);
                System.out.println("    - NIK                   : " + dataPinjaman[1]);
                System.out.printf("[2] - Jumlah Pinjaman       : Rp. %,.0f%n", dataPinjaman[2]);
                System.out.println("[3] - Bunga                 : " + dataPinjaman[3]);

                System.out.println("\nPilih atribut yang ingin diedit:");
                System.out.print(">>> ");

                int selEditAtribut = validIntInput();

                switch (selEditAtribut) {
                    case 1:
                        clearScreen();
                        if (listAnggota.isEmpty()) {
                            System.out.println("[ List anggota kosong, silahkan tambah terlebih dahulu :) ]");
                            menuPinjaman();
                        } else {
                            listAnggota();
                            System.out.print("Pilih Anggota Baru untuk Nama >> ");
                            int selAnggota = validIntInput();
                            int indexAnggota = selAnggota - 1;

                            if (indexAnggota < 0 || indexAnggota >= listAnggota.size()) {
                                System.out.println("Anggota tidak valid. Tidak ada perubahan yang dilakukan.");
                            } else {
                                Object[] dataAnggota = listAnggota.get(indexAnggota);
                                dataPinjaman[0] = dataAnggota[0];
                                dataPinjaman[1] = dataAnggota[1];
                            }
                            input.nextLine();
                        }
                        break;
                    case 2:
                        clearScreen();
                        System.out.print("Masukkan Jumlah Pinjaman baru: Rp. ");
                        double jumlahPinjaman = input.nextDouble();
                        dataPinjaman[2] = jumlahPinjaman;
                        
                        double bungaPinjaman = (double) dataPinjaman[3];
                        double totalPinjamanBunga = jumlahPinjaman + (jumlahPinjaman * bungaPinjaman / 100);
                        dataPinjaman[4] = totalPinjamanBunga;
                        input.nextLine();
                        break;
                    case 3:
                        clearScreen();
                        input.nextLine();
                        System.out.print("Masukkan Bunga baru (%): ");
                        double bungaBaru = input.nextDouble();
                        dataPinjaman[3] = bungaBaru;
                        input.nextLine();
                        
                        double jumlahPinjamanCurrent = (double) dataPinjaman[2];
                        double totalPinjamanBungaNew = jumlahPinjamanCurrent + (jumlahPinjamanCurrent * bungaBaru / 100);
                        dataPinjaman[4] = totalPinjamanBungaNew;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Tidak ada perubahan yang dilakukan.");
                        break;
                }
                clearScreen();
                System.out.println("Apakah anda ingin mengubah data lagi? [y/t]");
                System.out.print(">>> ");
                String jawabYt = input.nextLine();
                if (jawabYt.equalsIgnoreCase("t")) {
                    editDataPinjamanRunning = false;
                }
            }
            clearScreen();
            System.out.println("Data pinjaman telah diperbarui.");
            menuPinjaman();
        }
    }
    static void removePinjaman() throws IOException {
       if (listPinjaman.isEmpty()) {
            System.out.println("[ List pinjaman kosong, silahkan tambah terlebih dahulu :) ]");
            menuPinjaman();
        } else {
            listPinjaman();
            System.out.println("Pilih pinjaman yang ingin di hapus.");
            System.out.print(">>> ");

            int selRemovePinjaman = validIntInput();
            int indexRemoveData = selRemovePinjaman - 1;
            
            if (indexRemoveData < 0 || indexRemoveData >= listPinjaman.size()) {
                clearScreen();
                System.out.println("Pinjaman tidak valid. Silakan coba lagi.");
                menuPinjaman();
            } else {
                listPinjaman.remove(indexRemoveData);
            }
            
            clearScreen();
            menuPinjaman();
        } 
    }
    
    static int validIntInput() {
        int inputValue = -1;
        boolean inputValidasi = false;

        while (!inputValidasi) {
            try {
                inputValue = input.nextInt();
                inputValidasi = true;
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid! Silakan masukkan angka yang sesuai.");
                input.nextLine();
                System.out.print(">>> ");
            }
        }
        return inputValue;
    }
    static void clearScreen() throws IOException {
        if (System.getProperty("os.name").contains("Windows")) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (IOException | InterruptedException ex) {
                System.out.print("Error saat menghapus :(");
            }
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
    
    static void informasiProgram() throws IOException {
        System.out.println("==============================");
        System.out.println("Program Simpan Pinjam v1.0");
        System.out.println("Nama    : Fauzan Priatmana");
        System.out.println("NIM     : 24.240.0027");
        System.out.println("Kelas   : 1P41");
        System.out.println("==============================");
        System.out.println("[0] Kembali Ke Menu Utama");
        System.out.println("==============================");
        System.out.print(">>> ");
        
        int selInfoMenu = validIntInput();
        
        switch (selInfoMenu) {
            case 0:
                clearScreen();
                mainMenu();
            default:
                clearScreen();
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                informasiProgram();
                break;
        }

    }
}