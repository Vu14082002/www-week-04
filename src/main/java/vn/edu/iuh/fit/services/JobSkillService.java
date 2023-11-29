package vn.edu.iuh.fit.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.JobSkill;
import vn.edu.iuh.fit.repositories.JobSkillRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class JobSkillService {
    private JobSkillRepository jobSkillRepository;

    public Optional<JobSkill> getOne(UUID jobID, UUID skillID) {
        return jobSkillRepository.getOne(jobID, skillID);
    }

    public List<JobSkill> getAll() {
        return jobSkillRepository.getAll();
    }

    public boolean save(JobSkill jobSkill) {
        return jobSkillRepository.save(jobSkill);
    }

    public boolean update(JobSkill jobSkill) {
        return jobSkillRepository.update(jobSkill);
    }

    public boolean delete(UUID jobID, UUID skillID) {
        return jobSkillRepository.delete(jobID, skillID);
    }


}
