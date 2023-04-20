package com.prod_venda_trad;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInsertion {

    public void InsertCodigoPostal (){
        String url = "jdbc:postgresql://localhost:5432/ProdVenda_Trad";
        String user = "postgres";
        String password = "1234";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO codigo_postal (cod_postal, localidade) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "'4200-690'");
            statement.setString(2, "'Leiria'");
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new row was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
}
