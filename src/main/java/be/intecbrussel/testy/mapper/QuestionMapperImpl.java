package be.intecbrussel.testy.mapper;

import be.intecbrussel.testy.data.dto.ChoiceDTO;
import be.intecbrussel.testy.data.dto.QuestionDTO;
import be.intecbrussel.testy.data.entity.ChoiceEntity;
import be.intecbrussel.testy.data.entity.QuestionEntity;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public QuestionDTO toDTO(QuestionEntity source) {
        if ( source == null ) {
            return null;
        }

        QuestionDTO questionDTO = new QuestionDTO();

        questionDTO.setId( source.getId() );
        if ( source.getHeader() != null ) {
            questionDTO.setHeader( source.getHeader() );
        }
        if ( source.getBody() != null ) {
            questionDTO.setBody( source.getBody() );
        }
        if ( source.getChoices() != null ) {
            for ( ChoiceEntity choice : source.getChoices() ) {
                questionDTO.addChoice( choiceEntityToChoiceDTO( choice ) );
            }
        }

        return questionDTO;
    }

    @Override
    public QuestionEntity toEntity(QuestionDTO source) {
        if ( source == null ) {
            return null;
        }

        QuestionEntity questionEntity = new QuestionEntity();

        questionEntity.setId( source.getId() );
        if ( source.getHeader() != null ) {
            questionEntity.setHeader( source.getHeader() );
        }
        if ( source.getBody() != null ) {
            questionEntity.setBody( source.getBody() );
        }
        if ( source.getChoices() != null ) {
            for ( ChoiceDTO choice : source.getChoices() ) {
                questionEntity.addChoice( choiceDTOToChoiceEntity( choice ) );
            }
        }

        return questionEntity;
    }

    @Override
    public QuestionEntity toEntity(QuestionDTO source, QuestionEntity destination) {
        if ( source == null ) {
            return null;
        }

        destination.setId( source.getId() );
        if ( source.getHeader() != null ) {
            destination.setHeader( source.getHeader() );
        }
        if ( source.getBody() != null ) {
            destination.setBody( source.getBody() );
        }
        if ( source.getChoices() != null ) {
            for ( ChoiceDTO choice : source.getChoices() ) {
                destination.addChoice( choiceDTOToChoiceEntity( choice ) );
            }
        }

        return destination;
    }

    protected ChoiceDTO choiceEntityToChoiceDTO(ChoiceEntity choiceEntity) {
        if ( choiceEntity == null ) {
            return null;
        }

        ChoiceDTO choiceDTO = new ChoiceDTO();

        choiceDTO.setId( choiceEntity.getId() );
        choiceDTO.setWeight( choiceEntity.getWeight() );
        if ( choiceEntity.getHeader() != null ) {
            choiceDTO.setHeader( choiceEntity.getHeader() );
        }
        if ( choiceEntity.getBody() != null ) {
            choiceDTO.setBody( choiceEntity.getBody() );
        }
        if ( choiceEntity.getImage() != null ) {
            choiceDTO.setImage( choiceEntity.getImage() );
        }
        if ( choiceEntity.getExplanation() != null ) {
            choiceDTO.setExplanation( choiceEntity.getExplanation() );
        }

        return choiceDTO;
    }

    protected ChoiceEntity choiceDTOToChoiceEntity(ChoiceDTO choiceDTO) {
        if ( choiceDTO == null ) {
            return null;
        }

        ChoiceEntity choiceEntity = new ChoiceEntity();

        choiceEntity.setId( choiceDTO.getId() );
        choiceEntity.setWeight( choiceDTO.getWeight() );
        if ( choiceDTO.getHeader() != null ) {
            choiceEntity.setHeader( choiceDTO.getHeader() );
        }
        if ( choiceDTO.getBody() != null ) {
            choiceEntity.setBody( choiceDTO.getBody() );
        }
        if ( choiceDTO.getImage() != null ) {
            choiceEntity.setImage( choiceDTO.getImage() );
        }
        if ( choiceDTO.getExplanation() != null ) {
            choiceEntity.setExplanation( choiceDTO.getExplanation() );
        }

        return choiceEntity;
    }
}
