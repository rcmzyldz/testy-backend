package be.intecbrussel.testy.views.controller;

import be.intecbrussel.testy.data.dto.ExamDTO;
import be.intecbrussel.testy.service.ExamService;
import com.google.common.base.Preconditions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// SPRING
@RestController
@RequestMapping("/api/v1/exams")

// LOMBOK

public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping
    public List<ExamDTO> findAll(@RequestParam(value = "pageNo", defaultValue = "1", required = false) int pageNo,
                                 @RequestParam(value = "pageNo", defaultValue = "1", required = false) int pageSize) {

        return examService.findAll(pageNo, pageSize);
    }

    @GetMapping(value = "/{id}")
    public ExamDTO findById(@PathVariable("id") Long id) {
        return RestPreconditions.checkFound(examService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody ExamDTO resource) {
        Preconditions.checkNotNull(resource);
        return examService.create(resource);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Long id, @RequestBody ExamDTO resource) {
        Preconditions.checkNotNull(resource);
        RestPreconditions.checkNotNull(examService.getById(resource.getId()));
        examService.update(id, resource);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        examService.deleteById(id);
    }

}
