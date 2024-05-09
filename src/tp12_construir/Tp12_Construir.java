
package tp12_construir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Tp12_Construir {


    public static void main(String[] args) {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            
            Connection con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/construirsa","root", "");
            
            //agregar 3 empleados
//            String sqlEmple1="INSERT INTO empleado( dni, apellido, nombre, acceso, estado) "
//                    + "VALUES ('25997','Caceres','Ricardo',1,true)";
//            
//            PreparedStatement ps= con.prepareStatement(sqlEmple1);
//            ps.executeUpdate();
//            
//            String sqlEmple2="INSERT INTO empleado( dni, apellido, nombre, acceso, estado) "
//                    + "VALUES ('25033','Caceres','Alberto',1,true)";
//            
//            PreparedStatement ps1= con.prepareStatement(sqlEmple2);
//            ps1.executeUpdate();
//            
//            String sqlEmple3="INSERT INTO empleado( dni, apellido, nombre, acceso, estado) "
//                    + "VALUES ('25000','Mamani','Susana',1,true)";
//            
//            PreparedStatement ps2= con.prepareStatement(sqlEmple3);
//            ps2.executeUpdate();
            
            //agregar 2 herramientas
            String sqlH="INSERT INTO herramienta(nombre, descripcion, stock, estado)" 
                    +"VALUES ('Taladro','con percutor','13',true)";
            
            PreparedStatement psh= con.prepareStatement(sqlH);
            psh.executeUpdate();
            
            String sqlH1="INSERT INTO herramienta(nombre, descripcion, stock, estado)" 
                    +"VALUES ('pala','ancha','113',true)";
            
            PreparedStatement psh1= con.prepareStatement(sqlH1);
            psh1.executeUpdate();
            
            String lista="SELECT * FROM herramienta WHERE stock > 10";
            PreparedStatement lisherr= con.prepareStatement(lista);
            
            ResultSet datos= lisherr.executeQuery();
            
            while (datos.next()) {
                System.out.println("Id Herramienta: "+datos.getInt("idHerramienta"));
                System.out.println("Nombre : "+datos.getString("nombre"));
                System.out.println("Descripcion : "+datos.getString("descripcion"));
                System.out.println("Stock : "+datos.getInt("stock"));
                System.out.println("Estado : "+datos.getBoolean("estado"));
            }
            
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error a cargar el driver"+ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error a cconectarse a la base de datos"+ex.getMessage());
        }
    }
    
}
