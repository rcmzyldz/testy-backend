package be.intecbrussel.testy.views.controller;

import be.intecbrussel.testy.data.dto.QuestionDTO;
import be.intecbrussel.testy.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<QuestionDTO> findAll(@RequestParam(value = "pageNo", defaultValue = "1", required = false) int pageNo,
                                 @RequestParam(value = "pageSize", defaultValue = "25", required = false) int pageSize) {

        return questionService.findAll(pageNo, pageSize);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public QuestionDTO findById(@PathVariable("id") Long id) {
        return questionService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody @Valid QuestionDTO resource) {
        return questionService.create(resource);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@NotNull @PathVariable("id") Long id, @RequestBody @Valid QuestionDTO resource) {
        questionService.update(id, resource);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        questionService.deleteById(id);
    }

}
