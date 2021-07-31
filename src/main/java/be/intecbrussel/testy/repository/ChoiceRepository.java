package be.intecbrussel.testy.repository;

import be.intecbrussel.testy.data.entity.ChoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoiceRepository extends JpaRepository<ChoiceEntity, Long>, JpaSpecificationExecutor<ChoiceEntity> {

}
