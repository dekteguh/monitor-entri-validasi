/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.lampung.monitorentri.service;

import id.go.bps.lampung.monitorentri.db.Entrian;
import id.go.bps.lampung.monitorentri.db.Operator;
import id.go.bps.lampung.monitorentri.db.Validasi;
import id.go.bps.lampung.monitorentri.helper.DBHelper;
import id.go.bps.lampung.monitorentri.helper.QueryHelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ekoteguh
 */
public class OperatorService {
    
    private static final String TAG = OperatorService.class.getSimpleName();
    
    public static List<Operator> getOperatorsEntri(String statusOperator) throws SQLException{
        List<Operator> result = new ArrayList<>();
        DBHelper helper = new DBHelper();
        try{
            helper.getConnection().setAutoCommit(false);
            PreparedStatement ps;
            if(statusOperator.equals("")){
                ps = helper.getConnection().prepareStatement(QueryHelper.GET_OPERATORS);
            }else{
                ps = helper.getConnection().prepareStatement(QueryHelper.GET_OPERATOR_BY_STATUS);
                ps.setString(1, statusOperator);
            }
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Operator o = new Operator();
                o.setOperatorId(rs.getString("operator_id"));
                o.setNamaOperator(rs.getString("nama_operator"));
                result.add(o);
            }
            
            helper.getConnection().commit();
            System.out.println(TAG + ": User berhasil get banyak Operator by statusOperator");
        }catch(SQLException ex){
            System.out.println(TAG + ": " + ex.getMessage());
        }finally{
            try{
                helper.getConnection().setAutoCommit(true);
                if(helper.getConnection() != null){
                    helper.getConnection().close();
                }
            }catch(SQLException ex){
                System.out.println(TAG + ": " + ex.getMessage());
            }
        }
        return result;
    }
    
    public static List<Entrian> searchOperatorsEntriByKeyword(String keywordOperator) throws SQLException{
        List<Entrian> result = new ArrayList<>();
        DBHelper helper = new DBHelper();
        try{
            helper.getConnection().setAutoCommit(false);
            PreparedStatement ps = helper.getConnection().prepareStatement(QueryHelper.SEARCH_ENTRIAN_BY_OPERATOR);
            ps.setString(1, keywordOperator);
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
            
            helper.getConnection().commit();
            System.out.println(TAG + ": User berhasil search by Operator");
        }catch(SQLException ex){
            System.out.println(TAG + ": " + ex.getMessage());
        }finally{
            try{
                helper.getConnection().setAutoCommit(true);
                if(helper.getConnection() != null){
                    helper.getConnection().close();
                }
            }catch(SQLException ex){
                System.out.println(TAG + ": " + ex.getMessage());
            }
        }
        return result;
    }
    
    public static List<Validasi> searchOperatorsValidasiByKeyword(String keywordOperator) throws SQLException{
        List<Validasi> result = new ArrayList<>();
        DBHelper helper = new DBHelper();
        try{
            helper.getConnection().setAutoCommit(false);
            PreparedStatement ps = helper.getConnection().prepareStatement(QueryHelper.SEARCH_VALIDASI_BY_OPERATOR);
            ps.setString(1, keywordOperator);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Validasi entrian = new Validasi();
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
            
            helper.getConnection().commit();
            System.out.println(TAG + ": User berhasil search by Operator");
        }catch(SQLException ex){
            System.out.println(TAG + ": " + ex.getMessage());
        }finally{
            try{
                helper.getConnection().setAutoCommit(true);
                if(helper.getConnection() != null){
                    helper.getConnection().close();
                }
            }catch(SQLException ex){
                System.out.println(TAG + ": " + ex.getMessage());
            }
        }
        return result;
    }
}
