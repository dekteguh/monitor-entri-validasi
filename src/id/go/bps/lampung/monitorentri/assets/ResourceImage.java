/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.lampung.monitorentri.assets;

import java.net.URL;

/**
 *
 * @author ekoteguh
 */
public class ResourceImage {
    private static Class kelas;
    private static ResourceImage loader = new ResourceImage();
    
    private ResourceImage() {
        kelas = this.getClass();
    }
    
    public static URL getResource(String nama) {
        return kelas.getResource(nama);
    }
}
