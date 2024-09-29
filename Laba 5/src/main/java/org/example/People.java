package org.example;


import lombok.Getter;

@Getter
public class People {
    int id;
    String first_name;
    String last_name;
    String middle_name;
    String date_of_birth;
    int number_of_phone;

    public People(int id) {
        this.id = id;
    }

    public People(int id, String first_name, String last_name, String middle_name, String date_of_birth, int number_of_phone) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.middle_name = middle_name;
        this.date_of_birth = date_of_birth;
        this.number_of_phone = number_of_phone;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                ", number_of_phone=" + number_of_phone +
                '}';
    }
}

