/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sergi
 */
public class ConexionMysql {
   Connection conexion;
   public Connection conectar(){
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           conexion=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/almacen","root","Foreach7");
           System.out.println("Conexion exitosa");
       }catch(Exception e){
           System.err.println("Fallo la conexion"+e);
       }
       return conexion;
   }
  
}
