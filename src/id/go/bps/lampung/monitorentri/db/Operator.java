/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.lampung.monitorentri.db;

/**
 *
 * @author ekoteguh
 */
public class Operator {
    private String operatorId;
    private String namaOperator;
    private String statusOperator;

    public Operator() {
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getNamaOperator() {
        return namaOperator;
    }

    public void setNamaOperator(String namaOperator) {
        this.namaOperator = namaOperator;
    }

    public String getStatusOperator() {
        return statusOperator;
    }

    public void setStatusOperator(String statusOperator) {
        this.statusOperator = statusOperator;
    }
    
    
}
