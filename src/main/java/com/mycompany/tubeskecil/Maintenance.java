/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubeskecil;

import java.time.LocalDate;

/**
 *
 * @author joshu
 */
public class Maintenance {
    private String maintenanceId;
    private String maintenanceType;
    private LocalDate jadwalMaintenance;
    private Asrama asramaMaintenance;

    public Maintenance(String maintenanceId, String maintenanceType, LocalDate jadwalMaintenance, Asrama asramaMaintenance) {
        this.maintenanceId = maintenanceId;
        this.maintenanceType = maintenanceType;
        this.jadwalMaintenance = jadwalMaintenance;
        this.asramaMaintenance = asramaMaintenance;
    }

    public String getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(String maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public String getMaintenanceType() {
        return maintenanceType;
    }

    public void setMaintenanceType(String maintenanceType) {
        this.maintenanceType = maintenanceType;
    }

    public LocalDate getJadwalMaintenance() {
        return jadwalMaintenance;
    }

    public void setJadwalMaintenance(LocalDate jadwalMaintenance) {
        this.jadwalMaintenance = jadwalMaintenance;
    }

    public Asrama getAsramaMaintenance() {
        return asramaMaintenance;
    }

    public void setAsramaMaintenance(Asrama asramaMaintenance) {
        this.asramaMaintenance = asramaMaintenance;
    }
    
    public void performMaintenance() {
        System.out.println("Melakukan perawatan jenis " + maintenanceType + " di asrama " + asramaMaintenance.getDormName());
    }
    
    public void scheduleMaintenance(LocalDate newSchedule) {
        this.jadwalMaintenance = newSchedule;
        System.out.println("Perawatan jenis " + maintenanceType + " telah dijadwalkan ulang pada " + newSchedule + " di asrama " + asramaMaintenance.getDormName());
    }    
    
    
    
    
    
}
