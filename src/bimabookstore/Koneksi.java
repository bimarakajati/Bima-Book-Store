/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bimabookstore;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bima
 */
public class Koneksi {
    public Connection getConnection(){
        Connection con = null;
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bimabookstore", "root", "");
            // JOptionPane.showMessageDialog(null, "Koneksi Berhasil");
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Koneksi Gagal");
            System.exit(0);
        }
        return con;
    }
}
