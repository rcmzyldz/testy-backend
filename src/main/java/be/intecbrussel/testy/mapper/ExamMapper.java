package be.intecbrussel.testy.mapper;

import be.intecbrussel.testy.data.dto.ExamDTO;
import be.intecbrussel.testy.data.entity.ExamEntity;

import java.util.List;

public interface ExamMapper {

    ExamDTO toDTO(ExamEntity source);

    ExamEntity toEntity(ExamDTO source);

    ExamEntity toEntity(ExamDTO source, ExamEntity destination);

    List<ExamDTO> toDTOs(List<ExamEntity> source);

    List<ExamEntity> toEntities(List<ExamDTO> source);

    List<ExamEntity> toEntities(List<ExamDTO> source, List<ExamEntity> destination);

}
