/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.lampung.monitorentri.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author ekoteguh
 */
public class DBProperty {
    
    private static String host;
    private static String port;
    private static String namaDB;
    private static String username;
    private static String password;
    
    static {
        File file = new File("DBProperty.txt");
        FileReader reader = null;
        BufferedReader bufferedReader = null;
        try {
            reader = new FileReader(file);
            bufferedReader = new BufferedReader(reader);
            host = bufferedReader.readLine();
            port = bufferedReader.readLine();
            namaDB = bufferedReader.readLine();
            username = bufferedReader.readLine();
            password = bufferedReader.readLine();
        }catch(IOException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Property tidak ditemukan!", "Pesan Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
        try {
            bufferedReader.close();
            reader.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        DBProperty.host = host;
    }

    public static String getPort() {
        return port;
    }

    public static void setPort(String port) {
        DBProperty.port = port;
    }

    public static String getNamaDB() {
        return namaDB;
    }

    public static void setNamaDB(String namaDB) {
        DBProperty.namaDB = namaDB;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        DBProperty.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DBProperty.password = password;
    }
}
