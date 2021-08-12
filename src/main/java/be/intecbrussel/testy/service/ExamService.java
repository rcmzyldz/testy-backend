package be.intecbrussel.testy.service;

import be.intecbrussel.testy.model.dto.ExamDTO;
import be.intecbrussel.testy.model.entity.ExamEntity;
import be.intecbrussel.testy.repository.ExamRepository;
import be.intecbrussel.testy.service.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

// SPRING
@Service
public class ExamService {

    // LOGGER
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ExamService.class);

    // INJECT_REPOSITORY
    private final ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public Long create(ExamDTO dto) throws NullPointerException, IllegalArgumentException {

        if (Objects.isNull(dto)) {
            throw new NullPointerException("Exam is required");
        }

        if (Objects.isNull(dto.getQuestion())) {
            throw new NullPointerException("Questions are required to create an exam");
        }

        final var savedEntity = examRepository.save(dto.toEntity());
        return Objects.requireNonNullElse(savedEntity.getId(), -1L);
    }

    public Long update(Long examId, ExamDTO dto) throws NullPointerException, IllegalArgumentException {

        if (Objects.isNull(dto)) {
            throw new NullPointerException("Exam is required");
        }

        if (Objects.isNull(examId)) {
            throw new NullPointerException("Exam ID is required");
        }

        if (Objects.isNull(dto.getQuestion())) {
            throw new NullPointerException("Questions are required to create an exam");
        }

        final var oEntity = examRepository.findById(examId);
        if (oEntity.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        dto.setId(examId);
        final var savedEntity = examRepository.save(dto.toEntity());
        return Objects.requireNonNullElse(savedEntity.getId(), -1L);
    }

    public Long patchHeader(Long examId, String header) throws NullPointerException, IllegalArgumentException {

        if (Objects.isNull(header)) {
            throw new NullPointerException("Exam is required");
        }

        if (Objects.isNull(examId)) {
            throw new NullPointerException("Exam ID is required");
        }

        final var oEntity = examRepository.findById(examId);
        if (oEntity.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        final var savedEntity = examRepository.save(oEntity.get().withHeader(header));
        return Objects.requireNonNullElse(savedEntity.getId(), -1L);
    }

    public List<ExamDTO> findAll(int pageNo, int pageSize) throws IllegalArgumentException {

        if (pageNo < 1 || pageSize < 1) {
            throw new IllegalArgumentException("Page number and page size must be greater than 1.");
        }

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        final var entities = examRepository.findAll(pageable).toList();
        final var responses = new LinkedList<ExamDTO>();

        for (ExamEntity entity : entities) {
            responses.add(entity.toDTO());
        }

        return responses;
    }

    public ExamDTO findById(Long examId) throws NullPointerException, IllegalArgumentException, ResourceNotFoundException {

        if (examId < 1) {
            throw new NullPointerException("Exam ID must be greater than zero.");
        }

        final var oEntity = examRepository.findById(examId);
        if (oEntity.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return oEntity.get().toDTO();
    }

    public ExamDTO getById(Long examId) throws NullPointerException, IllegalArgumentException, ResourceNotFoundException {

        if (examId < 1) {
            throw new NullPointerException("Exam ID must be greater than zero.");
        }

        final var oEntity = examRepository.findById(examId);
        if (oEntity.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return oEntity.get().toDTO();
    }

    public Long deleteById(Long examId) throws NullPointerException, IllegalArgumentException, ResourceNotFoundException {

        if (examId < 1) {
            throw new NullPointerException("Exam ID must be greater than zero.");
        }

        if (!examRepository.existsById(examId)) {
            throw new ResourceNotFoundException();
        }

        examRepository.deleteById(examId);

        return examRepository.existsById(examId) ? examId : -1L;
    }


}
