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
            String query = "INSERT INTO order(distance,Drivers_driver_id, Clients_client_id) value(?,?,?)";
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
}
