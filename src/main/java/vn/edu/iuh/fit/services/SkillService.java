package vn.edu.iuh.fit.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.Skill;
import vn.edu.iuh.fit.repositories.SkillRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SkillService {

    private SkillRepository skillRepository;

    public Optional<Skill> getOne(UUID uuid) {
        return skillRepository.getOne(uuid);
    }

    public List<Skill> getAll() {
        return skillRepository.getAll();
    }

    public boolean save(Skill skill) {
        return skillRepository.save(skill);
    }

    public boolean update(Skill skill) {
        return skillRepository.save(skill);
    }

    public boolean delete(UUID uuid) {
        return skillRepository.delete(uuid);
    }


}
