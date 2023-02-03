package ru.akalavan.dance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.akalavan.dance.models.Role;
import ru.akalavan.dance.models.User;

import java.util.List;
import java.util.Optional;

/**
 * Class RoleRepository
 *
 * @author Вагин Михаил
 * date 20.01.2023
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Role SET name = :name WHERE id = :id ")
    void changeName(Long id, String name);

    Optional<Role> findByName(String name);

}
