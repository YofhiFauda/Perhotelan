import java.util.Scanner;
//import class untuk database MySQL
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Perhotelan {
    //database
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/Perhotelan";
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    //ahir dari data base
    static Scanner input = new Scanner(System.in);//Static Variabel berfungsi agar suatu atribut atau method dapat diakses oleh kelas atau objek tanpa harus melakukan instansiasi
    static int pilih;
    static int totalKamar,julkam, pesan, totalPembayaran;
    static String nama, alamat, ktp, noHp;
    static int kembalian , sewa, bayar;
    static int single = 175000, doublle = 225000, suite = 300000;
    static int kamarSingle = 0,kamarDouble = 0, kamarSuite = 0;
    static int jumSingle = 0, jumDouble = 0, jumSuite = 0;
    static String Single = "Single", Duoble = "Double", Suite = "Suite";


    public static void main(String[] args) {
        try {
            // register driver
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            while (!conn.isClosed()) {
                menu();
            }
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        //membuat perulangan untuk method menu
        do {
            menu();
        } while (pilih != 5);
            System.exit(0);
    }
    public static void menu() {
        System.out.println(" ________________________________ ");
        System.out.println("|          MENU UTAMA            |");
        System.out.println("|--------------------------------|");
        System.out.println("| (1) Data Kamar                 |");
        System.out.println("| (2) Data Penyewa               |");
        System.out.println("| (3) Data Transaksi             |");
        System.out.println("| (4) Hapus Data                 |");
        System.out.println("| (5) keluar dari Program        |");
        System.out.println(" -------------------------------- ");
        System.out.print("Masukan Pilihan : ");
        pilih = input.nextInt();
        switch (pilih) {
            case 1 -> dataKamar();
            case 2 -> dataPenyewa();
            case 3 -> dataTransaksi();
            case 4 -> hapusData();
            default -> System.out.println("Terima Kasih Telah Berkunjung");
        }
    }

    //MEMBUAT METHOD DATA KAMAR
   public static void dataKamar() {
        do {
            System.out.println(" ________________________________ ");
            System.out.println("|          DATA KAMAR            |");
            System.out.println("| (1) Pengecekan Semua Kamar     |");
            System.out.println("|--------------------------------|");
            System.out.println("| (2) Inputkan Total Semua Kamar |");
            System.out.println("| (3) Pesan Kamar                |");
            System.out.println("| (4) Kembali                    |");
            System.out.println("|________________________________|");
            System.out.print("Masukan Pilihan : ");
            pilih = input.nextInt();
            switch (pilih){
                case 1 -> cekKamar();
                case 2 -> inputKamar();
                case 3 -> pesanKamar();
            }
        }while (pilih!= 4);
                 menu();
    }

    //Membuat Method pada Menu DATA KAMAR
    public static void cekKamar() {
        totalKamar = (kamarSingle + kamarDouble + kamarSuite);

        if(julkam == 0){
            System.out.println(" _____________________________________________________ ");
            System.out.println("| Semua Kamar Masih Kosong Kakak                      |");
            System.out.println("| Silahkan Lakukan input Jumlah Kamar Terlebih dahulu |");
            System.out.println("|_____________________________________________________|");
        } else {
            System.out.println("------------------------------");
            System.out.println("          CEK KAMAR           ");
            System.out.println("------------------------------");
            System.out.println("Total Semua Kamar      : "+ julkam);
            System.out.println("Total Kamar Kosong     : " + totalKamar);
            System.out.println("Total Kamar di Pesan   : " + pesan);
            System.out.print("DATA KAMAR KOSONG : ");
            //membuat percabangan Apakah Data pada Masing"  kamar sudah terisi atau kosong
            if (jumSingle == 0){
            System.out.println("Single : "+kamarSingle);//jika kamar belum di pesan maka kamar kosong akan sesuai dengan inputan
            }else {
            System.out.println("Single : "+kamarSingle); //jika kamar sudah di pesan maka kamar kosong akan sesuai dengan kamar yang di pesan
            }
            if (jumDouble == 0){
            System.out.println("                    Double : "+kamarDouble);
            }else {
            System.out.println("                    Double : "+kamarDouble);
            }
            if (jumSuite == 0){
            System.out.println("                    Suite  : "+kamarSuite);
            }else {
            System.out.println("                    Suite  : "+kamarSuite);
            }
            System.out.println("-----------------------------------------");
        }
    }

    public static void inputKamar(){
        int total;
        System.out.print("Masukan Total Semua Kamar  : ");
        julkam = input.nextInt();
        System.out.print("Masukan Total Kamar Single : ");
        kamarSingle = input.nextInt();
        System.out.print("Masukan Total Kamar Double : ");
        kamarDouble = input.nextInt();
        System.out.print("Masukan Total Kamar Suite  : ");
        kamarSuite = input.nextInt();
        total = kamarSingle + kamarDouble + kamarSuite;
        if (total > julkam){
            System.out.println(" --------------------------------------------- ");
            System.out.println("| Kamar yang anda Masukan Melebihi batas      |");
            System.out.println("| Silahkan Melakukan Input Kamar dengan benar |");
            System.out.println(" --------------------------------------------- ");
        }


    }

    public static void pesanKamar(){ //pembuatan pada Menu Kamar
        System.out.println("-------------------------------------------------- ");
        System.out.println("|                *** MENU KAMAR ***               |");
        System.out.println("|-------------------------------------------------|");
        System.out.println("| NO | TYPE   | ISI | KOSONG |       HARGA        |");
        System.out.println("|----|--------|-----|--------|--------------------|");
        System.out.println("| 1  | SINGLE |  -  |   -    | Rp. 175.000 / Hari |");
        System.out.println("| 2  | DOUBLE |  -  |   -    | Rp. 225.000 / Hari |");
        System.out.println("| 3  | SUITE  |  -  |   -    | Rp. 300.000 / Hari |");
        System.out.println(" ----|--------|-----|--------|-------------------- ");
        System.out.print("Pilih Kamar yang ingin anda pesan : ");
        pesan = input.nextInt();
        switch (pesan){
            case 1 -> Single();
            case 2 -> Doublle();
            case 3 -> Suite();
        }
    }

    //PEMBUATAN METHOD SINGLE DARI MENU PESAN KAMAR
    //UNTUK PEMESANAN KAMAR SINGLE
        static void Single(){
        try {
            System.out.println("Jumlah Kamar Yang Tersedia : "+kamarSingle+" Kamar");
            System.out.println("........................................");
            //jka pesan lebih kecil dari total Kamar Single Maka Akan Melanjutkan Proses Registrasi
        if (pesan < kamarSingle){
             kamarSingle = kamarSingle -  1;
            System.out.println("Kamar yang di pesan : Single");
            System.out.println("Harga Sewa          : Rp. "+single+" per Hari");
            System.out.print("Lama Sewa             : ");
            sewa = input.nextInt();
            totalPembayaran = sewa * single;
            System.out.println("\n*** Silahkan Isi Data Diri ***");
            System.out.println("-------------------------------------");
            System.out.print("Masukan Nama Anda Sesuai KTP : ");
            nama = input.next();
            System.out.print("Alamat Anda sesuai KTP       : ");
            alamat = input.next();
            System.out.print("Masukan No KTP anda          : ");
            ktp = input.next();
            System.out.print("Masukan No Hp yang aktif     : ");
            noHp = input.next();

            System.out.println("\n*** Melakukan Pembayaran Sewa Kamar ***");
            System.out.println("---------------------------------------");
            System.out.println("Kamar yang anda pesan : Single");
            System.out.println("Lama Menginap         : "+sewa);
            System.out.println("Total Bayar           : Rp. "+totalPembayaran);
            System.out.print("Bayar                   : Rp. ");
            bayar = input.nextInt();
            kembalian = bayar - totalPembayaran;
            System.out.println("Kembalian              : Rp. "+kembalian);
            String sql = "INSERT INTO penyewa (nama, alamat, ktp, noHp, kamar) VALUE('%s', '%s','%s', '%s', '%s')";
            sql = String.format(sql, nama, alamat, ktp, noHp, Single);
            stmt.execute(sql);
            String sql2 = "INSERT INTO transaksi (nama, alamat, ktp, noHp, kamar, sewa, totalPembayaran, bayar, kembalian) VALUE('%s', '%s','%s', '%s', '%s', '%d','%d', '%d', '%d')";
            sql2 = String.format(sql2, nama, alamat, ktp, noHp, Single, sewa, totalPembayaran, bayar,  kembalian);
            stmt.execute(sql2);
        }
        else { //jika pesan lebih besar dari Kapasitas Kamar Single Maka akan mengeluarkan Output
            System.out.println("Mohon Maaf Kamar Sudah Penuh");
        }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //PEMBUATAN METHOD DOUBLLE DARI MENU PESAN KAMAR
    //UNTUK PEMESANAN KAMAR DOUBLE
    static void Doublle(){
        try {

        System.out.println("Jumlah Kamar Yang Tersedia : "+kamarDouble+" Kamar");
        System.out.println("........................................");
        if (pesan < kamarDouble){ //jka pesan lebih kecil dari total Kamar Double Maka Akan Melanjutkan Proses Registrasi
            kamarDouble = kamarDouble -  1;
            System.out.println("Kamar yang di pesan : Double");
            System.out.println("Harga Sewa          : Rp. "+doublle+" per Hari");
            System.out.print("Lama Sewa             : ");
            sewa = input.nextInt();
            totalPembayaran = sewa * doublle;
            System.out.println("\n*** Silahkan Isi Data Diri ***");
            System.out.println("-------------------------------------");
            System.out.print("Masukan Nama Anda Sesuai KTP : ");
            nama = input.next();
            System.out.print("Alamat Anda sesuai KTP       : ");
            alamat = input.next();
            System.out.print("Masukan No KTP anda          : ");
            ktp = input.next();
            System.out.print("Masukan No Hp yang aktif     : ");
            noHp = input.next();

            System.out.println("\n*** Melakukan Pembayaran Sewa Kamar ***");
            System.out.println("---------------------------------------");
            System.out.println("Kamar yang anda pesan : Double");
            System.out.println("Lama Menginap         : "+sewa);
            System.out.println("Total Bayar           : Rp. "+totalPembayaran);
            System.out.print("Bayar                   : Rp. ");
            bayar = input.nextInt();
            kembalian = bayar - totalPembayaran;
            System.out.println("Kembalian             : Rp. "+kembalian);
            String sql = "INSERT INTO penyewa (nama, alamat, ktp, noHp, kamar) VALUE('%s', '%s','%s', '%s', '%s')";
            sql = String.format(sql, nama, alamat, ktp, noHp, Duoble);
            stmt.execute(sql);
            String sql2 = "INSERT INTO transaksi (nama, alamat, ktp, noHp, kamar, sewa, totalPembayaran, bayar, kembalian) VALUE('%s', '%s','%s', '%s', '%s', '%d','%d', '%d', '%d')";
            sql2 = String.format(sql2, nama, alamat, ktp, noHp, Duoble, sewa, totalPembayaran, bayar, kembalian);
            stmt.execute(sql2);
        }
        else { //Jika pesan Lebih besar dari Kapasitas Kamar Double Maka Akan mengeluarkan Outputan
            System.out.println("Mohon Maaf Kamar Sudah Penuh");
        }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //PEMBUATAN METHOD SUITE DARI MENU PESAN KAMAR
    //UNTUK PEMESANAN KAMAR SUITE
    static void Suite(){
        try {

        System.out.println("Jumlah Kamar Yang Tersedia : "+kamarSuite+" Kamar");
        System.out.println("........................................");
        if (pesan < kamarSuite){
            kamarSuite = kamarSuite - 1;
            System.out.println("Kamar yang di pesan : Suite");
            System.out.println("Harga Sewa          : Rp. "+suite+" per Hari");
            System.out.print("Lama Sewa             : ");
            sewa = input.nextInt();
            totalPembayaran = sewa * suite;
            System.out.println("\n*** Silahkan Isi Data Diri ***");
            System.out.println("-------------------------------------");
            System.out.print("Masukan Nama Anda Sesuai KTP : ");
            nama = input.next();
            System.out.print("Alamat Anda sesuai KTP       : ");
            alamat = input.next();
            System.out.print("Masukan No KTP anda          : ");
            ktp = input.next();
            System.out.print("Masukan No Hp yang aktif     : ");
            noHp = input.next();

            System.out.println("\n*** Melakukan Pembayaran Sewa Kamar ***");
            System.out.println("---------------------------------------");
            System.out.println("Kamar yang anda pesan : Suite");
            System.out.println("Lama Menginap         : "+sewa);
            System.out.println("Total Bayar           : Rp. "+totalPembayaran);
            System.out.print("Bayar                   : Rp. ");
            bayar = input.nextInt();
           kembalian = bayar - totalPembayaran;
           System.out.println("Kembalian              : Rp. "+kembalian);
            String sql = "INSERT INTO penyewa (nama, alamat, ktp, noHp, kamar) VALUE('%s', '%s','%s', '%s', '%s')";
            sql = String.format(sql, nama, alamat, ktp, noHp, Suite);
            stmt.execute(sql);
            String sql2 = "INSERT INTO transaksi (nama, alamat, ktp, noHp, kamar, sewa, totalPembayaran, bayar, kembalian) VALUE('%s', '%s','%s', '%s', '%s', '%d','%d', '%d', '%d')";
            sql2 = String.format(sql2, nama, alamat, ktp, noHp, Suite, sewa, totalPembayaran, bayar,  kembalian);
            stmt.execute(sql2);
        }
        else {
            System.out.println("Maaf Kamar Sudah Penuh");
        }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //MEMBUAT METHOD DATA PENYEWA KAMAR
    public static void dataPenyewa() {
        String sql = "SELECT * FROM penyewa";
        try {
            
            rs = stmt.executeQuery(sql);
            System.out.println("===============================================");
            System.out.println("            *** DATA PENYEWA ***              ");
            System.out.println("----------------------------------------------");
            System.out.println("=======================================================================================");
            System.out.println("| "+" NO"+" | "+ " NAMA "+ " | "+" ALAMAT "+ " | "+" NO KTP "+" | "+ " NO HP "+" | "+" KAMAR YANG DI PESAN "+" | ");
            System.out.println("=======================================================================================");
            while (rs.next()) {
            for(int i=0; i<=pesan; i++){
                    System.out.print("| "+i);
                }
                String nama = rs.getString("nama");
                String alamat = rs.getString("alamat");
                String ktp = rs.getString("ktp");
                String noHp = rs.getString("noHp");
                String kamar = rs.getString("kamar");

                System.out.printf(" | %s | %s | %s | %s | %s %n%n%n |",nama, alamat, ktp, noHp, kamar);
                System.out.println("===============================================");
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //MEMBUAT METHOD DATA TRANSAKSI PENYEWA KAMAR
   public static void dataTransaksi() {           
    String sql2 = "SELECT * FROM transaksi";
        try {
            rs = stmt.executeQuery(sql2);
               System.out.println("==========================================================");
               System.out.println("             *** DATA TRANSAKSI ***           ");
            System.out.println("=======================================================================================");
            while (rs.next()) {
            for(int i=0; i<=pesan; i++){
                System.out.println("NO : "+i);
                }
                String nama = rs.getString("nama");
                String alamat = rs.getString("alamat");
                String ktp = rs.getString("ktp");
                String noHp = rs.getString("noHp");
                String kamar = rs.getString("kamar");
                int sewa = rs.getInt("sewa");
                int totalPembayaran = rs.getInt("totalPembayaran");
                int bayar = rs.getInt("bayar");
                int kembalian = rs.getInt("kembalian");
                
                System.out.println("Nama             : "+nama);
                System.out.println("Alamat           : "+alamat);
                System.out.println("No KTP           : "+ktp);
                System.out.println("No Hp            : "+noHp);
                System.out.println("Kamar            : "+kamar);
                System.out.println("Lama Sewa        : "+sewa);
                System.out.println("Total Pembayaran : "+totalPembayaran);
                System.out.println("Bayar            : "+bayar);
                System.out.println("Kembalian        : "+kembalian);
                System.out.println("===============================================");
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
   }
   public static void hapusData(){
        pesan = 0;
        System.out.println("Data telah terhapus...");
       
   }
}