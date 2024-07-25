package com.inox.cinema_service.controller;

import com.inox.cinema_service.dto.ScheduleRequest;
import com.inox.cinema_service.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/cinema")
public class ScheduleController {

    private final ScheduleService service;

    @GetMapping("/schedule")
    public ResponseEntity<?> getSchedule(@RequestBody ScheduleRequest scheduleRequest) {

        String movieTitle = scheduleRequest.getMovieTitle();
        LocalDate scheduleDate = scheduleRequest.getScheduleDate();
        String theatreName = scheduleRequest.getTheatreName();

        if(movieTitle != null && scheduleDate != null && theatreName != null) {
            List<LocalDateTime> scheduleTimes = service.getScheduleTimes(movieTitle, scheduleDate, theatreName);
            return ResponseEntity.ok(scheduleTimes);
        } else if (movieTitle != null && scheduleDate != null) {
            List<String> theatres = service.getTheatresByMovieTitleAndScheduleDate(movieTitle, scheduleDate);
            return ResponseEntity.ok(theatres);
        } else if (movieTitle != null) {
            List<String> scheduleDates = service.getAllScheduleDatesByMovieTitle(movieTitle);
            return ResponseEntity.ok(scheduleDates);
        }

        return ResponseEntity.badRequest().body("Bad Request");

    }

}
