package ru.photorex.demorestaurant.repo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.photorex.demorestaurant.domain.Restaurant;
import ru.photorex.demorestaurant.domain.Vote;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Repository
public interface VoteRepo extends JpaRepository<Vote, Long> {

    Vote findByUserIdAndCreatedAtBetween(long userId, LocalDateTime start, LocalDateTime end);

    Set<Vote> findByRestaurantAndCreatedAtBetween(Restaurant restaurant, LocalDateTime start, LocalDateTime end);

    Set<Vote> findAllByRestaurant(Restaurant restaurant);

    @Cacheable("votes")
    List<Vote> findAllByCreatedAtBetween(LocalDateTime start, LocalDateTime end);
}
