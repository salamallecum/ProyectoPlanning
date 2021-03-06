package ventanas;

import BD.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.WindowConstants;

/**
 *
 * @author ALEJO
 */
public class MenuAdministrador extends javax.swing.JFrame implements Runnable{

    String user, nombre_usuario;
    String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread h1;
    
    /**
     * Creates new form MenuAdministrador
     */
    String fechaHoraSalida = "";
    
    public static PanelUsuarios panelUsu;
    public static PanelTableros panelTablero;
    //PanelReportes panelReport;
    //PanelVehiculos panelVehi;
    //PanelParametros panelEmail;
    
    public MenuAdministrador() {
        initComponents();
        user = Login.usuario;
        
        setSize(1155,710);
        setResizable(false);
        setTitle("GESTOR DE OPERACIONES - MORE SECURITY");
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        
        //Hilo que ejecuta el reloj en tiempo real
        h1 = new Thread(this);
        h1.start();
        
        //Inicio de color a los botones
        btn_Usuarios.setBackground(Color.WHITE); 
        btn_tableros.setBackground(Color.WHITE);
        btn_mensajes.setBackground(Color.WHITE);
        btn_parametros.setBackground(Color.WHITE);
        
        //Carga de paneles
        panelUsu = new PanelUsuarios();
        panelUsu.setBounds(289,76,866,580);
        add(panelUsu);
        panelUsu.setVisible(false);
        
        
        panelTablero = new PanelTableros();
        panelTablero.setBounds(289,76,866,580);
        add(panelTablero);
        panelTablero.setVisible(false);
        /*
        panelReport = new PanelReportes();
        panelReport.setBounds(300,0,473,400);
        add(panelReport);
        panelReport.setVisible(false);
        */
        
        
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
            "select Nombres from usuarios where Usuario = '" + user + "'");
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                nombre_usuario = rs.getString("Nombres");
                lbl_nombreUsuario.setText(nombre_usuario);
            }
        } catch (Exception e) {
            System.err.println("Error en conexión desde la interfaz Administrador");
        }
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/icono.png"));
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

        Panel_Administrador = new javax.swing.JPanel();
        btn_Usuarios = new javax.swing.JButton();
        btn_tableros = new javax.swing.JButton();
        btn_mensajes = new javax.swing.JButton();
        lbl_Imagen = new javax.swing.JLabel();
        btn_parametros = new javax.swing.JButton();
        Panel_Sesion = new javax.swing.JPanel();
        lbl_nombreUsuario = new javax.swing.JLabel();
        btn_cerrarSesion = new javax.swing.JButton();
        Pnl_fotoDelPerfil = new javax.swing.JPanel();
        lbl_fotodePerfilDefault = new javax.swing.JLabel();
        txt_Reloj = new javax.swing.JTextField();
        lbl_bienvenida = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        Panel_Administrador.setBackground(new java.awt.Color(204, 0, 0));

        btn_Usuarios.setBackground(new java.awt.Color(255, 255, 255));
        btn_Usuarios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Usuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/User.png"))); // NOI18N
        btn_Usuarios.setText("Usuarios");
        btn_Usuarios.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_Usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UsuariosActionPerformed(evt);
            }
        });

        btn_tableros.setBackground(new java.awt.Color(255, 255, 255));
        btn_tableros.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_tableros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/board.png"))); // NOI18N
        btn_tableros.setText("Tableros");
        btn_tableros.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_tableros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tablerosActionPerformed(evt);
            }
        });

        btn_mensajes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_mensajes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/show-text-message_icon-icons.com_52478.png"))); // NOI18N
        btn_mensajes.setText("Mensajes");
        btn_mensajes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_mensajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mensajesActionPerformed(evt);
            }
        });

        lbl_Imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoPrincipal.jpg"))); // NOI18N
        lbl_Imagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ImagenMouseClicked(evt);
            }
        });

        btn_parametros.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_parametros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Ajuste.png"))); // NOI18N
        btn_parametros.setText("Parámetros");
        btn_parametros.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_parametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_parametrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_AdministradorLayout = new javax.swing.GroupLayout(Panel_Administrador);
        Panel_Administrador.setLayout(Panel_AdministradorLayout);
        Panel_AdministradorLayout.setHorizontalGroup(
            Panel_AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_AdministradorLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(Panel_AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_Imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Usuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_tableros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_mensajes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_parametros, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        Panel_AdministradorLayout.setVerticalGroup(
            Panel_AdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_AdministradorLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lbl_Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_Usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btn_tableros, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btn_mensajes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btn_parametros, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(232, Short.MAX_VALUE))
        );

        Panel_Sesion.setBackground(new java.awt.Color(204, 0, 0));

        lbl_nombreUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_nombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nombreUsuario.setText("Nombre de Usuario");

        btn_cerrarSesion.setText("Cerrar sesión");
        btn_cerrarSesion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_cerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarSesionActionPerformed(evt);
            }
        });

        lbl_fotodePerfilDefault.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuarioDefa.png"))); // NOI18N
        lbl_fotodePerfilDefault.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout Pnl_fotoDelPerfilLayout = new javax.swing.GroupLayout(Pnl_fotoDelPerfil);
        Pnl_fotoDelPerfil.setLayout(Pnl_fotoDelPerfilLayout);
        Pnl_fotoDelPerfilLayout.setHorizontalGroup(
            Pnl_fotoDelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_fotoDelPerfilLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_fotodePerfilDefault))
        );
        Pnl_fotoDelPerfilLayout.setVerticalGroup(
            Pnl_fotoDelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_fotodePerfilDefault, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txt_Reloj.setEditable(false);
        txt_Reloj.setBackground(new java.awt.Color(0, 255, 0));
        txt_Reloj.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_Reloj.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Reloj.setToolTipText("");
        txt_Reloj.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_Reloj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_RelojActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_SesionLayout = new javax.swing.GroupLayout(Panel_Sesion);
        Panel_Sesion.setLayout(Panel_SesionLayout);
        Panel_SesionLayout.setHorizontalGroup(
            Panel_SesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_SesionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Panel_SesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_Reloj, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Panel_SesionLayout.createSequentialGroup()
                        .addComponent(Pnl_fotoDelPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_nombreUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        Panel_SesionLayout.setVerticalGroup(
            Panel_SesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_SesionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_SesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Pnl_fotoDelPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nombreUsuario)
                    .addComponent(btn_cerrarSesion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Reloj, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        lbl_bienvenida.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        lbl_bienvenida.setForeground(new java.awt.Color(255, 0, 0));
        lbl_bienvenida.setText("Bienvenido");

        jMenu1.setText("Sistema");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel_Administrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Panel_Sesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(lbl_bienvenida)
                        .addGap(0, 334, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Administrador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel_Sesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160)
                .addComponent(lbl_bienvenida)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Metodo boton "Cerrar sesion"
    private void btn_cerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarSesionActionPerformed
        dispose();
        
        //Obtenemos la fecha y hora de salida en el sistema
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        fechaHoraSalida = dateFormat.format(date);
        System.out.print("Fecha de salida: " + dateFormat.format(date) + "\n");
        
        new Login().setVisible(true);
    }//GEN-LAST:event_btn_cerrarSesionActionPerformed

    //Metodo boton modulo "Usuarios"
    private void btn_UsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UsuariosActionPerformed
        
        lbl_bienvenida.setVisible(false);
           
        btn_Usuarios.setBackground(Color.GRAY); 
        btn_tableros.setBackground(Color.WHITE);
        btn_mensajes.setBackground(Color.WHITE);
        
       setSize(1150,700);
        panelUsu.setVisible(true);
        panelTablero.setVisible(false);
        /*
        panelVehi.setVisible(false);
        */
        repaint();
        
    }//GEN-LAST:event_btn_UsuariosActionPerformed
    
    private void txt_RelojActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_RelojActionPerformed
        
    }//GEN-LAST:event_txt_RelojActionPerformed

    //Metodo boton modulo "Caja"
    private void btn_tablerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tablerosActionPerformed
        lbl_bienvenida.setVisible(false);
        
        
        btn_Usuarios.setBackground(Color.WHITE); 
        btn_tableros.setBackground(Color.GRAY);
        btn_mensajes.setBackground(Color.WHITE);
        
        setSize(1150,700);
        panelUsu.setVisible(false);
        panelTablero.setVisible(true);
        /*
        panelVehi.setVisible(false);
        */
        repaint();
    }//GEN-LAST:event_btn_tablerosActionPerformed

    //Metodo boton modulo "Reportes"
    private void btn_mensajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mensajesActionPerformed
        lbl_bienvenida.setVisible(false);
        
        
        btn_Usuarios.setBackground(Color.WHITE); 
        btn_tableros.setBackground(Color.WHITE);
        btn_mensajes.setBackground(Color.WHITE);
        
        
        
    }//GEN-LAST:event_btn_mensajesActionPerformed

    private void btn_parametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_parametrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_parametrosActionPerformed

    private void lbl_ImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ImagenMouseClicked
        lbl_bienvenida.setVisible(true);
        
        setSize(1150,700);
        panelUsu.setVisible(false);
        panelTablero.setVisible(false);
        repaint();
    }//GEN-LAST:event_lbl_ImagenMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Administrador;
    private javax.swing.JPanel Panel_Sesion;
    private javax.swing.JPanel Pnl_fotoDelPerfil;
    private javax.swing.JButton btn_Usuarios;
    private javax.swing.JButton btn_cerrarSesion;
    private javax.swing.JButton btn_mensajes;
    private javax.swing.JButton btn_parametros;
    private javax.swing.JButton btn_tableros;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lbl_Imagen;
    private javax.swing.JLabel lbl_bienvenida;
    private javax.swing.JLabel lbl_fotodePerfilDefault;
    private javax.swing.JLabel lbl_nombreUsuario;
    private javax.swing.JTextField txt_Reloj;
    // End of variables declaration//GEN-END:variables
         
    //Metodo que calcula la hora
    private void calcularHora() {
        
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();
        
        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"AM":"PM";
        
        if(ampm.equals("PM")){
            int h = calendario.get(Calendar.HOUR_OF_DAY)-12;
            hora = h>9?""+h:"0"+h;
        }else{
            hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);
    }

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
            while(ct ==h1){
                calcularHora();
                txt_Reloj.setText(hora+":"+minutos+":"+segundos+" "+ampm);
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){}
            }
    }
}
