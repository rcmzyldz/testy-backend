package be.intecbrussel.testy.mapper;

import be.intecbrussel.testy.data.dto.ChoiceDTO;
import be.intecbrussel.testy.data.entity.ChoiceEntity;

public interface ChoiceMapper {

    ChoiceDTO toDTO(ChoiceEntity source);

    ChoiceEntity toEntity(ChoiceDTO source);

    ChoiceEntity toEntity(ChoiceDTO source, ChoiceEntity destination);

}
