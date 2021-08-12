package be.intecbrussel.testy.service;

import be.intecbrussel.testy.model.dto.QuestionDTO;
import be.intecbrussel.testy.model.entity.QuestionEntity;
import be.intecbrussel.testy.repository.QuestionRepository;
import be.intecbrussel.testy.service.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class QuestionService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(QuestionService.class);
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Long create(QuestionDTO dto) throws NullPointerException, IllegalArgumentException {

        if (Objects.isNull(dto)) {
            throw new NullPointerException("Question is required");
        }

        if (Objects.isNull(dto.getChoices())) {
            throw new NullPointerException("Choices are required to create an question");
        }

        final var savedEntity = questionRepository.save(dto.toEntity());
        return Objects.requireNonNullElse(savedEntity.getId(), -1L);
    }

    public Long update(Long questionId, QuestionDTO dto) throws NullPointerException, IllegalArgumentException {

        if (Objects.isNull(dto)) {
            throw new NullPointerException("Question is required");
        }

        if (Objects.isNull(questionId)) {
            throw new NullPointerException("Question ID is required");
        }

        if (Objects.isNull(dto.getChoices())) {
            throw new NullPointerException("Choices are required to create an question");
        }

        final var oEntity = questionRepository.findById(questionId);
        if (oEntity.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        dto.setId(questionId);
        final var savedEntity = questionRepository.save(dto.toEntity());
        return Objects.requireNonNullElse(savedEntity.getId(), -1L);
    }

    public List<QuestionDTO> findAll(int pageNo, int pageSize) throws IllegalArgumentException {

        if (pageNo < 1 || pageSize < 1) {
            throw new IllegalArgumentException("Page number and page size must be greater than 1.");
        }

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        final var entities = questionRepository.findAll(pageable).toList();
        final var responses = new LinkedList<QuestionDTO>();

        for (QuestionEntity entity : entities) {
            responses.add(entity.toDTO());
        }

        return responses;
    }

    public QuestionDTO findById(Long questionId) throws NullPointerException, IllegalArgumentException, ResourceNotFoundException {

        if (questionId < 1) {
            throw new NullPointerException("Question ID must be greater than zero.");
        }

        final var oEntity = questionRepository.findById(questionId);
        if (oEntity.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return oEntity.get().toDTO();
    }

    public QuestionDTO getById(Long questionId) throws NullPointerException, IllegalArgumentException, ResourceNotFoundException {

        if (questionId < 1) {
            throw new NullPointerException("Question ID must be greater than zero.");
        }

        final var oEntity = questionRepository.findById(questionId);
        if (oEntity.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return oEntity.get().toDTO();
    }

    public void deleteById(Long questionId) throws NullPointerException, IllegalArgumentException, ResourceNotFoundException {

        if (questionId < 1) {
            throw new NullPointerException("Question ID must be greater than zero.");
        }

        if (!questionRepository.existsById(questionId)) {
            throw new ResourceNotFoundException();
        }

        questionRepository.deleteById(questionId);
    }


}
