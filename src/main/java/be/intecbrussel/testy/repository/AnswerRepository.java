package be.intecbrussel.testy.repository;

import be.intecbrussel.testy.model.entity.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerEntity, Long>, JpaSpecificationExecutor<AnswerEntity> {

}
