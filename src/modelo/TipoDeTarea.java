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
public class TipoDeTarea {
    
    private int id;
    private String tipoTarea;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoTarea() {
        return tipoTarea;
    }

    public void setTipoTarea(String tipoTarea) {
        this.tipoTarea = tipoTarea;
    }
    
    //Metodos
    public String toString(){
        return this.tipoTarea;
    }
    
    //Agrega los valores de la tabla de tipos de tarea al combobox de tipos de tarea 
    public Vector<TipoDeTarea> mostrarTiposDeTarea(){
        
        //Traemos los tipos de tarea que esten disponibles
        PreparedStatement pst3 = null;
        ResultSet rs3 = null;       
        Connection cn3 = Conexion.conectar();
        
        Vector<TipoDeTarea> datos = new Vector<TipoDeTarea>();
        TipoDeTarea dat = null;

        
        try{
           pst3 = cn3.prepareStatement("select Id_tipoTarea, Nombre from tipos_tarea"); 
           rs3 = pst3.executeQuery();
           
           dat = new TipoDeTarea();
           dat.setId(0);
           dat.setTipoTarea("Seleccione");
           datos.add(dat);
           
           while(rs3.next()){
               dat = new TipoDeTarea();
               dat.setId(rs3.getInt("Id_tipoTarea"));
               dat.setTipoTarea(rs3.getString("Nombre"));
               datos.add(dat);
           }

           rs3.close();

        }catch(SQLException ex){
            System.out.println("Error al cargar listado de tipos de tarea" + ex.toString());
        }
        return datos;
    }
    
}
