package org.example.client;

import lombok.Getter;
import org.example.ConnectionDB;
import org.example.People;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Getter
public class ClientsDTO extends People {
    int password;

    public ClientsDTO(int id) {
        super(id);
    }

    public ClientsDTO(int id, String first_name, String last_name, String middle_name, String date_of_birth, int number_of_phone, int password) {
        super(id, first_name, last_name, middle_name, date_of_birth, number_of_phone);
        this.password = password;
    }

    static public ClientsDTO Client_from_DB(int id) throws SQLException {
        String config_properties = "D:\\laboratories_java\\Laba 5\\config.properties";
        Connection connection = null;

        try {

            connection = ConnectionDB.getConnection(config_properties);
            Statement statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery("SELECT * FROM client;");
            while (resultSet.next()) {
                if (resultSet.getInt(1) == id) {
                    return new ClientsDTO(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getInt(6),
                            resultSet.getInt(7)
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error! " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }
}
