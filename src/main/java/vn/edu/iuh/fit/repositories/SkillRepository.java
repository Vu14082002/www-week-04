package vn.edu.iuh.fit.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.mappers.SkillMapper;
import vn.edu.iuh.fit.models.Skill;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class SkillRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SkillRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Optional<Skill> getOne(UUID uuid) {
        String sqlQuery = "select * from skill where skill_id = ?";
        Skill skill = jdbcTemplate.queryForObject(sqlQuery, new SkillMapper(), uuid);
        return skill != null ? Optional.of(skill) : Optional.empty();
    }

    public List<Skill> getAll() {
        String sqlQuery = "select * from skill";
        return jdbcTemplate.query(sqlQuery, new SkillMapper());
    }

    public boolean save(Skill skill) {
        String sqlQuery = "insert into skill(skill_id, skill_description, skill_name, type) values (?, ?, ?, ?)";

        int result = jdbcTemplate.update(sqlQuery, skill.getId(), skill.getDescription(), skill.getName(), skill.getType().getTypeNum());
        return result > 0;
    }

    public boolean update(Skill skill) {
        String sqlQuery = "update skill set skill_name = ?, skill_description = ?, type = ? where skill_id = ?";
        int result = jdbcTemplate.update(sqlQuery, skill.getName(), skill.getDescription(), skill.getType().getTypeNum(), skill.getId());
        return result > 0;
    }

    public boolean delete(UUID uuid) {
        String sqlQuery = "delete from skill where skill_id = ?";
        int result = jdbcTemplate.update(sqlQuery, uuid);
        return result > 0;
    }
}
