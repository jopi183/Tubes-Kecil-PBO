/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubeskecil;

/**
 *
 * @author joshu
 */
public class Orang {
    protected String nama;
    protected int umur;
    protected String jenisKelamin;
    
    public Orang(String nama, int umur, String jenisKelamin){
        this.nama = nama;
        this.umur = umur;
        this.jenisKelamin = jenisKelamin;
    }

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
    
    public void getDetails(){
        System.out.println("Nama :" + nama);
        System.out.println("Jenis kelamin : " + jenisKelamin);
        System.out.println("Umur : "+ umur);
    }
    
    
}
