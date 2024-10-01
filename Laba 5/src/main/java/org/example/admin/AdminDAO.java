package org.example.admin;
import lombok.Getter;
import org.example.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Getter

public class AdminDAO {
    AdminDTO admin;

    public AdminDAO() {
    }

    public AdminDAO(AdminDTO admin) {
        this.admin = admin;
    }

    public void addDriver(Drivers driver) {
        String config_properties = "D:\\laboratories_java\\Laba 5\\config.properties";
        try {
            Connection connection = ConnectionDB.getConnection(config_properties);
            String query = "INSERT INTO \"taxi_service\".\"Drivers\"(first_name, last_name, middle_name, date_of_birth, number_of_phone, driving_experience) VALUES (?, ?, ?, ?, ?,)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            try {
                preparedStatement.setString(1,driver.getFirst_name());
                preparedStatement.setString(2, driver.getLast_name());
                preparedStatement.setString(3, driver.getMiddle_name());
                preparedStatement.setString(4, driver.getDate_of_birth());
                preparedStatement.setString(5, driver.getDriving_experience());
                preparedStatement.setInt(6, driver.getNumber_of_phone());

                int rowsInserted = preparedStatement.executeUpdate();
                System.out.println("Rows are inserted" + rowsInserted);
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error! " + e.getMessage());
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void addCar(Cars car) {
        String config_properties = "D:\\laboratories_java\\Laba 5\\config.properties";
        try {
            Connection connection = ConnectionDB.getConnection(config_properties);
            String query = "INSERT INTO \"taxi_service\".\"Cars\"(brand,model,year_of_production,type_of_fuel,type_of_body,color,license_plate, capacity_of_passenger,cargo_capacity,Drivers drivers) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            try {
                preparedStatement.setString(1,car.getBrand());
                preparedStatement.setString(2, car.getModel());
                preparedStatement.setInt(3,car.getYear_of_production());
                preparedStatement.setString(4,car.getType_of_fuel());
                preparedStatement.setString(5,car.getType_of_body());
                preparedStatement.setString(6,car.getColor());
                preparedStatement.setString(7,car.getLicense_plate());
                preparedStatement.setString(8,car.getCapacity_of_passenger());
                preparedStatement.setString(9,car.getCargo_capacity());
                preparedStatement.setInt(10,car.getDrivers().getId());
                int rowsInserted = preparedStatement.executeUpdate();
                System.out.println("Rows are inserted" + rowsInserted);
                preparedStatement.close();
                connection.close();
            }
            catch (SQLException e) {
                System.out.println("Error! " + e.getMessage());
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
