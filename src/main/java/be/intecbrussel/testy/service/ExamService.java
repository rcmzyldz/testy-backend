package be.intecbrussel.testy.service;

import be.intecbrussel.testy.data.dto.ExamDTO;
import be.intecbrussel.testy.exception.ResourceNotFoundException;
import be.intecbrussel.testy.mapper.ExamMapper;
import be.intecbrussel.testy.repository.ExamRepository;
import be.intecbrussel.testy.service.exception.ExamNotFoundExamException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

// SPRING
@Service

// LOMBOK

public class ExamService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ExamService.class);
    private final ExamRepository examRepository;
    private final ExamMapper examMapper;

    @Autowired
    public ExamService(ExamRepository examRepository, ExamMapper examMapper) {
        this.examRepository = examRepository;
        this.examMapper = examMapper;
    }

    public long create(ExamDTO dto) throws NullPointerException, IllegalArgumentException {

        if (Objects.isNull(dto)) {
            throw new NullPointerException("Exam is required");
        }

        if (dto.getQuestions().size() < 1) {
            throw new IllegalArgumentException("Questions are required to create an exam");
        }

        final var entity = examMapper.toEntity(dto);

        final var savedEntity = examRepository.save(entity);
        return savedEntity.getId();
    }

    public long update(long examId, ExamDTO dto) throws NullPointerException, IllegalArgumentException {

        if (Objects.isNull(dto)) {
            throw new NullPointerException("Exam is required");
        }

        if (Objects.isNull(examId)) {
            throw new NullPointerException("Exam ID is required");
        }

        if (dto.getQuestions().size() < 1) {
            throw new IllegalArgumentException("Questions are required to create an exam");
        }

        final var oEntity = examRepository.findById(examId);
        if(oEntity.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        final var entityWithUpdatedFields = examMapper.toEntity(dto, oEntity.get());

        final var savedEntity = examRepository.save(oEntity.get());
        return savedEntity.getId();
    }

    public List<ExamDTO> findAll(int pageNo, int pageSize) throws IllegalArgumentException {

        if (pageNo < 1 || pageSize < 1) {
            throw new IllegalArgumentException("Page number and page size must be greater than 1.");
        }

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        final var pages = examRepository.findAll(pageable);
        return examMapper.toDTOs(pages.toList());
    }

    public ExamDTO findById(long examId) throws NullPointerException, IllegalArgumentException, ExamNotFoundExamException {

        if (examId < 1) {
            throw new NullPointerException("Exam ID must be greater than zero.");
        }

        final var oEntity = examRepository.findById(examId);
        if(oEntity.isEmpty()) {
            throw new ExamNotFoundExamException();
        }

        final var entity = oEntity.get();
        return examMapper.toDTO(entity);
    }

    public ExamDTO getById(long examId) throws NullPointerException, IllegalArgumentException, ExamNotFoundExamException {

        if (examId < 1) {
            throw new NullPointerException("Exam ID must be greater than zero.");
        }

        final var oEntity = examRepository.findById(examId);
        if(oEntity.isEmpty()) {
            throw new ExamNotFoundExamException();
        }

        final var entity = oEntity.get();
        return examMapper.toDTO(entity);
    }

    public void deleteById(long examId) throws NullPointerException, IllegalArgumentException, ExamNotFoundExamException {

        if (examId < 1) {
            throw new NullPointerException("Exam ID must be greater than zero.");
        }

        if(!examRepository.existsById(examId)) {
            throw new ExamNotFoundExamException();
        }

        examRepository.deleteById(examId);
    }


}
