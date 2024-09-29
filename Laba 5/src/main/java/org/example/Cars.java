package org.example;
import lombok.Getter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Cars {
    int id_car;
    String brand;
    String model;
    int year_of_production;
    String type_of_fuel;
    String type_of_body;
    String color;
    String license_plate;
    String capacity_of_passenger;
    String cargo_capacity;
    Drivers drivers;
    public Cars(int id_car){
        this.id_car = id_car;
    }
    public Cars(int id_car, String brand, String model, int year_of_production, String type_of_fuel,
                String type_of_body, String color, String license_plate, String capacity_of_passenger, String cargo_capacity, Drivers drivers){
        this.id_car = id_car;
        this.brand = brand;
        this.model = model;
        this.year_of_production = year_of_production;
        this.type_of_fuel = type_of_fuel;
        this.type_of_body = type_of_body;
        this.color = color;
        this.license_plate = license_plate;
        this.capacity_of_passenger = capacity_of_passenger;
        this.cargo_capacity = cargo_capacity;
        this.drivers = drivers;
    }
}
