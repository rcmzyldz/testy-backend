package be.intecbrussel.testy.repository;

import be.intecbrussel.testy.model.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {

        Optional<UserEntity> findByEmail(@NotEmpty final String email);

        Optional<UserEntity> findByEmailAndPassword(@NotEmpty final String email, @NotEmpty final String password);

        Optional<UserEntity> findByEmailAndActivation(@NotEmpty final String email, @NotEmpty final String activation);

        Page<UserEntity> findByFirstNameIsContainingAndLastNameIsContaining(@NotEmpty final String firstName,
                        @NotEmpty final String lastName, final Pageable pageable);

        boolean existsByEmail(@NotEmpty @Email final String email);

        boolean existsByFirstNameIsContaining(@NotEmpty final String firstName);

        boolean existsByFirstNameIsContainingAndLastNameIsContaining(@NotEmpty final String firstName,
                        @NotEmpty final String lastName);

        @Modifying
        @Query(value = "update UserEntity u SET u.activated = :activated WHERE u.id = :id")
        int updateActivatedById(@Param(value = "id") long id, @Param("activated") boolean activated);

        @Modifying
        @Query(value = "update UserEntity u SET u.authenticated = :authenticated WHERE u.id = :id")
        int updateAuthenticatedById(@Param(value = "id") long id, @Param("authenticated") boolean activated);

        @Modifying(clearAutomatically = true)
        @Query(value = "update UserEntity u SET u.session = :session WHERE u.email = :email")
        int updateSessionByEmail(@Param(value = "email") String email, @Param("session") String session);

}
