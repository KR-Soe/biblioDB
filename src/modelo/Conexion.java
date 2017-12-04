package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    public static Conexion instancia;
    private Connection cnn;

    private Conexion() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/persona";
        String usuario = "root";
        String pass = "";
        try {
            Class.forName(driver);
            cnn = DriverManager.getConnection(url, usuario, pass);
            System.out.println("CONEXION EXITOSA!!");
        } catch (Exception ex) {
            System.out.println("CONEXION no EXITOSA!!");
        }
    }
//paso 1: metodo public para aplicar patrón Singleton

    public static Conexion getInstance() {
    //public synchronized static Conexion getInstance() {
        String mensaje="CONEXION YA CREADA";
        if (instancia == null) {
            mensaje="CONEXION NUEVA";
            instancia = new Conexion();
        }
        System.out.println("Mensaje:"+mensaje);
        return instancia;
    }

    public Connection getCnn() {
        return cnn;
    }

    //paso 2: metodo que cierra la conexion
    public void cerrar() {
        instancia = null;
    }
}
