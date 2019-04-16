package TorneoDeFrescas.BD;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private String url = "jdbc:mysql://localhost:3306/torneo?autoReconnect=true&useSSL=false";
    private String userName = "root";
    private String pass = "1234";
    private Connection con = null;

    public Conexion() {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url,userName,pass);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Connection getCon() {
        return con;
    }

    public Connection cerrarConexion(){
        try {
            con.close();
            System.out.println("Conexion cerrada");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        con=null;
        return con;
    }

}
