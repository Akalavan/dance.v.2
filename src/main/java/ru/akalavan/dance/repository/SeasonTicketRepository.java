package ru.akalavan.dance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.akalavan.dance.models.SeasonTicket;

import java.util.List;

/**
 * Class SeasonTicketRepository
 *
 * @author Вагин Михаил
 * date 20.01.2023
 */
@Repository
public interface SeasonTicketRepository extends JpaRepository<SeasonTicket, Long> {


}
