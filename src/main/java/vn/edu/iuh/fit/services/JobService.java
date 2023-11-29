package vn.edu.iuh.fit.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.Job;
import vn.edu.iuh.fit.repositories.JobRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class JobService {
    private JobRepository jobRepository;

    public Optional<Job> getOne(UUID jobID) {
        return jobRepository.getOne(jobID);
    }

    public List<Job> getAll() {
        return jobRepository.getAll();
    }

    public boolean save(Job job) {
        return jobRepository.save(job);
    }

    public boolean update(Job job) {
        return jobRepository.update(job);
    }

    public boolean delete(UUID jobID) {
        return jobRepository.delete(jobID);
    }

}
