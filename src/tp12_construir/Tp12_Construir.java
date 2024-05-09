
package tp12_construir;


import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;


public class Tp12_Construir {


    public static void main(String[] args) {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Driver cargado");
            String url="jdbc:mariadb://localhost:3308/construirsa";
            String usuario="root";
            String contraseña="";
            Connection con=DriverManager.getConnection(url,usuario,contraseña);
            System.out.println("Conectado a la base de datos");
            //agregar 3 empleados
            String sqlEmple1="INSERT INTO empleado( dni, apellido, nombre, acceso, estado) "
                    + "VALUES ('25997','Caceres','Ricardo',1,true)";
            
            PreparedStatement ps= con.prepareStatement(sqlEmple1);
            ps.executeUpdate();
            
            
            String sqlEmple2="INSERT INTO empleado( dni, apellido, nombre, acceso, estado) "
                    + "VALUES ('25033','Caceres','Alberto',1,true)";
            
            PreparedStatement ps1= con.prepareStatement(sqlEmple2);
            ps1.executeUpdate();
            
            String sqlEmple3="INSERT INTO empleado( dni, apellido, nombre, acceso, estado) "
                    + "VALUES ('25000','Mamani','Susana',1,true)";
            
            PreparedStatement ps2= con.prepareStatement(sqlEmple3);
            ps2.executeUpdate();
            
            //agregar 2 herramientas
            String sqlH="INSERT INTO herramienta(nombre, descripcion, stock, estado)" 
                    +"VALUES ('Taladro','con percutor','13',true)";
            
            PreparedStatement psh= con.prepareStatement(sqlH);
            psh.executeUpdate();
            
            String sqlH1="INSERT INTO herramienta(nombre, descripcion, stock, estado)" 
                    +"VALUES ('pala','ancha','113',true)";
            
            PreparedStatement psh1= con.prepareStatement(sqlH1);
            psh1.executeUpdate();
            //Listar herramientas con estock mayor a 10
            String lista="SELECT * FROM herramienta WHERE stock > 10";
            PreparedStatement lisherr= con.prepareStatement(lista);
            
            ResultSet datos= lisherr.executeQuery();
            
            while (datos.next()) {
                int idHerramienta=datos.getInt("idHerramienta");
                String nombre=datos.getString("nombre");
                String descripcion=datos.getString("descripcion");
                int stock=datos.getInt("stock");
                boolean estado=datos.getBoolean("estado");
                System.out.println("Id Herramienta: "+idHerramienta);
                System.out.println("Nombre : "+nombre);
                System.out.println("Descripcion : "+descripcion);
                System.out.println("Stock : "+stock);
                System.out.println("Estado : "+estado);
                System.out.println("----------------------------------------");
            }
            
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error a cargar el driver");
            System.out.println(ex.getMessage());
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error a cconectarse a la base de datos");
            System.out.println(ex.getMessage());
        }
    }
    
}
