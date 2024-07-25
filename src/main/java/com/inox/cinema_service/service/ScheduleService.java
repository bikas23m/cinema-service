package com.inox.cinema_service.service;

import com.inox.cinema_service.entity.Movie;
import com.inox.cinema_service.entity.Schedule;
import com.inox.cinema_service.entity.Theatre;
import com.inox.cinema_service.repository.MovieRepository;
import com.inox.cinema_service.repository.ScheduleRepository;
import com.inox.cinema_service.repository.TheatreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ScheduleService {

    private final MovieRepository movieRepository;
    private final ScheduleRepository scheduleRepository;
    private final TheatreRepository theatreRepository;

    public List<String> getAllScheduleDatesByMovieTitle(String movieTitle) {
        Movie movie = movieRepository.findByTitle(movieTitle);
        if (movie != null) {
            List<Schedule> schedules = scheduleRepository.findByMovie(movie).orElseThrow();
            return schedules.stream()
                    .map(schedule -> schedule.getShowTime().toString())
                    .collect(Collectors.toList());
        } else {
            throw new RuntimeException("Movie not found with title: " + movieTitle);
        }
    }

    public List<String> getTheatresByMovieTitleAndScheduleDate(String movieTitle, LocalDate scheduleDate) {
        Movie movie = movieRepository.findByTitle(movieTitle);
        if (movie != null) {
            LocalDateTime startOfDay = scheduleDate.atStartOfDay();
            LocalDateTime endOfDay = scheduleDate.atTime(LocalTime.MAX);
            List<Schedule> schedules = scheduleRepository.findByMovieAndShowTimeBetween(movie, startOfDay, endOfDay);
            log.info("{}", schedules);
            return schedules.stream()
                    .map(Schedule::getTheatre)
                    .map(Theatre::getName)
                    .distinct()
                    .collect(Collectors.toList());
        } else {
            throw new RuntimeException("Movie not found with title: " + movieTitle);
        }
    }

    public List<LocalDateTime> getScheduleTimes(String movieTitle, LocalDate scheduleDate, String theatreName) {
        Movie movie = movieRepository.findByTitle(movieTitle);
        Theatre theatre = theatreRepository.findByName(theatreName);

        if (movie != null && theatre != null) {
            LocalDateTime startOfDay = scheduleDate.atStartOfDay();
            LocalDateTime endOfDay = scheduleDate.atTime(LocalTime.MAX);
            List<Schedule> schedules = scheduleRepository.findByMovieAndTheatreAndShowTimeBetween(movie, theatre, startOfDay, endOfDay);
            return schedules.stream()
                    .map(Schedule::getShowTime)
                    .collect(Collectors.toList());
        } else {
            throw new RuntimeException("Movie or Theatre not found with the provided details.");
        }
    }

}
