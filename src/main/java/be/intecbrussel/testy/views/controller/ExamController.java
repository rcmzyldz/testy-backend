package be.intecbrussel.testy.views.controller;

import be.intecbrussel.testy.model.dto.ExamDTO;
import be.intecbrussel.testy.model.http.HttpEndPoints;
import be.intecbrussel.testy.model.http.HttpSuccessMessages;
import be.intecbrussel.testy.service.ExamService;
import be.intecbrussel.testy.service.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1/exams")
public class ExamController {

    private static final Logger log = LoggerFactory.getLogger(ExamController.class);

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(value = "pageNo", defaultValue = "1", required = false) int pageNo,
                                     @RequestParam(value = "pageSize", defaultValue = "25", required = false) int pageSize) {
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(examService.findAll(pageNo, pageSize));
        } catch (NullPointerException | ResourceNotFoundException exception) {
            log.error(exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping(value = HttpEndPoints.FIND_SINGLE_EXAM_BY_ID + "{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(examService.findById(id));
        } catch (NullPointerException | ResourceNotFoundException exception) {
            log.error(exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PostMapping(HttpEndPoints.CREATE_SINGLE_EXAM)
    public ResponseEntity<String> create(@RequestBody @Valid ExamDTO resource) {
        try {
            final var savedId = examService.create(resource);

            // RETURN SUCCESS
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .header("savedId", String.valueOf(savedId))
                    .body(HttpSuccessMessages.SINGLE_EXAM_IS_CREATED.name());

        } catch (NullPointerException | ResourceNotFoundException exception) {
            log.error(exception.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@NotNull @PathVariable("id") Long id, @RequestBody @Valid ExamDTO resource) {
        try {

            final var updatedId = examService.update(id, resource);

            // RETURN SUCCESS
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .header("updatedId", String.valueOf(updatedId))
                    .body(HttpSuccessMessages.SINGLE_EXAM_IS_UPDATED.name());
        } catch (NullPointerException | ResourceNotFoundException exception) {
            log.error(exception.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<String> updateHeaderById(@NotNull @PathVariable("id") Long id, @NotNull String header) {

        try {
            final var patchedId = examService.patchHeader(id, header);

            // RETURN SUCCESS
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .header("patchedId", String.valueOf(patchedId))
                    .body(HttpSuccessMessages.SINGLE_EXAM_IS_PATCHED.name());

        } catch (NullPointerException | ResourceNotFoundException exception) {
            log.error(exception.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {

        try {
            final var deletedId = examService.deleteById(id);

            // RETURN SUCCESS
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .header("deletedId", String.valueOf(deletedId))
                    .body(HttpSuccessMessages.SINGLE_EXAM_IS_CREATED.name());

        } catch (NullPointerException | IllegalArgumentException | ResourceNotFoundException exception) {
            log.error(exception.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }

    }

}
