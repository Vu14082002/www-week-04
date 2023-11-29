package vn.edu.iuh.fit.mappers;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.enums.SkillLevel;
import vn.edu.iuh.fit.models.JobSkill;
import vn.edu.iuh.fit.repositories.JobRepository;
import vn.edu.iuh.fit.repositories.SkillRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
@AllArgsConstructor
public class JobSkillMapper implements RowMapper<JobSkill> {
    private SkillRepository skillRepository;
    private JobRepository jobRepository;


    @Override
    public JobSkill mapRow(ResultSet rs, int rowNum) throws SQLException {
        JobSkill jobSkill = new JobSkill();
        jobSkill.setSkill(skillRepository.getOne(UUID.fromString(rs.getString("skill_id"))).orElse(null));
        jobSkill.setJob(jobRepository.getOne(UUID.fromString(rs.getString("job_id"))).orElse(null));
        jobSkill.setMoreInfos(rs.getString("more_infos"));
        jobSkill.setSkillLevel(SkillLevel.getSkillLevel(rs.getInt("skill_level")));
        return jobSkill;
    }
}
