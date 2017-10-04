/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.lampung.monitorentri.helper;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author ekoteguh
 */
public class Common {
    
    private static final String TAG = Common.class.getSimpleName();
    
    public static String getHost(String id) {
        String hostname = "";
        try {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            if (id.equals("ip")) {
                hostname = addr.getHostAddress();
            }
            if (id.equals("pc")) {
                hostname = addr.getHostName();
            }

        } catch (UnknownHostException ex) {
            System.out.println(TAG + ": " + ex.getMessage());
        }
        return hostname;
    }
    
    public static String showTime() {
        String time;
        Calendar calendar = new GregorianCalendar();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        int ampm = calendar.get(Calendar.AM_PM);
        
        String daynight = ampm == 1 ? "PM" : "AM";
        time = hour + ":" + minute + ":" + second + " " + daynight;
        return time;
    }
    
    public static String setPassword(String password) {
        String result = null;
        String algorithm = "MD5";
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(password.getBytes());
            byte[] digest = md.digest();
            result = DatatypeConverter.printHexBinary(digest).toLowerCase();
        }catch(NoSuchAlgorithmException ex) {
            System.out.println(TAG + ": " + ex.getMessage());
        }
        return result;
    }
    
    public static String generateUuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
    
    public static String convertDateToString(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
        String date = sdf.format(d);
        return date;
    }
    
    public static Date convertDateFromString(String d) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
        Date date = sdf.parse(d);
        return date;
    }
}
