package org.example;
import org.example.client.ClientsDAO;
import org.example.client.ClientsDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class Menu {

    public Map<String, Double> getCars() throws Exception {
        String configFilename = "D:\\laboratories_java\\Laba 5\\config.properties";
        Map<String, Double> map = new HashMap<>();

        try (Connection connection = ConnectionDB.getConnection(configFilename);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM `car`;")) {

            while (resultSet.next()) {

                Cars car = new Cars(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10),
                        Drivers.driverFromDB(resultSet.getInt(11))
                );
                Double buff = car.getOrders().stream()
                        .mapToDouble(Order::getDistance)
                        .sum();
                map.put(car.getCar(), buff);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Exception("DB problem", e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return map;
    }

    public List<ClientsDAO> getListOfClient() throws Exception {
        List<ClientsDAO> clients = new ArrayList<>();
        String configFile = "D:\\laboratories_java\\Laba 5\\config.properties";

        try (Connection connection = ConnectionDB.getConnection(configFile);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM `client`;")) {

            while (resultSet.next()) {
                ClientsDAO client = new ClientsDAO(new ClientsDTO(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getInt(6),
                        resultSet.getInt(7)
                ));
                client.setOrderHistory();
                clients.add(client);
            }
            return clients;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Exception("DB problem", e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}