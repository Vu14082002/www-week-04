package vn.edu.iuh.fit.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.CandidateSkill;
import vn.edu.iuh.fit.repositories.CandidateSkillRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CandidateSkillService {

    private CandidateSkillRepository candidateSkillRepository;

    public Optional<CandidateSkill> getOne(UUID canId, UUID skillId) {
        return candidateSkillRepository.getOne(canId, skillId);
    }

    public List<CandidateSkill> getAll() {
        return candidateSkillRepository.getAll();
    }

    public boolean save(CandidateSkill candidateSkill) {
        return candidateSkillRepository.save(candidateSkill);
    }

    public boolean update(CandidateSkill candidateSkill) {
        return candidateSkillRepository.update(candidateSkill);
    }

    public boolean delete(UUID canID, UUID skillID) {
        return candidateSkillRepository.delete(canID, skillID);
    }


}
