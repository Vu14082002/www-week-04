package vn.edu.iuh.fit.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import vn.edu.iuh.fit.enums.SkillLevel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JobSkill {
    private Job job;
    private Skill skill;
    private String moreInfos;
    private SkillLevel skillLevel;


}
