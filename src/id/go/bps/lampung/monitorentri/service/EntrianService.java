/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.lampung.monitorentri.service;

import id.go.bps.lampung.monitorentri.db.Entrian;
import id.go.bps.lampung.monitorentri.helper.DBHelper;
import id.go.bps.lampung.monitorentri.helper.QueryHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ekoteguh
 */
public class EntrianService {
    
    private static final String TAG = EntrianService.class.getSimpleName();
    
    public static long insertEntrian(Entrian entrian) throws SQLException{
        long result = 0;
        Connection connection = new DBHelper().getConnection();
        try{
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(QueryHelper.INSERT_ENTRIAN);
            ps.setString(1, entrian.getEntrianId());
            ps.setString(2, entrian.getKabkotaId());
            ps.setInt(3, entrian.getNomorBatch());
            ps.setInt(4, entrian.getJumlahDokSerah());
            ps.setDate(5, entrian.getWaktuSerah());
            ps.setInt(6, entrian.getIsSerah());
            ps.setInt(7, entrian.getJumlahDokTerima());
            ps.setDate(8, entrian.getWaktuTerima());
            ps.setInt(9, entrian.getIsTerima());
            ps.setDate(10, entrian.getWaktuSimpan());
            ps.setString(11, entrian.getOperatorEntri());
            ps.setString(12, entrian.getNamaSurveiSensus());
            result = ps.executeUpdate();
            connection.commit();
            System.out.println(TAG + ": User berhasil insert Entrian");
        }catch(SQLException ex){
            System.out.println(TAG + ": " + ex.getMessage());
        }finally{
            try{
                connection.setAutoCommit(true);
                connection.close();
            }catch(SQLException ex){
                System.out.println(TAG + ": " + ex.getMessage());
            }
        }
        return result;
    }
    
    public static long updateStatusTerimaEntrian(int jmlDokTerima, String id) throws SQLException{
        long result = 0;
        Connection connection = new DBHelper().getConnection();
        try{
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(QueryHelper.UPDATE_STATUS_TERIMA);
            ps.setInt(1, jmlDokTerima);
            ps.setDate(2, new Date(result));
            ps.setInt(3, 1);
            ps.setDate(4, new Date(result));
            ps.setString(5, id);
            result = ps.executeUpdate();
            connection.commit();
            System.out.println(TAG + ": User berhasil update status terima Entrian");
        }catch(SQLException ex){
            System.out.println(TAG + ": " + ex.getMessage());
        }finally{
            try{
                connection.setAutoCommit(true);
                connection.close();
            }catch(SQLException ex){
                System.out.println(TAG + ": " + ex.getMessage());
            }
        }
        return result;
    }
    
    public static long destroyEntrian(String id) throws SQLException{
        long result = 0;
        Connection connection = new DBHelper().getConnection();
        try{
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(TAG);
            ps.setString(1, id);
            result = ps.executeUpdate();
            connection.commit();
            System.out.println(TAG + ": User berhasil hapus Entrian");
        }catch(SQLException ex){
            System.out.println(TAG + ": " + ex.getMessage());
        }finally{
            try{
                connection.setAutoCommit(true);
                connection.close();
            }catch(SQLException ex){
                System.out.println(TAG + ": " + ex.getMessage());
            }
        }
        return result;
    }
    
    public static Entrian getEntrian(String id) throws SQLException{
        Entrian result = null;
        Connection connection = new DBHelper().getConnection();
        try{
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(QueryHelper.GET_ENTRIAN);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                result = new Entrian();
                result.setEntrianId(rs.getString("id"));
                result.setKabkotaId(rs.getString("kabkota_id"));
                result.setNomorBatch(rs.getInt("no_batch"));
                result.setJumlahDokSerah(rs.getInt("jml_dok_serah"));
                result.setWaktuSerah(rs.getDate("waktu_serah"));
                result.setIsSerah(rs.getInt("is_serah"));
                result.setJumlahDokTerima(rs.getInt("jml_dok_terima"));
                result.setWaktuTerima(rs.getDate("waktu_terima"));
                result.setIsTerima(rs.getInt("is_terima"));
                result.setWaktuSimpan(rs.getDate("waktu_simpan"));
                result.setOperatorEntri(rs.getString("operator_id"));
                result.setNamaSurveiSensus(rs.getString("survei_sensus_id"));
            }
            connection.commit();
            System.out.println(TAG + ": User berhasil get satu Entrian");
        }catch(SQLException ex){
            System.out.println(TAG + ": " + ex.getMessage());
        }finally{
            try{
                connection.setAutoCommit(true);
                connection.close();
            }catch(SQLException ex){
                System.out.println(TAG + ": " + ex.getMessage());
            }
        }
        return result;
    }
    
    public static List<Entrian> getEntrianByIsSerah(int isSerah) throws SQLException{
        List<Entrian> result = new ArrayList<>();
        Connection connection = new DBHelper().getConnection();
        try{
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(QueryHelper.GET_ENTRIAN_BY_IS_SERAH);
            ps.setInt(1, isSerah);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Entrian entrian = new Entrian();
                entrian.setEntrianId(rs.getString("id"));
                entrian.setKabkotaId(rs.getString("kabkota_id"));
                entrian.setNomorBatch(rs.getInt("no_batch"));
                entrian.setJumlahDokSerah(rs.getInt("jml_dok_serah"));
                entrian.setWaktuSerah(rs.getDate("waktu_serah"));
                entrian.setIsSerah(rs.getInt("is_serah"));
                entrian.setJumlahDokTerima(rs.getInt("jml_dok_terima"));
                entrian.setWaktuTerima(rs.getDate("waktu_terima"));
                entrian.setIsTerima(rs.getInt("is_terima"));
                entrian.setWaktuSimpan(rs.getDate("waktu_simpan"));
                entrian.setOperatorEntri(rs.getString("operator_id"));
                entrian.setNamaSurveiSensus(rs.getString("survei_sensus_id"));
                result.add(entrian);
            }
            
            connection.commit();
            System.out.println(TAG + ": User berhasil get banyak Entrian");
        }catch(SQLException ex){
            System.out.println(TAG + ": " + ex.getMessage());
        }finally{
            try{
                connection.setAutoCommit(true);
                connection.close();
            }catch(SQLException ex){
                System.out.println(TAG + ": " + ex.getMessage());
            }
        }
        return result;
    }
}
