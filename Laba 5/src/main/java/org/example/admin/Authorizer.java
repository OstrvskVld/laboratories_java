package org.example.admin;

import org.example.ConnectionDB;
import org.example.client.*;
import lombok.Getter;

import java.sql.*;

@Getter
public class Authorizer {
    public ClientsDAO register(ClientsDTO clientsDTO) {
        String config_properties = "D:\\laboratories_java\\Laba 5\\config.properties";
        try {
            Connection connection = ConnectionDB.getConnection(config_properties);
            String query = "INSERT INTO \"taxi_service\".\"Clients\"(first_name, last_name, middle_name, date_of_birth, number_of_phone,password)" +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            try {
                preparedStatement.setString(1, clientsDTO.getFirst_name());
                preparedStatement.setString(2, clientsDTO.getLast_name());
                preparedStatement.setString(3, clientsDTO.getMiddle_name());
                preparedStatement.setString(4, clientsDTO.getDate_of_birth());
                preparedStatement.setInt(5, clientsDTO.getNumber_of_phone());
                preparedStatement.setInt(6, clientsDTO.getPassword());

                int rowsInserted = preparedStatement.executeUpdate();
                System.out.println("Registration is done: " + rowsInserted);
                preparedStatement.close();
                connection.close();

                return new ClientsDAO(clientsDTO);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public AdminDAO adminAuthorization(String first_name, int password) throws Exception {
        String config_properties = "D:\\laboratories_java\\Laba 5\\config.properties";
        try (Connection connection = ConnectionDB.getConnection(config_properties);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM admin")) {

            while (resultSet.next()) {
                if (resultSet.getString(2).equals(first_name) && resultSet.getInt(6) == password) {
                    AdminDTO adminDTO = new AdminDTO(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getInt(6)
                    );
                    System.out.println("You have logged in as 'admin' ");
                    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                    System.out.println();
                    System.out.println("Information about admin:");
                    int columnCount = resultSetMetaData.getColumnCount();
                    System.out.println("Number of values: " + columnCount);
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.println(resultSetMetaData.getCatalogName(i) + " " + resultSetMetaData.getColumnTypeName(i) + ")");
                    }
                    System.out.println();
                    return new AdminDAO(adminDTO);
                }
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            throw new Exception(e);
        }
        return null;
    }


    public ClientsDAO clientAuthorization(String name, int password) throws Exception {
        String configFilename = "D:\\laboratories_java\\Laba 5\\config.properties";

        try (Connection connection = ConnectionDB.getConnection(configFilename);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM `client`;")) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {

                if (resultSet.getString(2).equals(name) && resultSet.getInt(7) == password) {
                    ClientsDTO client = new ClientsDTO(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getInt(6),
                            resultSet.getInt(7)
                    );
                    ClientsDAO clientDao = new ClientsDAO(client);
                    clientDao.setOrderHistory();
                    System.out.println("You have authorized success");
                    return clientDao;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error! " + e.getMessage());
            throw new Exception("Problem with DB!", e);
        }
        return null;
    }

}
