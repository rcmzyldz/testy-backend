package be.intecbrussel.testy.mapper;

import be.intecbrussel.testy.data.dto.ChoiceDTO;
import be.intecbrussel.testy.data.dto.ExamDTO;
import be.intecbrussel.testy.data.dto.QuestionDTO;
import be.intecbrussel.testy.data.entity.ChoiceEntity;
import be.intecbrussel.testy.data.entity.ExamEntity;
import be.intecbrussel.testy.data.entity.QuestionEntity;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class ExamMapperImpl implements ExamMapper {

    @Override
    public ExamDTO toDTO(ExamEntity source) {
        if ( source == null ) {
            return null;
        }

        ExamDTO examDTO = new ExamDTO();

        examDTO.setId( source.getId() );
        if ( source.getCode() != null ) {
            examDTO.setCode( source.getCode() );
        }
        if ( source.getHeader() != null ) {
            examDTO.setHeader( source.getHeader() );
        }
        if ( source.getBody() != null ) {
            examDTO.setBody( source.getBody() );
        }
        if ( source.getStarted() != null ) {
            examDTO.setStarted( source.getStarted() );
        }
        if ( source.getEnded() != null ) {
            examDTO.setEnded( source.getEnded() );
        }
        if ( source.getQuestions() != null ) {
            for ( QuestionEntity question : source.getQuestions() ) {
                examDTO.addQuestion( questionEntityToQuestionDTO( question ) );
            }
        }

        return examDTO;
    }

    @Override
    public ExamEntity toEntity(ExamDTO source) {
        if ( source == null ) {
            return null;
        }

        ExamEntity examEntity = new ExamEntity();

        examEntity.setId( source.getId() );
        if ( source.getCode() != null ) {
            examEntity.setCode( source.getCode() );
        }
        if ( source.getHeader() != null ) {
            examEntity.setHeader( source.getHeader() );
        }
        if ( source.getBody() != null ) {
            examEntity.setBody( source.getBody() );
        }
        if ( source.getStarted() != null ) {
            examEntity.setStarted( source.getStarted() );
        }
        if ( source.getEnded() != null ) {
            examEntity.setEnded( source.getEnded() );
        }
        if ( source.getQuestions() != null ) {
            for ( QuestionDTO question : source.getQuestions() ) {
                examEntity.addQuestion( questionDTOToQuestionEntity( question ) );
            }
        }

        return examEntity;
    }

    @Override
    public ExamEntity toEntity(ExamDTO source, ExamEntity destination) {
        if ( source == null ) {
            return null;
        }

        destination.setId( source.getId() );
        if ( source.getCode() != null ) {
            destination.setCode( source.getCode() );
        }
        if ( source.getHeader() != null ) {
            destination.setHeader( source.getHeader() );
        }
        if ( source.getBody() != null ) {
            destination.setBody( source.getBody() );
        }
        if ( source.getStarted() != null ) {
            destination.setStarted( source.getStarted() );
        }
        if ( source.getEnded() != null ) {
            destination.setEnded( source.getEnded() );
        }
        if ( source.getQuestions() != null ) {
            for ( QuestionDTO question : source.getQuestions() ) {
                destination.addQuestion( questionDTOToQuestionEntity( question ) );
            }
        }

        return destination;
    }

    @Override
    public List<ExamDTO> toDTOs(List<ExamEntity> source) {
        if ( source == null ) {
            return null;
        }

        List<ExamDTO> list = new ArrayList<ExamDTO>( source.size() );
        for ( ExamEntity examEntity : source ) {
            list.add( toDTO( examEntity ) );
        }

        return list;
    }

    @Override
    public List<ExamEntity> toEntities(List<ExamDTO> source) {
        if ( source == null ) {
            return null;
        }

        List<ExamEntity> list = new ArrayList<ExamEntity>( source.size() );
        for ( ExamDTO examDTO : source ) {
            list.add( toEntity( examDTO ) );
        }

        return list;
    }

    @Override
    public List<ExamEntity> toEntities(List<ExamDTO> source, List<ExamEntity> destination) {
        if ( source == null ) {
            return null;
        }

        destination.clear();
        for ( ExamDTO examDTO : source ) {
            destination.add( toEntity( examDTO ) );
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

    protected QuestionDTO questionEntityToQuestionDTO(QuestionEntity questionEntity) {
        if ( questionEntity == null ) {
            return null;
        }

        QuestionDTO questionDTO = new QuestionDTO();

        questionDTO.setId( questionEntity.getId() );
        if ( questionEntity.getHeader() != null ) {
            questionDTO.setHeader( questionEntity.getHeader() );
        }
        if ( questionEntity.getBody() != null ) {
            questionDTO.setBody( questionEntity.getBody() );
        }
        if ( questionEntity.getChoices() != null ) {
            for ( ChoiceEntity choice : questionEntity.getChoices() ) {
                questionDTO.addChoice( choiceEntityToChoiceDTO( choice ) );
            }
        }

        return questionDTO;
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

    protected QuestionEntity questionDTOToQuestionEntity(QuestionDTO questionDTO) {
        if ( questionDTO == null ) {
            return null;
        }

        QuestionEntity questionEntity = new QuestionEntity();

        questionEntity.setId( questionDTO.getId() );
        if ( questionDTO.getHeader() != null ) {
            questionEntity.setHeader( questionDTO.getHeader() );
        }
        if ( questionDTO.getBody() != null ) {
            questionEntity.setBody( questionDTO.getBody() );
        }
        if ( questionDTO.getChoices() != null ) {
            for ( ChoiceDTO choice : questionDTO.getChoices() ) {
                questionEntity.addChoice( choiceDTOToChoiceEntity( choice ) );
            }
        }

        return questionEntity;
    }
}
