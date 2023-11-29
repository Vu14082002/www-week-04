package vn.edu.iuh.fit.mappers;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.repositories.AddressRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
@AllArgsConstructor
public class CandidateMapper implements RowMapper<Candidate> {

    private AddressRepository addressRepository;

    @Override
    public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
        Candidate candidate = new Candidate();
        candidate.setId(UUID.fromString(rs.getString("id")));
        candidate.setDob(rs.getDate("dob").toLocalDate());
        candidate.setEmail(rs.getString("email"));
        candidate.setFullName(rs.getString("full_name"));
        candidate.setPhone(rs.getString("phone"));
        candidate.setAddress(addressRepository.getOne(UUID.fromString(rs.getString("address"))).orElse(null));

        return candidate;
    }
}
