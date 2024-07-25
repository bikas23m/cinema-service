package com.inox.cinema_service.repository;

import com.inox.cinema_service.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    Theatre findByName(String theatreName);
}
