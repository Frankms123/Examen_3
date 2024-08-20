package controller;

import connection.ConnecMSSQL;
import model.mdl_Persona;
import model.mdl_Provincia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ctrl_Provincia {
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public ArrayList<mdl_Provincia> get_Provincia() throws SQLException {
        ArrayList<mdl_Provincia> Provincias = new ArrayList<>();
        try {
            // Try to connect to the database and prepare the statement
            stmt = ConnecMSSQL.toConnect().prepareStatement("select * from Provincia");

            // Execute the statement
            rs = stmt.executeQuery();

            // Create an array list to store the records
            Provincias = new ArrayList<mdl_Provincia>();

            // Iterate the result set
            while (rs.next()) {
                // Create an instance of the mdl_Avion class
                mdl_Provincia Provincia = new mdl_Provincia(rs.getInt(1), rs.getString(2));

                // Add the instance to the array list
                Provincias.add(Provincia);
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

        return Provincias;
    }

    public void add_Provincia(mdl_Provincia Provincia) throws SQLException{
        String auxSql = "";
        try {
            // Try to connect to the database and prepare the statement
            auxSql = "exec InsertAvion ?, ?";

            // Try to connect to the database and prepare the statement
            stmt =ConnecMSSQL.toConnect().prepareStatement(auxSql);

            // Update the statement with the data
            if(Provincia != null){
                stmt.setInt(1, Provincia.getId_provincia());
                stmt.setString(2, Provincia.getNombre_provincia());


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
