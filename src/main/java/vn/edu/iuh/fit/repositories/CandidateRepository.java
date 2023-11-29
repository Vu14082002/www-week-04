package vn.edu.iuh.fit.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.mappers.CandidateMapper;
import vn.edu.iuh.fit.models.Candidate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CandidateRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private CandidateMapper candidateMapper;

    @Autowired
    public CandidateRepository(DataSource dataSource, CandidateMapper candidateMapper) {
        this.dataSource = dataSource;
        this.candidateMapper = candidateMapper;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Optional<Candidate> getOne(UUID uuid) {
        String sqlQuery = "select * from candidate where id = ?";
        Candidate candidate = jdbcTemplate.queryForObject(sqlQuery, candidateMapper, uuid);
        return candidate != null ? Optional.of(candidate) : Optional.empty();
    }

    public List<Candidate> getAll() {
        String sqlQuery = "select * from candidate";
        return jdbcTemplate.query(sqlQuery, candidateMapper);
    }

    public boolean save(Candidate candidate) {
        String sqlQuery = "insert into candidate(id, address, dob, email, full_name, phone) values(?, ?, ?, ?, ? ,?)";
        int result = jdbcTemplate.update(sqlQuery, candidate.getId(), candidate.getAddress().getId(), candidate.getDob()
                , candidate.getEmail(), candidate.getFullName(), candidate.getPhone());
        return result > 0;
    }

    public boolean update(Candidate candidate) {
        String sqlQuery = "update candidate set address = ?, dob = ?, email = ?, full_name = ?, phone = ? where id = ?";
        int result = jdbcTemplate.update(sqlQuery, candidate.getAddress().getId(), candidate.getDob()
                , candidate.getEmail(), candidate.getFullName(), candidate.getPhone(), candidate.getId());
        return result > 0;
    }

    public boolean delete(UUID uuid) {
        String sqlQuery = "delete from candidate where id = ?";
        int result = jdbcTemplate.update(sqlQuery, uuid);
        return result > 0;
    }
}
