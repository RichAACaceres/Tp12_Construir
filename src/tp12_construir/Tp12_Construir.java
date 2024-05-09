
package tp12_construir;


import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;


public class Tp12_Construir {


    public static void main(String[] args) {

        try { 
            //Metodo para cargar driver
            cargarDrivers();
            //Conectar a la bd
            String url="jdbc:mariadb://localhost:3308/construirsa";
            String usuario="root";
            String contraseña="";
            Connection con=DriverManager.getConnection(url,usuario,contraseña);
            System.out.println("Conectado a la base de datos");
           //Metodo para agregar 3 empleados
            agregarEmpleado(con);
            System.out.println("---------------------------------");
          //Metodo para agregar 2 herramientas
            agregarHerramientas(con);
            //Metodo para listar herramientas con estock mayor a 10
             listarherramientas(con);
               System.out.println("-------------------------------------");
            //Metodo para dar de baja a un empleado
            darDeBaja(con);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error a cargar el driver");
            System.out.println(ex.getMessage());
           
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null,"Error a cconectarse a la base de datos");
            
            System.out.println(ex.getMessage());
        }
    
    }
    public static void cargarDrivers() throws ClassNotFoundException{
    Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Driver cargado");
   }
   
  public static void agregarEmpleado(Connection con) throws SQLException{
     //Empleado 1
      String emp1="INSERT INTO empleado( dni, apellido, nombre, acceso, estado) "
              + "VALUES (23542345,'Sosa','Rogelio',4,1)";
      PreparedStatement ps=con.prepareStatement(emp1);
      ps.executeUpdate();
      
      //Empleado 2
      String emp2="INSERT INTO empleado( dni, apellido, nombre, acceso, estado) "
              + "VALUES (23542345,'Sosa','Rogelio',4,1)";
      PreparedStatement ps2=con.prepareStatement(emp2);
     ps.executeUpdate();
     //Empleado 3
     String emp3="INSERT INTO empleado( dni, apellido, nombre, acceso, estado) "
              + "VALUES (23542345,'Sosa','Rogelio',4,1)";
      PreparedStatement ps3=con.prepareStatement(emp2);
     int verificar=ps.executeUpdate();
     if(verificar>0){
         System.out.println("Empleados agregados");
     }
     
  }
  public static void agregarHerramientas(Connection con) throws SQLException{
  String sqlH="INSERT INTO herramienta(nombre, descripcion, stock, estado)" 
                   +"VALUES ('Taladro','con percutor','13',true)";
           
          PreparedStatement psh= con.prepareStatement(sqlH);
            psh.executeUpdate();
            
            String sqlH1="INSERT INTO herramienta(nombre, descripcion, stock, estado)" 
                    +"VALUES ('pala','ancha','113',true)";
            
            PreparedStatement psh1= con.prepareStatement(sqlH1);
            int ver=psh1.executeUpdate();
            if(ver>0){
                System.out.println("Herramientas agregadas");}
  }
  public static void listarherramientas(Connection con) throws SQLException{
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
  
  
  }
 public static void darDeBaja(Connection con) throws SQLException{
  String baja="UPDATE empleado SET estado = 0 WHERE idEmpleado = 1";
            PreparedStatement ps=con.prepareStatement(baja);
            int cont= ps.executeUpdate();
            if(cont>0){
                System.out.println("Empleado dado de baja");
            }
 }
 
}
