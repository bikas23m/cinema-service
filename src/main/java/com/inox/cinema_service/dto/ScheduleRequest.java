package com.inox.cinema_service.dto;


import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScheduleRequest {

    private String movieTitle;
    private LocalDate scheduleDate;
    private String theatreName;

}
