package ru.akalavan.dance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.akalavan.dance.models.Group;
import ru.akalavan.dance.models.GroupTrainer;
import ru.akalavan.dance.models.Role;
import ru.akalavan.dance.models.User;

import java.util.List;
import java.util.Optional;

/**
 * Class UserRepository
 *
 * @author Вагин Михаил
 * date 20.01.2023
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByLogin(String login);

    @Query("SELECT MAX(id) FROM User")
    Long getLastId();

    List<User> findAll();

    List<User> findAllByRoles(Role role);

    //@Query("SELECT User FROM User INNER JOIN GroupTrainer WHERE GroupTrainer.id = :id")
    List<User> findAllByGroupTrainers(GroupTrainer gp);
}
