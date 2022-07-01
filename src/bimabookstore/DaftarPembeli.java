/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bimabookstore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Bima
 */
public class DaftarPembeli extends javax.swing.JFrame {

    /**
     * Creates new form FormNilaiMhs
     */
    DefaultTableModel tabel1;
    Object[] list_mhs = new Object[8];
    int x = 0; // counter
    Koneksi dbConn = new Koneksi();
    Connection con = dbConn.getConnection();
    
    public DaftarPembeli() throws SQLException {
        initComponents();
        
        tabel1 = new DefaultTableModel();
        tabel.setModel(tabel1); // tabel nama table GUI
        // siapkan array yg akan dimasukkan ke table
        tabel1.addColumn("No");
        tabel1.addColumn("Nama");
        tabel1.addColumn("Email");
        tabel1.addColumn("No HP");
        tabel1.addColumn("Alamat");
        tabel1.addColumn("Judul");
        tabel1.addColumn("Total");
        tabel1.addColumn("Jumlah Harga");
        
        setResizable(false); // tdk dpt diperbesar
        // tdk bisa diklik
        update.setEnabled(false);
        hapus.setEnabled(false);
        tambahLain.setEnabled(false);
        tampilkanDiTabel();
        listBuku();
    }
    
    public void listBuku(){
        ResultSet rs;
        PreparedStatement stmt;
        String query = "SELECT judul_buku FROM buku";
        try {
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String abc = rs.getString(1);
                pJudul.addItem(abc);
            }
        } catch (Exception e) {
        }
    }

    public ArrayList[] getPembeliList() throws SQLException{
        // mendapatkan data dari tb dan disimpan di arraylist
        String queryCount = "SELECT COUNT(*) AS c FROM pembeli";
        Statement st;
        ResultSet rsCount, rs;
        st = con.createStatement();
        rsCount = st.executeQuery(queryCount);
        int sizeTable = 0;
        while (rsCount.next()) {
            sizeTable = rsCount.getInt("c");
            // panggil alias c dari querycount
        }
        ArrayList[] mhsList = new ArrayList[sizeTable];
        // membuat arraylist dengan size sebanyak data di db
        String query = "SELECT * FROM pembeli";
        rs = st.executeQuery(query);
        int x = 0;
        while (rs.next()) {
            mhsList[x] = new ArrayList<>();
            mhsList[x].add(rs.getString("nama"));
            mhsList[x].add(rs.getString("email"));
            mhsList[x].add(rs.getString("no_hp"));
            mhsList[x].add(rs.getString("alamat"));
            mhsList[x].add(rs.getString("judul_buku"));
            mhsList[x].add(rs.getString("total_buku"));
            mhsList[x].add(rs.getString("total_harga"));
            x++;
        }
        return mhsList;
    }
    
    public void tampilkanDiTabel() throws SQLException{
        ArrayList[] list = getPembeliList();
        // sebelum lanjut, buat fungsi getMhsList dulu
        DefaultTableModel model = (DefaultTableModel)tabel.getModel();
        
        Object[] row = new Object[8];
        for(int i=0; i<list.length; i++){
            row[0] = i+1;
            row[1] = list[i].get(0);
            row[2] = list[i].get(1);
            row[3] = list[i].get(2);
            row[4] = list[i].get(3);
            row[5] = list[i].get(4);
            row[6] = list[i].get(5);
            row[7] = list[i].get(6);
            
            model.addRow(row);
        }
    }
    
    public void kosongkanTextField(){
        pNama.setText(""); pNoHP.setText("");
        pEmail.setText(""); pAlamat.setText("");
    }
    
    public void kosongkanTabel(){
        DefaultTableModel model = (DefaultTableModel)this.tabel.getModel();
        model.setRowCount(0);
    }
    
    public void terpilih(int index) throws SQLException{
        ArrayList[] list = getPembeliList();
        pNama.setText((String) list[index].get(0));
        pEmail.setText((String) list[index].get(1));
        pNoHP.setText((String) list[index].get(2));
        pAlamat.setText((String) list[index].get(3));
        pJudul.setSelectedItem((String) list[index].get(4));
        pTotal.setSelectedItem((String) list[index].get(5));
        simpan.setEnabled(false);
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        pNama = new javax.swing.JTextField();
        pNoHP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pAlamat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        simpan = new javax.swing.JButton();
        tambahLain = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        cetak = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pJudul = new javax.swing.JComboBox<>();
        pTotal = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Daftar Pembeli");

        jPanel1.setBackground(new java.awt.Color(204, 223, 239));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Daftar Pembeli");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nama");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("No HP");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Email");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Alamat");

        simpan.setBackground(new java.awt.Color(92, 184, 92));
        simpan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        simpan.setForeground(new java.awt.Color(255, 255, 255));
        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/diskette.png"))); // NOI18N
        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        tambahLain.setBackground(new java.awt.Color(91, 192, 222));
        tambahLain.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tambahLain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/tambahlain.png"))); // NOI18N
        tambahLain.setText("Tambah Lain");
        tambahLain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahLainActionPerformed(evt);
            }
        });

        keluar.setBackground(new java.awt.Color(41, 43, 44));
        keluar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        keluar.setForeground(new java.awt.Color(255, 255, 255));
        keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/exit.png"))); // NOI18N
        keluar.setText("Keluar");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        hapus.setBackground(new java.awt.Color(217, 83, 79));
        hapus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        hapus.setForeground(new java.awt.Color(255, 255, 255));
        hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete.png"))); // NOI18N
        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(2, 117, 216));
        update.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/refresh.png"))); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        cetak.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/printer.png"))); // NOI18N
        cetak.setText("Cetak");
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Judul");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Total");

        pTotal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pJudul, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pAlamat)
                            .addComponent(pNama)
                            .addComponent(pNoHP)
                            .addComponent(pEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(simpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tambahLain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keluar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pNama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pNoHP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(pAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(pJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan)
                    .addComponent(tambahLain)
                    .addComponent(keluar)
                    .addComponent(update))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cetak)
                    .addComponent(hapus))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(285, 285, 285))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
        String path = ".\\src\\BimaBookStore\\reportBuku.jasper";
        try {
            JasperReport reports = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(path, null, con);
            JasperViewer jviewer = new JasperViewer(jprint, false);
            jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(DaftarPembeli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cetakActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int index = tabel.getSelectedRow();
        try {
            terpilih(index);
        } catch (SQLException ex) {
            Logger.getLogger(DaftarPembeli.class.getName()).log(Level.SEVERE, null, ex);
        }
        pNama.setEditable(false);
        hapus.setEnabled(true);
        update.setEnabled(true);
        tambahLain.setEnabled(true);
    }//GEN-LAST:event_tabelMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        ResultSet rs;
        PreparedStatement stmt;
        int totalHarga = 0;
        String query = "SELECT harga_buku FROM buku WHERE judul_buku=?";
        try {
            stmt = con.prepareStatement(query);
            stmt.setString(1, pJudul.getSelectedItem().toString());
            rs = stmt.executeQuery();
            if(rs.next()){
                String harga = rs.getString("harga_buku");
                totalHarga = Integer.parseInt((String) pTotal.getSelectedItem()) * Integer.parseInt(harga);
            }
        } catch (Exception e) {
        }
        
        String updateQuery = null;
        PreparedStatement ps = null;
        updateQuery = "UPDATE pembeli SET nama=?, email=?, no_hp=?, alamat=?, judul_buku=?, total_buku=?, total_harga=? WHERE nama=?";
        try {
            ps = con.prepareStatement(updateQuery);
            ps.setString(1, pNama.getText()); 
            ps.setString(2, pEmail.getText());
            ps.setString(3, pNoHP.getText()); 
            ps.setString(4, pAlamat.getText());
            ps.setString(5, pJudul.getSelectedItem().toString()); 
            ps.setString(6, pTotal.getSelectedItem().toString()); 
            ps.setInt(7, totalHarga); 
            ps.setString(8, pNama.getText()); // nama jangan digonta-ganti ya
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
        } catch (SQLException ex) {
            Logger.getLogger(DaftarPembeli.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data gagal diupdate");
        }

        kosongkanTextField();
        kosongkanTabel();
        try {
            tampilkanDiTabel();
        } catch (SQLException ex) {
            Logger.getLogger(DaftarPembeli.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        update.setEnabled(false);
        simpan.setEnabled(true);
        tambahLain.setEnabled(false);
        hapus.setEnabled(false);
        pJudul.setSelectedIndex(0);
        pTotal.setSelectedIndex(0);
    }//GEN-LAST:event_updateActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("DELETE FROM pembeli WHERE nama=?");
            ps.setString(1, pNama.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(DaftarPembeli.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data gagal dihapus");
        }
        
        kosongkanTextField();
        kosongkanTabel();
        try {
            tampilkanDiTabel();
        } catch (SQLException ex) {
            Logger.getLogger(DaftarPembeli.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        simpan.setEnabled(true);
        update.setEnabled(false);
        tambahLain.setEnabled(false);
        hapus.setEnabled(false);
        pNama.setEditable(true);
    }//GEN-LAST:event_hapusActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        dispose();
        try {
            new Beranda().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(DaftarPembeli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_keluarActionPerformed

    private void tambahLainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahLainActionPerformed
        kosongkanTextField();

        simpan.setEnabled(true); 
        update.setEnabled(false);
        tambahLain.setEnabled(false);
        hapus.setEnabled(false);
        pNama.setEditable(true);
    }//GEN-LAST:event_tambahLainActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        ResultSet rs;
        PreparedStatement stmt;
        int totalHarga = 0;
        String query = "SELECT harga_buku FROM buku WHERE judul_buku=?";
        try {
            stmt = con.prepareStatement(query);
            stmt.setString(1, pJudul.getSelectedItem().toString());
            rs = stmt.executeQuery();
            if(rs.next()){
                String harga = rs.getString("harga_buku");
                totalHarga = Integer.parseInt((String) pTotal.getSelectedItem()) * Integer.parseInt(harga);
            }
        } catch (Exception e) {
        }
        
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO pembeli(nama, email, no_hp, alamat, judul_buku, total_buku, total_harga) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, pNama.getText());
            ps.setString(2, pEmail.getText()); 
            ps.setString(3, pNoHP.getText());
            ps.setString(4, pAlamat.getText());
            ps.setString(5, pJudul.getSelectedItem().toString());
            ps.setString(6, pTotal.getSelectedItem().toString()); 
            ps.setInt(7, totalHarga);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data tersimpan");
        } catch (SQLException ex) {
            Logger.getLogger(DaftarPembeli.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data tidak tersimpan");
        }

        kosongkanTextField();
        kosongkanTabel();
        try {
            tampilkanDiTabel();
        } catch (SQLException ex) {
            Logger.getLogger(DaftarPembeli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_simpanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DaftarPembeli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DaftarPembeli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DaftarPembeli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DaftarPembeli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DaftarPembeli().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(DaftarPembeli.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cetak;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton keluar;
    private javax.swing.JTextField pAlamat;
    private javax.swing.JTextField pEmail;
    private javax.swing.JComboBox<String> pJudul;
    private javax.swing.JTextField pNama;
    private javax.swing.JTextField pNoHP;
    private javax.swing.JComboBox<String> pTotal;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel;
    private javax.swing.JButton tambahLain;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
