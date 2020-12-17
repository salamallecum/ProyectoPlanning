package ventanas;

import BD.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;
import static ventanas.MenuAdministrador.panelTablero;


/**
 *
 * @author ALEJO
 */
public class EditarTablero extends javax.swing.JFrame {
      
    String usuario = "", tablero_actualizado="";
    int ID;
    javax.swing.JTable tablaTableros;
    int FilaAnterior;
    boolean usoIngresoTableroPrincipal = false;
    boolean usoIngresoTableroCompartido = false;
    Usuario miembro;
    public static Vector <Usuario> miembrosPermitidos = new Vector<Usuario>();
    DefaultListModel modelo;
    DefaultTableModel modeloTabla;
    
    /**
     * Creates new form nuevoUsuario
     */
    public EditarTablero() {
        usuario = Login.usuario;
        tablero_actualizado = PanelTableros.tablero_update;
        tablaTableros = PanelTableros.Table_listaTableros;
        modeloTabla = PanelTableros.modelo;
        
        initComponents();
        setSize(482, 408);
        setResizable(false);
        setLocationRelativeTo(null);
        
        limpiarListadoDeMiembros();
        
        //Declaramos un objeto tipo Usuario y se lo aprovisionamos a su combobox
        Usuario usu = new Usuario();
        DefaultComboBoxModel modeloMiembros = new DefaultComboBoxModel(usu.mostrarUsuarios());
        cmb_miembros.setModel(modeloMiembros);
        
        //Consultamos si el tablero es principal o compartido, para asi hacer la consulta de datos que convenga
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                "select Tipo from tableros where Nombre_tablero = '" + tablero_actualizado + "' AND Tipo='PRINCIPAL'");
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
        
                //Hace la consulta de registros pertenecientes al tablero PRINCIPAL a la base de datos
                try {
                    Connection cn1 = Conexion.conectar();
                    PreparedStatement pst1 = cn1.prepareStatement(
                        "select * from tableros where Nombre_tablero = '" + tablero_actualizado + "'");
                    ResultSet rs1 = pst1.executeQuery();

                    if(rs1.next()){
                        ID = rs1.getInt("Id_tablero");
                        txt_nombreTablero.setText(rs1.getString("Nombre_tablero"));
                        cmb_tipoTablero.setSelectedItem(rs1.getString("Tipo"));
                    }
                    cn1.close();
                } catch (SQLException e) {
                    System.err.println("Error en cargar tablero principal. " + e);
                    JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!!, contacte al administrador.");
                }
            }else{
                //Hace la consulta de registros pertenecientes al tablero COMPARTIDO a la base de datos
                try {
                    Connection cn2 = Conexion.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement(
                        "select * from tableros where Nombre_tablero = '" + tablero_actualizado + "' AND Tipo='COMPARTIDO'");
                    ResultSet rs2 = pst2.executeQuery();

                    if(rs2.next()){
                        ID = rs2.getInt("Id_tablero");
                        txt_nombreTablero.setText(rs2.getString("Nombre_tablero"));
                        cmb_tipoTablero.setSelectedItem(rs2.getString("Tipo"));
                        
                        //Hace la consulta de los permisos pertenecientes al tablero COMPARTIDO a la base de datos
                        try {
                            Connection cn3 = Conexion.conectar();
                            PreparedStatement pst3 = cn3.prepareStatement(
                                "select Nombre_usuario from permisos where Nombre_tablero = '" + tablero_actualizado + "' Tiene_permiso='Si'");
                            ResultSet rs3 = pst3.executeQuery();

                            if(rs3.next()){
                                
                                
                                
                            }
                            cn3.close();
                        } catch (SQLException e) {
                            System.err.println("Error en cargar tablero compartido. " + e);
                            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!!, contacte al administrador.");
                        }
                    }
                    cn2.close();
                } catch (SQLException e) {
                    System.err.println("Error en cargar tablero compartido. " + e);
                    JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!!, contacte al administrador.");
                }
            }
            
            
            } catch (SQLException e) {
                    System.err.println("Error en cargar usuario. " + e);
                    JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!!, contacte al administrador.");
                }
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
        txt_nombreTablero = new javax.swing.JTextField();
        btn_cancelar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        cmb_tipoTablero = new javax.swing.JComboBox<>();
        cmb_miembros = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        List_usuariosAutorizados = new javax.swing.JList<>();
        btn_limpiarLista = new javax.swing.JButton();
        btn_remover = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nombre de Tablero:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Tipo de Tablero:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Miembros:");

        txt_nombreTablero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreTableroKeyTyped(evt);
            }
        });

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

        cmb_tipoTablero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "PRINCIPAL", "COMPARTIDO" }));
        cmb_tipoTablero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_tipoTableroItemStateChanged(evt);
            }
        });

        cmb_miembros.setEnabled(false);
        cmb_miembros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_miembrosItemStateChanged(evt);
            }
        });

        List_usuariosAutorizados.setEnabled(false);
        jScrollPane1.setViewportView(List_usuariosAutorizados);

        btn_limpiarLista.setText("Limpiar");
        btn_limpiarLista.setEnabled(false);
        btn_limpiarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarListaActionPerformed(evt);
            }
        });

        btn_remover.setText("Remover");
        btn_remover.setEnabled(false);
        btn_remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removerActionPerformed(evt);
            }
        });

        btn_agregar.setText("Agregar");
        btn_agregar.setEnabled(false);
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nombreTablero, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_tipoTablero, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cmb_miembros, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_limpiarLista)
                            .addComponent(btn_remover)
                            .addComponent(btn_agregar))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_guardar)
                .addGap(18, 18, 18)
                .addComponent(btn_cancelar)
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(txt_nombreTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmb_tipoTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_miembros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_remover, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_limpiarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Metodo del boton cancelar
    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        DetalleTablero.btn_editar.setEnabled(true);
        dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    //Metodo boton Guardar
    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        
        if(usoIngresoTableroPrincipal == false && usoIngresoTableroCompartido == false){
            cmb_tipoTablero.setBackground(Color.red);
            txt_nombreTablero.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Diligencie el formulario por favor.");
            NormalizarCasoTableroPrincipal();
        }
        
        if(usoIngresoTableroPrincipal == true){
            actualizarATableroPrincipal();
                   
        }if(usoIngresoTableroCompartido == true){
            actualizarATableroCompartido();
            
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txt_nombreTableroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreTableroKeyTyped
        //Forza aescribir en mayuscula
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txt_nombreTableroKeyTyped

    //Metodo que habilita el combobox de miembros
    private void cmb_tipoTableroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_tipoTableroItemStateChanged
        String tipTablero_string = (String)cmb_tipoTablero.getSelectedItem();
        
        if(tipTablero_string.equals("Seleccione")){
            cmb_miembros.setEnabled(false);
            btn_limpiarLista.setEnabled(false);
            btn_remover.setEnabled(false);
            btn_agregar.setEnabled(false);
            List_usuariosAutorizados.setEnabled(false);
            
            usoIngresoTableroPrincipal = false;
            usoIngresoTableroCompartido = false;
        } 
        
        if(tipTablero_string.equals("COMPARTIDO")){
            cmb_miembros.setEnabled(true);
            btn_limpiarLista.setEnabled(true);
            btn_remover.setEnabled(true);
            btn_agregar.setEnabled(true);
            List_usuariosAutorizados.setEnabled(true);
            
            usoIngresoTableroCompartido = true;
            usoIngresoTableroPrincipal = false;
        }
        if(tipTablero_string.equals("PRINCIPAL")){
            cmb_miembros.setEnabled(false);
            btn_limpiarLista.setEnabled(false);
            btn_remover.setEnabled(false);
            btn_agregar.setEnabled(false);
            List_usuariosAutorizados.setEnabled(false);
            
            usoIngresoTableroPrincipal = true;
            usoIngresoTableroCompartido = false;
        }      
    }//GEN-LAST:event_cmb_tipoTableroItemStateChanged

    private void cmb_miembrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_miembrosItemStateChanged
            
    }//GEN-LAST:event_cmb_miembrosItemStateChanged

    //Metodo del boton Agregar
    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        
        miembro = (Usuario)cmb_miembros.getSelectedItem();
        int miembroValido = miembro.getId();
        String nombreMiembro = miembro.getNombres();
        
        Usuario usuarioPermitido = new Usuario();
        usuarioPermitido.setId(miembroValido);
        usuarioPermitido.setNombres(nombreMiembro);
        
                
        if(miembroValido == 0){
            JOptionPane.showMessageDialog(null, "Seleccione un miembro valido.");
        }else{
            modelo = (DefaultListModel)List_usuariosAutorizados.getModel();
            modelo.addElement(miembro);
            miembrosPermitidos.add(usuarioPermitido);
            System.out.println(miembrosPermitidos);           
        }       
    }//GEN-LAST:event_btn_agregarActionPerformed

    //Metodo del boton remover
    private void btn_removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removerActionPerformed
       
         modelo = (DefaultListModel)List_usuariosAutorizados.getModel();
         int miembroAEliminar = List_usuariosAutorizados.getSelectedIndex();
         
         int contador = 0;
         miembro = (Usuario)cmb_miembros.getSelectedItem();
         int miembroValido = miembro.getId();
                 
         modelo.remove(miembroAEliminar);
         miembrosPermitidos.remove(miembroAEliminar);
         
         miembro.setId(contador + 1);
         
         System.out.println(miembrosPermitidos);
         
    }//GEN-LAST:event_btn_removerActionPerformed

    //Metodo del boton limpiar
    private void btn_limpiarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarListaActionPerformed
        limpiarListadoDeMiembros();
        miembrosPermitidos.removeAllElements();
       
        int contador = 0;
        miembro = (Usuario)cmb_miembros.getSelectedItem();
        int IdMiembro = miembro.getId();
        
        miembro.setId(contador + 1);
                
        System.out.println(miembrosPermitidos);
    }//GEN-LAST:event_btn_limpiarListaActionPerformed

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
            java.util.logging.Logger.getLogger(EditarTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new EditarTablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> List_usuariosAutorizados;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_limpiarLista;
    private javax.swing.JButton btn_remover;
    private javax.swing.JComboBox<String> cmb_miembros;
    private javax.swing.JComboBox<String> cmb_tipoTablero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_nombreTablero;
    // End of variables declaration//GEN-END:variables

    //Metodo que registra un tablero principal
    public void actualizarATableroPrincipal(){
        
        int tipoTablero_cmb, validacion = 0;
        String nombreTablero, tipTablero_string = "";
        
        nombreTablero = txt_nombreTablero.getText().trim();
        tipoTablero_cmb = cmb_tipoTablero.getSelectedIndex() + 1;
        
        if(nombreTablero.equals("")){
            txt_nombreTablero.setBackground(Color.red);
            validacion++;
        }
        
        if(tipoTablero_cmb == 1){
            tipTablero_string = "Seleccione";
            validacion++;
        }        
        if(tipoTablero_cmb == 2){
            tipTablero_string = "PRINCIPAL";
        }if(tipoTablero_cmb == 3){
            tipTablero_string = "COMPARTIDO";
        } 
        
        //Valida que el tablero ingresado no exista previamente en la BD
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                "select Nombre_tablero from tableros where Nombre_tablero = '" + nombreTablero + "'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                txt_nombreTablero.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "El tablero indicado ya existe.");
                cn.close();
            } else {
                
                cn.close();
                
                if (validacion == 0) {
                    //Actualiza el registro en la base de datos
                    FilaAnterior = tablaTableros.getSelectedRow();
                    String nombre = tablaTableros.getValueAt(FilaAnterior, 0).toString();
            
                    try{
                        Connection cn3 = Conexion.conectar();
                        PreparedStatement pst3 = cn3.prepareStatement("update tableros set Nombre_tablero ='"+txt_nombreTablero.getText()+"',Tipo='"+tipTablero_string+"'where Id_tablero ='"+ID+"'");

                        pst3.executeUpdate();
                        cn3.close();
                
                        Object Fila[] = new Object[2];
                        Fila[0] = txt_nombreTablero.getText();
                        Fila[1] = tipTablero_string;
                        
                        modeloTabla.addRow(Fila);
                        modeloTabla.removeRow(FilaAnterior);
                        
                        txt_nombreTablero.setBackground(Color.GREEN);
                        cmb_tipoTablero.setBackground(Color.GREEN);

                        System.out.println("Tablero actualizado satisfactoriamente");
                        JOptionPane.showMessageDialog(null, "Tablero actualizado satisfactoriamente.");
                        DetalleTablero.lbl_nombreTablero.setText(nombreTablero);
                        this.dispose();
                

                    }catch(SQLException e){
                        System.err.println("Error al Actualizar el usuario." + e);
                        JOptionPane.showMessageDialog(null, "¡¡ERROR al actualizar!!, contacte al administrador.");
                    }    
        
                } else {
                    JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
                    NormalizarCasoTableroPrincipal();
                }                                      
            }     
        } catch (SQLException e) {
            System.err.println("Error en validar nombre de tablero." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al comparar tablero!!, contacte al administrador.");
        }
    }
    
    //Metodo que limpia el formulario en caso de ingresar tablero principal
    public void LimpiarEnCasoTableroPrincipal(){
        txt_nombreTablero.setText("");
        cmb_tipoTablero.setSelectedIndex(0);
    }
    
    //Metodo que normaliza el formulario en caso tablero compartido
    public void NormalizarCasoTableroPrincipal(){
        txt_nombreTablero.setBackground(Color.WHITE);
        cmb_tipoTablero.setBackground(Color.WHITE);    
    }
    
    
    //Metodo que registra un tablero compartido
    public void actualizarATableroCompartido(){
        
        int tipoTablero_cmb, validacion = 0;
        String nombreTablero, tipTablero_string = "";
        
        nombreTablero = txt_nombreTablero.getText().trim();
        tipoTablero_cmb = cmb_tipoTablero.getSelectedIndex() + 1;
        
        if(nombreTablero.equals("")){
            txt_nombreTablero.setBackground(Color.red);
            validacion++;
        }
        
        if(tipoTablero_cmb == 1){
            tipTablero_string = "Seleccione";
            validacion++;
        }        
        if(tipoTablero_cmb == 2){
            tipTablero_string = "PRINCIPAL";
        }if(tipoTablero_cmb == 3){
            tipTablero_string = "COMPARTIDO";
        } 
        
        if(miembrosPermitidos.isEmpty()){
            cmb_miembros.setBackground(Color.red);
            List_usuariosAutorizados.setBackground(Color.red);
            validacion++;
        }
        
        //Valida que el tablero ingresado no exista previamente en la BD
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                "select Nombre_tablero from tableros where Nombre_tablero = '" + nombreTablero + "'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                txt_nombreTablero.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "El tablero indicado ya existe.");
                cn.close();
                
            } else {
                
                cn.close();
                
                if (validacion == 0) {
                    //Actualiza el registro en la base de datos Tableros
                    FilaAnterior = tablaTableros.getSelectedRow();
                    String nombre = tablaTableros.getValueAt(FilaAnterior, 0).toString();
            
                    try{
                        Connection cn3 = Conexion.conectar();
                        PreparedStatement pst3 = cn3.prepareStatement("update tableros set Nombre_tablero ='"+txt_nombreTablero.getText()+"',Tipo='"+tipTablero_string+"'where Id_tablero ='"+ID+"'");

                        pst3.executeUpdate();
                        cn3.close();
                        
                        //Actualizamos los permisos de los miembros en la tabla permisos
                        /*
                        try{
                            Connection cn4 = Conexion.conectar();
                            PreparedStatement pst4 = cn4.prepareStatement("update tableros set Nombre_tablero ='"+txt_nombreTablero.getText()+"',Tipo='"+tipTablero_string+"'where Id_tablero ='"+ID+"'");

                            pst4.executeUpdate();
                            cn4.close();
                        }catch(SQLException e){
                            System.err.println("Error al Actualizar el usuario." + e);
                            JOptionPane.showMessageDialog(null, "¡¡ERROR al actualizar!!, contacte al administrador.");
                        }
                        */
                
                        Object Fila[] = new Object[2];
                        Fila[0] = txt_nombreTablero.getText();
                        Fila[1] = tipTablero_string;
                        
                        modeloTabla.addRow(Fila);
                        modeloTabla.removeRow(FilaAnterior);
                        
                        txt_nombreTablero.setBackground(Color.GREEN);
                        cmb_tipoTablero.setBackground(Color.GREEN);
                        cmb_miembros.setBackground(Color.GREEN);
                        List_usuariosAutorizados.setBackground(Color.GREEN);
                        
                        System.out.println("Tablero actualizado satisfactoriamente");
                        JOptionPane.showMessageDialog(null, "Tablero actualizado satisfactoriamente.");
                        DetalleTablero.lbl_nombreTablero.setText(nombreTablero);
                        this.dispose();
                

                    }catch(SQLException e){
                        System.err.println("Error al Actualizar el usuario." + e);
                        JOptionPane.showMessageDialog(null, "¡¡ERROR al actualizar!!, contacte al administrador.");
                    }    
        
                } else {
                    JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
                    NormalizarCasoTableroPrincipal();
                }                                      
            }     
        } catch (SQLException e) {
            System.err.println("Error en validar nombre de tablero." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al comparar tablero!!, contacte al administrador.");
        }

    }
    
    //Metodo que limpia el formulario en caso de ingresar tablero principal
    public void LimpiarEnCasoTableroCompartido(){
        txt_nombreTablero.setText("");
        cmb_tipoTablero.setSelectedIndex(0);
        cmb_miembros.setSelectedIndex(0);
        List_usuariosAutorizados.removeAll();
    }
    
    //Metodo que normaliza el formulario en caso tablero compartido
    public void NormalizarCasoTableroCompartido(){
        txt_nombreTablero.setBackground(Color.WHITE);
        cmb_tipoTablero.setBackground(Color.WHITE); 
        cmb_miembros.setBackground(Color.WHITE);
        List_usuariosAutorizados.setBackground(Color.WHITE);
    }
    
    public DefaultListModel limpiarListadoDeMiembros(){
        
        modelo = new DefaultListModel();
        List_usuariosAutorizados.setModel(modelo);
        return modelo;
    }
    
    
}


