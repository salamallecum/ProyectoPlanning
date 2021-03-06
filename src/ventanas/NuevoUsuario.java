package ventanas;


import BD.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static ventanas.MenuAdministrador.panelUsu;


/**
 *
 * @author ALEJO
 */
public class NuevoUsuario extends javax.swing.JFrame {
       
    
    /**
     * Creates new form nuevoUsuario
     */
    public NuevoUsuario() {
        initComponents();
        setSize(535, 408);
        setTitle("Nuevo usuario");
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/adduser.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_nombres = new javax.swing.JTextField();
        txt_apellidos = new javax.swing.JTextField();
        txt_celular = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        txt_nombreUsuario = new javax.swing.JTextField();
        txt_clave = new javax.swing.JTextField();
        cmb_Rol = new javax.swing.JComboBox<>();
        btn_cancelar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        lbl_imagenDefault = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Nuevo usuario");
        setIconImage(getIconImage());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nombres:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Apellidos:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Celular:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Correo:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Usuario:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Clave:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Rol:");

        txt_nombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombresKeyTyped(evt);
            }
        });

        txt_apellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apellidosKeyTyped(evt);
            }
        });

        cmb_Rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administra", "Usuario" }));

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cancelar.png"))); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Save_icon-icons.com_73702.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        lbl_imagenDefault.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_imagenDefault.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmb_Rol, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_clave, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_celular, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_imagenDefault, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(9, 9, 9))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addComponent(txt_apellidos))
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(56, 56, 56))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_guardar)
                .addGap(18, 18, 18)
                .addComponent(btn_cancelar)
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(txt_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel3)
                            .addComponent(txt_celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel4)
                            .addComponent(txt_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel5)
                            .addComponent(txt_nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel6)
                            .addComponent(txt_clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel7)
                            .addComponent(cmb_Rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_imagenDefault, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Metodo del boton cancelar
    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        PanelUsuarios.btn_nuevoUsuario.setEnabled(true);
        dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    //Metodo boton Guardar
    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        
        int roles_cmb, validacion = 0;
        String nombres, apellidos, celular, correo, usuario, pass, roles_string = "";
        
        nombres = txt_nombres.getText().trim();
        apellidos = txt_apellidos.getText().trim();
        celular = txt_celular.getText().trim();
        correo = txt_correo.getText().trim();
        usuario = txt_nombreUsuario.getText().trim();
        pass = txt_clave.getText().trim();
        roles_cmb = cmb_Rol.getSelectedIndex() + 1;
        
        if(nombres.equals("")){
            txt_nombres.setBackground(Color.red);
            validacion++;
        }
        if(apellidos.equals("")){
            txt_apellidos.setBackground(Color.red);
            validacion++;
        }
        if(celular.equals("")){
            txt_celular.setBackground(Color.red);
            validacion++;
        }
        if(correo.equals("")){
            txt_correo.setBackground(Color.red);
            validacion++;
        }
        if(usuario.equals("")){
            txt_nombreUsuario.setBackground(Color.red);
            validacion++;
        }
        if(pass.equals("")){
            txt_clave.setBackground(Color.red);
            validacion++;
        }   
        
        if(roles_cmb == 1){
            roles_string = "Administra";
        } else if(roles_cmb == 2){
            roles_string = "Usuario";
        } 
        
        //Valida que el usuario ingresado no exista previamente en la BD
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                "select Usuario from usuarios where Usuario = '" + usuario + "'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                txt_nombreUsuario.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible.");
                cn.close();
                Normalizar();
            } else {
                
                cn.close();
                
                if (validacion == 0) {
                    //Inserta el registro en la base de datos
                    try {
                        
                        Connection cn2 = Conexion.conectar();
                        PreparedStatement pst2 = cn2.prepareStatement(
                            "insert into usuarios values (?,?,?,?,?,?,?,?)");
                        
                        pst2.setInt(1, 0);
                        pst2.setString(2, nombres);
                        pst2.setString(3, apellidos);
                        pst2.setString(4, celular);
                        pst2.setString(5, correo);
                        pst2.setString(6, usuario);
                        pst2.setString(7, pass);
                        pst2.setString(8, roles_string);
                       
                        pst2.executeUpdate();
                        cn2.close();
                        
                        Object[] fila = new Object[6];
                        fila[0] = nombres;
                        fila[1] = apellidos;
                        fila[2] = celular;
                        fila[3] = correo;
                        fila[4] = usuario;
                        fila[5] = roles_string;
                        PanelUsuarios.modelo.addRow(fila);
                                               
                        Limpiar();                     
                        
                        txt_nombres.setBackground(Color.green);
                        txt_apellidos.setBackground(Color.green);
                        txt_celular.setBackground(Color.green);
                        txt_correo.setBackground(Color.green);
                        txt_nombreUsuario.setBackground(Color.green);
                        txt_clave.setBackground(Color.green);              
                        
                        
                        JOptionPane.showMessageDialog(null, "Registro exitoso.");
                        this.dispose();
                        panelUsu.setVisible(true);
                        PanelUsuarios.btn_nuevoUsuario.setEnabled(true);
                        
                    } catch (SQLException e) {
                        System.err.println("Error en Registrar usuario." + e);
                        JOptionPane.showMessageDialog(null, "¡¡ERROR al registrar!!, contacte al administrador.");
                    }
                
                    } else {
                        JOptionPane.showMessageDialog(null, "Debes de llenar todos los campos.");
                        Normalizar();
                    }
            
            
            }
            
        } catch (SQLException e) {
            System.err.println("Error en validar nombre de usuario." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al comparar usuario!!, contacte al administrador.");
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txt_nombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombresKeyTyped
        //Forza aescribir en mayuscula
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txt_nombresKeyTyped

    private void txt_apellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidosKeyTyped
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txt_apellidosKeyTyped

       

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
            java.util.logging.Logger.getLogger(NuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JComboBox<String> cmb_Rol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbl_imagenDefault;
    private javax.swing.JTextField txt_apellidos;
    private javax.swing.JTextField txt_celular;
    private javax.swing.JTextField txt_clave;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_nombreUsuario;
    private javax.swing.JTextField txt_nombres;
    // End of variables declaration//GEN-END:variables

    //Metodo que limpia el formulario
    public void Limpiar(){
        txt_nombres.setText("");
        txt_apellidos.setText("");
        txt_celular.setText("");
        txt_correo.setText("");
        txt_nombreUsuario.setText("");
        txt_clave.setText("");
        cmb_Rol.setSelectedIndex(0);
    }
    
    //Metodo que normaliza el formulario
    public void Normalizar(){
        txt_nombres.setBackground(Color.WHITE);
        txt_apellidos.setBackground(Color.WHITE);
        txt_celular.setBackground(Color.WHITE);
        txt_correo.setBackground(Color.WHITE);
        txt_nombreUsuario.setBackground(Color.WHITE);
        txt_clave.setBackground(Color.WHITE);
    }
}


