package parcer.project.mockservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parcer.project.mockservice.entity.JobEntity;
import parcer.project.mockservice.dto.JobApiDto;
import parcer.project.mockservice.dto.JobDto;
import parcer.project.mockservice.mapper.JobMapper;
import parcer.project.mockservice.repository.JobRepository;

import java.util.InvalidPropertiesFormatException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CrudService {
    private final static String DATE_FORMAT = "\\d{1,2}-\\d{2}-\\d{4}";
    @Autowired
    private JobRepository repository;
    @Autowired
    private JobMapper mapper;

    public List<JobDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    public void save(JobDto jobDto) {
        JobEntity jobEntity = mapper.toEntity(jobDto);

        repository.save(jobEntity);
    }

    public List<JobApiDto> getResultByFilteredFields(List<String> dates, List<String> sources) throws InvalidPropertiesFormatException {
        if ((dates == null || dates.isEmpty()) && (sources == null || sources.isEmpty())) {
            return mapper.toApiDto(findAll());
        } else if ((dates != null && !dates.isEmpty()) && (sources == null || sources.isEmpty())) {
            return getResultByFilteredByDates(dates);
        } else {
            return getResultByFilteredByDatesAndSources(dates, sources);
        }
    }

    private List<JobApiDto> getResultByFilteredByDates(List<String> dates) throws InvalidPropertiesFormatException {
        checkDateFormat(dates);
        return mapper.entityToApiDto(repository.findJobEntitiesByPostedAtIn(dates));
    }

    private List<JobApiDto> getResultByFilteredByDatesAndSources(List<String> dates, List<String> sources) throws InvalidPropertiesFormatException {
        checkDateFormat(dates);
        return mapper.entityToApiDto(repository.findJobEntitiesByPostedAtInAndSourceIdIn(dates, sources));
    }

    private void checkDateFormat(List<String> dates) throws InvalidPropertiesFormatException {
        if (dates == null || !dates.stream().allMatch(e -> e.matches(DATE_FORMAT))) {
           throw new InvalidPropertiesFormatException("Invalid date format!");
        }
    }
}
