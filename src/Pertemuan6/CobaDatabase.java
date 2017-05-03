package Pertemuan6;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.HashMap;

public class CobaDatabase {
    private static final String DB_NAME = "dbcs_1";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    private Connection connection;

    public CobaDatabase() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_NAME, DB_USERNAME, DB_PASSWORD);
    }

    public void select(String tableName, String[] column) {
        try {
            Statement statement = this.connection.createStatement();

            String query = "SELECT ";
            for (int i = 0; i < column.length; i++) {
                query += column[i];
                if (i != column.length - 1)
                    query += ",";
            }

            query += " FROM " + tableName;

            ResultSet result = statement.executeQuery(query);
            this.print(result);

            result.close();
            statement.close();
        } catch(SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public void update(String tableName, String set, String where) {
        try {
            Statement statement = this.connection.createStatement();

            String query = "UPDATE " + tableName + " SET " + set;

            if (where != null)
                query += " WHERE " + where;
//            System.out.println(query);
            if (statement.executeUpdate(query) > 0)
                System.out.println("Successfully updated database");
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    public void print(ResultSet result) throws SQLException {

        // Ambil daftar kolom dari hasil
        String[] resColumn = new String[result.getMetaData().getColumnCount()];
        for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
            resColumn[i - 1] = result.getMetaData().getColumnLabel(i);
        }

        while (result.next()) {
            for (int i = 0; i < resColumn.length; i++)
                System.out.println(resColumn[i] + " : " + result.getString(resColumn[i]));
        }
    }

    public static void main(String[] args) {

        try {
            CobaDatabase database = new CobaDatabase();
            database.select("mahasiswa", new String[]{"nim", "nama", "jenis_kelamin as \"Jenis Kelamin\"",
                    "IF(kewarganegaraan = 'I', 'Warga Negara Indonesia', 'Warga Negara Asing') as Kewarganegaraan"});
            database.update("mahasiswa", "namat = \"MAMAK\"", "nim = '140101002'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
