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
    
    public static final String INSERT_ENTRIAN = "INSERT INTO entrian(id,kabkota_id,no_batch,jml_dok_serah,waktu_serah,is_serah,operator_id,survei_sensus_id) VALUES(?,?,?,?,?,?,?,?);";
    
    public static final String UPDATE_STATUS_TERIMA = "UPDATE entrian SET jml_dok_terima=?,waktu_terima=?,is_terima=?,is_serah=?,waktu_simpan=? WHERE id=?";
 
    public static final String DELETE_ENTRIAN = "DELETE FROM entrian WHERE id=?";
    
    public static final String GET_ENTRIAN = "SELECT * FROM entrian WHERE id=?";
    
    public static final String GET_ENTRIAN_BY_IS_SERAH = "SELECT * FROM entrian WHERE is_serah=?";
    
    public static final String INSERT_VALIDASI = "INSERT INTO validasi(id,kabkota_id,no_batch,jml_dok_serah,waktu_serah,is_serah,operator_id,survei_sensus_id) VALUES(?,?,?,?,?,?,?,?);";
    
    public static final String UPDATE_STATUS_TERIMA_VALIDASI = "UPDATE validasi SET jml_dok_terima=?,waktu_terima=?,is_terima=?,is_serah=?,waktu_simpan=? WHERE id=?";
 
    public static final String DELETE_VALIDASI = "DELETE FROM validasi WHERE id=?";
    
    public static final String GET_VALIDASI = "SELECT * FROM validasi WHERE id=?";
    
    public static final String GET_VALIDASI_BY_IS_SERAH = "SELECT v.* FROM validasi v, operator o WHERE v.operator_id=o.id AND v.is_serah=? AND o.status=?";
    
    public static final String GET_OPERATOR_BY_STATUS = "SELECT o.id as operator_id, o.nama as nama_operator FROM operator o WHERE o.status=?";
    public static final String GET_OPERATORS = "SELECT * FROM operator";

    public static final String SEARCH_ENTRIAN_BY_OPERATOR = "SELECT * FROM entrian WHERE operator_id LIKE ? AND is_serah=1";
    public static final String SEARCH_VALIDASI_BY_OPERATOR = "SELECT * FROM validasi WHERE operator_id LIKE ? AND is_serah=1";

    public static final String CEK_SUDAH_ENTRI = "SELECT COUNT(*) as rowCount FROM entrian WHERE kabkota_id=? AND no_batch=?";
    public static final String CEK_SUDAH_VALIDASI = "SELECT COUNT(*) as rowCount FROM validasi WHERE kabkota_id=? AND no_batch=?";
}
