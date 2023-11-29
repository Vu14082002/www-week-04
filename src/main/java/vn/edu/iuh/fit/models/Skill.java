package vn.edu.iuh.fit.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import vn.edu.iuh.fit.enums.SkillType;

import java.util.UUID;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
    private UUID id;
    private String description;
    private String name;
    private SkillType type;

    public Skill(UUID id) {
        this.id = id;
    }
}
