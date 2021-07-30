package be.intecbrussel.testy.mapper;

import be.intecbrussel.testy.data.dto.AnswerDTO;
import be.intecbrussel.testy.data.entity.AnswerEntity;

public interface AnswerMapper {

    AnswerDTO toDTO(AnswerEntity source);

    AnswerEntity toEntity(AnswerDTO source);

    AnswerEntity toEntity(AnswerDTO source, AnswerEntity destination);

}
