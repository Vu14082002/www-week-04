package vn.edu.iuh.fit.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Address {
    private UUID id;
    private String city;
    private Short country;
    private String number;
    private String street;
    private String zipcode;

    public Address(UUID id) {
        this.id = id;
    }
}
