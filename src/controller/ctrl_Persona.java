package controller;

// import the necessary libraries
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// import the database functions
import connection.ConnecMSSQL;
import connection.config_DB;

// import the model class of table Persona
import model.mdl_Persona;

import static connection.ConnecMSSQL.*;

public class ctrl_Persona {
    // Create the connection variables
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public ArrayList<mdl_Persona> get_Peronas() throws SQLException {
        ArrayList<mdl_Persona> aviones = new ArrayList<>();
        try {
            // Try to connect to the database and prepare the statement
            stmt = ConnecMSSQL.toConnect().prepareStatement("select * from Persona");

            // Execute the statement
            rs = stmt.executeQuery();

            // Create an array list to store the records
            aviones = new ArrayList<mdl_Persona>();

            // Iterate the result set
            while (rs.next()) {
                // Create an instance of the mdl_Avion class
                mdl_Persona Persona = new mdl_Persona(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5).charAt(0),rs.getString(6).charAt(0),rs.getDate(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getNString(11),rs.getInt(12));

                // Add the instance to the array list
                aviones.add(Persona);
            }

            // Try to close
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }

        } catch (SQLException e) {
            throw new SQLException("Error: " + e.getMessage());
        } finally {
            // Try to disconnect from the database
            ConnecMSSQL.toDisConnect();
        }

        return aviones;
    }

    public void add_Avion(mdl_Persona Persona) throws SQLException{
        String auxSql = "";
        try {
            // Try to connect to the database and prepare the statement
            auxSql = "exec InsertAvion ?, ?, ?, ?,?,?,?,?,?,?,?,?";

            // Try to connect to the database and prepare the statement
            stmt =ConnecMSSQL.toConnect().prepareStatement(auxSql);

            // Update the statement with the data
            if(Persona != null){
                stmt.setInt(1, Persona.getId_Persona());
                stmt.setString(2, Persona.getNombre());
                stmt.setString(3, Persona.getApell1());
                stmt.setString(4, Persona.getApell2());
                stmt.setString(5, String.valueOf(Persona.getSexo()));
                stmt.setString(6, String.valueOf(Persona.getSexo()));
                stmt.setDate(7,Persona.getNacido());
                stmt.setString(8,String.valueOf(Persona.getProvincia()));
                stmt.setString(9,String.valueOf(Persona.getOsexual()));
                stmt.setString(10,String.valueOf(Persona.getaPolitica()));
                stmt.setString(11,String.valueOf(Persona.getnAcademico()));
                stmt.setString(12,String.valueOf(Persona.getSalario()));


                // Execute the statement
                stmt.execute();
            }

            // Try to close
            if(stmt != null){
                stmt.close();
                stmt = null;
            }

        }catch (SQLException e){
            throw new SQLException("Error: " + e.getMessage());
        }finally{
            // Try to disconnect from the database
            ConnecMSSQL.toDisConnect();
        }
    }


}
