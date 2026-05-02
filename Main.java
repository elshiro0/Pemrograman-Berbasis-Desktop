import java.util.Scanner;

public class Main {

    // Array menu
    static Menu[] menu = {
        new Menu("Nasi Goreng", 25000, "Makanan"),
        new Menu("Nasi Soto", 20000, "Makanan"),
        new Menu("Mie Ayam", 18000, "Makanan"),
        new Menu("Ayam Bakar", 30000, "Makanan"),
        
        new Menu("Es Teh Manis", 5000, "Minuman"),
        new Menu("Es Jeruk", 7000, "Minuman"),
        new Menu("Jus Alpukat", 15000, "Minuman"),
        new Menu("Air Mineral", 4000, "Minuman")
    };

    //Array menyimpan pesanan
    static String[] namaPesan = new String[4];
    static int[] jumlahPesan = new int[4];
    static int totalItem = 0;

    // Method untuk menampilkan menu
    static void tampilkanMenu() {
        System.out.println(" ");
        System.out.println("WARUNG SUKA SUKA");
        System.out.println(" ");
        System.out.println("Makanan");
        System.out.println("1. " + menu[0].nama + "\t\tRp " + (int) menu[0].harga);
        System.out.println("2. " + menu[1].nama + "\t\tRp " + (int) menu[1].harga);
        System.out.println("3. " + menu[2].nama + "\t\t\tRp " + (int) menu[2].harga);
        System.out.println("4. " + menu[3].nama + "\t\tRp " + (int) menu[3].harga);
        System.out.println(" ");

        System.out.println("Minuman");
        System.out.println("5. " + menu[4].nama + "\t\tRp " + (int) menu[4].harga);
        System.out.println("6. " + menu[5].nama + "\t\t\tRp " + (int) menu[5].harga);
        System.out.println("7. " + menu[6].nama + "\t\tRp " + (int) menu[6].harga);
        System.out.println("8. " + menu[7].nama + "\t\tRp " + (int) menu[7].harga);
        System.out.println(" ");
    }

    //Method cari menu berdasarkan nomor
    static Menu cariMenu(int nomor) {
        if (nomor == 1) return menu[0];
        else if (nomor == 2) return menu[1];
        else if (nomor == 3) return menu[2];
        else if (nomor == 4) return menu[3];
        else if (nomor == 5) return menu[4];
        else if (nomor == 6) return menu[5];
        else if (nomor == 7) return menu[6];
        else if (nomor == 8) return menu[7];
        else return null;
    }

    //Pesanan
    static void inputPesanan(Scanner sc, int ke) {
        System.out.print("Pilih menu ke-" + ke + " (0 = selesai): ");
        int pilih = sc.nextInt();

        if (pilih == 0) return;

        Menu m = cariMenu(pilih);
        if (m == null) {
            System.out.println("Menu tidak valid. Silakan coba lagi.");
            inputPesanan(sc, ke);
            return;
        }

        System.out.print("Jumlah " + m.nama + ": ");
        int jumlah = sc.nextInt();

        namaPesan[totalItem] = m.nama;
        jumlahPesan[totalItem] = jumlah;
        totalItem++;
        System.out.println(m.nama + " x " + jumlah + " berhasil ditambahkan ke pesanan.");
    }

    //Menthod untuk mendapatkan harga berdasarkan nama menu
    static double getHargaByNama(String nama) {
        if (menu[0].nama.equals(nama)) return menu[0].harga;
        else if (menu[1].nama.equals(nama)) return menu[1].harga;
        else if (menu[2].nama.equals(nama)) return menu[2].harga;
        else if (menu[3].nama.equals(nama)) return menu[3].harga;
        else if (menu[4].nama.equals(nama)) return menu[4].harga;
        else if (menu[5].nama.equals(nama)) return menu[5].harga;
        else if (menu[6].nama.equals(nama)) return menu[6].harga;
        else if (menu[7].nama.equals(nama)) return menu[7].harga;
        else return 0;
    }

    //Method untuk mendapatkan kategori berdasarkan nama menu
    static String getKategoriByNama(String nama) {
        if (menu[0].nama.equals(nama)) return menu[0].kategori;
        else if (menu[1].nama.equals(nama)) return menu[1].kategori;
        else if (menu[2].nama.equals(nama)) return menu[2].kategori;
        else if (menu[3].nama.equals(nama)) return menu[3].kategori;
        else if (menu[4].nama.equals(nama)) return menu[4].kategori;
        else if (menu[5].nama.equals(nama)) return menu[5].kategori;
        else if (menu[6].nama.equals(nama)) return menu[6].kategori;
        else if (menu[7].nama.equals(nama)) return menu[7].kategori;
        else return "";
    }

    //untuk mencetak struk pembayaran
    static void cetakStruk() {
        double subtotal = 0;

        if (totalItem >= 1) subtotal += getHargaByNama(namaPesan[0]) * jumlahPesan[0];
        if (totalItem >= 2) subtotal += getHargaByNama(namaPesan[1]) * jumlahPesan[1];
        if (totalItem >= 3) subtotal += getHargaByNama(namaPesan[2]) * jumlahPesan[2];
        if (totalItem >= 4) subtotal += getHargaByNama(namaPesan[3]) * jumlahPesan[3];

        double diskon = 0;
        double bogoHarga = 0;
        String bogoNama = "";

        if (subtotal > 100000) {
            diskon = subtotal * 0.10;
            System.out.println("Selamat! Anda mendapatkan diskon 10%");
        }

        if (subtotal > 50000) {
            if (totalItem >= 1 && getKategoriByNama(namaPesan[0]).equals("Minuman")) {
                bogoNama = namaPesan[0];
                bogoHarga = getHargaByNama(namaPesan[0]);
            } else if (totalItem >= 2 && getKategoriByNama(namaPesan[1]).equals("Minuman")) {
                bogoNama = namaPesan[1];
                bogoHarga = getHargaByNama(namaPesan[1]);
            } else if (totalItem >= 3 && getKategoriByNama(namaPesan[2]).equals("Minuman")) {
                bogoNama = namaPesan[2];
                bogoHarga = getHargaByNama(namaPesan[2]);
            } else if (totalItem >= 4 && getKategoriByNama(namaPesan[3]).equals("Minuman")) {
                bogoNama = namaPesan[3];
                bogoHarga = getHargaByNama(namaPesan[3]);
            }
            if (!bogoNama.isEmpty()) {
                System.out.println("Promo Beli 1 Gratis 1: " + bogoNama + "gratis 1 porsi!");
            }
        }

        double totalSetelahDiskon = subtotal - diskon - bogoHarga;
        double pajak = totalSetelahDiskon * 0.10;
        double pelayanan = 20000;
        double grandTotal = totalSetelahDiskon + pajak + pelayanan;

        System.out.println();
        System.out.println("STRUK PEMBAYARAN");
        if(totalItem >= 1)
            System.out.println(namaPesan[0] + " x " + jumlahPesan[0] + " =Rp " + (int) (getHargaByNama(namaPesan[0]) * jumlahPesan[0]));
        if(totalItem >= 2)
            System.out.println(namaPesan[1] + " x " + jumlahPesan[1] + " =Rp " + (int) (getHargaByNama(namaPesan[1]) * jumlahPesan[1]));
        if(totalItem >= 3)
            System.out.println(namaPesan[2] + " x " + jumlahPesan[2] + " =Rp " + (int) (getHargaByNama(namaPesan[2]) * jumlahPesan[2]));
        if(totalItem >= 4)
            System.out.println(namaPesan[3] + " x " + jumlahPesan[3] + " =Rp " + (int) (getHargaByNama(namaPesan[3]) * jumlahPesan[3]));

        System.out.println(" ");
        System.out.println("Subtotal: Rp " + (int) subtotal);
        if (diskon > 0) 
            System.out.println("Diskon 10%: -Rp " + (int) diskon);
        if (bogoHarga > 0) 
            System.out.println("Gratis " + bogoNama + ": -Rp " + (int) bogoHarga);
        System.out.println("Setelah diskon : Rp " + (int)totalSetelahDiskon);
        System.out.println("Pajak 10%: Rp " + (int) pajak);
        System.out.println("Biaya Pelayanan: Rp " + (int) pelayanan);
        System.out.println(" ");
        System.out.println("Grand Total: Rp " + (int) grandTotal);
        System.out.println("Terima kasih atas kunjungan Anda!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        tampilkanMenu();

        System.out.println("Silahkan masukkan pesanan (maks 4 manu):");
        inputPesanan(sc, 1 );
        if (totalItem == 1) inputPesanan(sc, 2);
        if (totalItem == 2) inputPesanan(sc, 3);
        if (totalItem == 3) inputPesanan(sc, 4);

        if (totalItem == 0) {
            System.out.println("Tidak ada pesanan.");
        } else {
            cetakStruk();
        }

        sc.close();
    }
}