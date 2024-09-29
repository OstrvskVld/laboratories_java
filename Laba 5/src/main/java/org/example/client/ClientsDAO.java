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


}
