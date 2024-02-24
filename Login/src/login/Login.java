package login;
import java.awt.Desktop;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txUsername = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txPassword = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        wrPass = new javax.swing.JLabel();
        wrUser = new javax.swing.JLabel();

        jLabel3.setText("Password");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(102, 102, 255));
        jLabel1.setFont(new java.awt.Font("Helvetica", 1, 24)); // NOI18N
        jLabel1.setText("FORM LOGIN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 27, -1, -1));

        txUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txUsernameKeyReleased(evt);
            }
        });
        jPanel1.add(txUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 217, -1));

        btnRegister.setText("register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 80, -1));

        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        txPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txPasswordKeyReleased(evt);
            }
        });
        jPanel1.add(txPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 217, -1));

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 70));

        jLabel4.setText("Username");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        btnLogin.setText("login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 120, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Help Center");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, -1, -1));

        wrPass.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        wrPass.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.add(wrPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 220, 10));

        wrUser.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        wrUser.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.add(wrUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 220, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        this.dispose();
        Register a = new Register();
        a.setLocationRelativeTo(null);
        a.setVisible(true);    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
       
        
        try{
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            Register register = new Register();
            String sql = "SELECT * FROM users WHERE username='" + txUsername.getText()
                    +"' and password='"+ register.encr(txPassword.getText()) + "'";
            ResultSet r = s.executeQuery(sql);
            System.out.println("====");
            if (r.next()){
                System.out.println(r.getInt("id"));
                Main m = new Main();
                m.admin.setText(r.getString(2));
                Common common = new Common();
                common.idUser = r.getInt("id");
                JOptionPane.showMessageDialog(null, "Login Successfully");
             
                Main a = new Main();
                a.setVisible(true);
                a.setLocationRelativeTo(null);
                this.dispose(); //close the form
            }else{
                JOptionPane.showMessageDialog(null, "Wrong Username or Password");
                txPassword.requestFocus();
            }
        }catch(SQLException e){
            System.out.println("error");
        }
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        try {
            Desktop.getDesktop().browse(new URL("https://www.instagram.com/_irvantfq_/").toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jLabel5MouseClicked

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

    
    public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Login().setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txPassword;
    private javax.swing.JTextField txUsername;
    private javax.swing.JLabel wrPass;
    private javax.swing.JLabel wrUser;
    // End of variables declaration//GEN-END:variables
}
