package TorneoDeFrescas.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;

public class Consultas {

    public Consultas() {
    }

    public void guardarBatalla(String equipo, int litrosConsumidos){
        Conexion con = new Conexion();
        Connection conexion = con.getCon();

        Calendar calendar = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

        String query = "insert into ganadores(nombreEquipo, litrosConsumidos, fecha) values(?, ?, ?)";

        try{
            PreparedStatement preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setString(1,equipo);
            preparedStatement.setInt(2,litrosConsumidos);
            preparedStatement.setDate(3,startDate);

            preparedStatement.execute();

            conexion.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
