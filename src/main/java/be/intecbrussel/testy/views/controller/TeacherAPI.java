package be.intecbrussel.testy.views.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import be.intecbrussel.testy.model.dto.create.CreateUserRequest;
import be.intecbrussel.testy.model.dto.response.UserResponse;
import be.intecbrussel.testy.model.dto.update.UpdateUserRequest;
import be.intecbrussel.testy.model.http.HttpEndPoints;
import be.intecbrussel.testy.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherAPI {

    // INJECTIONS
    private final UserRepository teacherRepository;

    public TeacherAPI(final UserRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping
    @Transactional
    public ResponseEntity<List<UserResponse>> findAll(@RequestParam(value = "pageNo", defaultValue = "1", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "25", required = false) int pageSize) {

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(
                    teacherRepository.findAll(PageRequest.of(pageNo, pageSize))
                    .stream()
                    .map(entity -> entity.toResponse())
                    .collect(Collectors.toUnmodifiableList())
                );
    }

    @GetMapping(value = HttpEndPoints.FIND_SINGLE_EXAM_BY_ID + "{id}")
    @Transactional
    public ResponseEntity<UserResponse> findById(@PathVariable("id") Long id) {
       return teacherRepository
                .findById(id)
                .map(entity -> entity.toResponse())
                .map(response -> ResponseEntity.status(HttpStatus.FOUND).body(response))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                });
    }

    @PostMapping(HttpEndPoints.CREATE_SINGLE_EXAM)
    @Transactional
    public ResponseEntity<String> create(@RequestBody @Valid CreateUserRequest request) {
        
        // IF_EXISTS
        if(teacherRepository.exists(Example.of(request.toEntity()))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Teacher already exists");
        }
        
        // BUSINESS_FLOW
         return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("saved_id", String.valueOf(teacherRepository.save(request.toEntity()).getId()))
                .body("Teacher is created successfully.");
    }

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<String> update(@NotNull @PathVariable("id") Long id, @RequestBody @Valid UpdateUserRequest request) {
       return teacherRepository
                .findById(id)
                .map(entity -> request.toEntity().withId(entity.getId()))
                .map(entity -> teacherRepository.save(entity))
                .map(response -> ResponseEntity.status(HttpStatus.ACCEPTED).body("Teacher is updated successfully."))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher does not exist!");
                });
    }


    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return teacherRepository
        .findById(id)
        .map(entity -> teacherRepository.save(entity.withIsActive(false)))
        .map(entity -> entity.toUpdate())
        .map(response -> ResponseEntity.status(HttpStatus.ACCEPTED).body("Teacher is deleted successfully."))
        .orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher does not exist!");
        });

    }

}
