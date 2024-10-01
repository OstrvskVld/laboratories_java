package org.example;
import lombok.Getter;
import org.example.client.ClientsDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@Getter

public class Drivers extends People{
    String driving_experience;
    public Drivers(int id){
        super(id);
    }
    public Drivers(int id, String first_name, String last_name, String middle_name, String date_of_birth, String driving_experience, int number_of_phone){
        super(id, first_name, last_name, middle_name, date_of_birth, number_of_phone);
        this.driving_experience = driving_experience;
    }

    static public Drivers driverFromDB(int id) throws Exception {
        String configFile = "D:\\laboratories_java\\Laba 5\\config.properties";

        try (Connection connection = ConnectionDB.getConnection(configFile);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM driver;")) {

            while (resultSet.next()) {

                if (resultSet.getInt(1) == id) {
                    return new Drivers(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getInt(7)
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Exception(e);
        }
        return null;
    }

    public List<Order> getOrders() throws Exception {
        List<Order> orders = new ArrayList<>();
        String configFile = "D:\\laboratories_java\\Laba 5\\config.properties";

        try (Connection connection = ConnectionDB.getConnection(configFile);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM `order`;")) {

            while (resultSet.next()) {
                if (resultSet.getInt(3) == this.id) {
                    resultSet.getInt(1);
                    resultSet.getDouble(2);
                    resultSet.getInt(3);
                    resultSet.getInt(4);
                    ClientsDTO client = ClientsDTO.Client_from_DB(resultSet.getInt(4));
                    Order order = new Order(resultSet.getInt(1), resultSet.getDouble(2), this, null, client);
                    orders.add(order);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Exception(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return orders;
    }
}
