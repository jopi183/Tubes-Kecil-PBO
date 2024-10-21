/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tubeskecil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author joshu
 */
public class TubesKecil {

    public static void main(String[] args) {
        List<Mahasiswa> daftarMahasiswa = new ArrayList<>();
        List<Asrama> daftarAsrama = new ArrayList<>();
        int maintenanceId = 1;
        List<Room> daftarKamar = new ArrayList<>();
        List<Maintenance> daftarMaintenance = new ArrayList<>();
        Asrama asrama = new Asrama("A101","Sekatung",270);
        daftarAsrama.add(asrama); 
        
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("=== Menu Utama Asrama ===");
            System.out.println("1. Tambah Kamar");
            System.out.println("2. Lihat Kamar Tersedia");
            System.out.println("3. Tambah Mahasiswa");
            System.out.println("4. Pendaftaran Mahasiswa ke Kamar");
            System.out.println("5. Mahasiswa Keluar dari Kamar");
            System.out.println("6. Tampilkan Data Mahasiswa di Asrama");
            System.out.println("7. Tambah Jadwal Mentoring untuk Kakak Asrama");
            System.out.println("8. Tampilkan Jadwal Mentoring");
            System.out.println("9. Jadwal dan Lakukan Maintenance Asrama");
            System.out.println("10. Keluar");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

        switch (choice) {
            case 1:
                System.out.print("Masukkan nomor kamar: ");
                String noKamar = scanner.nextLine();
                System.out.print("Masukkan lantai kamar: ");
                int lantaiKamar = scanner.nextInt();
                scanner.nextLine(); 
                Room newRoom = new Room(noKamar, lantaiKamar, false);
                asrama.addRoom(newRoom);
                break;
            case 2:
                asrama.getAvailableRooms();
                break;
            case 3:
                System.out.print("Masukkan nama mahasiswa: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan umur mahasiswa: ");
                int umur = scanner.nextInt();
                scanner.nextLine(); 
                System.out.print("Masukkan jenis kelamin mahasiswa: ");
                String jenisKelamin = scanner.nextLine();
                System.out.print("Masukkan NIM mahasiswa: ");
                String NIM = scanner.nextLine();
                Mahasiswa mahasiswaBaru = new Mahasiswa(nama, umur, jenisKelamin, NIM);
                asrama.addStudent(mahasiswaBaru);
                System.out.println("Apakah mahasiswa adalah Senior Residents?");
                String SR = scanner.nextLine();
                if (SR.equals("Ya")){
                    System.out.println("Masukkan nama group mentoring: ");
                    String groupMentoring = scanner.nextLine();
                    SeniorResidents newSR = new SeniorResidents(mahasiswaBaru.getNama(),mahasiswaBaru.getUmur(), mahasiswaBaru.getJenisKelamin(), mahasiswaBaru.getNIM(),asrama.getDormName(),groupMentoring);
                    asrama.addSeniorResidents(newSR);
                }
                break;
            case 4:
                System.out.print("Masukkan NIM mahasiswa: ");
                String nimDaftar = scanner.nextLine();
                Mahasiswa mahasiswaDaftar = asrama.findStudentByNIM(nimDaftar);
                System.out.print("Masukkan nomor kamar yang ingin didaftarkan: ");
                String nomorKamarDaftar = scanner.nextLine();
                Room roomDaftar = asrama.findRoomByNumber(nomorKamarDaftar);
                if (mahasiswaDaftar != null && roomDaftar != null) {
                    mahasiswaDaftar.registerRoom(roomDaftar);
                }else{
                    System.out.println("Mahasiswa atau kamar tidak ditemukan.");
                }
                
                break;
            case 5:
                System.out.print("Masukkan NIM mahasiswa: ");
                String nimKeluar = scanner.nextLine();
                Mahasiswa mahasiswaKeluar = asrama.findStudentByNIM(nimKeluar);
                System.out.print("Masukkan nomor kamar yang ingin dikeluarkan: ");
                String nomorKamarKeluar = scanner.nextLine();
                Room roomKeluar = asrama.findRoomByNumber(nomorKamarKeluar);
                if (mahasiswaKeluar != null && roomKeluar != null) {
                    mahasiswaKeluar.checkOut(roomKeluar);
                } else {
                    System.out.println("Mahasiswa atau kamar tidak ditemukan.");
                }
                break;
            case 6:
                asrama.tampilKamarMahasiswa();
            case 7:
                System.out.print("Masukkan nama kakak asrama: ");
                String namaSenior = scanner.nextLine();
                SeniorResidents senior = asrama.findSeniorByName(namaSenior);
                System.out.print("Masukkan tanggal jadwal mentoring (yyyy-mm-dd): ");
                LocalDate jadwalMentoring = LocalDate.parse(scanner.nextLine());
                if (senior != null) {
                    senior.addSchedule(jadwalMentoring);
                } else {
                    System.out.println("Kakak asrama tidak ditemukan.");
                }
                break;
            case 8:
                System.out.print("Masukkan nama kakak asrama: ");
                String namaSeniorTampil = scanner.nextLine();
                SeniorResidents seniorTampil = asrama.findSeniorByName(namaSeniorTampil);
                if (seniorTampil != null) {
                    seniorTampil.displaySchedule();
                } else {
                    System.out.println("Kakak asrama tidak ditemukan.");
                }
                break;
            case 9:
                System.out.print("Masukkan jenis maintenance :");
                String jenisMaintenance = scanner.nextLine();
                System.out.print("Masukkan tanggal jadwal maintenance (yyyy-mm-dd): ");
                LocalDate jadwalMaintenance = LocalDate.parse(scanner.nextLine());
                Maintenance maintenance = new Maintenance(String.valueOf(maintenanceId),jenisMaintenance,jadwalMaintenance,asrama);
                maintenance.scheduleMaintenance(jadwalMaintenance);
                maintenance.performMaintenance();
                maintenanceId++;
                break;
            case 10:
                System.out.println("Keluar dari aplikasi.");
                break;
            default:
                System.out.println("Pilihan tidak valid. Coba lagi.");
        }
    } while (choice != 9);

    scanner.close();
    }
}
