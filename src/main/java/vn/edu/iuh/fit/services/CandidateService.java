package vn.edu.iuh.fit.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.repositories.CandidateRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CandidateService {
    private CandidateRepository candidateRepository;

    public Optional<Candidate> getOne(UUID uuid) {
        return candidateRepository.getOne(uuid);
    }

    public List<Candidate> getAll() {
        return candidateRepository.getAll();
    }

    public boolean save(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public boolean update(Candidate candidate) {
        return candidateRepository.update(candidate);
    }

    public boolean delete(UUID uuid) {
        return candidateRepository.delete(uuid);
    }


}
