package be.intecbrussel.testy.mapper;

import be.intecbrussel.testy.data.dto.AnswerDTO;
import be.intecbrussel.testy.data.entity.AnswerEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AnswerMapperImpl implements AnswerMapper {

    @Override
    public AnswerDTO toDTO(AnswerEntity source) {
        if ( source == null ) {
            return null;
        }

        AnswerDTO answerDTO = new AnswerDTO();

        answerDTO.setId( source.getId() );
        if ( source.getHeader() != null ) {
            answerDTO.setHeader( source.getHeader() );
        }
        if ( source.getBody() != null ) {
            answerDTO.setBody( source.getBody() );
        }
        byte[] document = source.getDocument();
        if ( document != null ) {
            answerDTO.setDocument( Arrays.copyOf( document, document.length ) );
        }

        return answerDTO;
    }

    @Override
    public AnswerEntity toEntity(AnswerDTO source) {
        if ( source == null ) {
            return null;
        }

        AnswerEntity answerEntity = new AnswerEntity();

        answerEntity.setId( source.getId() );
        if ( source.getHeader() != null ) {
            answerEntity.setHeader( source.getHeader() );
        }
        if ( source.getBody() != null ) {
            answerEntity.setBody( source.getBody() );
        }
        byte[] document = source.getDocument();
        if ( document != null ) {
            answerEntity.setDocument( Arrays.copyOf( document, document.length ) );
        }

        return answerEntity;
    }

    @Override
    public AnswerEntity toEntity(AnswerDTO source, AnswerEntity destination) {
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
        byte[] document = source.getDocument();
        if ( document != null ) {
            destination.setDocument( Arrays.copyOf( document, document.length ) );
        }

        return destination;
    }
}
