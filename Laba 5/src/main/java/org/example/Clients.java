package org.example;

public class Clients extends People{
    public Clients(int id){
        super(id);
    }
    public Clients(int id, String first_name, String last_name, String middle_name, String date_of_birth, int number_of_phone){
        super(id, first_name, last_name, middle_name, date_of_birth, number_of_phone);
    }
}
