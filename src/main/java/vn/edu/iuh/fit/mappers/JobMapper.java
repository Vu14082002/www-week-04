package vn.edu.iuh.fit.mappers;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.models.Job;
import vn.edu.iuh.fit.repositories.CompanyRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
@AllArgsConstructor
public class JobMapper implements RowMapper<Job> {
    private CompanyRepository companyRepository;

    @Override
    public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
        Job job = new Job();
        job.setId(UUID.fromString(rs.getString("job_id")));
        job.setName(rs.getString("job_name"));
        job.setDescription(rs.getString("job_desc"));
        job.setCompany(companyRepository.getOne(UUID.fromString(rs.getString("company"))).orElse(null));
        return job;
    }
}
