/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubeskecil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joshu
 */
public class SeniorResidents extends Mahasiswa {
    private String mentorshipGroup;
    private List<LocalDate> jadwalMentoring;
    public SeniorResidents(String nama, int umur, String jenisKelamin, String NIM, String dormName, String noKamar, String mentorshipGroup){
        super(nama, umur, jenisKelamin,NIM);
        this.mentorshipGroup = mentorshipGroup;
        this.jadwalMentoring = new ArrayList<>(); 
    }
    public void addSchedule(LocalDate jadwal){
        jadwalMentoring.add(jadwal);
        System.out.println("Jadwal mentoring pada " + jadwal + " telah ditambahkan.");
    }
    public void displaySchedule(){
        if (jadwalMentoring.isEmpty()) {
            System.out.println("Tidak ada jadwal mentoring yang tersedia.");
        } else {
            System.out.println("Jadwal Mentoring untuk " + mentorshipGroup + ":");
            for (LocalDate date : jadwalMentoring) {
                System.out.println("- " + date);
            }
        }
    }

    public String getMentorshipGroup() {
        return mentorshipGroup;
    }

    public void setMentorshipGroup(String mentorshipGroup) {
        this.mentorshipGroup = mentorshipGroup;
    }

    public List<LocalDate> getJadwalMentoring() {
        return jadwalMentoring;
    }

    public void setJadwalMentoring(List<LocalDate> jadwalMentoring) {
        this.jadwalMentoring = jadwalMentoring;
    }
    
    @Override
    public void getDetails(){
        super.getDetails();
        System.out.println("Mentorship Group : " + mentorshipGroup);
    } 
}
