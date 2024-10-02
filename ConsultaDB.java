package ConsultaMariaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultaDB {
    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3306/p2"; // Conexion a BD
        String user = "p2"; // Usuario
        String password = "p2"; 
        Connection conn = null;
        Statement stmt = null;

        try {
            // Conexion a la base de datos
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();

            // Realizar una consulta
            String sql = "SELECT * FROM alumno"; //consulta a la tabla
            ResultSet rs = stmt.executeQuery(sql);

            // Procesar el resultado
            while (rs.next()) {
                int id = rs.getInt("id"); // Obtiene el ID del alumno
                String nombre = rs.getString("nombre"); // Obtiene el nombre del Alumno
                System.out.println("ID: " + id + ", Nombre: " + nombre);
            }

            // Cerrar el ResultSet
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión y el statement
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

