package parcer.project.mockservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import parcer.project.mockservice.dbo.JobEntity;
import parcer.project.mockservice.dto.JobDto;
import parcer.project.mockservice.mapper.JobMapper;
import parcer.project.mockservice.repository.JobRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CrudService {

    private final JobRepository repository;
    private final JobMapper mapper;

    public List<JobDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    public void save(JobDto jobDto) {
        JobEntity jobEntity = mapper.toEntity(jobDto);

        repository.save(jobEntity);
    }

    public List<JobDto> findByPostedAt(String postedAt) {
        List<JobEntity> entities = repository.findByPostedAt(postedAt);

        return mapper.toDto(entities);
    }

    public List<JobDto> findByPostedAtAndSourceId(String postedAt, String source) {
        List<JobEntity> entities = repository.findByPostedAtAndSourceId(postedAt, source);

        return mapper.toDto(entities);
    }

    public List<JobDto> findBySourceId(String source) {
        List<JobEntity> entities = repository.findBySourceId(source);

        return mapper.toDto(entities);
    }
}
