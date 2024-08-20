package controller;

import connection.ConnecMSSQL;
import model.mdl_nAcademica;
import model.mdl_oSexual;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ctrl_nAcademica {
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public ArrayList<mdl_nAcademica> get_academica() throws SQLException {
        ArrayList<mdl_nAcademica> academicas = new ArrayList<>();
        try {
            // Try to connect to the database and prepare the statement
            stmt = ConnecMSSQL.toConnect().prepareStatement("select * from nAcademica");

            // Execute the statement
            rs = stmt.executeQuery();

            // Create an array list to store the records
            academicas = new ArrayList<mdl_nAcademica>();

            // Iterate the result set
            while (rs.next()) {
                // Create an instance of the mdl_Avion class
                mdl_nAcademica academica = new mdl_nAcademica(rs.getInt(1), rs.getString(2));

                // Add the instance to the array list
                academicas.add(academica);
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

        return academicas;
    }

    public void add_academica(mdl_nAcademica nAcademica) throws SQLException{
        String auxSql = "";
        try {
            // Try to connect to the database and prepare the statement
            auxSql = "exec InsertAcademica ?, ?";

            // Try to connect to the database and prepare the statement
            stmt =ConnecMSSQL.toConnect().prepareStatement(auxSql);

            // Update the statement with the data
            if(nAcademica != null){
                stmt.setInt(1, nAcademica.getId_academica());
                stmt.setString(2, nAcademica.getDescripcion());

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
