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
    private int nomorBatch;
    private int jumlahDokSerah;
    private int jumlahDokTerima;
    private String operatorEntri;
    private Date waktuSerah;
    private Date waktuTerima;
    private int isSerah;
    private int isTerima;
    private String namaSurveiSensus;
    private Date waktuSimpan;
    
    public Entrian() {
    }

    public String getNamaSurveiSensus() {
        return namaSurveiSensus;
    }

    public void setNamaSurveiSensus(String namaSurveiSensus) {
        this.namaSurveiSensus = namaSurveiSensus;
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

    public int getNomorBatch() {
        return nomorBatch;
    }

    public void setNomorBatch(int nomorBatch) {
        this.nomorBatch = nomorBatch;
    }

    public int getJumlahDokSerah() {
        return jumlahDokSerah;
    }

    public void setJumlahDokSerah(int jumlahDokSerah) {
        this.jumlahDokSerah = jumlahDokSerah;
    }

    public int getJumlahDokTerima() {
        return jumlahDokTerima;
    }

    public void setJumlahDokTerima(int jumlahDokTerima) {
        this.jumlahDokTerima = jumlahDokTerima;
    }

    public String getOperatorEntri() {
        return operatorEntri;
    }

    public void setOperatorEntri(String operatorEntri) {
        this.operatorEntri = operatorEntri;
    }

    public Date getWaktuSerah() {
        return waktuSerah;
    }

    public void setWaktuSerah(Date waktuSerah) {
        this.waktuSerah = waktuSerah;
    }

    public Date getWaktuTerima() {
        return waktuTerima;
    }

    public void setWaktuTerima(Date waktuTerima) {
        this.waktuTerima = waktuTerima;
    }

    public Date getWaktuSimpan() {
        return waktuSimpan;
    }

    public void setWaktuSimpan(Date waktuSimpan) {
        this.waktuSimpan = waktuSimpan;
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
