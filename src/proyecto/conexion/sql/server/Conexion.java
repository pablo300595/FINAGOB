/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.conexion.sql.server;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pablo
 */
public class Conexion {
    Statement Sentencias;
    ResultSet Datos,Datos1;
    Statement psPrepararSentencia;
    Connection conexion;
    
    
    //Metodo para conectarse al servidor de base de datos
    public Conexion() throws SQLException{
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url= "jdbc:sqlserver://localhost:1433;databaseName=AGENDAFINAGOB;user=sa;password=lalitro19;";
            //String url= "jdbc:sqlserver://localhost:1433;databaseName=AGENDAFINAGOB;integratedSecurity=true;";
            
            conexion=DriverManager.getConnection(url);
            Sentencias= conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Metodo para consultar y buscar en la base de datos
    public ResultSet Consultar1(String tabla, String campo,String valor){
        try {
            Datos= Sentencias.executeQuery("SELECT * FROM "+ tabla +" WHERE "+campo+" LIKE '"+valor+"%'");//'R%'
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Datos;
    }
    
    //Metodo para buscar registros duplicados
    public ResultSet Consultar2(String tabla, String campo1,String campo2){
        try {
            Datos= Sentencias.executeQuery("SELECT * FROM "+ tabla +" WHERE "+campo1+"='"+campo2+"'");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Datos;
    }
    //Metodo para eliminar registros
    public void Eliminar(String tabla, String campo1,String campo2){
        try {            
            Sentencias.execute("DELETE FROM "+ tabla +" WHERE "+campo1+ "='"+campo2+"'");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet primerCarga() throws SQLException{
        Datos1= Sentencias.executeQuery("SELECT * FROM Contacto");
        return Datos1;
    }
    
    public ResultSet primerCarga1() throws SQLException{
        Datos1= Sentencias.executeQuery("SELECT * FROM Correspondencia");
        return Datos1;
    }
    
    public ResultSet primerCarga2() throws SQLException{
        Datos1= Sentencias.executeQuery("SELECT * FROM Usuarios");
        return Datos1;
    }
    
    public ResultSet primerCarga3() throws SQLException{
        Datos1= Sentencias.executeQuery("SELECT * FROM tramite");
        return Datos1;
    }
    
    
}
