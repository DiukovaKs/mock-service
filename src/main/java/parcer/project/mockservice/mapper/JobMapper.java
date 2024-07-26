package parcer.project.mockservice.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import parcer.project.mockservice.dao.JobEntity;
import parcer.project.mockservice.dto.JobApiDto;
import parcer.project.mockservice.dto.JobDto;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class JobMapper {

    public abstract JobEntity toEntity(JobDto dto);
    public abstract List<JobEntity> toEntity(List<JobDto> dto);

    public abstract JobDto toDto(JobEntity entity);
    public abstract List<JobDto> toDto(List<JobEntity> entity);

    public abstract JobApiDto toApiDto(JobDto entity);
    public abstract List<JobApiDto> toApiDto(List<JobDto> entity);

    public abstract JobApiDto entityToApiDto(JobEntity entity);
    public abstract List<JobApiDto> entityToApiDto(List<JobEntity> entity);
}
