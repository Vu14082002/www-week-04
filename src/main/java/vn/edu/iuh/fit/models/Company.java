package vn.edu.iuh.fit.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Company {
    private UUID id;
    private String about;
    private Address address;
    private String compName;
    private String email;
    private String phone;
    private String webUrl;

    public Company(UUID id) {
        this.id = id;
    }
}
