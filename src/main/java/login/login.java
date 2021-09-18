/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;


import java.awt.*;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.*;
import usu.usuarioCone;

/**
 *
 * @author USUARIO
 */
public class login extends javax.swing.JFrame {
   private ImageIcon imagen;
   private Icon icono;
   
   
   
   
    usuarioCone cc=new usuarioCone();
    Connection con= cc.conexion();
    
    public login() {
        
        initComponents();
     
        this.setLocationRelativeTo(null);//para que aparezca en el centro
        this.pintarImagen(this.lbl1,"C:\\Users\\USUARIO\\Pictures\\Parcial2Pro2\\src\\main\\java\\login\\user.png");
        this.pintarImagen(this.lbl2,"C:\\Users\\USUARIO\\Pictures\\Parcial2Pro2\\src\\main\\java\\login\\blue-2384333_960_720.png");
    
        this.setTitle("Login"); //asignar titulo
    }

    //creación de metodo
    public void validarAcceso(){
    int resultado=0;
    
    try{
    
    String usuario=txtUsuario.getText();
    String pass=String.valueOf(txtPas.getPassword());
    
    
    String sql="Select * from tb_usuario where username='"+usuario+"' and password='"+pass+"'";
    
    Statement st=con.createStatement();
    //ejecutar la consulta
    ResultSet rs= st.executeQuery(sql);
    
    if(rs.next()){
    
    resultado=1;
    
    if(resultado==1){
        JOptionPane.showMessageDialog(null,"Bienvenid@ al sistema " + txtUsuario.getText());
        
        
        
    sistema form=new sistema();
    form.setVisible(true); //sea visible
    this.dispose();//cierra el login
    }else{
    
    JOptionPane.showMessageDialog(null,"Error en el acceso");
    }
    }
    
    
    
    
    }catch (Exception e){
        
        JOptionPane.showMessageDialog(null,"Error en el acceso..."+e.getMessage()); //si hay errores y una concatenacion para ver donde esta el error
    }}
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtPas = new javax.swing.JPasswordField();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("USERNAME: ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 100, 20));
        jPanel2.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 190, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PASSWORD:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        jButton1.setBackground(new java.awt.Color(204, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 0, 0));
        jButton1.setText("INGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, -1, -1));
        jPanel2.add(txtPas, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 190, 30));
        jPanel2.add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 110, 130));
        jPanel2.add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 380, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       validarAcceso();
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }
    
    private void pintarImagen(JLabel lbl, String ruta){
    this.imagen = new ImageIcon(ruta);
    this.icono=new ImageIcon(
            this.imagen.getImage().getScaledInstance(
                    lbl.getWidth(), 
                    lbl.getHeight(), 
                    Image.SCALE_DEFAULT
            )
    );
    lbl.setIcon(this.icono);
    this.repaint();
    
    
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JPasswordField txtPas;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables






}
