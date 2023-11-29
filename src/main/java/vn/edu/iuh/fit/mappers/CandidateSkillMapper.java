package vn.edu.iuh.fit.mappers;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.enums.SkillLevel;
import vn.edu.iuh.fit.models.CandidateSkill;
import vn.edu.iuh.fit.repositories.CandidateRepository;
import vn.edu.iuh.fit.repositories.SkillRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
@AllArgsConstructor
public class CandidateSkillMapper implements RowMapper<CandidateSkill> {
    private CandidateRepository candidateRepository;
    private SkillRepository skillRepository;

    @Override
    public CandidateSkill mapRow(ResultSet rs, int rowNum) throws SQLException {

        CandidateSkill candidateSkill = new CandidateSkill();
        candidateSkill.setCandidate(candidateRepository.getOne(UUID.fromString(rs.getString("can_id"))).orElse(null));
        candidateSkill.setSkill(skillRepository.getOne(UUID.fromString(rs.getString("skill_id"))).orElse(null));
        candidateSkill.setMoreInfos(rs.getString("more_infos"));
        candidateSkill.setSkillLevel(SkillLevel.getSkillLevel(rs.getInt("skill_level")));
        return candidateSkill;
    }
}
