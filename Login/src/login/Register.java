package login;
import java.awt.Desktop;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
/**
 *
 * @author alfa
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
        txID.setEnabled(true);
        txID.setVisible(false);
        txID.setVisible(false);
        txID.setEditable(false);
//        btnRegis.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txID = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        txUsername = new javax.swing.JTextField();
        txPassword = new javax.swing.JPasswordField();
        txConPassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        btnRegis = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txPhone = new javax.swing.JTextField();
        wrPass = new javax.swing.JLabel();
        wrTlp = new javax.swing.JLabel();
        wrCon = new javax.swing.JLabel();
        wrUser = new javax.swing.JLabel();

        txID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txIDActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txUsernameActionPerformed(evt);
            }
        });
        txUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txUsernameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txUsernameKeyReleased(evt);
            }
        });
        jPanel1.add(txUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 220, -1));

        txPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPasswordActionPerformed(evt);
            }
        });
        txPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txPasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txPasswordKeyReleased(evt);
            }
        });
        jPanel1.add(txPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 220, -1));

        txConPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txConPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(txConPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 220, -1));

        jButton1.setText("back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 95, -1));

        btnRegis.setText("register");
        btnRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 120, -1));

        jLabel3.setText("Username");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        jLabel4.setText("Password");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        jLabel5.setText("Re-Type Password");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));

        jLabel1.setFont(new java.awt.Font("Helvetica", 1, 24)); // NOI18N
        jLabel1.setText("REGISTER");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(jLabel1)
                .addContainerGap(158, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(15, 15, 15))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 60));

        jLabel2.setText("Phone Number");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        txPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPhoneActionPerformed(evt);
            }
        });
        txPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txPhoneKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txPhoneKeyReleased(evt);
            }
        });
        jPanel1.add(txPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 220, -1));

        wrPass.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        wrPass.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(wrPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 220, 10));

        wrTlp.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        wrTlp.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(wrTlp, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 220, 10));

        wrCon.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        wrCon.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(wrCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 220, 10));

        wrUser.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        wrUser.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(wrUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 220, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static String encr(String param) {
         /* Plain-text password initialization. */  
        String encryptedpassword = null;  
        try   
        {  
            /* MessageDigest instance for MD5. */  
            MessageDigest m = MessageDigest.getInstance("MD5");  
              
            /* Add plain-text password bytes to digest using MD5 update() method. */  
            m.update(param.getBytes());  
              
            /* Convert the hash value into bytes */   
            byte[] bytes = m.digest();  
              
            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */  
            StringBuilder s = new StringBuilder();  
            for(int i=0; i< bytes.length ;i++)  
            {  
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
            }  
              
            /* Complete hashed password in hexadecimal format */  
            encryptedpassword = s.toString(); 
        }   
        catch (NoSuchAlgorithmException e)   
        {  
            e.printStackTrace();  
        }  
        return encryptedpassword;
    }

    private void btnRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisActionPerformed
        String id = txID.getText().toString().trim();
        String username = txUsername.getText().toString().trim();
        String password = txPassword.getText().toString().trim();
        String conPassword = txConPassword.getText().toString().trim();
        String passwordEncr = encr(txPassword.getText().toString().trim());
        String phone = txPhone.getText().toString().trim();
        String encryptedpassword = null;  
        
        if (!password.equals(conPassword)){
            JOptionPane.showMessageDialog(null, "Password not match");
        }else if (password.equals("") || username.equals("")){
            JOptionPane.showMessageDialog(null, "Username or Password cannot be empty");
        

        }else{
            try{
                Connection c = Koneksi.getKoneksi();
                String sql = "INSERT INTO users (username, phone ,password) values (?,?,?)";
                PreparedStatement p = c.prepareStatement(sql);
//                p.setString(1, id);
                p.setString(1, username);
                p.setString(2, phone);
                p.setString(3, passwordEncr);
                p.executeUpdate();
                p.close();
                JOptionPane.showMessageDialog(null, "Create Account Successfully");
            }catch(SQLException e){
                System.out.println("Error"+e);
            }finally{
                this.dispose();
                Login a = new Login();
                a.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnRegisActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         this.dispose();
        Login a = new Login();
//        Login a = new Login();
        a.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txConPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txConPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txConPasswordActionPerformed

    private void txIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txIDActionPerformed

    private void txPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txPasswordActionPerformed

    private void txPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txPhoneActionPerformed

    private void txPhoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPhoneKeyPressed
        // TODO add your handling code here:
//        char c = evt.getKeyChar();
//        String phone = txPhone.getText().toString().trim();
//        if(Character.isLetter(c)){
//            btnRegis.setEnabled(false);
//        }else{
//            if(phone.matches("^[0-9, ]+$") && (phone.length() > 6 && phone.length() < 11)) {
//            btnRegis.setEnabled(true);
//            }  else {
//                btnRegis.setEnabled(false);
//            }
//        }
    }//GEN-LAST:event_txPhoneKeyPressed

    private void txUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txUsernameActionPerformed
        
    }//GEN-LAST:event_txUsernameActionPerformed

    private void txUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txUsernameKeyPressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txUsernameKeyPressed

    private void txPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPasswordKeyPressed
        // TODO add your handling code here:
   
    }//GEN-LAST:event_txPasswordKeyPressed

    private void txUsernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txUsernameKeyReleased
        // TODO add your handling code here:
         String pattern = "^[a-zA-Z0-9]{5,13}$";
        Pattern patt = Pattern.compile(pattern);
        Matcher match = patt.matcher(txUsername.getText());
        if(!match.matches()){
            wrUser.setText("Format Username is incorrect");
            
        }else{
            wrUser.setText(null);
        }
    }//GEN-LAST:event_txUsernameKeyReleased

    private void txPhoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPhoneKeyReleased
        // TODO add your handling code here:
        String pattern = "^[0-9]{6,14}$";
        Pattern patt = Pattern.compile(pattern);
        Matcher match = patt.matcher(txPhone.getText());
        if(!match.matches()){
            wrTlp.setText("Format Number is incorrect");
            
        }else{
            wrTlp.setText(null);
        }
    }//GEN-LAST:event_txPhoneKeyReleased

    private void txPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPasswordKeyReleased
        // TODO add your handling code here:
        String pattern = "^[a-zA-Z0-9][^w]{7,14}$";
        Pattern patt = Pattern.compile(pattern);
        Matcher match = patt.matcher(txPassword.getText());
        if(!match.matches()){
            wrPass.setText("Minimum Character is 6");
            
        }else{
            wrPass.setText(null);
        }
    }//GEN-LAST:event_txPasswordKeyReleased

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegis;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txConPassword;
    private javax.swing.JTextField txID;
    private javax.swing.JPasswordField txPassword;
    private javax.swing.JTextField txPhone;
    private javax.swing.JTextField txUsername;
    private javax.swing.JLabel wrCon;
    private javax.swing.JLabel wrPass;
    private javax.swing.JLabel wrTlp;
    private javax.swing.JLabel wrUser;
    // End of variables declaration//GEN-END:variables
}
