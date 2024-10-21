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
public class Room {
    private String noKamar;
    private int lantaiKamar;
    private boolean isOccupied;
    private Mahasiswa assignedStudent;     
    public Room(String noKamar, int lantaiKamar, boolean isOccupied){
        this.noKamar = noKamar;
        this.lantaiKamar = lantaiKamar;
        this.isOccupied = false;
        this.assignedStudent = null;   
    }
    public boolean checkAvailability(){
        return !isOccupied;
    }
    public void assignStudent(Mahasiswa mahasiswa){
        if (checkAvailability()) { 
            isOccupied = true; 
            System.out.println(mahasiswa.getNama() + " telah didaftarkan ke kamar " + noKamar);
            assignedStudent = mahasiswa;
        } else {
            System.out.println("Kamar " + noKamar + " sudah terisi.");
    }
    }

    public String getNoKamar() {
        return noKamar;
    }

    public void setNoKamar(String noKamar) {
        this.noKamar = noKamar;
    }

    public int getLantaiKamar() {
        return lantaiKamar;
    }

    public void setLantaiKamar(int lantaiKamar) {
        this.lantaiKamar = lantaiKamar;
    }

    public boolean isIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public Mahasiswa getAssignedStudent() {
        return assignedStudent;
    }

    public void setAssignedStudents(Mahasiswa assignedStudent) {
        this.assignedStudent = assignedStudent;
    }
    
public void vacateRoom() {
    if (assignedStudent != null) {
        System.out.println(this.assignedStudent.getNama() + " telah mengosongkan kamar " + noKamar);
        assignedStudent = null;
        isOccupied = false; 
        System.out.println("Kamar " + noKamar + " sekarang kosong.");
    } else {
        System.out.println("Kamar " + noKamar + " sudah kosong.");
    }
}
}
