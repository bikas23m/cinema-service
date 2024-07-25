package com.inox.cinema_service.repository;

import com.inox.cinema_service.entity.Movie;
import com.inox.cinema_service.entity.Schedule;
import com.inox.cinema_service.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Optional<List<Schedule>> findByMovie(Movie movie);

    List<Schedule> findByMovieAndShowTimeBetween(Movie movie, LocalDateTime startOfDay, LocalDateTime endOfDay);

    List<Schedule> findByMovieAndTheatreAndShowTimeBetween(Movie movie, Theatre theatre, LocalDateTime startOfDay, LocalDateTime endOfDay);
}
