package be.intecbrussel.testy.repository;

import be.intecbrussel.testy.model.entity.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<ExamEntity, Long>, JpaSpecificationExecutor<ExamEntity> {

}
