package vn.edu.iuh.fit.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Candidate {
    private UUID id;
    private String fullName;
    private String email;
    private String phone;
    private Address address;
    private LocalDate dob;

    public Candidate(UUID id) {
        this.id = id;
    }

    public void setAddress(Address address) {
    }
}
