package org.example.client;
import lombok.Getter;
import org.example.ConnectionDB;
import org.example.People;
import org.example.Drivers;
import org.example.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Getter
public class ClientsDAO {
    ClientsDTO client;

    List<Order> orders = new ArrayList<>();

    public ClientsDAO() {
    }

    public ClientsDAO(ClientsDTO client) {
        this.client = client;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void printOrders(){
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public void makeOrder(Order order){
        String config_properties = "D:\\laboratories_java\\Laba 5\\config.properties";
        try {
            Connection connection = ConnectionDB.getConnection(config_properties);
            String query = "INSERT INTO \"taxi_service\".\"Orders\"(distance,Drivers_driver_id, Clients_client_id) value(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        try {
            preparedStatement.setDouble(1, order.getDistance());
            preparedStatement.setInt(2, order.getDrivers().getId());
            preparedStatement.setInt(3, order.getClients().getId());

            int rowsInserted = preparedStatement.executeUpdate();
            System.out.println("Rows are inserted" + rowsInserted);
            preparedStatement.close();
            connection.close();

            this.addOrder(order);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void canselOrder(Order order){
        String config_properties = "D:\\laboratories_java\\Laba 5\\config.properties";
        try{
            Connection connection = ConnectionDB.getConnection(config_properties);
            String query = "DELETE FROM order WHERE order_id = ? AND Clients_client_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            try{
                preparedStatement.setInt(1, order.getId());
                preparedStatement.setInt(2, order.getClients().getId());

                int result = preparedStatement.executeUpdate();
                System.out.println("Rows affected " + result);
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void changeOrder(Order order,Drivers driver, double distance){
        order.orderFromFile(String.valueOf(order.getId()));
        order.setDistance(distance);
        order.setDrivers(driver);
        String config_properties = "D:\\laboratories_java\\Laba 5\\config.properties";
        try{
            Connection connection = ConnectionDB.getConnection(config_properties);
            String query = "UPDATE order SET distance = ?, Drivers_driver_id = ? WHERE order_id = ? AND Clients_client_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            try {
                preparedStatement.setDouble(1, order.getDistance());
                preparedStatement.setInt(2, order.getDrivers().getId());
                preparedStatement.setInt(3,order.getId());
                preparedStatement.setInt(4, order.getClients().getId());

                int result = preparedStatement.executeUpdate();
                System.out.println("Rows affected " + result);
                preparedStatement.close();
                connection.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setOrderHistory() {
        String configFilename = "D:\\laboratories_java\\Laba 5\\config.properties";
        try {
            Connection connection = ConnectionDB.getConnection(configFilename);
            Statement statement = connection.createStatement();

            try (connection; statement; ResultSet resultSet = statement.executeQuery("SELECT * FROM `order`;")) {
                while (resultSet.next()) {
                    if (resultSet.getInt("Clients_client_id") == this.getClient().getId()) {
                        Drivers driver = Drivers.driverFromDB(resultSet.getInt("Driver_driver_id"));
                        Order order = new Order(resultSet.getInt(1), resultSet.getDouble(2), driver, this.getClient());
                        order.orderFromFile(String.valueOf(order.getId()));
                        this.addOrder(order);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getOrdersNumber(){
        return orders.size();
    }

    @Override
    public String toString(){
        return client.toString();
    }

}

