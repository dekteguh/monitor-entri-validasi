/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.lampung.monitorentri.helper;

/**
 *
 * @author ekoteguh
 */
public class QueryHelper {
    
    public static final String INSERT_ENTRIAN = "INSERT INTO entrian(id,kabkota_id,no_batch,jml_dok_serah,waktu_serah,is_serah,jml_dok_terima,waktu_terima,is_terima,waktu_simpan,operator_id,survei_sensus_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
    
    public static final String UPDATE_STATUS_TERIMA = "UPDATE entrian SET jml_dok_terima=?,waktu_terima=?,is_terima=?,waktu_simpan=? WHERE id=?";
 
    public static final String DELETE_ENTRIAN = "DELETE FROM entrian WHERE id=?";
    
    public static final String GET_ENTRIAN = "SELECT * FROM entrian WHERE id=?";
    
    public static final String GET_ENTRIAN_BY_IS_SERAH = "SELECT * FROM entrian WHERE is_serah=1";
}
