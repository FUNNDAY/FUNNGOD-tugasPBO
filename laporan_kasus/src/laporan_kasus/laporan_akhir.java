/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laporan_kasus;
import informasi_desa.*;
import java.util.Scanner;
import crud.koneksi;
import gui.*;
import java.sql.Date;

/**
 *
 * @author RizalAbdi
 */
public class laporan_akhir {
    
    public static void main(String[] args){
        
        new frameUtama().setVisible(true);
        
        
        
        
        
        
//        koneksi db = new koneksi();
//        db.dataJentik();
//        db.hapusDesa(2);
//        db.dataDesa();
//        
        
        
        
        
//        zona_warna desa = new zona_warna ();
//        Scanner scanner = new Scanner(System.in);
//        
//        // Input Nama Desa
//        System.out.print("Masukkan nama desa: ");
//        String nama = scanner.nextLine();
//        desa.inputNama(nama);
//
//        // Input Kasus
//        System.out.print("Apakah ada kasus (iya/tidak)? ");
//        boolean adaKasus = convertToBoolean(scanner.nextLine());
//        boolean terjadiSetiapTahun = false; // Default value
//
//        if (adaKasus) {
//            System.out.print("Apakah terjadi setiap tahun (iya/tidak)? ");
//            terjadiSetiapTahun = convertToBoolean(scanner.nextLine());
//        }
//        desa.inputKasus(adaKasus, terjadiSetiapTahun);
//
//        // Input ABJ jika tidak ada kasus
//        if (!adaKasus) {
//            System.out.print("Masukkan nilai ABJ (0-100): ");
//            double ABJ = scanner.nextDouble();
//            try {
//                desa.inputABJ(ABJ);
//            } catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//                System.exit(1);
//            }
//        }
//
//        // Tentukan Klasifikasi
//        desa.tentukanKlasifikasi();
//        String klasifikasi = desa.ambilKlasifikasi();
//        System.out.println("Klasifikasi desa: " + klasifikasi);
//
//        // Menggunakan zona_warna untuk menentukan zona warna berdasarkan klasifikasi desa
//        zona_warna zona = new zona_warna();
//        zona.inputNama(nama); // inputkan nama desa
//        zona.inputKasus(adaKasus, terjadiSetiapTahun); // inputkan kasus
//        if (!adaKasus) {
//            zona.inputABJ(desa.ambilABJ()); // inputkan ABJ jika tidak ada kasus
//        }
//        zona.tentukanKlasifikasi(); // tentukan klasifikasi
//        zona.tentukanZonaWarna(); // tentukan zona warna
//
//        String zonaWarna = zona.ambilZonaWarna();
//        System.out.println("Zona warna desa: " + zonaWarna);
//
//        scanner.close();
//    }
//
//    // Method untuk mengonversi input "iya/tidak" menjadi boolean
//    public static boolean convertToBoolean(String input) {
//        if (input.equalsIgnoreCase("iya")) {
//            return true;
//        } else if (input.equalsIgnoreCase("tidak")) {
//            return false;
//        } else {
//            throw new IllegalArgumentException("Input harus 'iya' atau 'tidak'");
//        }
    }
    
}
