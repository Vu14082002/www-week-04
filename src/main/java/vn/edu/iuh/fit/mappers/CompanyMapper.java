package vn.edu.iuh.fit.mappers;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.models.Company;
import vn.edu.iuh.fit.repositories.AddressRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
@AllArgsConstructor
public class CompanyMapper implements RowMapper<Company> {
    private AddressRepository addressRepository;

    @Override
    public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
        Company company = new Company();
        company.setId(UUID.fromString(rs.getString("comp_id")));
        company.setAbout(rs.getString("about"));
        company.setAddress(addressRepository.getOne(UUID.fromString(rs.getString("address"))).orElse(null));
        company.setCompName(rs.getString("comp_name"));
        company.setEmail(rs.getString("email"));
        company.setPhone(rs.getString("phone"));
        company.setWebUrl(rs.getString("web_url"));
        return company;
    }

}
