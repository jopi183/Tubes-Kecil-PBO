/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubeskecil;

/**
 *
 * @author joshu
 */
public class Mahasiswa extends Orang{
    private String NIM;
    private String dormName;
    private String noKamar;
    
    public Mahasiswa(String nama, int umur, String jenisKelamin, String NIM){
        super(nama,umur,jenisKelamin);
        this.NIM = NIM;
        this.dormName = dormName;
        this.noKamar = noKamar;
    }
    

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public String getDormName() {
        return dormName;
    }

    public void setDormName(String dormName) {
        this.dormName = dormName;
    }

    public String getNoKamar() {
        return noKamar;
    }

    public void setNoKamar(String noKamar) {
        this.noKamar = noKamar;
    }
    
    @Override
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
    
    public void registerRoom(Room room) {
        if (room.checkAvailability()) { 
            room.assignStudent(this); 
            this.noKamar = room.getNoKamar(); 
            System.out.println("Mahasiswa " + getNama() + " berhasil terdaftar di kamar " + room.getNoKamar());
        } else {
            System.out.println("Kamar " + room.getNoKamar() + " sudah terisi. Pendaftaran gagal.");
        }
    }
    
    public void checkOut(Room room) {
        if (this.noKamar.equals(room.getNoKamar())) { 
            room.vacateRoom(); 
            this.noKamar = null; 
            System.out.println("Mahasiswa " + getNama() + " telah check out dari kamar " + room.getNoKamar());
        } else {
            System.out.println("Mahasiswa " + getNama() + " tidak terdaftar di kamar " + room.getNoKamar());
        }
    }

    
    @Override
    public void getDetails(){
        super.getDetails();
        System.out.println("Nama asrama : " + dormName);
        System.out.println("Nomor kamar : " + noKamar);
    }
}
