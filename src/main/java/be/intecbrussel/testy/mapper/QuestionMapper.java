package be.intecbrussel.testy.mapper;

import be.intecbrussel.testy.data.dto.QuestionDTO;
import be.intecbrussel.testy.data.entity.QuestionEntity;


public interface QuestionMapper {

    QuestionDTO toDTO(QuestionEntity source);

    QuestionEntity toEntity(QuestionDTO source);

    QuestionEntity toEntity(QuestionDTO source, QuestionEntity destination);

}
