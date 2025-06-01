package com.fdmgroup.academyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.academyapi.models.Movie;

public interface MovieDAO extends JpaRepository<Movie, Integer> {
}
