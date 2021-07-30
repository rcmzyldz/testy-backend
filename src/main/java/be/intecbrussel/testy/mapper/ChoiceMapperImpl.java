package be.intecbrussel.testy.mapper;

import be.intecbrussel.testy.data.dto.ChoiceDTO;
import be.intecbrussel.testy.data.entity.ChoiceEntity;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class ChoiceMapperImpl implements ChoiceMapper {

    @Override
    public ChoiceDTO toDTO(ChoiceEntity source) {
        if ( source == null ) {
            return null;
        }

        ChoiceDTO choiceDTO = new ChoiceDTO();

        choiceDTO.setId( source.getId() );
        choiceDTO.setWeight( source.getWeight() );
        if ( source.getHeader() != null ) {
            choiceDTO.setHeader( source.getHeader() );
        }
        if ( source.getBody() != null ) {
            choiceDTO.setBody( source.getBody() );
        }
        if ( source.getImage() != null ) {
            choiceDTO.setImage( source.getImage() );
        }
        if ( source.getExplanation() != null ) {
            choiceDTO.setExplanation( source.getExplanation() );
        }

        return choiceDTO;
    }

    @Override
    public ChoiceEntity toEntity(ChoiceDTO source) {
        if ( source == null ) {
            return null;
        }

        ChoiceEntity choiceEntity = new ChoiceEntity();

        choiceEntity.setId( source.getId() );
        choiceEntity.setWeight( source.getWeight() );
        if ( source.getHeader() != null ) {
            choiceEntity.setHeader( source.getHeader() );
        }
        if ( source.getBody() != null ) {
            choiceEntity.setBody( source.getBody() );
        }
        if ( source.getImage() != null ) {
            choiceEntity.setImage( source.getImage() );
        }
        if ( source.getExplanation() != null ) {
            choiceEntity.setExplanation( source.getExplanation() );
        }

        return choiceEntity;
    }

    @Override
    public ChoiceEntity toEntity(ChoiceDTO source, ChoiceEntity destination) {
        if ( source == null ) {
            return null;
        }

        destination.setId( source.getId() );
        destination.setWeight( source.getWeight() );
        if ( source.getHeader() != null ) {
            destination.setHeader( source.getHeader() );
        }
        if ( source.getBody() != null ) {
            destination.setBody( source.getBody() );
        }
        if ( source.getImage() != null ) {
            destination.setImage( source.getImage() );
        }
        if ( source.getExplanation() != null ) {
            destination.setExplanation( source.getExplanation() );
        }

        return destination;
    }
}
