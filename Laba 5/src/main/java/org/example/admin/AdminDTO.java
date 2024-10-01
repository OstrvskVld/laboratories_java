package org.example.admin;
import lombok.Getter;
import org.example.People;

@Getter
public class AdminDTO extends People {
    int password;

    public AdminDTO(int id, String first_name, String last_name, String middle_name, String date_of_birth, int number_of_phone){
        super(id, first_name, last_name, middle_name, date_of_birth, number_of_phone);
        this.password = password;
    }
}
