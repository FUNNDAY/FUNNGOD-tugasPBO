/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ACER
 */
public class koneksi {
    
    private String databaseName="2210010177";
    private String username="root";
    private String password="";
    private String lokasi="jdbc:mysql://localhost/"+databaseName;
    public static Connection koneksiDB;
    
    // KONEKSI DATABASE
    public koneksi(){
        try {
           Class.forName("com.mysql.cj.jdbc.Driver") ;
           koneksiDB=DriverManager.getConnection(lokasi,username,password);
           System.out.println("database terkoneksi");
           
        } catch (Exception e) {
           System.err.println(e.toString()); 
        }
    }
    
    // CODING DESA
    public void simpanDesa(int paramId, String paramNama, String paramWarna, int paramLat, int paramLong, int paramJumlah){
        try{
            String SQL="INSERT INTO desa(IdDesa,NamaDesa,Warna,CenterLat,CenterLong,JumlahPenduduk)"
                   + "VALUE(?,?,?,?,?,?)"; 
                    
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            
            perintah.setInt(1, paramId);
            perintah.setString(2, paramNama);
            perintah.setString(3, paramWarna);
            perintah.setInt(4, paramLat);
            perintah.setInt(5, paramLong);
            perintah.setInt(6, paramJumlah);
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahDesa(int paramId, String paramNama, String paramWarna, int paramLat, int paramLong, int paramJumlah){
        try{
            String SQL="UPDATE desa SET NamaDesa=?, Warna=?, CenterLat=?, CenterLong=?, JumlahPenduduk=? WHERE IdDesa=?"; 
                    
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            
            perintah.setString(1, paramNama);
            perintah.setString(2, paramWarna );
            perintah.setInt(3, paramLat);
            perintah.setInt(4, paramLong);
            perintah.setInt(5, paramJumlah);
            perintah.setInt(6, paramId);
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusDesa(int paramId){
        try{
            String SQL ="DELETE FROM desa WHERE IdDesa=?";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            
            perintah.setInt(1, paramId);
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void cariDesa(int paramId){
        try{
            String SQL ="SELECT*FROM desa WHERE IdDesa=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId);
            ResultSet data = perintah.executeQuery();
           
            while(data.next()){
                System.out.println("Id : "+data.getInt("IdDesa"));
                System.out.println("Nama Desa : "+data.getString("NamaDesa"));
                System.out.println("Warna : "+data.getString("Warna"));
                System.out.println("Center Latitude : "+data.getString("CenterLat"));
                System.out.println("Center Longitude: "+data.getString("CenterLong"));
                System.out.println("Jumlah Penduduk : "+data.getInt("JumlahPenduduk"));
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void dataDesa(){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("SELECT*FROM desa ORDER BY IdDesa ASC");
            
            System.out.println("Id | Nama Desa | Jumlah Penduduk");
            
            while (baris.next()){
                System.out.println(baris.getInt("IdDesa")+" | "+
                        baris.getString("NamaDesa")+" | "+
                        baris.getString("Warna")+" | "+
                        baris.getInt("CenterLat")+" | "+
                        baris.getInt("CenterLong")+" | "+
                        baris.getInt("JumlahPenduduk")+" | ");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    // CODING PENDERITA   
    public void simpanPenderita(int paramId, String paramNama, String paramAlamat, int paramIdDesa, String paramJk, int paramUmur, int paramTahun ){
        try {
            String SQL="INSERT INTO penderita(IdPenderita,NamaPenderita,Alamat,IdDesa,JenisKelamin,Umur,Tahun)"
                   + "VALUE(?,?,?,?,?,?,?)";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            
            perintah.setInt(1, paramId);
            perintah.setString(2, paramNama);
            perintah.setString(3, paramAlamat);
            perintah.setInt(4, paramIdDesa);
            perintah.setString(5, paramJk);
            perintah.setInt(6, paramUmur);
            perintah.setInt(7,paramTahun);
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
            
        } catch (Exception e) {
        }
    }
    
    public void ubahPenderita(int paramIdPenderita, String paramNama, String paramAlamat, int paramIdDesa, String paramJk, int paramUmur, int paramTahun ){
        try {
            String SQL="UPDATE penderita SET NamaPenderita=?, Alamat=?, IdDesa=?, JenisKelamin=?,"
                    + "Umur=?, Tahun=? WHERE IdPenderita=?"; 
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            
            perintah.setString(1, paramNama);
            perintah.setString(2, paramAlamat);
            perintah.setInt(3, paramIdDesa);
            perintah.setString(4, paramJk);
            perintah.setInt(5, paramUmur);
            perintah.setInt(6, paramTahun);
            perintah.setInt(7, paramIdPenderita);
            perintah.executeUpdate();
            System.out.println("data berhasil diubah"); 

        } catch (Exception e) {
        }
    }
    
    public void hapusPenderita(int paramIdPenderita){
        try {
            String SQL ="DELETE FROM penderita WHERE IdPenderita=?";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            
            perintah.setInt(1,paramIdPenderita);
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
        }
    }
    
    public void cariPenderita(int paramIdPenderita){
        try {
            String SQL="SELECT*FROM penderita WHERE IdPenderita=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramIdPenderita);
            ResultSet data = perintah.executeQuery();
            
            while(data.next()){
                System.out.println("Id Penderita: "+data.getInt("IdPenderita"));
                System.out.println("Nama Penderita : "+data.getString("NamaPenderita"));
                System.out.println("Alamat : "+data.getString("Alamat"));
                System.out.println("Id Desa : "+data.getInt("IdDesa"));
                System.out.println("Jenis Kelamin : "+data.getString("JenisKelamin"));
                System.out.println("Umur : "+data.getInt("Umur"));
                System.out.println("Tahun : "+data.getInt("Tahun"));
            }
                    
        } catch (Exception e) {
        }
    }
    
    public void dataPenderita(){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("SELECT*FROM penderita ORDER BY IdPenderita ASC");
            
            System.out.println("ID PENDERITA | NAMA PENDERITA | ALAMAT | ID DESA | JENIS KELAMIN | UMUR | TAHUN");
            
            while (baris.next()){
                System.out.println(baris.getInt("IdPenderita")+" | "+
                        baris.getString("NamaPenderita")+" | "+
                        baris.getString("Alamat")+" | "+
                        baris.getInt("IdDesa")+" | "+
                        baris.getString("JenisKelamin")+" | "+
                        baris.getInt("Umur")+" | "+
                        baris.getInt("Tahun")+" | ");
            }
        } catch (Exception e) {
        }
    }
    
    // CODING MAP
    public void simpanMap(int paramIdMap, int paramIdDesa, int paramPol, int paramLat, int paramLong) {
    try {
        String SQL = "INSERT INTO map(IdMap, IdDesa, NoPoligon, LatMap, LongMap) VALUES(?,?,?,?,?)";
        
        PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
        
        perintah.setInt(1, paramIdMap);
        perintah.setInt(2, paramIdDesa);
        perintah.setInt(3, paramPol);
        perintah.setInt(4, paramLat);
        perintah.setInt(5, paramLong);
        perintah.executeUpdate();
        System.out.println("Data berhasil disimpan");
        
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Terjadi kesalahan saat menyimpan data");
    }
}

    public void ubahMap(int paramIdMap, int paramIdDesa, int paramPol, int paramLat, int paramLong) {
    try {
        String SQL = "UPDATE map SET IdDesa=?, NoPoligon=?, LatMap=?, LongMap=? WHERE IdMap=?";
        
        PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
        
        perintah.setInt(1, paramIdDesa);
        perintah.setInt(2, paramPol);
        perintah.setInt(3, paramLat);
        perintah.setInt(4, paramLong);
        perintah.setInt(5, paramIdMap);
        perintah.executeUpdate();
        System.out.println("Data berhasil diubah");
        
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Terjadi kesalahan saat mengubah data");
        }
    }
 
    public void hapusMap(int paramIdMap) {
    try {
        String SQL = "DELETE FROM map WHERE IdMap=?";
        
        PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
        
        perintah.setInt(1, paramIdMap);
        perintah.executeUpdate();
        System.out.println("Data berhasil dihapus");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Terjadi kesalahan saat menghapus data");
        }
    }
    
    public void cariMap(int paramIdMap) {
    try {
        String SQL = "SELECT * FROM map WHERE IdMap=?";
        PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
        perintah.setInt(1, paramIdMap);
        ResultSet data = perintah.executeQuery();
        
        while (data.next()) {
            System.out.println("Id Map: " + data.getInt("IdMap"));
            System.out.println("Id Desa: " + data.getInt("IdDesa"));
            System.out.println("No Poligon: " + data.getInt("NoPoligon"));
            System.out.println("Lat Map: " + data.getInt("LatMap"));
            System.out.println("Long Map: " + data.getInt("LongMap"));
        }
        
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Terjadi kesalahan saat mencari data");
        }
    }
    
    public void dataMap() {
    try {
        Statement stmt = koneksiDB.createStatement();
        ResultSet baris = stmt.executeQuery("SELECT * FROM map ORDER BY IdMap ASC");
        
        System.out.println("ID MAP | ID DESA | NO POLIGON | LAT MAP | LONG MAP");
        
        while (baris.next()) {
            System.out.println(baris.getInt("IdMap") + " | " +
                    baris.getInt("IdDesa") + " | " +
                    baris.getInt("NoPoligon") + " | " +
                    baris.getInt("LatMap") + " | " +
                    baris.getInt("LongMap"));
        }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Terjadi kesalahan saat mengambil data");
        }
    }
    
    // CODING JENTIK
    public void simpanJentik(int paramIdJentik, int paramIdDesa, String paramRd, String paramRj, int paramTahun) {
    try {
        String SQL = "INSERT INTO jentik(IdJentik, IdDesa, Rd, Rj, Tahun) VALUES(?,?,?,?,?)";
        
        PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
        
        perintah.setInt(1, paramIdJentik);
        perintah.setInt(2, paramIdDesa);
        perintah.setString(3, paramRd);
        perintah.setString(4, paramRj);
        perintah.setInt(5, paramTahun);
        
        perintah.executeUpdate();
        System.out.println("Data berhasil disimpan");
        
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Terjadi kesalahan saat menyimpan data");
        }
    }

    public void ubahJentik(int paramIdJentik, int paramIdDesa, String paramRd, String paramRj, int paramTahun) {
    try {
        String SQL = "UPDATE jentik SET IdDesa=?, Rd=?, Rj=?, Tahun=? WHERE IdJentik=?";
        
        PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
        
        perintah.setInt(1, paramIdDesa);
        perintah.setString(2, paramRd);
        perintah.setString(3, paramRj);
        perintah.setInt(4, paramTahun);
        perintah.setInt(5, paramIdJentik);
        
        perintah.executeUpdate();
        System.out.println("Data berhasil diubah");
        
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Terjadi kesalahan saat mengubah data");
        }
    }
    
    public void hapusJentik(int paramIdJentik) {
    try {
        String SQL = "DELETE FROM jentik WHERE IdJentik=?";
        
        PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
        
        perintah.setInt(1, paramIdJentik);
        
        perintah.executeUpdate();
        System.out.println("Data berhasil dihapus");
        
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Terjadi kesalahan saat menghapus data");
        }
    }
    
    public void cariJentik(int paramIdJentik) {
    try {
        String SQL = "SELECT * FROM jentik WHERE IdJentik=?";
        PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
        perintah.setInt(1, paramIdJentik);
        ResultSet data = perintah.executeQuery();
        
        while (data.next()) {
            System.out.println("Id Jentik: " + data.getInt("IdJentik"));
            System.out.println("Id Desa: " + data.getInt("IdDesa"));
            System.out.println("Rd: " + data.getString("Rd"));
            System.out.println("Rj: " + data.getString("Rj"));
            System.out.println("Tahun: " + data.getInt("Tahun"));
        }
        
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Terjadi kesalahan saat mencari data");
        }
    }
    
    public void dataJentik() {
    try {
        Statement stmt = koneksiDB.createStatement();
        ResultSet baris = stmt.executeQuery("SELECT * FROM jentik ORDER BY IdJentik ASC");
        
        System.out.println("ID JENTIK | ID DESA | RD | RJ | TAHUN");
        
        while (baris.next()) {
            System.out.println(baris.getInt("IdJentik") + " | " +
                    baris.getInt("IdDesa") + " | " +
                    baris.getString("Rd") + " | " +
                    baris.getString("Rj") + " | " +
                    baris.getInt("Tahun"));
        }
        
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Terjadi kesalahan saat mengambil data");
        }
    }

}
