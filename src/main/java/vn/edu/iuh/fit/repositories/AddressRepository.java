package vn.edu.iuh.fit.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.Address;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class AddressRepository {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AddressRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Optional<Address> getOne(UUID uuid) {
        String sqlQuery = "select * from address where id = ?";
        Address address = jdbcTemplate.queryForObject(sqlQuery, new BeanPropertyRowMapper<>(Address.class), uuid);
        return address != null ? Optional.of(address) : Optional.empty();
    }

    public List<Address> getAll() {
        String sqlQuery = "select * from address";
        return jdbcTemplate.query(sqlQuery, new BeanPropertyRowMapper<>(Address.class));
    }

    public boolean save(Address address) {
        String sqlQuery = "insert into address(id, street, city, country, number, zipcode) " +
                "values(?, ?, ?, ?, ?, ?)";
        int result = jdbcTemplate.update(sqlQuery, address.getId(), address.getStreet()
                , address.getCity(), address.getCountry(), address.getNumber(), address.getZipcode());
        return result > 0;
    }

    public boolean update(Address address) {
        String sqlQuery = "update address set street = ?, city = ?, country = ?, number = ?, zipcode = ? where id = ?";
        int result = jdbcTemplate.update(sqlQuery, address.getStreet()
                , address.getCity(), address.getCountry(), address.getNumber(), address.getZipcode(), address.getId());
        return result > 0;
    }

    public boolean delete(UUID uuid) {
        String sqlQuery = "delete from address where id = ?";
        int result = jdbcTemplate.update(sqlQuery, uuid);
        return result > 0;
    }


}
