/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.lampung.monitorentri.helper;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author ekoteguh
 */
public class DBHelper {
    
    private Connection connection;
    private static final String TAG = DBHelper.class.getSimpleName();

    public Connection getConnection() {
        if(connection == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://" + DBProperty.getHost() + ":" + DBProperty.getPort() + "/" + DBProperty.getNamaDB());
            dataSource.setUser(DBProperty.getUsername());
            dataSource.setPassword(DBProperty.getPassword());
            try {
                connection = dataSource.getConnection();
                System.out.println(TAG + ": " + "Koneksi berhasil!");
            }catch(SQLException ex){
                System.out.println(TAG + ": " + ex.getMessage());
            }
        }
        
        return connection;
    }
    
}
