package TorneoDeFrescas.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class Consultas {

    public Consultas() {
    }

    public void guardarBatalla(String equipo, int litrosConsumidos){
        Connection conexion = null;

        PreparedStatement preparedStatement = null;

        Calendar calendar = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

        String query = "insert into ganadores(nombreEquipo, litrosConsumidos, fecha) values(?, ?, ?)";

        try{
            conexion = Conexion.getCon();
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setString(1,equipo);
            preparedStatement.setInt(2,litrosConsumidos);
            preparedStatement.setDate(3,startDate);

            preparedStatement.execute();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
