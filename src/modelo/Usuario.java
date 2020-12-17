package modelo;

import BD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author ALEJO
 */
public class Usuario {
    
    private int id;
    private String nombres;
    private String apellidos;
    private String celular;
    private String correo;
    private String nombreUsuario;
    private String clave;
    private String rol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    //Metodos
    public String toString(){
        return this.nombres;
    }
    
    //Agrega los valores de la tabla de usuarios al combobox de usuarios permitidos 
    public Vector<Usuario> mostrarUsuarios(){
        
        //Traemos los uuarios que esten disponibles
        PreparedStatement pst3 = null;
        ResultSet rs3 = null;       
        Connection cn3 = Conexion.conectar();
        
        Vector<Usuario> datos = new Vector<Usuario>();
        Usuario dat = null;

        
        try{
           pst3 = cn3.prepareStatement("select Id_usuario, Nombres from usuarios where Rol = 'Usuario'"); 
           rs3 = pst3.executeQuery();
           
           dat = new Usuario();
           dat.setId(0);
           dat.setNombres("Seleccione");
           datos.add(dat);
           
           while(rs3.next()){
               dat = new Usuario();
               dat.setId(rs3.getInt("Id_usuario"));
               dat.setNombres(rs3.getString("Nombres"));
               datos.add(dat);
           }

           rs3.close();

        }catch(SQLException ex){
            System.out.println("Error al cargar listado de usuarios" + ex.toString());
        }
        return datos;
    }
    
    //Agrega los valores de la tabla de usuarios al combobox de encargados de tarea 
    public Vector<Usuario> mostrarEncargadosDeTareas(){
        
        //Traemos los usuarios que esten disponibles
        PreparedStatement pst3 = null;
        ResultSet rs3 = null;       
        Connection cn3 = Conexion.conectar();
        
        Vector<Usuario> datos = new Vector<Usuario>();
        Usuario dat = null;

        
        try{
           pst3 = cn3.prepareStatement("select Id_usuario, Nombres from usuarios"); 
           rs3 = pst3.executeQuery();
           
           dat = new Usuario();
           dat.setId(0);
           dat.setNombres("Seleccione");
           datos.add(dat);
           
           while(rs3.next()){
               dat = new Usuario();
               dat.setId(rs3.getInt("Id_usuario"));
               dat.setNombres(rs3.getString("Nombres"));
               datos.add(dat);
           }

           rs3.close();

        }catch(SQLException ex){
            System.out.println("Error al cargar listado de encargados" + ex.toString());
        }
        return datos;
    }
    
}
