package vn.edu.iuh.fit.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.mappers.JobMapper;
import vn.edu.iuh.fit.models.Job;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class JobRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private JobMapper jobMapper;

    @Autowired
    public JobRepository(DataSource dataSource, JobMapper jobMapper) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jobMapper = jobMapper;
    }

    public Optional<Job> getOne(UUID jobID) {
        String sqlQuery = "select * from job where job_id = ?";
        Job job = jdbcTemplate.queryForObject(sqlQuery, jobMapper, jobID);
        return job != null ? Optional.of(job) : Optional.empty();
    }

    public List<Job> getAll() {
        String sqlQuery = "select * from job";
        return jdbcTemplate.query(sqlQuery, jobMapper);
    }

    public boolean save(Job job) {
        String sqlQuery = "insert into job(job_id, job_desc, job_name, company) values (?, ?, ? ,?)";
        int result = jdbcTemplate.update(sqlQuery, job.getId(), job.getDescription(), job.getName(), job.getCompany().getId());
        return result > 0;
    }

    public boolean update(Job job) {
        String sqlQuery = "update job set company = ?, job_desc = ?, job_name = ? where job_id = ?";
        int result = jdbcTemplate.update(sqlQuery, job.getCompany().getId(), job.getDescription(), job.getName(), job.getId());
        return result > 0;
    }

    public boolean delete(UUID jobID) {
        String sqlQuery = "delete from job where job_id = ?";
        int result = jdbcTemplate.update(sqlQuery, jobID);
        return result > 0;
    }
}
