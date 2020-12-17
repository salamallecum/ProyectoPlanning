package ventanas;

import BD.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import modelo.EstadoTarea;
import modelo.TipoDeTarea;
import modelo.Usuario;
import static ventanas.PanelTableros.Table_listaTableros;
import static ventanas.PanelTableros.modelo;

import static ventanas.PanelTableros.tablero_update;

/**
 *
 * @author ALEJO
 */
public class DetalleTablero extends javax.swing.JFrame {

    String nombreDelTablero;
    String usuarioQuecreaTarea;
    int Fila;
    public static DefaultTableModel modeloTabla;
    int id_tablero;
    
    /**
     * Creates new form DetalleTablero
     */
    public DetalleTablero() {
        initComponents();
        nombreDelTablero = PanelTableros.tablero_update;
        usuarioQuecreaTarea = Login.usuario;
        
        setSize(958, 704);
        setResizable(false);
        setTitle("GESTOR DE OPERACIONES - Tablero de " + nombreDelTablero);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        lbl_nombreTablero.setText(nombreDelTablero);
        
        //Declaramos un objeto tipo TipoDeTarea y se lo aprovisionamos al combobox de Tipo de tarea
        TipoDeTarea tipTarea = new TipoDeTarea();
        DefaultComboBoxModel modeloTiposTarea = new DefaultComboBoxModel(tipTarea.mostrarTiposDeTarea());
        cmb_tipoTarea.setModel(modeloTiposTarea);
        
        //Declaramos un objeto tipo Usuario y se lo aprovisionamos al combobox de encargado
        EstadoTarea est = new EstadoTarea();
        DefaultComboBoxModel modeloEstados = new DefaultComboBoxModel(est.mostrarEstadosDeTarea());
        cmb_estados.setModel(modeloEstados);
        
        //Traemos el id del tablero en cuestion con ayudsa del nombre del tablero
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                "select Id_tablero from tableros where Nombre_tablero = '" + nombreDelTablero + "'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                id_tablero = rs.getInt("Id_tablero");
                cn.close();
            } 
        } catch (SQLException e) {
            System.err.println("Error en consultar id de tablero." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al comparar usuario!!, contacte al administrador.");
        }
           
        //Traemos el contenido asociado al id consultado en la tabla tareas de la BD
        try {
            modeloTabla = new DefaultTableModel();
            Table_listTareas.setModel(modeloTabla);
            
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                        "select Tipo_tarea, Nombre_tarea, Encargado, Estado, Fecha_Plazo from tareas where Id_Tablero= '" + id_tablero + "'");
            
            ResultSet rs = pst.executeQuery();
            
            ResultSetMetaData rsmd = rs.getMetaData();
            int cantidadColumnas = rsmd.getColumnCount();
            
            modeloTabla.addColumn("Tipo de tarea");
            modeloTabla.addColumn("Nombre");
            modeloTabla.addColumn("Encargado");
            modeloTabla.addColumn("Estado");
            modeloTabla.addColumn("Plazo");
                                  
            while (rs.next()) {
                
                Object[] filas = new Object[cantidadColumnas];
                
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modeloTabla.addRow(filas);
                }
                cn.close();        
            
            } catch (SQLException e) {
                System.err.println("Error al llenar tabla de tareas." + e);
                JOptionPane.showMessageDialog(null, "Error al mostrar información, ¡Contacte al administrador!");
            }

            //Agregamos la funcion de ver informacion del cliente al hacer click sobre el registro de la tabla
            Table_listTareas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                int fila_point = Table_listTareas.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if(fila_point > -1){
                    tablero_update = (String) modeloTabla.getValueAt(fila_point, columna_point);
                    InformacionTarea info_tarea = new InformacionTarea();
                    info_tarea.setVisible(true);
                }

            }
        });
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/board.png"));
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

        lbl_nombreTablero = new javax.swing.JLabel();
        btn_editar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        btn_nvaTarea = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmb_estados = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txt_nombreTarea = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmb_tipoTarea = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        jDate_plazo = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_listTareas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        lbl_nombreTablero.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_nombreTablero.setText("Nombre del Tablero");

        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-validated_40458.png"))); // NOI18N
        btn_editar.setText("Editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ic_delete_128_28267.png"))); // NOI18N
        btn_Eliminar.setText("Eliminar");
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });

        btn_nvaTarea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/notepad_bloc_notes_15548.png"))); // NOI18N
        btn_nvaTarea.setText("Nueva Tarea");
        btn_nvaTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nvaTareaActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar por", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Estado:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nombre tarea:");

        txt_nombreTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreTareaActionPerformed(evt);
            }
        });
        txt_nombreTarea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreTareaKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Tipo tarea:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Plazo:");

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Search_find_locate_1542.png"))); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        jDate_plazo.setDateFormatString("yyyy/MM/dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmb_estados, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txt_nombreTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cmb_tipoTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDate_plazo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_buscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmb_estados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_nombreTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cmb_tipoTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDate_plazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Table_listTareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tipo de tarea", "Nombre", "Encargado", "Estado", "Plazo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table_listTareas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(lbl_nombreTablero)
                        .addGap(129, 129, 129)
                        .addComponent(btn_editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Eliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btn_nvaTarea)
                        .addGap(50, 50, 50)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_nombreTablero)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_nvaTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Metodo del boton Editar
    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        btn_editar.setEnabled(false);
        new EditarTablero().setVisible(true);
    }//GEN-LAST:event_btn_editarActionPerformed

    //Metodo del boton Eliminar
    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
        btn_Eliminar.setEnabled(false);
        Fila = Table_listaTableros.getSelectedRow();
        int cantidadFilas = Table_listaTableros.getSelectedRowCount();

        int decision = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar?", "Eliminar tablero", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if(decision == JOptionPane.YES_OPTION){

            PreparedStatement ps = null;
            try{
                Connection cn = Conexion.conectar();
                String nombre = Table_listaTableros.getValueAt(Fila, 0).toString();

                ps = cn.prepareStatement("delete from tableros where Nombre_tablero=?");
                ps.setString(1, nombre);
                ps.execute();

                //Eliminamos los permisos exitentes para dicho tablero en la tabla de permisos
                try{
                    Connection cn3 = Conexion.conectar();
                    PreparedStatement pst3 = cn3.prepareStatement("delete from permisos where Nombre_tablero='"+nombre+"'");

                    pst3.executeUpdate();
                    cn3.close();

                }catch(SQLException e){
                    System.err.println("Error al eliminar los permisos" + e);
                    JOptionPane.showMessageDialog(null, "¡¡ERROR al eliminar!!, contacte al administrador.");
                }

                JOptionPane.showMessageDialog(null, "El tablero de nombre: " + nombre + " ha sido eliminado");
                dispose();
                modelo.removeRow(Fila);

            }catch(SQLException e){
                System.err.println("Error al Eliminar tablero." + e);
                JOptionPane.showMessageDialog(null, "¡¡ERROR al actualizar!!, contacte al administrador.");
            }

        }else if(decision == JOptionPane.NO_OPTION){
            btn_Eliminar.setEnabled(true);
        }
    }//GEN-LAST:event_btn_EliminarActionPerformed

    //Metodo boton "Nueva tarea"
    private void btn_nvaTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nvaTareaActionPerformed
        btn_nvaTarea.setEnabled(false);
        new NuevaTarea().setVisible(true);
    }//GEN-LAST:event_btn_nvaTareaActionPerformed

    private void txt_nombreTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreTareaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreTareaActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void txt_nombreTareaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreTareaKeyTyped
        //Forza a escribir en mayuscula
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            evt.setKeyChar(Character.toUpperCase(c));
            
        }
    }//GEN-LAST:event_txt_nombreTareaKeyTyped

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
            java.util.logging.Logger.getLogger(DetalleTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalleTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalleTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalleTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalleTablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable Table_listTareas;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_buscar;
    public static javax.swing.JButton btn_editar;
    public static javax.swing.JButton btn_nvaTarea;
    private javax.swing.JComboBox<String> cmb_estados;
    private javax.swing.JComboBox<String> cmb_tipoTarea;
    private com.toedter.calendar.JDateChooser jDate_plazo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lbl_nombreTablero;
    private javax.swing.JTextField txt_nombreTarea;
    // End of variables declaration//GEN-END:variables
}
