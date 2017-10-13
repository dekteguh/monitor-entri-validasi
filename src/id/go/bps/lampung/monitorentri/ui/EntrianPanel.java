/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.lampung.monitorentri.ui;

import id.go.bps.lampung.monitorentri.db.Entrian;
import id.go.bps.lampung.monitorentri.db.Operator;
import id.go.bps.lampung.monitorentri.helper.Common;
import id.go.bps.lampung.monitorentri.service.EntrianService;
import id.go.bps.lampung.monitorentri.service.OperatorService;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ekoteguh
 */
public class EntrianPanel extends javax.swing.JPanel {

    /**
     * Creates new form LoginPanel
     */
    
    MainFrame mainFrame;
    String entrianID;
    
    public EntrianPanel(MainFrame frame) {
        this.mainFrame = frame;
        initComponents();
        this.customizeTable();
        this.loadData();
        //this.statusSerah();
        this.setTampilFormTerima(false);
        this.loadOperator();
    }
    
    private void resetForm(){
        this.kabkotaId.setSelectedIndex(0);
        this.noBatch.setText("");
        this.jmlDokSerah.setText("");
        this.operatorId.setSelectedIndex(0);
        this.jmlDokTerima.setText("");
        this.kabkotaId.requestFocus();
    }
    
    private void statusSerah(){
        this.kabkotaId.setEnabled(true);
        this.noBatch.setEnabled(true);
        this.jmlDokSerah.setEnabled(true);
        this.operatorId.setEnabled(true);
        this.btnSerahDok.setEnabled(true);
        this.jmlDokTerima.setEnabled(true);
        this.btnTerimaDok.setEnabled(true);
    }
    
    private void statusTerima(){
        this.kabkotaId.setEnabled(false);
        this.noBatch.setEnabled(false);
        this.jmlDokSerah.setEnabled(false);
        this.operatorId.setEnabled(false);
        this.btnSerahDok.setEnabled(false);
        this.jmlDokTerima.setEnabled(true);
        this.btnTerimaDok.setEnabled(true);
    }
    
    private void setTampilFormTerima(boolean b){
        this.jLabel6.setVisible(b);
        this.jmlDokTerima.setVisible(b);
        this.btnTerimaDok.setVisible(b);
        this.jmlDokTerima.requestFocus();
    }
    
    private void loadOperator(){
        try{
            operatorId.removeAllItems();
            operatorId.addItem("-Pilih Nama Operator-");
            List<Operator> arr = OperatorService.getOperatorsEntri("Mitra");
            for(Operator o : arr){
                operatorId.addItem(o.getOperatorId());
            }
        }catch(SQLException ex){
            Logger.getLogger(EntrianPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadData(){
        try {
            List<Entrian> arr = EntrianService.getEntrianByIsSerah(1);
            DefaultTableModel tableModel = (DefaultTableModel) this.tabelEntrian.getModel();
            while (tableModel.getRowCount() > 0){
                tableModel.removeRow(0);
            }
            
            int i = 0;
            for(Entrian e : arr){
                tableModel.addRow(new Object[]{
                    e.getEntrianId(),
                    e.getKabkotaId(),
                    e.getNomorBatch(),
                    e.getJumlahDokSerah(),
                    e.getOperatorEntri()
                });
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntrianPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadDataByOperator(String operator){
        try {
            List<Entrian> arr = OperatorService.searchOperatorsEntriByKeyword(operator);
            DefaultTableModel tableModel = (DefaultTableModel) this.tabelEntrian.getModel();
            while (tableModel.getRowCount() > 0){
                tableModel.removeRow(0);
            }
            
            int i = 0;
            for(Entrian e : arr){
                tableModel.addRow(new Object[]{
                    e.getEntrianId(),
                    e.getKabkotaId(),
                    e.getNomorBatch(),
                    e.getJumlahDokSerah(),
                    e.getOperatorEntri()
                });
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntrianPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void customizeTable() {
        //tabelEntrian.getTableHeader().setBackground(Color.WHITE);
        Font f = new Font(Font.SANS_SERIF, Font.BOLD, 14);
        tabelEntrian.getTableHeader().setFont(f);
        ((DefaultTableCellRenderer) tabelEntrian.getTableHeader().getDefaultRenderer()).setHorizontalAlignment((int) CENTER_ALIGNMENT);
        ((DefaultTableCellRenderer) tabelEntrian.getTableHeader().getDefaultRenderer()).setVerticalAlignment((int) CENTER_ALIGNMENT);
        
        tabelEntrian.setRowHeight(30);
        
        DefaultTableCellRenderer centerCellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                super.setHorizontalAlignment(SwingConstants.CENTER);
                return cell;
            }
        };

        DefaultTableCellRenderer leftCellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                super.setHorizontalAlignment(SwingConstants.LEFT);
                return cell;
            }
        };
        tabelEntrian.getColumnModel().getColumn(0).setCellRenderer(centerCellRenderer);
        tabelEntrian.getColumnModel().getColumn(1).setCellRenderer(centerCellRenderer);
        tabelEntrian.getColumnModel().getColumn(2).setCellRenderer(centerCellRenderer);
        tabelEntrian.getColumnModel().getColumn(3).setCellRenderer(centerCellRenderer);
        tabelEntrian.getColumnModel().getColumn(4).setCellRenderer(centerCellRenderer);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        kabkotaId = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        noBatch = new javax.swing.JTextField();
        jmlDokSerah = new javax.swing.JTextField();
        btnSerahDok = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jmlDokTerima = new javax.swing.JTextField();
        btnTerimaDok = new javax.swing.JButton();
        operatorId = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelEntrian = new javax.swing.JTable();
        btnLihatEntrian = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cariOperator = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 153, 0));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1024, 670));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Form Entri Dokumen");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel1.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setText("Kabupaten/Kota");

        kabkotaId.setBackground(new java.awt.Color(255, 255, 255));
        kabkotaId.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        kabkotaId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Kabupaten/Kota -", "[1801] Lampung Barat", "[1802] Tanggamus", "[1803] Lampung Selatan", "[1804] Lampung Timur", "[1805] Lampung Tengah", "[1806] Lampung Utara", "[1807] Way Kanan", "[1808] Tulang Bawang", "[1809] Pesawaran", "[1810] Pringsewu", "[1811] Mesuji", "[1812] Tulang Bawang Barat", "[1813] Pesisir Barat", "[1871] Bandar Lampung", "[1872] Metro" }));
        kabkotaId.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setText("Nomor Batch");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setText("Jumlah Dok. Diambil");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setText("Operator");

        noBatch.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        noBatch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        noBatch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        noBatch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                noBatchKeyPressed(evt);
            }
        });

        jmlDokSerah.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jmlDokSerah.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jmlDokSerah.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        jmlDokSerah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jmlDokSerahKeyPressed(evt);
            }
        });

        btnSerahDok.setBackground(new java.awt.Color(255, 153, 0));
        btnSerahDok.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnSerahDok.setForeground(new java.awt.Color(255, 255, 255));
        btnSerahDok.setText("Ambil Dokumen");
        btnSerahDok.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        btnSerahDok.setOpaque(true);
        btnSerahDok.setSize(new java.awt.Dimension(97, 35));
        btnSerahDok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSerahDokActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel6.setText("Jumlah Dok. Dikembalikan");

        jmlDokTerima.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jmlDokTerima.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jmlDokTerima.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        jmlDokTerima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jmlDokTerimaKeyPressed(evt);
            }
        });

        btnTerimaDok.setBackground(new java.awt.Color(0, 153, 102));
        btnTerimaDok.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnTerimaDok.setForeground(new java.awt.Color(255, 255, 255));
        btnTerimaDok.setText("Kembalikan Dokumen");
        btnTerimaDok.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 102), 1, true));
        btnTerimaDok.setOpaque(true);
        btnTerimaDok.setSize(new java.awt.Dimension(97, 35));
        btnTerimaDok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerimaDokActionPerformed(evt);
            }
        });

        operatorId.setBackground(new java.awt.Color(255, 255, 255));
        operatorId.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        operatorId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Nama Operator -" }));
        operatorId.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jmlDokSerah, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kabkotaId, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSerahDok, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jmlDokTerima, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTerimaDok, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(operatorId, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kabkotaId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jmlDokTerima, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(noBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jmlDokSerah, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnTerimaDok, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(operatorId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSerahDok, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tabelEntrian.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tabelEntrian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Kabupaten/Kota", "No. Batch", "Jumlah Dokumen Ambil", "Operator"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelEntrian.setSelectionBackground(new java.awt.Color(0, 153, 102));
        tabelEntrian.setSize(new java.awt.Dimension(450, 80));
        jScrollPane1.setViewportView(tabelEntrian);
        if (tabelEntrian.getColumnModel().getColumnCount() > 0) {
            tabelEntrian.getColumnModel().getColumn(0).setResizable(false);
            tabelEntrian.getColumnModel().getColumn(0).setPreferredWidth(150);
            tabelEntrian.getColumnModel().getColumn(1).setResizable(false);
            tabelEntrian.getColumnModel().getColumn(1).setPreferredWidth(20);
            tabelEntrian.getColumnModel().getColumn(2).setResizable(false);
            tabelEntrian.getColumnModel().getColumn(2).setPreferredWidth(20);
            tabelEntrian.getColumnModel().getColumn(3).setResizable(false);
            tabelEntrian.getColumnModel().getColumn(3).setPreferredWidth(30);
            tabelEntrian.getColumnModel().getColumn(4).setResizable(false);
            tabelEntrian.getColumnModel().getColumn(4).setPreferredWidth(20);
        }

        btnLihatEntrian.setBackground(new java.awt.Color(255, 0, 51));
        btnLihatEntrian.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnLihatEntrian.setForeground(new java.awt.Color(255, 255, 255));
        btnLihatEntrian.setText("Lihat Entrian");
        btnLihatEntrian.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 102), 1, true));
        btnLihatEntrian.setOpaque(true);
        btnLihatEntrian.setSize(new java.awt.Dimension(97, 35));
        btnLihatEntrian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLihatEntrianActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Cari Operator:");

        cariOperator.setBackground(new java.awt.Color(255, 51, 51));
        cariOperator.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        cariOperator.setForeground(new java.awt.Color(255, 255, 255));
        cariOperator.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cariOperator.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        cariOperator.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cariOperatorKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLihatEntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cariOperator, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLihatEntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariOperator, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSerahDokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSerahDokActionPerformed
        if(kabkotaId.getSelectedIndex()!=0 && !noBatch.getText().equals("") && !jmlDokSerah.getText().equals("") && operatorId.getSelectedIndex()==0){
            try {
               // TODO add your handling code here:
               Entrian entrian = new Entrian();
               entrian.setEntrianId(Common.generateUuid());
               entrian.setKabkotaId(kabkotaId.getSelectedItem().toString().split(" ")[0].substring(1, 5));
               entrian.setNomorBatch(Integer.parseInt(noBatch.getText()));
               entrian.setJumlahDokSerah(Integer.parseInt(jmlDokSerah.getText()));
               entrian.setOperatorEntri(operatorId.getSelectedItem().toString());
               entrian.setWaktuSerah(new Date());
               entrian.setIsSerah(1);
               entrian.setNamaSurveiSensus("SE2016 UMK UMB");

               long result = EntrianService.insertEntrian(entrian);
               if(result == 1){
                   JOptionPane.showMessageDialog(this, "Data berhasil disimpan!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                   this.loadData();
               }else{
                   JOptionPane.showMessageDialog(this, "Data gagal disimpan!", "Error", JOptionPane.ERROR_MESSAGE);
               }
               this.resetForm();
           } catch (SQLException ex) {
               Logger.getLogger(EntrianPanel.class.getName()).log(Level.SEVERE, null, ex);
           }   
        }else{
            JOptionPane.showMessageDialog(this, "Isian masih ada yang kosong!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSerahDokActionPerformed

    private void noBatchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noBatchKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar() == KeyEvent.VK_ENTER){
            if(this.noBatch.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Isian masih kosong", "Error", JOptionPane.ERROR_MESSAGE);
                this.noBatch.requestFocus();
            }else{
                this.jmlDokSerah.requestFocus();
            }
        }
    }//GEN-LAST:event_noBatchKeyPressed

    private void jmlDokSerahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jmlDokSerahKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar() == KeyEvent.VK_ENTER){
            if(Integer.parseInt(this.jmlDokSerah.getText()) > 20 || Integer.parseInt(this.jmlDokSerah.getText()) < 1){
                JOptionPane.showMessageDialog(this, "Isian antara 1-20 dokumen", "Error", JOptionPane.ERROR_MESSAGE);
                this.jmlDokSerah.requestFocus();
            }else{
                this.operatorId.requestFocus();
            }
        }
    }//GEN-LAST:event_jmlDokSerahKeyPressed

    private void jmlDokTerimaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jmlDokTerimaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar() == KeyEvent.VK_ENTER){
            if(Integer.parseInt(this.jmlDokTerima.getText()) > 20 || Integer.parseInt(this.jmlDokTerima.getText()) < 1){
                JOptionPane.showMessageDialog(this, "Isian antara 1-20 dokumen", "Error", JOptionPane.ERROR_MESSAGE);
                this.jmlDokTerima.requestFocus();
            }else{
                this.btnTerimaDok.requestFocus();
            }
        }
    }//GEN-LAST:event_jmlDokTerimaKeyPressed

    private void btnTerimaDokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerimaDokActionPerformed
        // TODO add your handling code here:
        try {
            long result = EntrianService.updateStatusTerimaEntrian(Integer.parseInt(this.jmlDokTerima.getText()), this.entrianID);
            if(result == 1){
                JOptionPane.showMessageDialog(this, "Data berhasil diupdate!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                this.loadData();
            }else{
                JOptionPane.showMessageDialog(this, "Data gagal diupdate!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            this.resetForm();
            this.statusSerah();
            this.setTampilFormTerima(false);
        } catch (SQLException ex) {
            Logger.getLogger(EntrianPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTerimaDokActionPerformed

    private void btnLihatEntrianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLihatEntrianActionPerformed
        // TODO add your handling code here:
        int row = tabelEntrian.getSelectedRow();
        String ID = tabelEntrian.getValueAt(row, 0).toString();
        this.entrianID = ID;
        try {
            Entrian e = EntrianService.getEntrian(ID);
            String kabkota = e.getKabkotaId().substring(2, 4);
            if(kabkota.equals("71")){
                this.kabkotaId.setSelectedIndex(14);
            }else if(kabkota.equals("72")){
                this.kabkotaId.setSelectedIndex(15);
            }else{
                this.kabkotaId.setSelectedIndex(Integer.parseInt(kabkota));
            }
            
            this.noBatch.setText(String.valueOf(e.getNomorBatch()));
            this.jmlDokSerah.setText(String.valueOf(e.getJumlahDokSerah()));
            this.operatorId.setSelectedItem(e.getOperatorEntri());
            this.jmlDokTerima.requestFocus();
            this.statusTerima();
            this.setTampilFormTerima(true);
        } catch (SQLException ex) {
            Logger.getLogger(EntrianPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLihatEntrianActionPerformed

    private void cariOperatorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariOperatorKeyTyped
        // TODO add your handling code here:
        char keyChar = evt.getKeyChar();
        if(Character.isLowerCase(keyChar)){
            evt.setKeyChar(Character.toUpperCase(keyChar));
        }
        
        if(this.cariOperator.getText().equals("")){
            this.loadData();
        }else{
            this.loadDataByOperator(this.cariOperator.getText().trim());
        }
    }//GEN-LAST:event_cariOperatorKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLihatEntrian;
    private javax.swing.JButton btnSerahDok;
    private javax.swing.JButton btnTerimaDok;
    private javax.swing.JTextField cariOperator;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jmlDokSerah;
    private javax.swing.JTextField jmlDokTerima;
    private javax.swing.JComboBox<String> kabkotaId;
    private javax.swing.JTextField noBatch;
    private javax.swing.JComboBox<String> operatorId;
    private javax.swing.JTable tabelEntrian;
    // End of variables declaration//GEN-END:variables
}
