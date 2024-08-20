package controller;

import connection.ConnecMSSQL;
import model.mdl_aPolitica;
import model.mdl_nAcademica;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class aPolitica {
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public ArrayList<mdl_aPolitica> get_aPolitica() throws SQLException {
        ArrayList<mdl_aPolitica> Politicas = new ArrayList<>();
        try {
            // Try to connect to the database and prepare the statement
            stmt = ConnecMSSQL.toConnect().prepareStatement("select * from aPolitica");

            // Execute the statement
            rs = stmt.executeQuery();

            // Create an array list to store the records
            Politicas = new ArrayList<mdl_aPolitica>();

            // Iterate the result set
            while (rs.next()) {
                // Create an instance of the mdl_Avion class
                mdl_aPolitica Politica = new mdl_aPolitica(rs.getInt(1), rs.getString(2));

                // Add the instance to the array list
                Politicas.add(Politica);
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

        return Politicas;
    }

    public void add_aPolitica(mdl_aPolitica aPolitica) throws SQLException{
        String auxSql = "";
        try {
            // Try to connect to the database and prepare the statement
            auxSql = "exec InserPolitica ?, ?";

            // Try to connect to the database and prepare the statement
            stmt =ConnecMSSQL.toConnect().prepareStatement(auxSql);

            // Update the statement with the data
            if(aPolitica != null){
                stmt.setInt(1, aPolitica.getId_Politica());
                stmt.setString(2, aPolitica.getNombre());

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
