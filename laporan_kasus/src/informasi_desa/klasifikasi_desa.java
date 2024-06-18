/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package informasi_desa;

/**
 *
 * @author RIzalAbdi
 */
public class klasifikasi_desa {
    int id;
    String nama, klasifikasi;
    boolean adaKasus, terjadiSetiapTahun; //true/false
    private double ABJ; // ABJ dalam persentase

    public klasifikasi_desa() {} // constructor

    public void inputId(int id){
        this.id = id;
    }
    
    public int ambilID(){
        return this.id;
    }
    
    public void inputNama(String nama) {
        this.nama = nama;
    }

    public String ambilNama() {
        return this.nama;
    }

    public void inputKasus(boolean adaKasus, boolean terjadiSetiapTahun) {
        this.adaKasus = adaKasus;
        this.terjadiSetiapTahun = terjadiSetiapTahun;
    }

    public void inputABJ(double ABJ) {
        if (ABJ < 0 || ABJ > 100) {
            throw new IllegalArgumentException("Nilai ABJ harus antara 0 dan 100.");
        }
        this.ABJ = ABJ;
    }

    public double ambilABJ() {
        return this.ABJ;
    }

    public void tentukanKlasifikasi() {
        if (adaKasus) {
            if (terjadiSetiapTahun) {
                this.klasifikasi = "DESA ENDEMIS";
            } else {
                this.klasifikasi = "DESA SPORADIS";
            }
        } else {
            if (ABJ < 5) {
                this.klasifikasi = "DESA BEBAS";
            } else {
                this.klasifikasi = "DESA POTENSIAL";
            }
        }
    }

    public String ambilKlasifikasi() {
        return this.klasifikasi;
    }
}