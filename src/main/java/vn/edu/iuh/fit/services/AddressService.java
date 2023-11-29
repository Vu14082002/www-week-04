package vn.edu.iuh.fit.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.repositories.AddressRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AddressService {
    private AddressRepository addressRepository;

    public Optional<Address> getOne(UUID uuid) {
        return addressRepository.getOne(uuid);
    }

    public List<Address> getAll() {
        return addressRepository.getAll();
    }

    public boolean save(Address address) {
        return addressRepository.save(address);
    }

    public boolean update(Address address) {
        return addressRepository.update(address);
    }

    public boolean delete(UUID uuid) {
        return addressRepository.delete(uuid);
    }


}
