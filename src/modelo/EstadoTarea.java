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
public class EstadoTarea {
    
    private int id;
    private String nombreEstado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }
    
    //Metodos
    public String toString(){
        return this.nombreEstado;
    }
    
    //Agrega los valores de la tabla de estados  al combobox de estados de tarea 
    public Vector<EstadoTarea> mostrarEstadosDeTarea(){
        
        //Traemos los tipos de tarea que esten disponibles
        PreparedStatement pst3 = null;
        ResultSet rs3 = null;       
        Connection cn3 = Conexion.conectar();
        
        Vector<EstadoTarea> datos = new Vector<EstadoTarea>();
        EstadoTarea dat = null;

        
        try{
           pst3 = cn3.prepareStatement("select Id_estado, Nombre from estados"); 
           rs3 = pst3.executeQuery();
           
           dat = new EstadoTarea();
           dat.setId(0);
           dat.setNombreEstado("Seleccione");
           datos.add(dat);
           
           while(rs3.next()){
               dat = new EstadoTarea();
               dat.setId(rs3.getInt("Id_estado"));
               dat.setNombreEstado(rs3.getString("Nombre"));
               datos.add(dat);
           }

           rs3.close();

        }catch(SQLException ex){
            System.out.println("Error al cargar listado de estados de tarea" + ex.toString());
        }
        return datos;
    }
    
}
