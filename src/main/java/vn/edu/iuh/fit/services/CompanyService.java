package vn.edu.iuh.fit.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.Company;
import vn.edu.iuh.fit.repositories.CompanyRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CompanyService {
    private CompanyRepository companyRepository;

    public Optional<Company> getOne(UUID compID) {
        return companyRepository.getOne(compID);
    }

    public List<Company> getAll() {
        return companyRepository.getAll();
    }

    public boolean save(Company company) {
        return companyRepository.save(company);
    }

    public boolean update(Company company) {
        return companyRepository.update(company);
    }

    public boolean delete(UUID compID) {
        return companyRepository.delete(compID);
    }


}
