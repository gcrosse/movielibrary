package com.humber.movielibrary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.humber.movielibrary.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByGenre(String genre);

    List<Movie> findByYear(int year);
}