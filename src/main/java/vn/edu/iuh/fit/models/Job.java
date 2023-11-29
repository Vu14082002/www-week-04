package vn.edu.iuh.fit.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    private UUID id;
    private Company company;
    private String description;
    private String name;

    public Job(UUID id) {
        this.id = id;
    }
}
