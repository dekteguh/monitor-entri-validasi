/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.lampung.monitorentri.db;

import java.util.Date;

/**
 *
 * @author ekoteguh
 */
public class Entrian {
    
    private String entrianId;
    private String kabkotaId;
    private String nomorBatch;
    private String jumlahDokSerah;
    private String jumlahDokTerima;
    private String operatorEntri;
    private Date waktuEntri;
    private int isSerah;
    private int isTerima;

    public Entrian() {
    }
    
    public String getEntrianId() {
        return entrianId;
    }

    public void setEntrianId(String entrianId) {
        this.entrianId = entrianId;
    }

    public String getKabkotaId() {
        return kabkotaId;
    }

    public void setKabkotaId(String kabkotaId) {
        this.kabkotaId = kabkotaId;
    }

    public String getNomorBatch() {
        return nomorBatch;
    }

    public void setNomorBatch(String nomorBatch) {
        this.nomorBatch = nomorBatch;
    }

    public String getJumlahDokSerah() {
        return jumlahDokSerah;
    }

    public void setJumlahDokSerah(String jumlahDokSerah) {
        this.jumlahDokSerah = jumlahDokSerah;
    }

    public String getJumlahDokTerima() {
        return jumlahDokTerima;
    }

    public void setJumlahDokTerima(String jumlahDokTerima) {
        this.jumlahDokTerima = jumlahDokTerima;
    }

    public String getOperatorEntri() {
        return operatorEntri;
    }

    public void setOperatorEntri(String operatorEntri) {
        this.operatorEntri = operatorEntri;
    }

    public Date getWaktuEntri() {
        return waktuEntri;
    }

    public void setWaktuEntri(Date waktuEntri) {
        this.waktuEntri = waktuEntri;
    }

    public int getIsSerah() {
        return isSerah;
    }

    public void setIsSerah(int isSerah) {
        this.isSerah = isSerah;
    }

    public int getIsTerima() {
        return isTerima;
    }

    public void setIsTerima(int isTerima) {
        this.isTerima = isTerima;
    }
    
    
}
