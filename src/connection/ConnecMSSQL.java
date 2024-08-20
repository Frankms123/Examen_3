package connection;

// Call external libraries
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import connection.config_DB;
import java.sql.*;

public class ConnecMSSQL {
    // Create the connection variables
    private static Connection conex = null;
    private static ResultSet rs = null;

    // Create the connection string
    private static String dbURL = "jdbc:sqlserver://" + config_DB.Server + ":"+ config_DB.Port +";databaseName="+ config_DB.DB +";encrypt=false";
    private static String user = "";
    private static String pass = "";

    // Create the connection method
    public static Connection toConnect() throws SQLException {
        // Try to connect to the database
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            conex = DriverManager.getConnection(dbURL, user, pass);
            if (conex != null) {
                conex.setAutoCommit(true);
                System.out.println("Connected to the database...!\n");
            }
        }catch (SQLException e){
            throw new SQLException("Error: " + e.getMessage());
        }
        return conex;
    }

    // Create the disconnection method
    public static void toDisConnect() throws SQLException{
        try {
            if (rs != null) {
                rs.close();
            }
            if (conex != null) {
                conex.close();
            }
            System.out.println("Disconnected from the database...!\n");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Validate the connection to the database is active
    public static boolean get_Conectado(){
        boolean conectado = true;
        try{
            if(config_DB.MOTOR.equals("MSSQL")){
                toConnect();
                toDisConnect();
            }
        } catch (SQLException e) {
            conectado = false;
        }
        return conectado;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        ConnecMSSQL.user = user;
    }

    public static void setPass(String pass) {
        ConnecMSSQL.pass = pass;
    }
}