package ru.akalavan.dance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.akalavan.dance.models.Group;
import ru.akalavan.dance.models.User;

import java.util.List;

/**
 * Class GroupRepository
 *
 * @author Вагин Михаил
 * date 20.01.2023
 */
@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {


}
