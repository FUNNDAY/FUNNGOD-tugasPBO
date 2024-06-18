/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package informasi_desa;

/**
 *
 * @author RizalAbdi
 */
public class zona_warna extends klasifikasi_desa{
    String zonaWarna;
    
    public zona_warna(){}
    
        public void tentukanZonaWarna() {
        switch (ambilKlasifikasi()) {
            case "DESA BEBAS":
                zonaWarna = "PUTIH";
                break;
            case "DESA POTENSIAL":
                zonaWarna = "HIJAU";
                break;
            case "DESA SPORADIS":
                zonaWarna = "KUNING";
                break;
            case "DESA ENDEMIS":
                zonaWarna = "MERAH";
                break;
            default:
                zonaWarna = "Tidak Diketahui";
        }
    }

    public String ambilZonaWarna() {
        return this.zonaWarna;
    }

}
