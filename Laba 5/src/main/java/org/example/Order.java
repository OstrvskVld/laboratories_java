package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.client.ClientsDTO;
import java.sql.*;
@Getter
@Setter

public class Order {
    int id;
    double distance;
    Drivers drivers;
    ClientsDTO clients;

    public Order(int id, double distance, Drivers drivers, ClientsDTO clients){
        this.id = id;
        this.distance = distance;
        this.drivers = drivers;
        this.clients = clients;
    }

    public void orderFromFile(String path){
        String config_properties = "D:\\laboratories_java\\Laba 5\\config.properties";
        try {
            Connection connection = ConnectionDB.getConnection(config_properties);
            String query = "Select order_id FROM 'order' WHERE distance = ? AND Drivers_driver_id = ? AND Clients_client_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            try {
                preparedStatement.setInt(1, this.id);
                preparedStatement.setDouble(2, this.distance);
                preparedStatement.setInt(3, this.drivers.getId());
                preparedStatement.setInt(4, this.clients.getId());

                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){
                    this.id = resultSet.getInt(1);
                }
                int rowsInserted = preparedStatement.executeUpdate();
                System.out.println("Rows are inserted" + rowsInserted);
                preparedStatement.close();
                connection.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String toString(){
        return "Order{" +
                "id=" + id +
                ", distance=" + distance +
                ", drivers=" + drivers +
                ", clients=" + clients +
                '}';
    }
}
