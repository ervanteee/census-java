package login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.regex.*;

public class Main extends javax.swing.JFrame {
    public Statement st;
    public ResultSet rs;
    Connection cn = Koneksi.getKoneksi();

    public Main() {
        initComponents();
        TampilData();
        TampilDataKecamatan();
        String selectedValue = cmbAlm.getSelectedItem().toString();
        TampilDataKelurahan(selectedValue);
        Common common = new Common();
        System.out.println((common.idUser));
//        profile();
    }
    private void Bersih(){
        txtNIK.setText("");
        txtNama.setText("");
        txtTlp.setText("");
        txtAlm.setText("");
        cmbAlm.setSelectedItem("");
        cmbAlmKlr.setSelectedItem("");
        
        btnSimpan.setText("Simpan");
        txtNIK.setEditable(true);
    }

    private void profile(){
        try{
            String uname = rs.getNString("username");
            System.out.println(rs);
            
        }catch(Exception e){
               System.out.println(e);
        }
    }
    private void CariData(){
        try{System.out.println("SELECT * FROM biodata WHERE " +cmbCari.getSelectedItem().toString()
                    +"LIKE'%"+txtCari.getText()+"%'");                
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM biodata WHERE " +cmbCari.getSelectedItem().toString()
                    +" LIKE'%"+txtCari.getText()+"%'");
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("nik");
            model.addColumn("nama"); 
            model.addColumn("telepon"); 
            model.addColumn("alamat"); 
            model.addColumn("kecamatan"); 
            model.addColumn("kelurahan"); 

            
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while(rs.next()){
            Object[] data ={
                rs.getString("nik"),
                rs.getString("nama"),
                rs.getString("telepon"),
                rs.getString("alamat"),
                rs.getString("kecamatan"),
                rs.getString("kelurahan")     
            };
            model.addRow(data);
            tblData.setModel(model);
            }
        }catch(Exception e){
            
        }
    }
    private void TampilData(){
        try{
            st = cn.createStatement();
//            rs = st.executeQuery("SELECT * FROM biodata");
//                "SELECT biodata.nik,  biodata.nama, biodata.telepon, biodata.nik, biodata.alamat, biodata.kelurahan, biodata.kecamatan, users.username  "
//                    + "from biodata "
//                    + "LEFT JOIN users on biodata.user_id = users.id "
//                    + "where biodata.user_id = "+ 2
            rs = st.executeQuery("SELECT biodata.nik,  biodata.nama, biodata.telepon, biodata.nik, biodata.alamat, biodata.kelurahan, biodata.kecamatan, users.username  "
                    + "from biodata "
                    + "LEFT JOIN users on biodata.user_id = users.id");
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("nik");
            model.addColumn("nama"); 
            model.addColumn("telepon"); 
            model.addColumn("alamat");
            model.addColumn("kecamatan");
            model.addColumn("kelurahan");
            model.addColumn("Inputed by");

            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while(rs.next()){
            Object[] data ={
                rs.getString("nik"),
                rs.getString("nama"),
                rs.getString("telepon"),
                rs.getString("alamat"),
                rs.getString("kecamatan"),
                rs.getString("kelurahan"),
                rs.getString("username")
            };
            model.addRow(data);
            tblData.setModel(model);
            }
            
        }catch(Exception e){
               System.out.println("e"+ e);
        }

    }
    
 
    
    private void TampilDataKecamatan(){
        try{
            
            st = cn.createStatement();
            DefaultTableModel model = new DefaultTableModel();
            rs = st.executeQuery("Select * from kecamatan");
            System.out.println(rs);
            while (rs.next()){
                cmbAlm.addItem(rs.getString("kecamatan"));
            }
            cmbAlm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String selectedValue = cmbAlm.getSelectedItem().toString();
                    TampilDataKelurahan(selectedValue);
                }
            });
        }catch(Exception e){
               System.out.println(e);
        }
    }
    
     private void TampilDataKelurahan(String kecamatan){
        try{
            cmbAlmKlr.removeAllItems();
            st = cn.createStatement();
            DefaultTableModel model = new DefaultTableModel();
            rs = st.executeQuery("Select * from kelurahan where kecamatan = '"+kecamatan+"'");
            while (rs.next()){
                cmbAlmKlr.addItem(rs.getString("name"));
            }
        }catch(Exception e){
               System.out.println(e);
        }
    }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNIK = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtTlp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        txtAlm = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        cmbCari = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmbAlm = new javax.swing.JComboBox<>();
        cmbAlmKlr = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        wrNik = new javax.swing.JLabel();
        wrTlp = new javax.swing.JLabel();
        wrAlm = new javax.swing.JLabel();
        wrNama = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Helvetica", 1, 24)); // NOI18N
        jLabel6.setText("SENSUS PENDUDUK");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 6, -1, -1));

        jLabel9.setFont(new java.awt.Font("Helvetica", 1, 24)); // NOI18N
        jLabel9.setText("KOTA DEPOK");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 37, -1, -1));

        jLabel10.setFont(new java.awt.Font("Helvetica", 1, 10)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Admin");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 100, -1));

        admin.setFont(new java.awt.Font("Helvetica", 1, 10)); // NOI18N
        admin.setForeground(new java.awt.Color(51, 51, 255));
        admin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 100, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 60));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("NIK");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 77, -1, -1));

        txtNIK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNIKActionPerformed(evt);
            }
        });
        txtNIK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNIKKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNIKKeyReleased(evt);
            }
        });
        jPanel2.add(txtNIK, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 70, 316, -1));

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });
        txtNama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNamaKeyReleased(evt);
            }
        });
        jPanel2.add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 100, 316, -1));

        txtTlp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTlpActionPerformed(evt);
            }
        });
        txtTlp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTlpKeyReleased(evt);
            }
        });
        jPanel2.add(txtTlp, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 132, 316, -1));

        jLabel3.setText("Telepon");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 135, -1, -1));

        btnHapus.setText("Hapus");
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
        });
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel2.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 270, 96, -1));

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        jPanel2.add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 270, 102, -1));

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel2.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 270, 100, -1));

        txtAlm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlmActionPerformed(evt);
            }
        });
        txtAlm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAlmKeyReleased(evt);
            }
        });
        jPanel2.add(txtAlm, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 161, 316, -1));

        jLabel2.setText("Nama Lengkap");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 106, -1, -1));

        jLabel4.setText("Alamat");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 164, -1, -1));

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NIK", "Full Name", "Telephone", "Address", "Kecamatan", "Kelurahan", "Diisi oleh:"
            }
        ));
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 660, 145));

        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariKeyPressed(evt);
            }
        });
        jPanel2.add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, 250, 30));

        cmbCari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nik", "nama", "telepon", "alamat", "kecamatan", "kelurahan" }));
        cmbCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCariActionPerformed(evt);
            }
        });
        jPanel2.add(cmbCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 154, 30));

        jLabel5.setText("Cari");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 40, 50));

        cmbAlm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAlmActionPerformed(evt);
            }
        });
        jPanel2.add(cmbAlm, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 193, 316, -1));

        cmbAlmKlr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAlmKlrActionPerformed(evt);
            }
        });
        jPanel2.add(cmbAlmKlr, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 229, 316, -1));

        jLabel7.setText("Kecamatan");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 196, -1, -1));

        jLabel8.setText("Kelurahan");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 232, -1, -1));

        jButton1.setText("Keluar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 470, 70, 30));

        wrNik.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        wrNik.setForeground(new java.awt.Color(255, 0, 0));
        wrNik.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                wrNikComponentAdded(evt);
            }
        });
        jPanel2.add(wrNik, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 140, 20));

        wrTlp.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        wrTlp.setForeground(new java.awt.Color(255, 0, 0));
        wrTlp.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                wrTlpComponentAdded(evt);
            }
        });
        jPanel2.add(wrTlp, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 130, 20));

        wrAlm.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        wrAlm.setForeground(new java.awt.Color(255, 0, 0));
        wrAlm.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                wrAlmComponentAdded(evt);
            }
        });
        jPanel2.add(wrAlm, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 120, 20));

        wrNama.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        wrNama.setForeground(new java.awt.Color(255, 0, 0));
        wrNama.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                wrNamaComponentAdded(evt);
            }
        });
        jPanel2.add(wrNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 130, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void cmbCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCariActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
            String nik = txtNIK.getText().trim();

        
        try{
            Common common = new Common();
            st = cn.createStatement();
            if(txtNIK.getText().equals("")|| 
               txtNama.getText().equals("")||
               txtTlp.getText().equals("")){
                    JOptionPane.showMessageDialog 
                    (null,"Data Tidak Boleh Kosong","Validasi Data",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            System.out.println(btnSimpan.getText());
            if(btnSimpan.getText()== "Simpan"){
                String cek = "SELECT * FROM biodata WHERE nik ='"+ txtNIK.getText()+"'";
                rs = st.executeQuery(cek);
                if(rs.next()){
                    JOptionPane.showMessageDialog(null,"your nik has already exsist ");
                }else{
                    Connection c = Koneksi.getKoneksi();
                    String sql = "INSERT INTO biodata (nik,nama,telepon,alamat,kecamatan,kelurahan,user_id) values (?,?,?,?,?,?,?)";
                    PreparedStatement p = c.prepareStatement(sql);
                    p.setString(1, txtNIK.getText());
                    p.setString(2, txtNama.getText());
                    p.setString(3, txtTlp.getText());
                    p.setString(4, txtAlm.getText());
                    p.setString(5, cmbAlm.getSelectedItem().toString());
                    p.setString(6, cmbAlmKlr.getSelectedItem().toString());
                    p.setInt(7, common.idUser);
 
                    p.executeUpdate();
                    p.close();
                    JOptionPane.showMessageDialog(null, "Data berhasil di Daftarkan");
                    Bersih();
                    TampilData();
                }
            }else{
                String update = "UPDATE biodata SET nama = '" + txtNama.getText() +
                        "',telepon = '" +txtTlp.getText()+"',alamat ='"+txtAlm.getText()+"'"
                        + ",kelurahan='"+cmbAlmKlr.getSelectedItem()+"',kecamatan='"+cmbAlm.getSelectedItem()
                        +"'WHERE nik = '" + txtNIK.getText()+ "'";
                st.executeUpdate(update);
                JOptionPane.showMessageDialog(null,"Data berhasil disimpan");
                Bersih();
                TampilData();
            }
        }catch(Exception e){
        System.out.println("error"+e);
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
            Bersih();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void txtAlmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlmActionPerformed

    private void txtTlpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTlpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTlpActionPerformed

    private void txtNIKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNIKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNIKActionPerformed

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        if(txtNIK.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Silahkan pilih data yang akan anda hapus!");
            
        }else{
            int jawab = JOptionPane.showConfirmDialog(null,"Data ini akan dihapus, lanjutkan?",
                    "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if(jawab == 0){
                try{
                    st = cn.createStatement();
                    String sql ="DELETE FROM biodata WHERE nik='" + txtNIK.getText()+"'";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
                    
                    Bersih();
                    TampilData();
                }catch(Exception e){
                    System.out.println("Error"+e);
                }
            }
        }
    }//GEN-LAST:event_btnHapusMouseClicked

    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyPressed
        CariData();
    }//GEN-LAST:event_txtCariKeyPressed

    private void cmbAlmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAlmActionPerformed
        // TODO add your handling code here
//        cmbAlm.removeAllItems();
//        TampilDataKecamatan();
//        String selectedValue = cmbAlm.getSelectedItem().toString();
//        TampilDataKelurahan(selectedValue);
        
    }//GEN-LAST:event_cmbAlmActionPerformed

    private void cmbAlmKlrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAlmKlrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAlmKlrActionPerformed

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        txtNIK.setText(tblData.getValueAt(tblData.getSelectedRow(),0).toString());
        txtNama.setText(tblData.getValueAt(tblData.getSelectedRow(),1).toString());
        txtTlp.setText(tblData.getValueAt(tblData.getSelectedRow(),2).toString());
        txtAlm.setText(tblData.getValueAt(tblData.getSelectedRow(),3).toString());
        cmbAlm.setSelectedItem(tblData.getValueAt(tblData.getSelectedRow(),4).toString());
        cmbAlmKlr.setSelectedItem(tblData.getValueAt(tblData.getSelectedRow(),5).toString());


        txtNIK.setEditable(false);
        btnSimpan.setText("ubah");
    }//GEN-LAST:event_tblDataMouseClicked

    private void wrNikComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_wrNikComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_wrNikComponentAdded

    private void txtNIKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNIKKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtNIKKeyPressed

    private void wrTlpComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_wrTlpComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_wrTlpComponentAdded

    private void wrAlmComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_wrAlmComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_wrAlmComponentAdded

    private void wrNamaComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_wrNamaComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_wrNamaComponentAdded

    private void txtNIKKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNIKKeyReleased
        // TODO add your handling code here:
        String pattern = "^[0-9]{6,12}$";
        Pattern patt = Pattern.compile(pattern);
        Matcher match = patt.matcher(txtNIK.getText());
        if(!match.matches()){
            wrNik.setText("Format NIK is incorrect");
            
        }else{
            wrNik.setText(null);
        }
    }//GEN-LAST:event_txtNIKKeyReleased

    private void txtNamaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaKeyReleased
        // TODO add your handling code here:
        String pattern = "^[a-zA-Z]{3,30}$";
        Pattern patt = Pattern.compile(pattern);
        Matcher match = patt.matcher(txtNama.getText());
        if(!match.matches()){
            wrNama.setText("Format Name is incorrect");
            
        }else{
            wrNama.setText(null);
        }
    }//GEN-LAST:event_txtNamaKeyReleased

    private void txtTlpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTlpKeyReleased
        // TODO add your handling code here:
        String pattern = "^[0-9]{7,13}$";
        Pattern patt = Pattern.compile(pattern);
        Matcher match = patt.matcher(txtTlp.getText());
        if(!match.matches()){
            wrTlp.setText("Format Numbers is incorrect");
            
        }else{
            wrTlp.setText(null);
        }
    }//GEN-LAST:event_txtTlpKeyReleased

    private void txtAlmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlmKeyReleased
        // TODO add your handling code here:
        String pattern = "^[a-zA-Z0-9]{5,40}$";
        Pattern patt = Pattern.compile(pattern);
        Matcher match = patt.matcher(txtNama.getText());
        if(!match.matches()){
            wrAlm.setText("Format Address is incorrect");
            
        }else{
            wrAlm.setText(null);
        }
    }//GEN-LAST:event_txtAlmKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final javax.swing.JLabel admin = new javax.swing.JLabel();
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cmbAlm;
    private javax.swing.JComboBox<String> cmbAlmKlr;
    private javax.swing.JComboBox<String> cmbCari;
    private javax.swing.JButton jButton1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtAlm;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtNIK;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtTlp;
    private javax.swing.JLabel wrAlm;
    private javax.swing.JLabel wrNama;
    private javax.swing.JLabel wrNik;
    private javax.swing.JLabel wrTlp;
    // End of variables declaration//GEN-END:variables
}
