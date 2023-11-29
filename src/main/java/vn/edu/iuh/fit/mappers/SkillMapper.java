package vn.edu.iuh.fit.mappers;


import org.springframework.jdbc.core.RowMapper;
import vn.edu.iuh.fit.enums.SkillType;
import vn.edu.iuh.fit.models.Skill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class SkillMapper implements RowMapper<Skill> {

    @Override
    public Skill mapRow(ResultSet rs, int rowNum) throws SQLException {
        Skill skill = new Skill();
        skill.setId(UUID.fromString(rs.getString("skill_id")));
        skill.setDescription(rs.getString("skill_description"));
        skill.setName(rs.getString("skill_name"));
        skill.setType(SkillType.getSkillType(rs.getInt("type")));
        return skill;
    }
}
