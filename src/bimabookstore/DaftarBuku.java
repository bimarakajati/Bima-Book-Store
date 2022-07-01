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
public class DaftarBuku extends javax.swing.JFrame {

    /**
     * Creates new form FormNilaiMhs
     */
    DefaultTableModel tabel1;
    Object[] list_mhs = new Object[6];
    int x = 0; // counter
    Koneksi dbConn = new Koneksi();
    Connection con = dbConn.getConnection();
    
    public DaftarBuku() throws SQLException {
        initComponents();
        
        tabel1 = new DefaultTableModel();
        tabel.setModel(tabel1); // tabel nama table GUI
        // siapkan array yg akan dimasukkan ke table
        tabel1.addColumn("No");
        tabel1.addColumn("Kode");
        tabel1.addColumn("Judul");
        tabel1.addColumn("Penerbit");
        tabel1.addColumn("Genre");
        tabel1.addColumn("Harga");
        
        setResizable(false); // tdk dpt diperbesar
        // tdk bisa diklik
        update.setEnabled(false);
        hapus.setEnabled(false);
        tambahLain.setEnabled(false);
        tampilkanDiTabel();
    }

    public ArrayList[] getBukuList() throws SQLException{
        // mendapatkan data dari tb dan disimpan di arraylist
        String queryCount = "SELECT COUNT(*) AS c FROM buku";
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
        String query = "SELECT * FROM buku";
        rs = st.executeQuery(query);
        int x = 0;
        while (rs.next()) {
            mhsList[x] = new ArrayList<>();
            mhsList[x].add(rs.getString("kode_buku"));
            mhsList[x].add(rs.getString("judul_buku"));
            mhsList[x].add(rs.getString("penerbit_buku"));
            mhsList[x].add(rs.getString("genre_buku"));
            mhsList[x].add(rs.getString("harga_buku"));
            x++;
        }
        return mhsList;
    }
    
    public void tampilkanDiTabel() throws SQLException{
        ArrayList[] list = getBukuList();
        // sebelum lanjut, buat fungsi getMhsList dulu
        DefaultTableModel model = (DefaultTableModel)tabel.getModel();
        
        Object[] row = new Object[6];
        for(int i=0; i<list.length; i++){
            row[0] = i+1;
            row[1] = list[i].get(0);
            row[2] = list[i].get(1);
            row[3] = list[i].get(2);
            row[4] = list[i].get(3);
            row[5] = list[i].get(4);
            
            model.addRow(row);
        }
    }
    
    public void kosongkanTextField(){
        bJudul.setText(""); bPenerbit.setText("");
        bGenre.setText(""); bHarga.setText("");
        bKode.setText("");
    }
    
    public void kosongkanTabel(){
        DefaultTableModel model = (DefaultTableModel)this.tabel.getModel();
        model.setRowCount(0);
    }
    
    public void terpilih(int index) throws SQLException{
        ArrayList[] list = getBukuList();
        bKode.setText((String) list[index].get(0));
        bJudul.setText((String) list[index].get(1));
        bPenerbit.setText((String) list[index].get(2));
        bGenre.setText((String) list[index].get(3)); // karena dia Double
        bHarga.setText((String) list[index].get(4).toString());
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
        bJudul = new javax.swing.JTextField();
        bPenerbit = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        bGenre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        bHarga = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        simpan = new javax.swing.JButton();
        tambahLain = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        bKode = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Daftar Buku");

        jPanel1.setBackground(new java.awt.Color(204, 223, 239));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Daftar Buku");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Judul");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Penerbit");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Genre");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Harga");

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
        tambahLain.setForeground(new java.awt.Color(51, 51, 51));
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

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Kode");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bJudul, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(bPenerbit))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(bHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(bGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(bKode, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(simpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(tambahLain)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(keluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(52, 52, 52))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(bGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(bJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(bKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(bPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(bHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan)
                    .addComponent(tambahLain)
                    .addComponent(update)
                    .addComponent(hapus))
                .addGap(18, 18, 18)
                .addComponent(keluar)
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(382, 382, 382))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tambahLainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahLainActionPerformed
        kosongkanTextField();
        
        simpan.setEnabled(true); 
        update.setEnabled(false);
        tambahLain.setEnabled(false);
        hapus.setEnabled(false);
        bKode.setEditable(true);
    }//GEN-LAST:event_tambahLainActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        dispose();
        try {
            new Beranda().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(DaftarBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_keluarActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("DELETE FROM buku WHERE kode_buku=?");
            ps.setString(1, bKode.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(DaftarBuku.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data gagal dihapus");
        }
        
        kosongkanTextField();
        kosongkanTabel();
        try {
            tampilkanDiTabel();
        } catch (SQLException ex) {
            Logger.getLogger(DaftarBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        simpan.setEnabled(true); 
        update.setEnabled(false);
        tambahLain.setEnabled(false);
        hapus.setEnabled(false);
        bKode.setEditable(true);
    }//GEN-LAST:event_hapusActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int index = tabel.getSelectedRow();
        try {
            terpilih(index);
        } catch (SQLException ex) {
            Logger.getLogger(DaftarBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
        bKode.setEditable(false);
        hapus.setEnabled(true);
        update.setEnabled(true);
        tambahLain.setEnabled(true);
    }//GEN-LAST:event_tabelMouseClicked

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO buku(kode_buku, judul_buku, penerbit_buku, genre_buku, harga_buku) VALUES (?,?,?,?,?)");
            ps.setString(1, bKode.getText());
            ps.setString(2, bJudul.getText()); ps.setString(3, bPenerbit.getText());
            ps.setString(4, bGenre.getText()); ps.setString(5, bHarga.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data tersimpan");
        } catch (SQLException ex) {
            Logger.getLogger(DaftarBuku.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data tidak tersimpan");
        }
        
        kosongkanTextField();
        kosongkanTabel();
        try {
            tampilkanDiTabel();
        } catch (SQLException ex) {
            Logger.getLogger(DaftarBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        String updateQuery = null;
        PreparedStatement ps = null;
        
        updateQuery = "UPDATE buku SET judul_buku=?, penerbit_buku=?, genre_buku=?, harga_buku=? WHERE kode_buku=?";
        
        try {
            ps = con.prepareStatement(updateQuery);
            ps.setString(1, bJudul.getText()); ps.setString(2, bPenerbit.getText());
            ps.setString(3, bGenre.getText()); ps.setString(4, bHarga.getText());
            ps.setString(5, bKode.getText()); // kode jangan digonta-ganti ya
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
        } catch (SQLException ex) {
            Logger.getLogger(DaftarBuku.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data gagal diupdate");
        }
        
        kosongkanTextField();
        kosongkanTabel();
        try {
            tampilkanDiTabel();
        } catch (SQLException ex) {
            Logger.getLogger(DaftarBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
        update.setEnabled(false);
        simpan.setEnabled(true);
        tambahLain.setEnabled(false);
        bKode.setEditable(true);
    }//GEN-LAST:event_updateActionPerformed

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
            java.util.logging.Logger.getLogger(DaftarBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DaftarBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DaftarBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DaftarBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DaftarBuku().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(DaftarBuku.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bGenre;
    private javax.swing.JTextField bHarga;
    private javax.swing.JTextField bJudul;
    private javax.swing.JTextField bKode;
    private javax.swing.JTextField bPenerbit;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton keluar;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel;
    private javax.swing.JButton tambahLain;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}