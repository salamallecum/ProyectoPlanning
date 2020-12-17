package ClasesDeApoyo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static ventanas.NuevoTablero.miembrosPermitidos;

/**
 *
 * @author ALEJO
 */
public class pruebaCodigo {
    
    public static void main(String [] args){
        
        //Codigo fecha actual
        /*
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String fecha_factura = sdf.format(date);
        System.out.print(fecha_factura);*/
        
        /**
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String fecha_ingreso = dateFormat.format(date);
        System.out.print(dateFormat.format(date));
        */
        
        System.out.println(miembrosPermitidos.size());
             
    
    
    }
}
