/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubeskecil;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joshu
 */
public class Asrama {
    private String dormitoryId;          
    private String dormName;             
    private int kapasitas;            
    private List<SeniorResidents> daftarSenior;
    private List<Room> daftarKamar;      
    private List<Mahasiswa> daftarMahasiswa; 
    
    public Asrama(String dormitoryId, String dormName, int kapasitas) {
        this.dormitoryId = dormitoryId;
        this.dormName = dormName;
        this.kapasitas = kapasitas;
        this.daftarKamar = new ArrayList<>(); 
        this.daftarMahasiswa = new ArrayList<>(); 
        this.daftarSenior = new ArrayList<>();
    }

    public String getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(String dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public String getDormName() {
        return dormName;
    }

    public void setDormName(String dormName) {
        this.dormName = dormName;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public List<Room> getDaftarKamar() {
        return daftarKamar;
    }

    public void setDaftarKamar(List<Room> daftarKamar) {
        this.daftarKamar = daftarKamar;
    }

    public List<Mahasiswa> getDaftarMahasiswa() {
        return daftarMahasiswa;
    }

    public void setDaftarMahasiswa(List<Mahasiswa> daftarMahasiswa) {
        this.daftarMahasiswa = daftarMahasiswa;
    }
    
    public void addRoom(Room kamar) {
        daftarKamar.add(kamar); 
        System.out.println("Kamar " + kamar.getNoKamar() + " telah ditambahkan ke " + dormName);
    }
    
    public void getAvailableRooms() {
        System.out.println("Daftar Kamar Tersedia di " + dormName + ":");
        boolean availableFound = false;
        for (Room kamar : daftarKamar) { 
            if (kamar.checkAvailability()) {
                System.out.println("- Kamar: " + kamar.getNoKamar());
                availableFound = true;
            }
        }
        if (!availableFound) {
            System.out.println("Tidak ada kamar tersedia.");
        }
    }
    
    public void tampilKamarMahasiswa(){
        if (daftarKamar.isEmpty()){
            System.out.println("Tidak ada kamar yang tersedia.");
            return;
        }
        System.out.println("=== Daftar Kamar dan Penghuninya ===");
        for (Room kamar : daftarKamar) {
            System.out.println("Nomor Kamar: " + kamar.getNoKamar());
            System.out.println("Lantai: " + kamar.getLantaiKamar());
            if (kamar.getAssignedStudent() != null) {
                System.out.println("Penghuni: " + kamar.getAssignedStudent().getNama());
            } else {
                System.out.println("Penghuni: Tidak ada");
            }
            System.out.println("-------------------------");
        }
    }
    public Mahasiswa findStudentByNIM(String NIM) {
            for (Mahasiswa mahasiswa : daftarMahasiswa) {
                if (mahasiswa.getNIM().equals(NIM)) {
                    return mahasiswa;
                }
            }
            return null; 
        }

    public Room findRoomByNumber(String noKamar) {
        for (Room room : daftarKamar) {
            if (room.getNoKamar().equals(noKamar)) {
                return room;
            }
        }
        return null; 

    }
    public void addSeniorResidents(SeniorResidents senior) {
            daftarSenior.add(senior);
            daftarMahasiswa.add(senior); 
            System.out.println("Senior Resident " + senior.getNama() + " berhasil ditambahkan.");
        }
    public SeniorResidents findSeniorByName(String nama) {
            for (SeniorResidents senior : daftarSenior) {
                if (senior.getNama().equalsIgnoreCase(nama)) {
                    return senior;
                }
            }
            return null; 
        }
    
    public void addStudent(Mahasiswa mahasiswa) {
            if (daftarMahasiswa.size() < kapasitas) { 
                daftarMahasiswa.add(mahasiswa);
                System.out.println(mahasiswa.getNama() + " telah ditambahkan ke " + dormName);
            } else {
                System.out.println("Kapasitas asrama sudah penuh. Tidak dapat menambahkan mahasiswa.");
            }
        }
    }
